/*
 * Alumni.java
 *
 * Created on October 23, 2006, 8:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.sql.*;

/**
 * Alumni object that extends the Person object
 * @author travis
 */
public class Alumni extends Person {
    
    private String company_name;
    private String position;
    private String graduation_date;
    private int mentor;
    
    /** Creates a new instance of Alumni */
    public Alumni() {
    }
    
    /**
     * Creates a new instance of Alumni with all of the attributes
     * @param fname Value for first name
     * @param lname Value for the last name
     * @param address1 Value for the first line of the address
     * @param address2 Value for the second line of the address
     * @param city Value for the city
     * @param state Value for the state
     * @param zip Value for the zip code
     * @param email Value for the email address
     * @param password Value for the password
     * @param company_name Value for the company name
     * @param position Value for the position
     * @param graduation_date Value for the graduation date
     * @param is_admin Boolean to determine if the member has access to admin functions
     * @param mentor Boolean to see if the person is interested in being a mentor
     */
    public Alumni(String fname, String lname, String address1, String address2, String city,
            String state, String zip, String email, String password, int is_admin, String company_name, 
            String position, String graduation_date, int mentor) {
        super(fname, lname, address1, address2, city, state, zip, email, password, is_admin);
        this.company_name = company_name;
        this.position = position;
        this.graduation_date = graduation_date;
        this.mentor = mentor;
    }
    
    /**
     * Gets the company name
     * @return Value of company name
     */
    public String getCompanyName() {
        return company_name;
    }
    
    /**
     * Sets the value of the company name
     * @param value New value of company name
     */
    public void setCompanyName(String value) {
        company_name = value;
    }
    
    /**
     * Gets the position
     * @return Value of position
     */
    public String getPosition() {
        return position;
    }
    
    /**
     * Sets the value of the position
     * @param value New value of position
     */
    public void setPosition(String value) {
        position = value;
    }
    
    /**
     * Gets the graduation date
     * @return Value of graduation date
     */
    public String getGraduationDate() {
        return graduation_date;
    }
    
    /**
     * Sets the value of the graduation date
     * @param value New value of the graduation date
     */
    public void setGraduationDate(String value) {
        graduation_date = value;
    }
    
    /**
     * Gets the mentor value
     * @return Value of mentor
     */
    public int getMentor() {
        return mentor;
    }
    
    /**
     * Sets the value of the mentor
     * @param value New value of the mentor
     */
    public void setMentor(int value) {
        mentor = value;
    }
    
    /**
     * Saves the Alumni object into the database
     * @return boolean
     */
    public boolean saveAlumni() {
        // before we save, we need to escape apostrophes for the Person object
        addSlashesToPerson();
        int person_id = 0;
        String sql = "INSERT INTO person(fname, lname, address1, address2, city, state, zip, " +
                "email, password, is_admin, member_type) VALUES(" + "'" + getFname() + "', '" + 
                getLname() + "', '" + getAddress1() + "', '" + getAddress2() + "', '" + 
                getCity() + "', '" + getState() + "', '" + getZip() + "', '"+ getEmail() + 
                "', '" + getPassword() + "', " + getIsAdmin() + ", 'alumni')";
        try{
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(sql);
            ;
        }
        catch(SQLException e) {
            return false;
        }
        sql = "SELECT id FROM person WHERE email LIKE '" + getEmail() + "'";
        try{
            dbResultSet = dbStatement.executeQuery(sql);
            if(dbResultSet.next()) {
                person_id = dbResultSet.getInt("id");
            }
        }
        catch(SQLException e) {
            return false;
        }
        sql = "INSERT INTO alumni(person_id, company_name, position, graduation_date, mentor) VALUES(" +  
                person_id + ", '" + addSlashes(getCompanyName()) + "', '" + addSlashes(getPosition()) + 
                "', '" + getGraduationDate() + "', " + getMentor() + ")";
        try{
            dbStatement.executeUpdate(sql);
        }
        catch(SQLException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Updates the alumni record in the database
     * @param person_id The id of the Person to update
     * @return boolean
     */
    public boolean updateAlumni(int person_id) {
        // before we save, we need to escape apostraphes for the Person object
        addSlashesToPerson();
        String sql = "UPDATE person SET fname='" + getFname() + "', lname='" + getLname() + "', address1='"
                + getAddress1() + "', address2='" + getAddress2() + "', city='" + getCity() + "', " +
                "state='" + getState() + "', zip='" + getZip() + "', email='" + getEmail() + "', " +
                "password='" + getPassword() + "', is_admin=" + getIsAdmin() +
                ", member_type='alumni' WHERE id=" + person_id;
        try{
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(sql);
            ;
        }
        catch(SQLException e) {
            return false;
        }
        sql = "UPDATE alumni SET company_name='" + addSlashes(getCompanyName()) + "', position='" + 
                addSlashes(getPosition()) + "', graduation_date='" + getGraduationDate() + 
                "', mentor=" + getMentor() + " WHERE person_id=" + person_id;
        try{
            dbStatement.executeUpdate(sql);
        }
        catch(SQLException e) {
            return false;
        }
        return true;
    }
    
    public String spitOutAlumni(int id) {
        String output = "";
        String sql = "SELECT fname, lname FROM person, alumni WHERE alumni.id=" + id + 
                " AND person_id=person.id";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            if(dbResultSet != null && dbResultSet.next()) {
                output += dbResultSet.getString("fname");
                output += " ";
                output += dbResultSet.getString("lname");
            }
        }
        catch(SQLException e) {
            return output;
        }
        return output;
    }
    
}
