/*
 * Hospital.java
 *
 * Created on October 24, 2006, 3:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.sql.*;

/**
 * Hospital object that extends Person
 * @author travis
 */
public class Hospital extends Person {
    
    private String name;
    private String phone;
    private String url;
    
    /** Creates a new instance of Hospital */
    public Hospital() {
        super();
    }
    
    /**
     * Creates new instance of Hospital with all of the attributes
     * @param fname Value of the first name
     * @param lname Value of the last name
     * @param address1 Value of the first line of the address
     * @param address2 Value of the second line of the address
     * @param city Value of the city
     * @param state Value of the state
     * @param zip Value of the zip code
     * @param email Value of the email address
     * @param password Value of the password
     * @param name Value of the hospital name
     * @param is_admin Int representing if they are an admin or not
     * @param phone String value of phone
     * @param url String value of hospital web site url
     */
    public Hospital(String fname, String lname, String address1, String address2, String city,
            String state, String zip, String email, String password, int is_admin, String name,
            String phone, String url) {
        super(fname, lname, address1, address2, city, state, zip, email, password, is_admin);
        this.name = name;
        this.phone = phone;
        this.url = url;
    }
    
    /**
     * Constructor used to create a hospital object with no contact person
     * @param address1 Value of the first line of the address
     * @param address2 Value of the second line of the address
     * @param city Value of the city
     * @param state Value of the state
     * @param zip Value of the zip code
     * @param name Value of the hospital name
     * @param phone String value of phone
     * @param url String value of hospital web site url
     */
    public Hospital(String lname, String address1, String address2, String city,
            String state, String zip, String name, String phone, String url) {
        super(lname, address1, address2, city, state, zip);
        this.name = name;
        this.phone = phone;
        this.url = url;
    }
    
    /**
     * Gets the value of the hospital name
     * @return Value of hospital name
     */
    public String getName() { return name; }
    
    /**
     * Sets the value of the hospitals name
     * @param value New value of hospital name
     */
    public void setName(String value) { name = value; }
    
    /**
     * Returns value of phone number
     * @return String value of phone number
     */
    public String getPhone() { return phone; }
    
    /**
     * Sets the value of the phone number
     * @param value String value of phone number
     */
    public void setPhone(String value) { phone = value; }
    
    /**
     * Gets the value of the web site url
     * @return String value of web site url
     */
    public String getURL() { return url; }
    
    /**
     * Sets the value of the web site url
     * @param value String value of the web site url
     */
    public void setURL(String value) { url = value; }
    
   
    /**
     * Saves the Hospital object into the database
     * @return boolean
     */
    public boolean saveHospital() {
        // before we save, we need to escape apostraphes for the Person object\
        addSlashesToPerson();
        int person_id = 0;
        String sql = "INSERT INTO person(fname, lname, address1, address2, city, state, zip, " +
                "email, password, is_admin, member_type) VALUES(" + "'" + getFname() + "', '" + 
                getLname() + "', '" + getAddress1() + "', '" + getAddress2() + "', '" + 
                getCity() + "', '" + getState() + "', '" + getZip() + "', '"+ getEmail() + 
                "', '" + getPassword() + "', " + getIsAdmin() + ", 'hospital')";
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
        sql = "INSERT INTO hospital(person_id, name, phone, url) VALUES(" + person_id + 
                ", '" + addSlashes(getName()) + "', '" + addSlashes(getPhone()) + "', '" +
                addSlashes(getURL()) + "')";
        try{
            dbStatement.executeUpdate(sql);
        }
        catch(SQLException e) {
            // if we can't save the hospital part, get rid of the person part
            sql = "DELETE FROM person WHERE id=" + person_id;
            try {
                dbStatement.executeUpdate(sql);
            }
            catch(SQLException x) {
                return false;
            }
            return false;
        }
        return true;
    }
    
    /**
     * Updated the Hospital record in the database
     * @param person_id Id of the person to update
     * @return boolean
     */
    public boolean updateHospital(int person_id) {
        // before we save, we need to escape apostraphes
        // first, do it for the Person object
        addSlashesToPerson();
        // now, do it for specific attributes
        name = addSlashes(name);
        String sql = "UPDATE person SET fname='" + getFname() + "', lname='" + getLname() + "', address1='"
                + getAddress1() + "', address2='" + getAddress2() + "', city='" + getCity() + "', " +
                "state='" + getState() + "', zip='" + getZip() + "', email='" + getEmail() + "', " +
                "password='" + getPassword() + "', is_admin=" + getIsAdmin() + 
                ", member_type='hospital' WHERE id=" + person_id;
        try{
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(sql);
            ;
        }
        catch(SQLException e) {
            return false;
        }
        sql = "UPDATE hospital SET name='" + getName() + "', phone='" +
                addSlashes(getPhone()) + "', url='" + addSlashes(getURL()) + 
                "' WHERE person_id=" + person_id;
        try{
            dbStatement.executeUpdate(sql);
        }
        catch(SQLException e) {
            return false;
        }
        return true;
    }
     /**
     * @author Shane Severy
     */   
    /**
     * Used by an admin to save a created hospital without specifying contact person
     * @return Boolean to indicate success or failure
     */
    public boolean saveHospitalAdmin() {
        // before we save, we need to escape apostraphes for the Person object\
        addSlashesToPerson();
        int person_id = 0;
        String sql = "INSERT INTO person(lname, address1, address2, city, state, zip, phone, member_type)" +
                "VALUES('" + getLname() + "', '" + getAddress1() + "', '" + getAddress2() + "', '" + 
                getCity() + "', '" + getState() + "', '" + getZip() + "', '" + getPhone() + "', 'hospital')";
        try{
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(sql);
            ;
        }
        catch(SQLException e) {
            return false;
        }
        sql = "SELECT id FROM person order by id desc limit 1";
        try{
            dbResultSet = dbStatement.executeQuery(sql);
            if(dbResultSet.next()) {
                person_id = dbResultSet.getInt("id");
            }
        }
        catch(SQLException e) {
            return false;
        }
        sql = "INSERT INTO hospital(person_id, name, url) VALUES(" + person_id + 
                ", '" + addSlashes(getName()) + "', '" +
                addSlashes(getURL()) + "')";
        try{
            dbStatement.executeUpdate(sql);
        }
        catch(SQLException e) {
            return false;
        }
        return true;
    }    
    
}
