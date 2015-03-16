/*
 * my_account.java
 *
 * Created on November 6, 2006, 7:28 PM
 */

package gsu;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import models.*;

import java.security.*;
import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;

/**
 * My Account servlet
 * @author travis
 * @version 1.0
 */
public class my_account extends HttpServlet {
    
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
        
        String member_type;
        String save_type;
        String action;
        String notice;
        
        // get the member type (if there IS a member type)
        if((String)session.getAttribute("member_type") != null) {
            member_type = (String)session.getAttribute("member_type");
        }
        // if no member_type, they are not logged in,
        // re-route them to the index with error notice
        else {
            notice = "You must login first!";
            request.setAttribute("notice", notice);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //==========================================================
        
        // if there is an action, get it
        // if no action, that means forward to edit page
        if(request.getParameter("action") != null) {
            action = (String)request.getParameter("action");
        }
        else {
            // if they are a student, forward them to student edit page
            if(member_type.equals("student")) {
                if(session.getAttribute("person") != null) {
                    Person person = (Person)session.getAttribute("person");
                    Student student = person.getStudent();
                    request.setAttribute("student", student);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/student.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                // if there is no Person object in the session, they
                // aren't logged in.  Re-route them to index with error notice.
                else {
                    notice = "You are not logged in!";
                    request.setAttribute("notice", notice);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
        
            // if they are an alumni, forward them to alumni edit page
            else if(member_type.equals("alumni")) {
                if(session.getAttribute("person") != null) {
                    Person person = (Person)session.getAttribute("person");
                    Alumni alumni = person.getAlumni();
                    request.setAttribute("alumni", alumni);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/alumni.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                // if there is no Person object in the session, they
                // aren't logged in.  Re-route them to index with error notice.
                else {
                    notice = "You are not logged in!";
                    request.setAttribute("notice", notice);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
        
            // if they are a hospital, forward them to hospital edit page
            else if(member_type.equals("hospital")) {
                if(session.getAttribute("person") != null) {
                    Person person = (Person)session.getAttribute("person");
                    Hospital hospital = person.getHospital();
                    request.setAttribute("hospital", hospital);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/hospital.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                // if there is no Person object in the session, they
                // aren't logged in.  Re-route them to index with error notice.
                else {
                    notice = "You are not logged in!";
                    request.setAttribute("notice", notice);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
        
            // fall through catch to handle errors
            else {
                notice = "I don't understand your request.  Please try again.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        
        //==========================================================
        
        // if there is an action, save posted object
        
        // if student, save updated info to db
        if(action.equals("save_student")) {
            //get the current Person object from the session
            // and then get a current Student object
            Person person = (Person)session.getAttribute("person");
            Student cur_student = person.getStudent();
            
            // get the person_id from the session
            int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
            
            // get student form details
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String address1 = request.getParameter("address1");
            String address2 = request.getParameter("address2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            String email = request.getParameter("email");
            // build SQL-friendly dates
            String start_date = request.getParameter("start_year") + "-" +
                    request.getParameter("start_month") + "-01";
            String graduation_date = "";
            if(!request.getParameter("grad_year").equals("") && !request.getParameter("grad_month").equals("")) {
                graduation_date = request.getParameter("grad_year") + "-" + 
                        request.getParameter("grad_month") + "-01";
            }
            String password = "";
            //only get the password and encrypt it if it has been changed
            if(request.getParameter("password") != null && !request.getParameter("password").equals("")) {
                password = request.getParameter("password");
                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("MD5");
                    md.update(password.getBytes("UTF-8"));
                }
                catch(Exception x) {
                    notice = "Could not encrypt your password.  Please try again.";
                    request.setAttribute("notice", notice);
                    //forward request back to register JSP to show notice
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/student.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                password = (new BASE64Encoder()).encode(md.digest());
            }
            else {
                password = cur_student.getPassword();
            }
            // is_admin
            int is_admin = 0;
            if(request.getParameter("is_admin") != null) {
                is_admin = 1;
            }
            
            // create a new student object
            Student new_student = new Student(fname, lname, address1, address2, city, state, zip, 
                    email, password, is_admin, start_date, graduation_date);
            
            // check to see if they have changed their email
            if(!new_student.getEmail().equals(cur_student.getEmail())) {
                // check to see if the new email is already registered
                if(new_student.checkEmailIsRegistered()) {
                   // if email is already registered, re-route to registration page and display error
                   notice = "That email address is already registered!";
                   request.setAttribute("notice", notice);
                   request.setAttribute("student", new_student);
                   //forward request back to register JSP to show notice
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/student.jsp");
                   dispatcher.forward(request, response);
                   return;
                }
            }
            // save the user's information into the database
            if(!new_student.updateStudent(person_id)) {
                notice = "There was an error saving your information.  Please try again.";
                request.setAttribute("notice", notice);
                //forward request back to register JSP to show notice
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/student.jsp");
                dispatcher.forward(request, response);
                return;
            }
            
            // update was successful
            // replace Person object in session with updated Person object
            Person updated_person = new_student.getPerson(person_id);
            session.setAttribute("person", updated_person);
            // set the success notice
            notice = "Information successfully updated.";
            request.setAttribute("notice", notice);
            // forward back to index
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // if alumni, save updated info to db
        else if(action.equals("save_alumni")) {
            //get the current Person object from the session
            // and then get a current Alumni object
            Person person = (Person)session.getAttribute("person");
            Alumni cur_alumni = person.getAlumni();
            
            // get the person_id from the session
            int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
            
            // get student form details
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String address1 = request.getParameter("address1");
            String address2 = request.getParameter("address2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            String email = request.getParameter("email");
            String company_name = request.getParameter("company_name");
            String position = request.getParameter("position");
            // do they want to be a mentor
            int mentor = 0;
            if(request.getParameter("mentor") != null) {
                mentor = 1;
            }
            // build SQL-friendly date
            String graduation_date = request.getParameter("graduation_year") + "-" +
                    request.getParameter("graduation_month") + "-01";
            String password = "";
            //only get the password and encrypt it if it has been changed
            if(request.getParameter("password") != null) {
                password = request.getParameter("password");
                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("MD5");
                    md.update(password.getBytes("UTF-8"));
                }
                catch(Exception x) {
                    notice = "Could not encrypt your password.  Please try again.";
                    request.setAttribute("notice", notice);
                    //forward request back to register JSP to show notice
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/alumni.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                password = (new BASE64Encoder()).encode(md.digest());
            }
            else {
                password = cur_alumni.getPassword();
            }
            // is_admin
            int is_admin = 0;
            if(request.getParameter("is_admin") != null) {
                is_admin = 1;
            }
            
            // create a new student object
            Alumni new_alumni = new Alumni(fname, lname, address1, address2, city, state, zip, 
                    email, password, is_admin, company_name, position, graduation_date, mentor);
            
            // check to see if they have changed their email
            if(!new_alumni.getEmail().equals(cur_alumni.getEmail())) {
                // check to see if the new email is already registered
                if(new_alumni.checkEmailIsRegistered()) {
                   // if email is already registered, re-route to registration page and display error
                   notice = "That email address is already registered!";
                   request.setAttribute("notice", notice);
                   request.setAttribute("alumni", new_alumni);
                   //forward request back to register JSP to show notice
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/alumni.jsp");
                   dispatcher.forward(request, response);
                   return;
                }
            }
            // save the user's information into the database
            if(!new_alumni.updateAlumni(person_id)) {
                // replace Alumni object in session with updated Alumni object
                session.setAttribute("alumni", new_alumni);
                notice = "There was an error saving your information.  Please try again.";
                request.setAttribute("notice", notice);
                //forward request back to register JSP to show notice
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/alumni.jsp");
                dispatcher.forward(request, response);
                return;
            }
            
            // update was successful
            // replace Person object in session with updated Person object
            Person updated_person = new_alumni.getPerson(person_id);
            session.setAttribute("person", updated_person);
            // set the success notice
            notice = "Information successfully updated.";
            request.setAttribute("notice", notice);
            // forward back to index
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        // if hospital, save updated info to db
        else if(action.equals("save_hospital")) {
            //get the current Person object from the session
            // and then get a current Alumni object
            Person person = (Person)session.getAttribute("person");
            Hospital cur_hospital = person.getHospital();
            
            // get the person_id from the session
            int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
            
            // get student form details
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String address1 = request.getParameter("address1");
            String address2 = request.getParameter("address2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String url = request.getParameter("url");
            String password = "";
            //only get the password and encrypt it if it has been changed
            if(request.getParameter("password") != null && !request.getParameter("password").equals("")) {
                password = request.getParameter("password");
                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("MD5");
                    md.update(password.getBytes("UTF-8"));
                }
                catch(Exception x) {
                    notice = "Could not encrypt your password.  Please try again.";
                    request.setAttribute("notice", notice);
                    //forward request back to register JSP to show notice
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/hospital.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                password = (new BASE64Encoder()).encode(md.digest());
            }
            else {
                password = cur_hospital.getPassword();
            }
            // is_admin
            int is_admin = 0;
            if(request.getParameter("is_admin") != null) {
                is_admin = 1;
            }
            
            // create a new student object
            Hospital new_hospital = new Hospital(fname, lname, address1, address2, city, state, zip, 
                    email, password, is_admin, name, phone, url);
            
            // check to see if they have changed their email
            if(!new_hospital.getEmail().equals(cur_hospital.getEmail())) {
                // check to see if the new email is already registered
                if(new_hospital.checkEmailIsRegistered()) {
                   // if email is already registered, re-route to registration page and display error
                   notice = "That email address is already registered!";
                   request.setAttribute("notice", notice);
                   request.setAttribute("hospital", new_hospital);
                   //forward request back to register JSP to show notice
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/hospital.jsp");
                   dispatcher.forward(request, response);
                   return;
                }
            }
            // save the user's information into the database
            if(!new_hospital.updateHospital(person_id)) {
                // replace Hospital object in session with updated Hospital object
                session.setAttribute("hospital", new_hospital);
                notice = "There was an error saving your information.  Please try again.";
                request.setAttribute("notice", notice);
                //forward request back to register JSP to show notice
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/hospital.jsp");
                dispatcher.forward(request, response);
                return;
            }
            
            // update was successful
            // replace Person object in session with updated Person object
            Person updated_person = new_hospital.getPerson(person_id);
            session.setAttribute("person", updated_person);
            // set the success notice
            notice = "Information successfully updated.";
            request.setAttribute("notice", notice);
            // forward back to index
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // fall through to catch everything
        else {
            notice = "There was an error with your request.  Please try again.";
            request.setAttribute("notice", notice);
            //forward request back to register JSP to show notice
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member/hospital.jsp");
            dispatcher.forward(request, response);
            return;
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
