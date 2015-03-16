/*
 * Education.java
 *
 * Created on March 4, 2007, 8:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.sql.*;

/**
 * Model for saving education experience in the database
 * @author travis
 */
public class Education extends Super {
    
    /** Creates a new instance of Education */
    private String degree;
    private String school_name;
    private String city;
    private String state;
    private String start_date;
    private String end_date;
    private String description;

    /**
     * Blank constructor
     */
    public Education() {} // empty constructor

    /**
     * Constructor that accepts all values for Education model
     * @param degree Name of the degree earned
     * @param school_name Name of the school attended
     * @param city Name of the city where school is located
     * @param state Name of state where school is located
     * @param start_date Date degree started
     * @param end_date Date degree completed
     * @param description Any extra information about the degree
     */
    public Education(String degree, String school_name, String city, String state,
            String start_date, String end_date, String description) {
        this.degree = degree;
        this.school_name = school_name;
        this.city = city;
        this.state = state;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }

    /**
     * Returns value of degree
     * @return String value of degree
     */
    public String getDegree() { return degree; }

    /**
     * Sets the value of the degree
     * @param value String value of degree
     */
    public void setDegree(String value) { degree = value; }

    /**
     * Gets the value of the school name
     * @return String value of the school
     */
    public String getSchoolName() { return school_name; }

    /**
     * Sets the value of the school name
     * @param value String value of school name
     */
    public void setSchoolName(String value) { school_name = value; }

    /**
     * Gets the value of the city
     * @return String value of city
     */
    public String getCity() { return city; }

    /**
     * Sets the value of the city
     * @param value String value of city
     */
    public void setCity(String value) { city = value; }

    /**
     * Gets the value of the state
     * @return String value of state
     */
    public String getState() { return state; }

    /**
     * Sets the value of the state
     * @param value String value of state
     */
    public void setState(String value) { state = value; }

    /**
     * Gets the value of the start date
     * @return String value of start date
     */
    public String getStartDate() { return start_date; }

    /**
     * Sets the value of the start date
     * @param value String value of start date
     */
    public void setStartDate(String value) { start_date = value; }

    /**
     * Gets teh value of the end date
     * @return String value of end date
     */
    public String getEndDate() { return end_date; }

    /**
     * Sets the value of the end date
     * @param value String value of end date
     */
    public void setEndDate(String value) { end_date = value; }

    /**
     * Gets the value of the description
     * @return String value of descripton
     */
    public String getDescription() { return description; }

    /**
     * Sets the value of the description
     * @param value String value of description
     */
    public void setDescription(String value) { description = value; }

    /**
     * Commits the education object to the database
     * @param resume_id Int value of resume id
     * @return Boolean to indicate success or failure
     */
    public boolean saveEducation(int resume_id) {
        String sql = "";
        if(getEndDate().equals("")) {
            sql = "INSERT INTO education(resume_id, degree, school_name, city, state, start_date, " +
                "description) VALUES(" + resume_id + ", '" + addSlashes(getDegree()) + "', '"
                 + addSlashes(getSchoolName()) + "', '" + addSlashes(getCity()) + "', '"
                 + getState() + "', '" + getStartDate() + "', '" + addSlashes(getDescription()) + "')";
        }
        else {
            sql = "INSERT INTO education(resume_id, degree, school_name, city, state, start_date, " +
                "end_date, description) VALUES(" + resume_id + ", '" + addSlashes(getDegree()) + "', '"
                 + addSlashes(getSchoolName()) + "', '" + addSlashes(getCity()) + "', '"
                 + getState() + "', '" + getStartDate() + "', '" + getEndDate() + "', '"
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
    
    /**
     * Removed education record from database
     * @param id Int value of the id of the education record to retrieve
     * @return Boolean to indicate success or failure
     */
    public boolean deleteEducation(int id) {
        String sql = "DELETE FROM education WHERE id=" + id;
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
    
    /**
     * Retrieves education record from database
     * @param id Int value of the id of the education record to retrieve
     * @return Education object
     */
    public ResultSet getEducation(int id) {
        String sql = "SELECT * FROM education WHERE id=" + id;
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
    
    /**
     * Updates education record in database with values of object
     * @param id Int id for the education record to update
     * @return Boolean to indicate success or failure
     */
    public boolean updateEducation(int id) {
        String sql = "";
        if(getEndDate().equals("")) {
            sql = "UPDATE education SET degree='" + addSlashes(getDegree()) + "', school_name='" +
                    addSlashes(getSchoolName()) + "', city='" + addSlashes(getCity()) + "', state='" +
                    getState() + "', start_date='" + getStartDate() + "', description='" +
                    addSlashes(getDescription()) + "' WHERE id=" + id;
        }
        else {
            sql = "UPDATE education SET degree='" + addSlashes(getDegree()) + "', school_name='" +
                    addSlashes(getSchoolName()) + "', city='" + addSlashes(getCity()) + "', state='" +
                    getState() + "', start_date='" + getStartDate() + "', end_date='" + getEndDate() + 
                    "', description='" + addSlashes(getDescription()) + "' WHERE id=" + id;
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
