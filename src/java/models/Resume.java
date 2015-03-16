/*
 * Resume.java
 *
 * Created on February 24, 2007, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.sql.*;

/**
 * Resume object
 * @author travis
 */
public class Resume extends Super {
    
    private int person_id;
    private String title;
    private String comments;
    
    /** Creates a new empty instance of Resume */
    public Resume() {
    }
    
    /**
     * Creates new instance of Resume
     * @param person_id Int value of the person id
     * @param title String value of the resume title
     * @param comments String value of the comments
     */
    public Resume(int person_id, String title, String comments) {
        this.person_id = person_id;
        this.title = title;
        this.comments = comments;
    }
    
    /**
     * Gets the value of the person id
     * @return Int value of the person id
     */
    public int getPersonID() {
        return person_id;
    }
    
    /**
     * Sets the value of the person id
     * @param value Int value of the person id
     */
    public void setPersonID(int value) {
        person_id = value;
    }
    
    /**
     * Gets the value of the title
     * @return String value of title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the value of the title
     * @param value String value of the title
     */
    public void setTitle(String value) {
        title = value;
    }
    
    /**
     * Gets the value of the comments
     * @return String value of the comments
     */
    public String getComments() {
        return comments;
    }
    
    /**
     * Sets the value of the comments
     * @param value String value of the comments
     */
    public void setComments(String value) {
        comments = value;
    }
    
    /**
     * Gets the resume oject from the database
     * @param person_id Int value of the person id to retrieve the resume for
     * @return ResultSet containing resume data
     */
    public ResultSet getResume(int person_id) {
        String sql = "SELECT * FROM resume WHERE person_id=" + person_id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.last() && (dbResultSet.getRow() == 1)) {
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
     * Gets all education associated with the resume
     * @param resume_id Int value of the resume id to retrieve education for
     * @return ResultSet containt education records
     */
    public ResultSet getEducation(int resume_id) {
        String sql = "SELECT * FROM education WHERE resume_id=" + resume_id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
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
     * Gets all of the work experience associated with the resume
     * @param resume_id Int value of the resume id to retrieve work for
     * @return ResultSet containing work records
     */
    public ResultSet getWorkExperience(int resume_id) {
        String sql = "SELECT * FROM work_experience WHERE resume_id=" + resume_id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
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
     * Gets all of the skill associated with the resume
     * @param resume_id Int value of the resume id to retrieve skills for
     * @return ResultSet containing skills records
     */
    public ResultSet getSkills(int resume_id) {
        String sql = "SELECT * FROM skills WHERE resume_id=" + resume_id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
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
     * Saves the resume object into the database
     * @return Boolean indicating success or failure
     */
    public boolean saveResume() {
        String sql = "INSERT INTO resume(person_id, title, additional_comments) VALUES(" +
                getPersonID() + ", '" + addSlashes(getTitle()) + "', '" + 
                addSlashes(getComments()) + "')";
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
     * Gets the value of the resume id
     * @param person_id Int value of person id to retrieve resume for
     * @return ResultSet containing resume record
     */
    public int getID(int person_id) {
        String sql = "SELECT id FROM resume WHERE person_id=" + person_id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.last() && (dbResultSet.getRow() == 1)) {
                return dbResultSet.getInt("id");
            }
            else {
                return 0;
            }
        }
        catch(SQLException e) {
            return 0;
        }
    }
    
    /**
     * Updates the title in the resume record
     * @param id Int value of the resume id to update
     * @param title String value of the new title
     * @return Boolean to indicate success or failure
     */
    public boolean updateTitle(int id, String title) {
        String sql = "UPDATE resume SET title='" + addSlashes(title) + "' WHERE id=" + id;
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
     * Updates the comments in the resume record
     * @param id Int value of resume id to update
     * @param comments String value of new comments
     * @return Boolean to indicate success or failure
     */
    public boolean updateComments(int id, String comments) {
        String sql = "UPDATE resume SET additional_comments='" + 
                addSlashes(comments) + "' WHERE id=" + id;
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
     * Finalize and save resume
     * @return Boolean to indicate success or failure
     */
    public boolean finalizeResume() {
        String sql = "UPDATE resume SET additional_comments='" + addSlashes(getComments()) + 
                "' WHERE person_id=" + getPersonID();
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
     * Formats the dates to be in the form 'Jan 2000 - Jan 2005'
     * @param start_date String value of the start date
     * @param end_date String value of the end date
     * @return String of dates concatenated
     */
    public String formatDates(String start_date, String end_date) {
        String formatted = "";
        if(!start_date.equals("")) {
            String start_year = start_date.substring(0,4);
            String start_month = start_date.substring(5,7);
            formatted += getMonthName(start_month) + " " + start_year + " - ";
        }
        if(end_date != null) {
            String end_year = end_date.substring(0,4);
            String end_month = end_date.substring(5,7);
            formatted += getMonthName(end_month) + " " + end_year;
        }
        else {
            formatted += "current";
        }
        return formatted;
    }
    
    /**
     * Retrieves all resumes from the database
     * @return ResultSet containing all of the resume records
     */
    public ResultSet listResumes(){
        String sql = "select r.id, p.id, fname, lname, graduation_date from resume r, "+
                     "person p, student s where r.person_id = p.id = s.person_id order by lname";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
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
     * Gets the details of a resume from the database
     * @param resume_id Int value of the resume to retrieve
     * @return ResultSet containing resume record
     */
    public ResultSet getResumeDetail(int resume_id) {
        String sql = "SELECT * FROM resume WHERE id=" + resume_id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.last() && (dbResultSet.getRow() == 1)) {
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
}
