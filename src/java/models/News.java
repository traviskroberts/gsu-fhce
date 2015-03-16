/*
 * News.java
 *
 * Created on November 16, 2006, 10:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.security.MessageDigest;
import java.io.*;
import java.security.*;
import sun.misc.*;

import java.sql.*;


/**
 *
 * @author Adrian Flynt
 */
public class News extends Super {
    
    private String id;
    private String title;
    private String date;
    private String content;
    private String year;
    private String month;
    private String day;
    
    
    /** Creates a new instance of News */
    public News (String title, String date, String content){
    this.title = title;
    this.date = date;
    this.content = content;
      
    }
    
    /**
     * Creates a new instance of News when passed attributes
     * @param title Value of the title
     * @param year Value of the description
     * @param month Value of the month
     * @param day Value of the day
     * @param content Value of the content
     */
    public News (String title, String year, String month, String day, String content){
    this.title = title;
    this.year = year;
    this.month = month;
    this.day = day;
    this.content = content;
    
    }
        
    public News () {}
    /**
     * Sets the value of the id
     * @param value New value of the id 
     */
    public void setId(String value) {
        id = value;
    }
    
    /**
     * gets the value of the id
     * @return Value of the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Sets the value of the title
     * @param value New value of the id 
     */
     public void setTitle(String value) {
        title = value;
    }
     
     /**
     * gets the value of the title
     * @return Value of the title
     */
    
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the value of the date
     * @param value New value of the date 
     */
    
     public void setDate(String value) {
        date = value;
    }
     
     /**
     * gets the value of the date
     * @return Value of the date
     */
    
    public String getDate() {
        return date;
    }
    
    /**
     * Gets the value of month
     * @return Value of the month
     */
    public String getMonth() {
        return month;
    }
    
    /**
     * Sets the value of month
     * @param value New value of the month
     */
    public void setMonth(String value) {
        month = value;
    }
    
    /**
     * Gets the value of day
     * @return Value of the day
     */
    public String getDay() {
        return day;
    }
    
    /**
     * Sets the value of day
     * @param value New value of the day
     */
    public void setDay(String value) {
        day = value;
    }
    
    /**
     * Gets the value of year
     * @return Value of the year
     */
    public String getYear() {
        return year;
    }
    
    /**
     * Sets the value of year
     * @param value New value of the year
     */
    public void setYear(String value) {
        year = value;
    }
    
    /**
     * Sets the value of the content
     * @param value New value of the content 
     */
    
     public void setContent(String value) {
        content = value;
    }
     
     /**
     * gets the value of the content
     * @return Value of the content
     */
    
    public String getContent() {
        return content;
    }
    
    /**
     * Builds output for three most recent news items
     * @return String of HTML formatted list of news
     */
    public String buildRecentNews() {
        String output = "";
        String sql = "SELECT id, title, date, content FROM news ORDER BY date DESC LIMIT 3";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            while(dbResultSet.next()) {
                // build an attractive date
                String date = "";
                if(!dbResultSet.getString("date").equals("")) {
                    date = dbResultSet.getString("date").substring(5,7) + "/" +
                            dbResultSet.getString("date").substring(8,10) + "/" +
                            dbResultSet.getString("date").substring(0,4);
                }
                output += "<div class=\"story\">";
                output += "<p class=\"news_title\">";
                output += "<a href=\"/gsu_fhce/news?action=detail&amp;id=" + dbResultSet.getInt("id") + "\">";
                output += dbResultSet.getString("title") + "</a> - " + date;
                output += "</p>";
                output += "<p>" + truncate(dbResultSet.getString("content"), 225) + "</p>";
                output += "<p class=\"news_link\"><a href=\"/gsu_fhce/news?action=detail&amp;id=" + dbResultSet.getInt("id") + "\">Read full story&raquo;</a></p>";
                output += "</div><!-- story -->";
            }
        }
        catch(SQLException e) {
            return output;
        }
        return output;
    }
    
    /**
     * Retrieve the details of the news from the database
     * @param id Int value of the news id to retrieve
     * @return News object
     */
    public News getNews(int id) {
        String sql = "SELECT * FROM news WHERE id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                String title = dbResultSet.getString("title");
                String date = dbResultSet.getString("date");
                String content = dbResultSet.getString("content");
                String year = date.substring(0,4);
                String month = date.substring(5,7);
                String day = date.substring(8,10);
                
                News news = new News(title, year, month, day, content);
                return news;
            }
            else {
                return null;
            }
        }
        catch(SQLException e) {
            return null;
        }
    }

    /**
     * Updates the news record in the database with the value of the object
     * @param id Int value of the id of the news record to update
     * @return Boolean to indicate success or failure
     */
    public boolean updateNews(int id) {
        String date = getYear() + "-" + getMonth() + "-" + getDay();
        String sql = "UPDATE news SET title='" + addSlashes(getTitle()) + "', date='" + 
                getDate() + "', content='" + 
                addSlashes(getContent()) + "' WHERE id=" + id;
        
        try{
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(sql);
            ;
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    /**
     * Adds news record to the database
     * @return Boolean to indicate success or failure
     */
    public boolean addNews (){
         String addNewsSQL = "INSERT INTO news (title, date, content) "
                        + "VALUES (' " + addSlashes(getTitle()) + "', " +
                        "'" + getDate() + "', " +
                        "'" + addSlashes(getContent()) + "')";
         
         try{
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(addNewsSQL);
            ;
            return true;
        }
        catch(SQLException e) {
            return false;
        }
         
    }
    
    /**
     * Gets list of all news records from the database  
     * @return ResultSet to show all news records
     */
    public ResultSet getNewsList() {
        String getNewsListSQL = "SELECT id, title, date, content FROM news";
        
        try{
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(getNewsListSQL);
            ;
            if(dbResultSet.last() && (dbResultSet.getRow() > 0)) {
                dbResultSet.beforeFirst();
                return dbResultSet;
            }
            else {
                return null;
            }
        }
        catch(SQLException e) {
            return null;
        }
    }
    
    /**
     * Gets news detail from the database
     * @param id String value of the news id of interest 
     * @return ResultSet to show the content of the news record
     */
    public ResultSet getNewsDetail(String id) {
        String getNewsListSQL = "select title, date, content from news" +
                       " where id=" + id;
        
        try{
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(getNewsListSQL);
            ;
            if(dbResultSet.last() && (dbResultSet.getRow() > 0)) {
                dbResultSet.beforeFirst();
                return dbResultSet;
            }
            else {
                return null;
            }
        }
        catch(SQLException e) {
            return null;
        }
    }
    /**
     * Deletes news record from the database
     * @param id Int value of the news id to delete
     * @return Boolean to indicate success or failure
     */
    public boolean deleteNews(int id) {
        String sql = "DELETE FROM news WHERE id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(sql);
            ;
        }
        catch(SQLException e) {
            return false;
        }
        return true;
    }

}
