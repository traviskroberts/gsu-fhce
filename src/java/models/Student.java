/*
 * Student.java
 *
 * Created on October 20, 2006, 7:48 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.sql.*;


/**
 * Student object that extend the Person class
 * @author travis
 */
public class Student extends Person {
    
    private String start_date;
    private String graduation_date;
    
    /** Creates a new instance of Student */
    public Student() {
        super();
    }
    
    /**
     * Creates new instance of Student with all of the attributes
     * @param fname Value of the first name
     * @param lname Value of the last name
     * @param address1 Value of the first line of the address
     * @param address2 Value of the second line of the address
     * @param city Value of the city
     * @param state Value of the state
     * @param zip Value of the zip code
     * @param email Value of the email address
     * @param password Value of the password
     * @param start_date Value of the start date
     * @param graduation_date Value of the graduation date
     * @param is_admin Int value to determine if the member has access to admin functions
     */
    public Student(String fname, String lname, String address1, String address2, String city,
            String state, String zip, String email, String password, int is_admin, String start_date, 
            String graduation_date) {
        super(fname, lname, address1, address2, city, state, zip, email, password, is_admin);
        this.start_date = addSlashes(start_date);
        this.graduation_date = addSlashes(graduation_date);
    }
    
    /**
     * Sets the value of the start date
     * @param new_date New value of start date
     */
    public void setStartDate(String new_date) {
        start_date = new_date;
    }
    
    /**
     * Gets the value of the start date
     * @return start date
     */
    public String getStartDate() {
        return start_date;
    }
    
    /**
     * Sets the value of the graduation date
     * @param new_date New value of the graduation date
     */
    public void setGraduationDate(String new_date) {
        graduation_date = new_date;
    }
    
    /**
     * Gets the value of the graduation date
     * @return graduation date
     */
    public String getGraduationDate() {
        return graduation_date;
    }
    
    /**
     * Saves the Student object into the database
     * @return boolean
     */
    public boolean saveStudent() {
        // before we save, we need to escape apostraphes
        // first, do it for the Person object
        addSlashesToPerson();
        int person_id = 0;
        String sql = "INSERT INTO person(fname, lname, address1, address2, city, state, zip, " +
                "email, password, is_admin, member_type) VALUES(" + "'" + getFname() + "', '" + 
                getLname() + "', '" + getAddress1() + "', '" + getAddress2() + "', '" + 
                getCity() + "', '" + getState() + "', '" + getZip() + "', '"+ getEmail() + 
                "', '" + getPassword() + "', " + getIsAdmin() + ", 'student')";
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
        if(getGraduationDate().equals("")) {
            sql = "INSERT INTO student(person_id, start_date) VALUES(" +  
                person_id + ", '" + getStartDate() + "')";
        }
        else {
            sql = "INSERT INTO student(person_id, start_date, graduation_date) VALUES(" +  
                person_id + ", '" + getStartDate() + "', '" + getGraduationDate() + "')";
        }
        
        try{
            dbStatement.executeUpdate(sql);
        }
        catch(SQLException e) {
            // if we can't save the student part, get rid of the person part
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
     * Updated the Student record in the database
     * @return boolean
     * @param person_id ID of the person to update
     */
    public boolean updateStudent(int person_id) {
        // before we save, we need to escape apostraphes
        // first, do it for the Person object
        addSlashesToPerson();
        // now, do it for specific attributes
        start_date = addSlashes(start_date);
        graduation_date = addSlashes(graduation_date);
        String sql = "UPDATE person SET fname='" + getFname() + "', lname='" + getLname() + "', address1='"
                + getAddress1() + "', address2='" + getAddress2() + "', city='" + getCity() + "', " +
                "state='" + getState() + "', zip='" + getZip() + "', email='" + getEmail() + "', " +
                "password='" + getPassword() + "', is_admin=" + getIsAdmin() + 
                ", member_type='student' WHERE id=" + person_id;
        try{
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(sql);
            ;
        }
        catch(SQLException e) {
            return false;
        }
        if(getGraduationDate().equals("")) {
            sql = "UPDATE student SET start_date='" + getStartDate() + "' WHERE person_id=" + person_id;
        }
        else {
            sql = "UPDATE student SET start_date='" + getStartDate() + "', " +
                "graduation_date='" + getGraduationDate() + "' WHERE person_id=" + person_id;
        }
        try{
            dbStatement.executeUpdate(sql);
        }
        catch(SQLException e) {
            return false;
        }
        return true;
    }
    
    public String spitOutStudent(int id) {
        String output = "";
        String sql = "SELECT fname, lname FROM person, student WHERE student.id=" + id + 
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
