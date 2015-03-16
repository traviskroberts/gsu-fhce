/*
 * Page.java
 *
 * Created on February 1, 2007, 7:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.sql.*;

/**
 * Object for creating, saving, editing a content page
 * @author travis
 */
public class Page extends Super {
    
    private String title;
    private String content;
    private int parent_id;
    
    /** Creates a new instance of Page */
    public Page() {
    }
    
    /**
     * Creates a new instance of Page with values provided
     * @param title String value of title
     * @param content String value of content
     * @param parent_id Int value of parent id
     */
    public Page(String title, String content, int parent_id) {
        this.title = title;
        this.content = content;
        this.parent_id = parent_id;
    }
    
    /**
     * Sets the value of title
     * @param value String value of the title
     */
    public void setTitle(String value) {
        title = value;
    }
    
    /**
     * Gets the value of title
     * @return String value of the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the value of content
     * @param value String value of the content
     */
    public void setContent(String value) {
        content = value;
    }
    
    /**
     * Sets the value of content
     * @return String value of the content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Sets the value of parent id
     * @param value Int value of the parent id
     */
    public void setParentID(int value) {
        parent_id = value;
    }
    
    /**
     * Gets the value of parent id
     * @return Int value of the parent id
     */
    public int getParentID() {
        return parent_id;
    }
    
    /**
     * Checks to see if the oject has any child pages
     * @param id Int value of page id to check for subpages
     * @return Boolean to indicate whether a page has subpages or not
     */
    public boolean checkForSubPages(int id) {
        String sql = "SELECT * FROM pages WHERE parent_id=" + id;
        try{
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.last() && (dbResultSet.getRow() > 0)) {
                return true;
            }
            else {
                return false;
            }
        }
        catch(SQLException e) {
            return true;
        }
    }
    
    /**
     * Saves the page object into the database
     * @return Boolean to indicate success or failure
     */
    public boolean savePage() {
        String sql = "";
        if(getParentID() > 0) {
            sql = "INSERT INTO pages(title, content, parent_id) VALUES('" + 
                    addSlashes(getTitle()) + "', '" + addSlashes(getContent()) + 
                    "', " + getParentID() + ")";
        }
        else {
            sql = "INSERT INTO pages(title, content) VALUES('" + addSlashes(getTitle()) + 
                    "', '" + addSlashes(getContent()) + "')";
        }
        // attepmt to save page
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
    
    /**
     * Updates the page object in the database
     * @return Boolean to indicate success or failure
     * @param id Int value of page id to update
     */
    public boolean updatePage(int id) {
        String sql = "UPDATE pages SET title='" + addSlashes(getTitle()) + "', content='" + 
                addSlashes(getContent()) + "', parent_id=" + getParentID() + " WHERE id=" + id;
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
    
    /**
     * Deletes the page record from the database
     * @param id Int value of the page id to delete
     * @return Boolean to indicate success or failure
     */
    public boolean deletePage(int id) {
        String sql = "DELETE FROM pages WHERE id=" + id + " OR parent_id=" + id;
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
    
    /**
     * Builds output for displaying page navigation
     * @return String containing HTML formatted navigation
     */
    public String buildNavigation() {
        String nav = "";
        String sql = "SELECT * FROM pages WHERE parent_id=1";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            // get each page and build links
            while(dbResultSet.next()) {
                nav += "<li><a href=\"/gsu_fhce/content?action=view_page&amp;id=" + 
                        dbResultSet.getInt("id") + "\">" + dbResultSet.getString("title") + "</a></li>";
            }
        }
        catch(SQLException e) {
            return "";
        }
        return nav;
    }
    
    /**
     * Checks to see if the page has any subpages
     * @param id Int value of page id to check for subpages
     * @return Boolean to indicate whether a page has subpages or not
     */
    public boolean hasSubNavigation(int id) {
        String sql = "SELECT * FROM pages WHERE parent_id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.last() && dbResultSet.getRow() > 0) {
                return true;
            }
            else {
                return false;
            }
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    /**
     * Build output to show subpage navigation
     * @param id Int value of the page id to build subnav for
     * @return String containing HTML formatted subnavigation
     */
    public String buildSubNavigation(int id) {
        String nav = "";
        String sql = "SELECT * FROM pages WHERE parent_id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            // get each page and build links
            while(dbResultSet.next()) {
                nav += "<li><a href=\"/gsu_fhce/content?action=view_page&amp;id=" + 
                        dbResultSet.getInt("id") + "\">" + dbResultSet.getString("title") + "</a></li>";
            }
        }
        catch(SQLException e) {
            return "";
        }
        return nav;
    }
    
    /**
     * Retrieve the page object from the database
     * @param id Int value of the page record to retrieve from the database
     * @return Event object
     */
    public Page getPage(int id) {
        String sql = "SELECT * FROM pages WHERE id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                Page page = new Page(dbResultSet.getString("title"), dbResultSet.getString("content"), dbResultSet.getInt("parent_id"));
                return page;
            }
            else {
                return null;
            }
        }
        catch(SQLException e) {
            return null;
        }
    }
    
    public String getContent(String page_name) {
        String output = "";
        String sql = "SELECT content FROM pages WHERE title LIKE '" + page_name + "'";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                output += dbResultSet.getString("content");
                return output;
            }
            else {
                return output;
            }
        }
        catch(SQLException e) {
            return output;
        }
    }
    
}
