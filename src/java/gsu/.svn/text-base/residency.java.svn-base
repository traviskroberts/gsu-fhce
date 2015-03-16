/*
 * residency.java
 *
 * Created on October 13, 2006, 7:00 PM
  */

package gsu;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import models.*;

/**
 * Residency Servlet
 * @author Shane Severy
 * @version 1
 */
public class residency extends HttpServlet {

    private Statement dbStatement;
    private ResultSet dbResultSet;
    private ResultSetMetaData dbResultSetMetaData;
    private Connection connection;
    /**
     * Initializes the Servlet
     * @throws javax.servlet.ServletException Exception
     */
    public void init() throws ServletException {
        super.init();
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws java.io.IOException Exception
     * @throws javax.servlet.ServletException Exception
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String description=null;
        String deadlineDate=null;
        String endDate=null;
        String startDate=null;
        String title=null;
        

        HttpSession session = request.getSession();
        // set timeout value for 5 minutes
        session.setMaxInactiveInterval(300);
        
        // set the servlet-wide variables
        String action = "";
        String notice = "";
        String error = "";
        
        // see if there is an action
        if(request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        //Gets a listing of residencies for user hospital.
        if (action.equals("current_residencies")){
            // make sure they are logged in
            if(session.getAttribute("person") != null) {
                Person person = (Person)session.getAttribute("person");
                Residency residency = new Residency();
                int hospital_id = person.getHospitalId();
                dbResultSet = residency.getHospitalResidencies(hospital_id);

                String hospital_name = person.getHospitalName(hospital_id);
                
                session.setAttribute("hospital_name", hospital_name);
                request.setAttribute("result", dbResultSet);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/residency/index.jsp");
                dispatcher.forward(request, response);                   
                return;
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        //Deletes the selected residency
        if (action.equals("delete")){
            //Gets the residency id.
            int job_id = Integer.parseInt(request.getParameter("id")); 
            Residency residency = new Residency();
                if (residency.deleteResidency(job_id)) {
                    notice = "Residency has been successfully deleted.";
                    request.setAttribute("notice", notice);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/residency?action=current_residencies");
                    dispatcher.forward(request, response);
                    return; 
                }    
                else {
                    notice = "Error deleting the residency.";
                    request.setAttribute("notice", notice);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                    return;
                } 
        }
        //Selects the residency to be edited.
        if (action.equals("edit_residency")){
            //Gets the residency id
            int job_id = Integer.parseInt(request.getParameter("id")); 
            Residency residency = new Residency();
            dbResultSet = residency.getResidency(job_id);
                if (dbResultSet != null) {
                    request.setAttribute("result", dbResultSet);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/residency/edit_residency.jsp");
                    dispatcher.forward(request, response);
                    return; 
                }    
                else {
                    notice = "There was an error in locating the residency you selected.";
                    request.setAttribute("notice", notice);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                    return;
                } 
        }
       //Saves the residency information.
        if (action.equals("save_residency")) {
            Person person = (Person)session.getAttribute("person");            
            int job_id = Integer.parseInt(request.getParameter("job_id"));
            
            title = request.getParameter("title");
            description = request.getParameter("description");
            
            // start date
            String start_month = request.getParameter("startDateMonth");
            String start_day = request.getParameter("startDateDay");
            String start_year = request.getParameter("startDateYear");
            String start_date = start_year + start_month + start_day;

            // end date
            String end_month = request.getParameter("endDateMonth");
            String end_day = request.getParameter("endDateDay");
            String end_year = request.getParameter("endDateYear");
            String end_date = end_year + end_month + end_day;

            // deadline date
            String deadline_month = request.getParameter("deadlineDateMonth");
            String deadline_day = request.getParameter("deadlineDateDay");
            String deadline_year = request.getParameter("deadlineDateYear");
            String deadline_date = deadline_year + deadline_month + deadline_day;

            
            Residency residency = new Residency (job_id, title, start_date, end_date, deadline_date, description);

            // Update the residency.
            
            if (residency.updateResidency(job_id)) {
                    notice = "Residency has been successfully saved.";
                    request.setAttribute("notice", notice);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/residency?action=current_residencies");
                    dispatcher.forward(request, response);
                    return; 
            }    
            else {
                    notice = "Error saving the residency.";
                    request.setAttribute("notice", notice);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            
        }
        //Gets information to add residency
        if (action.equals("add_residency")) {
            if(session.getAttribute("person") != null) {
                title = request.getParameter("title");
                description = request.getParameter("description");
                
                // start date
                String start_month = request.getParameter("startDateMonth");
                String start_day = request.getParameter("startDateDay");
                String start_year = request.getParameter("startDateYear");
                String start_date = start_year + start_month + start_day;

                // end date
                String end_month = request.getParameter("endDateMonth");
                String end_day = request.getParameter("endDateDay");
                String end_year = request.getParameter("endDateYear");
                String end_date = end_year + end_month + end_day;

                // deadline date
                String deadline_month = request.getParameter("deadlineDateMonth");
                String deadline_day = request.getParameter("deadlineDateDay");
                String deadline_year = request.getParameter("deadlineDateYear");
                String deadline_date = deadline_year + deadline_month + deadline_day;
                
                Person person = (Person)session.getAttribute("person"); 
                int hId = person.getHospitalId();

                Residency residency = new Residency (title, start_date, end_date, deadline_date, description, hId);
                
                // Save the residency.      
                if (residency.saveResidency()) {
                        notice = "Residency has been successfully saved.";
                        request.setAttribute("notice", notice);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/residency?action=current_residencies");
                        dispatcher.forward(request, response);
                        return; 
                }    
                else {
                        notice = "Error saving the residency.";
                        request.setAttribute("notice", notice);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                        dispatcher.forward(request, response);
                        return;
                    }
            }
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        //Finds all open residencies.
        if (action.equals("open_residencies")){
            // make sure they are logged in
            if(session.getAttribute("person") != null) {
                Person person = (Person)session.getAttribute("person");
                Residency residency = new Residency();
                
                dbResultSet = residency.getResidencies();
                
                request.setAttribute("result", dbResultSet);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/residency/list_residency.jsp");
                dispatcher.forward(request, response);                   
                return;
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        //Retrieves a selected residency.
        if (action.equals("get_residency")){
            //Gets the residency id.
            int job_id = Integer.parseInt(request.getParameter("id")); 
            Residency residency = new Residency();
            Person person = (Person)session.getAttribute("person");
            //Gets the email address of the hospital for the selected residency.
            String email = person.getEmail();
            
                if (residency.getResidency(job_id)!= null) {
                    dbResultSet = residency.getResidency(job_id);
                    ResultSet resultSet;
                    try {
                        int hId = dbResultSet.getInt("hospital_id");
                        String hName = residency.getHospitalName(hId);
                        resultSet = person.getHospitalPhoneUrl(hId);
                        request.setAttribute("hName", hName);
                        request.setAttribute("email", email);
                        dbResultSet.beforeFirst();
                        resultSet.beforeFirst();
                    }
                    catch(SQLException e) {
                        error = "There was an error retreiving the residency.";
                        session.setAttribute("error", error);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                        dispatcher.forward(request, response);
                        return;
                   }
                    request.setAttribute("result", dbResultSet);
                    request.setAttribute("result2",resultSet);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/residency/detail_residency.jsp");
                    dispatcher.forward(request, response);
                    return; 
                }    
                else {
                    notice = "Error retrieving the residency.";
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
