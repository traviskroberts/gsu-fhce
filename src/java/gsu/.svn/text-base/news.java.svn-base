/*
 * news.java
 *
 * Created on October 13, 2006, 6:58 PM
 */

package gsu;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import models.*;

import java.sql.*;

/**
 *
 * @author travis
 * @version
 */
public class news extends HttpServlet {
    private ResultSet dbResultSet;
    
    /** Initializes the servlet.
     */
    public void init() throws ServletException {
        super.init();
    }
    
 /**======================================================================================**/
 /**Adrian**/
 /**======================================================================================**/
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String message = "";
        String error = "";
        
        // Get the parameter from the calling page.
        String action = request.getParameter("action");
        //attempt to add news to the database
        if (action.equals("Add News")) {
            String id = "";
            // Get the parameters to add the news story to the database
            String title = request.getParameter("title");
            String date = request.getParameter("year") + "-" + request.getParameter("month")+ "-" + request.getParameter("day");
            String content = request.getParameter("content");   
            
            // create the News object with the supplied information
            News news = new News(title, date, content);
                
                        //  Use method to add the news.
            if(news.addNews()){
                message = "News successfully added.";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pressroom.jsp");
                dispatcher.forward(request, response);
            }
            else {
             message = "Could not add news.";
             request.setAttribute("message", message);
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pressroom.jsp");
                dispatcher.forward(request, response);
            }
           
        }//end of add news processing
        
        //news list processing
        
        if (action.equals("get_list")) {
            
            News news = new News();
            
            // use the method to get a list of news articles for non-admin.
            if(news.getNewsList() != null){
                dbResultSet = news.getNewsList();
                request.setAttribute("result", dbResultSet);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/news/list.jsp");
                dispatcher.forward(request, response);
            }
            else {
                error = "Could not get news list.";
                request.setAttribute("error", error);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
            
            
           
        }//end of get non admin news list processing
        
        if (action.equals("Get Admin News List")) {
            
            News news = new News();
            
            // use the method to get a list of news articles for non-admin.
            if(news.getNewsList() != null){
                dbResultSet = news.getNewsList();
                request.setAttribute("result", dbResultSet);
                
                
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/news/list.jsp");
                dispatcher.forward(request, response);
            }
            else {
             message = "Could not get news list.";
             request.setAttribute("message", message);
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pressroom.jsp");
                dispatcher.forward(request, response);
            }
            
            
           
        }//end of get admin news list processing
        
        

                    
        // news detail processing
        
        if (action.equals("detail")) {
           
            
            String id = request.getParameter("id");
            News news = new News();
            if(news.getNewsDetail(id)!= null){
                dbResultSet = news.getNewsDetail(id);
                request.setAttribute("result", dbResultSet);
                
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/news/news_detail.jsp");
                dispatcher.forward(request, response);
            }
            else {
             error = "Could not get news detail.";
             request.setAttribute("error", error);
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
                
              
            
            
       }//end of news detail processing
        
        //delete record processing
        if (action.equals("delete")){
            int id = 0;
            id = Integer.parseInt(request.getParameter("id"));
            News news = new News();
          if(news.deleteNews(id)){
              message = "News successfully deleted.";
              request.setAttribute("message", message);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pressroom.jsp");
                    dispatcher.forward(request, response);
                    return; 
                }    
                else {
                    message = "Error deleting the news.";
                    request.setAttribute("message", message);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pressroom.");
                    dispatcher.forward(request, response);  
                }

                      
    }//end delete news processing
        
        //begin edit news processing
        // edit an news item, get id of news item from list.jsp, these values will go to news_update and populate for editing
           if(action.equals("edit")) {
            // get the id of the news to edit
            
            int id = Integer.parseInt(request.getParameter("id"));
            News news = new News();
            news = news.getNews(id);
            if(news != null) {
                request.setAttribute("news", news);
                request.setAttribute("id", Integer.toString(id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/news/news_update.jsp");
                dispatcher.forward(request, response);
                return;
            }
            else {
                message = "Error retrieving news from the database.";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/news/index.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

        
        
        
          //begin update news processing
        if (action.equals("Update News")){
            
             
            String title = request.getParameter("title");//get title 
            String date = (request.getParameter("year")) + (request.getParameter("month")) + (request.getParameter("day"));            
            String content = request.getParameter("content"); //get content

            
            int id = Integer.parseInt(request.getParameter("newsid"));          

            // create the News object with the supplied information
            News news = new News(title, date, content);              
              
            // Use method to update the news.

            if(news.updateNews(id)){
                message = "News successfully updated.";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pressroom.jsp");
                dispatcher.forward(request, response);
            }
            else {   
             message = "Could not update news.";
             request.setAttribute("message", message);
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pressroom.jsp");
                dispatcher.forward(request, response);
            }
              
        } //end update news processing

           
        
    }//end of processRequest method
    
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

