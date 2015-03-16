/*
 * logout.java
 *
 * Created on October 26, 2006, 9:47 PM
 */

package gsu;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Logout servlet
 * @author travis
 * @version 1.0
 */
public class logout extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException Exception
     * @throws java.io.IOException Exception
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // first, get the session
        HttpSession session = request.getSession();
        
        // now, destroy the session
        session.invalidate();
        
        // last, send them back to the index
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
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
