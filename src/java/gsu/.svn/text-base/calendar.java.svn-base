/*
 * calendar.java
 *
 * Created on October 13, 2006, 6:58 PM
 */

package gsu;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import models.*;

/**
 * Calendar servlet
 * @author travis
 * @version 1.0
 */
public class calendar extends HttpServlet {

    private Statement dbStatement;
    private ResultSet dbResultSet;
    private ResultSetMetaData dbResultSetMetaData;
    private Connection connection;
    
    /**
     * Initializes the servlet
     * @throws javax.servlet.ServletException Exception
     */
    public void init() throws ServletException {
        super.init();
    }
    
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
        
        String action;
        
        // if there is an action, get it
        if(request.getParameter("action") != null) {
            action = (String)request.getParameter("action");
            
            if(action.equals("update_event")) {
                return;
            }
        }
        
        // otherwise, just forward to index and show current month
        else {
            Event right_now = new Event();
            session.setAttribute("event", right_now);
            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/events/index.jsp");
            dispatch.forward(request, response);
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
