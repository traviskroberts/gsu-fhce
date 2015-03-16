/*
 * Residency.java
 *
 */

package models;

import java.sql.*;

/**
 * Residency Object
 * @author ssevery
 * @version 1
 */
public class Residency extends Super {
    
    private int id;
    private int hId;
    private String hName;
    private String title;
    private String startDate;
    private String endDate;
    private String deadlineDate;
    private String description;
    
    /**
     * Creates a new instance of the residency.
     */
    public Residency(){
    }

     /**
     * Creates a new instance of Residency with all of the attributes
     * @param id value of the id
     * @param hId value of the hospital id
     * @param hName value of the hospital name
     * @param title value of the title
     * @param startDate value of the start date
     * @param endDate value of the end date
     * @param deadlineDate value of the deadline date
     * @param description value of the description
     */
    
     public Residency(int id, int hId, String hName, String title, String startDate, 
            String endDate, String deadlineDate, String description) {
        this.id = id;
        this.hId = hId;
        this.hName = hName;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadlineDate = deadlineDate;
        this.description = description;  
     }
    /**
     * Creates a new instance of Residency with all of the attributes except the hospital name
     * @param hId Value of the hospital ID
     * @param title value of the title
     * @param startDate value of the start date
     * @param endDate value of the end date
     * @param deadlineDate value of the deadline date
     * @param description value of the description
     */
    public Residency(String title, String startDate, 
            String endDate, String deadlineDate, String description, int hId) {
        this.hId = hId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadlineDate = deadlineDate;
        this.description = description;
    }
        /**
     * Creates a new instance of Residency with all of the attributes except the hospital name
     * @param id value of the id
     * @param title value of the title
     * @param startDate value of the start date
     * @param endDate value of the end date
     * @param deadlineDate value of the deadline date
     * @param description value of the description
     */
     public Residency(int id, String title, String startDate, 
            String endDate, String deadlineDate, String description) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadlineDate = deadlineDate;
        this.description = description;
    }
    /**
     * Sets the value of the id.
     * @param value of the id
     */
    public void setId (int value){
        id=value;
    }
    
    /**
     * Gets the value of the residency id.
     * @return value of the id
     */
    public int getId (){
        return id;
    }
    /**
     * Sets the value of the id.
     * @param value of the id
     */
    public void setHId (int value){
        hId=value;
    }
    
    /**
     * Gets the value of the hospital id.
     * @return value of the id
     */
    public int getHId (){
        return hId;
    }
    
    /**
     * Sets the value of the residency title.
     * @param value of the hospital name
     */
    public void setHName (String value){
        hName=value;
    }
    
    /**
     * Gets the value of the residency title.
     * @return value of the hospital name
     */
    public String getHName(){
        return hName;
    }    
    /**
     * Sets the value of the residency title.
     * @param value of the title
     */
    public void setTitle (String value){
        title=value;
    }
    
    /**
     * Gets the value of the residency title.
     * @return value of the title
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * Sets the value of the residency description.
     * @param value of the description
     */
    public void setDescription (String value){
        description = value;
    }
    
    /**
     * Gets the value of the residency description.
     * @return value of the description
     */
    public String getDescription(){
        return description;
    }
    /**
     * Sets the value of the residency start date.
     * @param value of the start date
     */
    public void setStartDate (String value){
        startDate=value;
    }
    
    /**
     * Gets the value of the residency start date.
     * @return the value of the start date
     */
    public String getStartDate(){
        return startDate;
    }    
    /**
     * Sets the value of the residency end date.
     * @param value of the end date
     */
    public void setEndDate (String value){
        endDate=value;
    }
    
    /**
     * Gets the value of the residency end date.
     * @return the value of the end date
     */
    public String getEndDate(){
        return endDate;
    }    
    /**
     * Sets the value of the residency deadline date.
     * @param value of the deadline date
     */
    public void setDeadlineDate (String value){
      deadlineDate=value;
    }
    
    /**
     * Gets the value of the deadline date.
     * @return value of the deadline date
     */
    public String getDeadlineDate(){
        return deadlineDate;
    } 
    
    /**
     * Gets a information for a residency job listing given a
     * job listing id.
     * @param id Int value of the residency job listing id.
     * @return ResultSet containing residency record
     */
    public ResultSet getResidency(int id) {
        String sql = "SELECT * FROM job_listing WHERE id=" + id;
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
     * Gets all of the residency job listings ordered by hospital names
     * @return ResultSet containing residency records.
     */
    public ResultSet getResidencies() {
        String sql = "SELECT j.id as id, j.hospital_id as hId, h.name as hName, j.position_title as title, " +
                "j.deadline_date as deadline_date, j.start_date as start_date, j.end_date as end_date, " +
                "j.description as description from job_listing j, hospital h where j.hospital_id = h.id ORDER BY hName";
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
     * Saves the residency job listing record.
     * @return Boolean to indicate success or failure
     */
    public boolean saveResidency() {
        int hId = getHId();
        String title = addSlashes(getTitle());
        String deadlineDate = getDeadlineDate();
        String startDate = getStartDate();
        String endDate = getEndDate();
        String description = addSlashes(getDescription());
        String sql = "INSERT INTO job_listing(hospital_id, position_title, deadline_date, start_date, end_date, description) " +
                "VALUES(" + hId + ", '" + title + "', " + deadlineDate + ", " + startDate + ", " + 
                     endDate + ", '" + description + "')";
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
     * Updates the residency job listing record for
     * a job listing id.
     * @param id Int value of the residency job listing id.
     * @return Boolean to indicate success or failure
     */
    public boolean updateResidency(int id) {
        String sql = "UPDATE job_listing SET position_title ='" + addSlashes(getTitle()) + "', deadline_date = " + getDeadlineDate() +
                ", start_date =" + getStartDate() + ", end_date =" + getEndDate() + ", description ='" + addSlashes(getDescription()) + 
                "' WHERE id=" + id;
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
     * Deletes a job listing for an id.
     * @param id Int value of the residency job listing id.
     * @return Boolean to indicate success or failure
     */
    public boolean deleteResidency(int id) {
        String sql = "DELETE FROM job_listing WHERE id=" + id;
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
     * Gets a hospital id for a hospital name.
     * @param hName String of the hospital name.
     * @return Int of the hospital id.
     */
    public int getHospitalId(String hName){
               String sql = "SELECT id FROM hospital WHERE id=" + hName;
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
     * Gets the hospital name for a hospital id.
     * @param hospital_id Int value of the hospital id.
     * @return String of hospital name.
     */
     public String getHospitalName(int hospital_id) {
        String sql = "SELECT name FROM hospital WHERE id=" + hospital_id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.last() && (dbResultSet.getRow() == 1)) {
                return dbResultSet.getString("name");
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
     * Gets all hospitals ordered by hospital name.
     * @return ResultSet containing all records containing hospital ids and names
     */
    public ResultSet getHospitals() {
        String sql = "SELECT id, name FROM hospital ORDER BY name";
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
     * Gets a list of residency job listins for a specified hospital ordered 
     * by the residency end date.
     * @param hospital_id Int value of the hospital id.
     * @return ResultSet containing residency job listing records for specified hospital
     */
     public ResultSet getHospitalResidencies(int hospital_id) {
        String sql = "SELECT * FROM job_listing WHERE hospital_id=" + hospital_id + " ORDER BY end_date";
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
}
