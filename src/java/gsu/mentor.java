/*
 * mentor.java
 *
 * Created on April 2, 2007, 8:47 PM
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
 * @author Charles
 * @version
 */
public class mentor extends HttpServlet {
    
   private Statement dbStatement;
   private Statement dbStatement2;
   private ResultSet dbResultSet;
   private ResultSet dbResultSet2;
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
        
        //get context initialization parameters
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        try {
            String driver = context.getInitParameter("driver");
            Class.forName(driver);
            String dbURL = context.getInitParameter("db");
            String username = context.getInitParameter("username");
            String password = "";
            connection = DriverManager.getConnection(dbURL, username, password);
        }
        catch(ClassNotFoundException e) {
            System.out.println("Database driver not found.");
        }
        catch(SQLException e) {
            System.out.println("Error opening the db connection: " + e.getMessage());
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
}
    // </editor-fold>
