/*
 * member_register.java
 *
 * Created on October 2, 2006, 5:59 PM
 */

package gsu;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import models.*;

import java.security.*;
import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;

/**
 * Member Register servlet
 * @author Travis Roberts
 * @version 1.0
 */
public class member_register extends HttpServlet {
    
    private String error;
    private String notice;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException Exception
     * @throws java.io.IOException Exception
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // get the session
        HttpSession session = request.getSession();
        // set timeout value for 5 minutes
        session.setMaxInactiveInterval(300);
        
        // get the action of the page
        String action = request.getParameter("action");
        
        if(action.equals("register")) {
            
            // get the member_register type
            String register_type = request.getParameter("register_type");
            
            // determine what type of user is trying to 
            // member_register and route them to the correct page
        
            // if they are a student, send them to the student member_register page
            if(register_type.equals("student")) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/student.jsp");
                dispatcher.forward(request, response);
                return;
            }
        
            // if they are an alumi, send them to the almni member_register page
            else if(register_type.equals("alumni")) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/alumni.jsp");
                dispatcher.forward(request, response);
                return;
            }
        
            // if they are a hospital, send them to the hospital member_register page
            else if(register_type.equals("hospital")) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/hospital.jsp");
                dispatcher.forward(request, response);
                return;
            }
            
            // catch error and forward to error page
            else {
                error = "I didn't understand the member type you chose.<br />Please try again.";
                request.setAttribute("error", error);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        
        // if the page is posted back from a registration page,
        // encrypt the password and save the info to the db
        else if(action.equals("save")) {
            // get the member type from the page
            String member_type = request.getParameter("member_type");
            
            //based on member type, save the info to the database
            
            if(member_type.equals("student")) {
                // get student details
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String address1 = request.getParameter("address1");
                String address2 = request.getParameter("address2");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zip = request.getParameter("zip");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                // build SQL-friendly dates
                String start_date = request.getParameter("start_year") + "-" + 
                        request.getParameter("start_month") + "-01";
                String graduation_date = "";
                if(!request.getParameter("grad_year").equals("") && !request.getParameter("grad_year").equals("")) {
                    graduation_date = request.getParameter("grad_year") + "-" +
                            request.getParameter("grad_month") + "-01";
                }
                // is_admin
                int is_admin = 0;
                if(request.getParameter("is_admin") != null) {
                    is_admin = 1;
                }
                
                // create the Student object with the supplied information
                Student student = new Student(fname, lname, address1, address2, city, state,
                        zip, email, password, is_admin, start_date, graduation_date);
                
                // check to see if the email address is already registered
                if(student.checkEmailIsRegistered()) {
                    // if email is already registered, re-route to registration page and display error
                   notice = "That email address is already registered!";
                   request.setAttribute("notice", notice);
                   request.setAttribute("student", student);
                   //forward request back to register JSP to show notice
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/student.jsp");
                   dispatcher.forward(request, response);
                   return;
                }
                
                // try to encrypt the password
                if(!student.encryptPass()) {
                    // if encryption is unsuccessful, re-route to registration page and display error
                    notice = "There was an error encrypting your password. Please try again";
                    request.setAttribute("notice", notice);
                    request.setAttribute("student", student);
                    //forward request back to register JSP to show notice
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/student.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                
                // save the user's information into the database
                if(!student.saveStudent()) {
                    // if save is unsuccessful, re-route to registration page and display error
                    notice = "There was an error saving your information.  Please try again.";
                    request.setAttribute("notice", notice);
                    request.setAttribute("student", student);
                    //forward request back to register JSP to show notice
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/student.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                
                // success!  re-route to index
                notice = "You have successfully registered.  You may now login.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                return;
            }
            
            else if(member_type.equals("alumni")) {
                // get student details
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String address1 = request.getParameter("address1");
                String address2 = request.getParameter("address2");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zip = request.getParameter("zip");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String company_name = request.getParameter("company_name");
                String position = request.getParameter("position");
                // do they want to be a mentor
                int mentor = 0;
                if(request.getParameter("mentor") != null) {
                    mentor = 1;
                }
                // buld SQL-friendly dates
                String graduation_date = request.getParameter("graduation_year") + "-" + 
                        request.getParameter("graduation_month") + "-01";
                // is_admin
                int is_admin = 0;
                if(request.getParameter("is_admin") != null) {
                    is_admin = 1;
                }
                
                // create the Student object with the supplied information
                Alumni alumni = new Alumni(fname, lname, address1, address2, city, state,
                        zip, email, password, is_admin, company_name, position, graduation_date, mentor);
                
                // check to see if the email address is already registered
                if(alumni.checkEmailIsRegistered()) {
                   notice = "That email address is already registered!";
                   request.setAttribute("notice", notice);
                   request.setAttribute("alumni", alumni);
                   //forward request back to register JSP to show notice
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/alumni.jsp");
                   dispatcher.forward(request, response);
                   return;
                }
                
                // try to encrypt the password
                if(!alumni.encryptPass()) {
                    notice = "There was an error encrypting your password. Please try again";
                    request.setAttribute("notice", notice);
                    //forward request back to register JSP to show notice
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/alumni.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                
                // save the user's information into the database
                if(!alumni.saveAlumni()) {
                    notice = "There was an error saving your information.  Please try again.";
                    request.setAttribute("notice", notice);
                    //forward request back to register JSP to show notice
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/alumni.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                
                notice = "You have successfully registered.  You may now login.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                return;
            }
            
            else if(member_type.equals("hospital")) {
                // get hospital details
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String address1 = request.getParameter("address1");
                String address2 = request.getParameter("address2");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zip = request.getParameter("zip");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String url = request.getParameter("url");
                // is_admin
                int is_admin = 0;
                if(request.getParameter("is_admin") != null) {
                    is_admin = 1;
                }
                
                // create the Student object with the supplied information
                Hospital hospital = new Hospital(fname, lname, address1, address2, city, state,
                        zip, email, password, is_admin, name, phone, url);
                
                // check to see if the email address is already registered
                if(hospital.checkEmailIsRegistered()) {
                   notice = "That email address is already registered!";
                   request.setAttribute("notice", notice);
                   request.setAttribute("hospital", hospital);
                   //forward request back to register JSP to show notice
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/hospital.jsp");
                   dispatcher.forward(request, response);
                   return;
                }
                
                // try to encrypt the password
                if(!hospital.encryptPass()) {
                    notice = "There was an error encrypting your password. Please try again";
                    request.setAttribute("notice", notice);
                    //forward request back to register JSP to show notice
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/hospital.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                
                // save the user's information into the database
                if(!hospital.saveHospital()) {
                    notice = "There was an error saving your information.  Please try again.";
                    request.setAttribute("notice", notice);
                    //forward request back to register JSP to show notice
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register/hospital.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                
                notice = "You have successfully registered.  You may now login.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException Exception
     * @throws java.io.IOException Exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException Exception
     * @throws java.io.IOException Exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     * @return String
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
