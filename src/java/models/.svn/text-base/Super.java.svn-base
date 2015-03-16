/*
 * Super.java
 *
 * Created on January 28, 2007, 7:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.sql.*;

/**
 * Super class
 * @author travis
 */
public class Super {
    
    // db-specific variables
    /**
     * Database specific attribute for Statement
     */
    protected Statement dbStatement;
    /**
     * Database specific attribute for ResultSet
     */
    protected ResultSet dbResultSet;
    /**
     * Database specific attribute for ResultSetMetaData
     */
    protected ResultSetMetaData dbResultSetMetaData;
    /**
     * Database specific attribute for Connection
     */
    protected Connection connection;
    
    /** Creates a new instance of Super */
    public Super() {
        // connect to the database
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String dbURL = "jdbc:mysql://localhost:3306/ache";
            String username = "travis";
            String password = "";
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch(ClassNotFoundException e) {
            System.out.println("Database driver not found.");
        } catch(SQLException e) {
            System.out.println("Error opening the db connection: " + e.getMessage());
        }
    }
    
    /**
     * Escape certain characters for saving to database
     */
    public String addSlashes(String str) {
        if(str==null) return "";
        StringBuffer s = new StringBuffer ((String) str);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\'') {
                s.insert(i++, '\\');
            }
        }
        return s.toString();
    }
    
    /**
     * Truncates a String to a given length
     */
    public String truncate(String source, int maxSize) {
        if(source.length() > maxSize) {
            return source.substring(0,maxSize) + "...";
        }
        else {
            return source;
        }
    }
    
    /**
     * Gets the month name
     * @return String
     */
    public String getMonthName(String month) {
        int month_number = Integer.parseInt(month);
        if(month_number == 0) { return "Jan"; }
        else if(month_number == 1) { return "Feb"; }
        else if(month_number == 2) { return "Mar"; }
        else if(month_number == 3) { return "Apr"; }
        else if(month_number == 4) { return "May"; }
        else if(month_number == 5) { return "June"; }
        else if(month_number == 6) { return "July"; }
        else if(month_number == 7) { return "Aug"; }
        else if(month_number == 8) { return "Sep"; }
        else if(month_number == 9) { return "Oct"; }
        else if(month_number == 10) { return "Nov"; }
        else if(month_number == 11) { return "Dec"; }
        else { return ""; }
    }
    
}
