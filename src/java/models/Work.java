/*
 * Work.java
 *
 * Created on March 5, 2007, 7:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.sql.*;

/**
 *
 * @author travis
 */
public class Work extends Super {
    
    private String company_name;
    private String city;
    private String state;
    private String position;
    private String start_date;
    private String end_date;
    private String description;

    /** Creates a new instance of Work */
    public Work() {} //empty constructor

    public Work(String company_name, String city, String state, String position, String start_date,
            String end_date, String description) {
        this.company_name = company_name;
        this.city = city;
        this.state = state;
        this.position = position;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }
    
    public String getCompany() { return company_name; }
    
    public void setCompany(String value) { company_name = value; }
    
    public String getCity() { return city; }
    
    public void setCity(String value) { city = value; }
    
    public String getState() { return state; }
    
    public void setState(String value) { state = value; }
    
    public String getPosition() { return position; }
    
    public void setPosition(String value) { position = value; }
    
    public String getStartDate() { return start_date; }
    
    public void setStartDate(String value) { start_date = value; }
    
    public String getEndDate() { return end_date; }
    
    public void setEndDate(String value) { end_date = value; }
    
    public String getDescription() { return description; }
    
    public void setDescription(String value) { description = value; }
    
    public boolean saveWork(int resume_id) {
        String sql = "";
        if(getEndDate().equals("")) {
            sql = "INSERT INTO work_experience(resume_id, company_name, city, state, position, start_date, " +
                "description) VALUES(" + resume_id + ", '" + addSlashes(getCompany()) + "', '"
                 + addSlashes(getCity()) + "', '" + getState() + "', '"
                 + addSlashes(getPosition()) + "', '" + getStartDate() + "', '"
                 + addSlashes(getDescription()) + "')";
        }
        else {
            sql = "INSERT INTO work_experience(resume_id, company_name, city, state, position, start_date, " +
                "end_date, description) VALUES(" + resume_id + ", '" + addSlashes(getCompany()) + "', '"
                 + addSlashes(getCity()) + "', '" + getState() + "', '"
                 + addSlashes(getPosition()) + "', '" + getStartDate() + "', '" + getEndDate() + "', '"
                 + addSlashes(getDescription()) + "')";
        }
        try {
            dbStatement = connection.createStatement();
            dbStatement.execute(sql);
            ;
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    public boolean deleteWork(int id) {
        String sql = "DELETE FROM work_experience WHERE id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbStatement.execute(sql);
            ;
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    public ResultSet getWork(int id) {
        String sql = "SELECT * FROM work_experience WHERE id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            return dbResultSet;
        }
        catch(SQLException e) {
            return null;
        }
    }
    
    public boolean updateWork(int id) {
        String sql = "";
        if(getEndDate().equals("")) {
            sql = "UPDATE work_experience SET company_name='" + addSlashes(getCompany()) + 
                    "', city='" + addSlashes(getCity()) + "', state='" + getState() + 
                    "', position='" + addSlashes(getPosition()) + "', start_date='" +
                    getStartDate() + "', description='" + addSlashes(getDescription()) +
                    "' WHERE id=" + id;
        }
        else {
            sql = "UPDATE work_experience SET company_name='" + addSlashes(getCompany()) + 
                    "', city='" + addSlashes(getCity()) + "', state='" + getState() + 
                    "', position='" + addSlashes(getPosition()) + "', start_date='" +
                    getStartDate() + "', end_date='" + getEndDate() + "', description='" + 
                    addSlashes(getDescription()) + "' WHERE id=" + id;
        }
        try {
            dbStatement = connection.createStatement();
            dbStatement.execute(sql);
            ;
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
}
