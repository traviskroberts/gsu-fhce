/*
 * content.java
 *
 * Created on February 3, 2007, 6:49 PM
 */

package gsu;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import models.*;

/**
 *
 * @author Travis Roberts
 * @version
 */
public class content extends HttpServlet {
    
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
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // get the session
        HttpSession session = request.getSession();
        // set timeout value for 5 minutes
        session.setMaxInactiveInterval(300);
        
        String action;
        String notice;
        
        // if there is an action, get it
        if(request.getParameter("action") != null) {
            action = (String)request.getParameter("action");
        }
        // if no action, bounce them back to index
        else {
            notice = "Unknown request.  Please try again.";
            request.setAttribute("notice", notice);
            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
            dispatch.forward(request, response);
            return;
        }
        
        // the only possible action is to view a content page
        if(action.equals("view_page")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Page pg = new Page();
            pg = pg.getPage(id);
            request.setAttribute("page", pg);
            request.setAttribute("id", Integer.toString(id));
            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/view_page.jsp");
            dispatch.forward(request, response);
            return;
        }
        else {
            notice = "Unknown request.  Please try again.";
            request.setAttribute("notice", notice);
            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
            dispatch.forward(request, response);
            return;
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
