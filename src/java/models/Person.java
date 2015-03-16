/*
 * Person.java
 *
 * Created on October 20, 2006, 7:43 PM
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
 * Superclass for all members
 * @author travis
 */
public class Person extends Super {
    
    private String fname;
    private String lname;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String password;
    private int is_admin;
    
    /** Creates a new instance of Person */
    public Person() {
    
    }
    
    /**
     * Creates a new instance of Person
     * @param fname Value for first name
     * @param lname Value for the last name
     * @param address1 Value for the first line of the address
     * @param address2 Value for the second line of the address
     * @param city Value for the city
     * @param state Value for the state
     * @param zip Value for the zip code
     * @param email Value for the email address
     * @param password Value for the password
     * @param is_admin Int to determine if member has access to admin functions
     */
    public Person(String fname, String lname, String address1, String address2, String city,
            String state, String zip, String email, String password, int is_admin) {
        this.fname = fname;
        this.lname = lname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }
    
    /**
     * Creates a new instance of Person
     * @param address1 Value for the first line of the address
     * @param address2 Value for the second line of the address
     * @param city Value for the city
     * @param state Value for the state
     * @param zip Value for the zip code
     */
    public Person(String lname, String address1, String address2, String city,
            String state, String zip) {
        this.lname = lname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    /**
     * Sets the First Name
     * @param value New value of first name
     */
    public void setFname(String value) {
        fname = value;
    }
    
    /**
     * Gets the first name
     * @return first name
     */
    public String getFname() {
        return fname;
    }
    
    /**
     * Sets the value of the last name
     * @param value new value of last name
     */
    public void setLname(String value) {
        lname = value;
    }
    
    /**
     * Returns the last name
     * @return last name
     */
    public String getLname() {
        return lname;
    }
    
    /**
     * Sets the value of the first line of the address
     * @param value new value of first line of address
     */
    public void setAddress1(String value) {
        address1 = value;
    }
    
    /**
     * Gets the value of the first line of the address
     * @return first line of address
     */
    public String getAddress1() {
        return address1;
    }
    
    /**
     * Sets the value for the second line of the address
     * @param value new value of second line of address
     */
    public void setAddress2(String value) {
        address2 = value;
    }
    
    /**
     * Gets the value of the second line of the address
     * @return second line of address
     */
    public String getAddress2() {
        return address2;
    }
    
    /**
     * Sets the value for the city
     * @param value new value of city
     */
    public void setCity(String value) {
        city = value;
    }
    
    /**
     * Gets the value of the city
     * @return city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Sets the value for the state
     * @param value new value of state
     */
    public void setState(String value) {
        state = value;
    }
    
    /**
     * Gets the value of the state
     * @return state
     */
    public String getState() {
        return state;
    }
    
    /**
     * Sets the value for the zip code
     * @param value new value of zip code
     */
    public void setZip(String value) {
        zip = value;
    }
    
    /**
     * Gets the value of the zip code
     * @return email address
     */
    public String getZip() {
        return zip;
    }
    
    /**
     * Sets the value for the email address
     * @param value new value of email address
     */
    public void setEmail(String value) {
        email = value;
    }
    
    /**
     * Gets the value of the email address
     * @return email address
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the value for the password
     * @param value new value of password
     */
    public void setPassword(String value) {
        password = value;
    }
    
    /**
     * Gets the value of the password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the value for is_admin
     * @param value new value of is_admin
     */
    public void setIsAdmin(int value) {
        is_admin = value;
    }
    
    /**
     * Gets the value of is_admin
     * @return is_admin
     */
    public int getIsAdmin() {
        return is_admin;
    }
    
    /**
     * Encrypts the password using the MD5 hash algorithm
     * @return boolean
     */
    public boolean encryptPass() {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(getPassword().getBytes("UTF-8"));
        }
        catch(NoSuchAlgorithmException x) {
            return false;
        }
        catch(UnsupportedEncodingException e) {
            return false;
        }
        String encrypted_password = (new BASE64Encoder()).encode(md.digest());
        setPassword(encrypted_password);
        return true;
    }
    
    /**
     * Checks to see if the email address is already registered
     * @return boolean
     */
    public boolean checkEmailIsRegistered() {
        String sql_check_email = "SELECT * FROM person WHERE email LIKE '" + email + "'";
        try{
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql_check_email);
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
     * Escapes all necessary characters before saving record to database
     */
    public void addSlashesToPerson() {
        fname = addSlashes(fname);
        lname = addSlashes(lname);
        address1 = addSlashes(address1);
        address2 = addSlashes(address2);
        city = addSlashes(city);
        zip = addSlashes(zip);
        email = addSlashes(email);
    }
    
    /**
     * Checks to see if the person is an admin
     * @return Boolean to indicate whether they are an admin or not
     */
    public boolean isAdmin() {
        String sql = "SELECT is_admin FROM person WHERE id=" + getID();
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.last() && (dbResultSet.getInt("is_admin") == 1)) {
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
     * Gets the id of the person record in the database
     * @return Int value of record id in database
     */
    public int getID() {
        String sql_get_id = "SELECT id FROM person WHERE email LIKE '" + getEmail() + "'";
        try{
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql_get_id);
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
     * Gets the Person object
     * @return Person object
     * @param id Person id
     */
    public Person getPerson(int id) {
        String sql = "SELECT * FROM person WHERE id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                Person person = new Person(dbResultSet.getString("fname"), dbResultSet.getString("lname"), 
                        dbResultSet.getString("address1"), dbResultSet.getString("address2"), 
                        dbResultSet.getString("city"), dbResultSet.getString("state"), 
                        dbResultSet.getString("zip"), dbResultSet.getString("email"), 
                        dbResultSet.getString("password"), dbResultSet.getInt("is_admin"));
                return person;
            }
            else {
                return null;
            }
        }
        catch(Exception x) {
            return null;
        }
    }
    
    /**
     * Deletes the person record and associated member record from the database
     * @param member_type String value of person member type
     * @return Boolean indicated success or failure
     */
    public boolean deletePerson(String member_type) {
        String sql_delete_person = "DELETE FROM person WHERE id=" + getID();
        String sql_delete_member = "DELETE FROM " + member_type + " WHERE person_id=" + getID();
        // First, delete the person record
        try {
            dbStatement = connection.createStatement();
            if(!dbStatement.execute(sql_delete_person)) {
                // it worked
                ;
            }
            else {
                ;
                return false;
            }
        }
        catch(SQLException e) {
            return false;
        }
        // Then, delete the member record
        try {
            dbStatement = connection.createStatement();
            if(!dbStatement.execute(sql_delete_member)) {
                ;
                return true;
            }
            else {
                ;
                return false;
            }
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    /**
     * Gets the Student object based on the Person ID
     * @return Student object
     */
    public Student getStudent() {
        String sql = "SELECT * FROM student WHERE person_id=" + getID();
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                Student student = new Student(getFname(), getLname(), getAddress1(), getAddress2(),
                        getCity(), getState(), getZip(), getEmail(), getPassword(), getIsAdmin(),
                        dbResultSet.getString("start_date"),
                        dbResultSet.getString("graduation_date"));
                return student;
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
     * Gets the Alumni object based on the Person ID
     * @return Alumni object
     */
    public Alumni getAlumni() {
        String sql = "SELECT * FROM alumni WHERE person_id=" + getID();
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                Alumni alumni = new Alumni(getFname(), getLname(), getAddress1(), getAddress2(),
                        getCity(), getState(), getZip(), getEmail(), "", getIsAdmin(), 
                        dbResultSet.getString("company_name"), dbResultSet.getString("position"),
                        dbResultSet.getString("graduation_date"), dbResultSet.getInt("mentor"));
                return alumni;
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
     * Gets the Hospital object based on the Person ID
     * @return Hospital object
     */
    public Hospital getHospital() {
        String sql = "SELECT * FROM hospital WHERE person_id=" + getID();
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                Hospital hospital = new Hospital(getFname(), getLname(), getAddress1(), getAddress2(),
                        getCity(), getState(), getZip(), getEmail(), "", getIsAdmin(), 
                        dbResultSet.getString("name"), dbResultSet.getString("phone"), 
                        dbResultSet.getString("url"));
                return hospital;
            }
            else {
                return null;
            }
        }
        catch(SQLException e) {
            return null;
        }
    }
    //Shane
    /**
     * Gets the hospital id from the database associated with a person
     * @return Int value of hospital id
     */
    public int getHospitalId() {
        String sql = "SELECT id FROM hospital WHERE person_id=" + getID();
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                int id = dbResultSet.getInt("id");
                return id;
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
     * Gets the hospital name from the database associated with a person
     * @param hospital_id Int value of the hospital id
     * @return String value of hospital name
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
     * Gets the hospital id from the database associated with a hospital
     * @param hName String value of the hospital name
     * @return Int value of the hospital id
     */
    public int getHospitalId(String hName){
        String sql = "SELECT id FROM hospital WHERE name LIKE '" + hName + "'";
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
     * Gets the person id from the database associated with a person
     * @param hName String value of the hospital name
     * @return Int value of the hospital id
     */
    public int getPersonId(String hName){
        String sql = "SELECT person_id FROM hospital WHERE name LIKE '" + hName + "'";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.last() && (dbResultSet.getRow() == 1)) {
                return dbResultSet.getInt("person_id");
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
     * Gets the hospital phone number from the database associated with a person
     * @param hospital_id Int value of the hospital id
     * @return String value of the hospital phone number
     */
        public ResultSet getHospitalPhoneUrl(int hospital_id) {
        String sql = "SELECT phone, url FROM hospital WHERE id=" + hospital_id;
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
    public Hospital getHospital(int id) {
        String sql = "SELECT * FROM hospital WHERE person_id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                Hospital hospital = new Hospital(getFname(), getLname(), getAddress1(), getAddress2(),
                        getCity(), getState(), getZip(), getEmail(), getPassword(), getIsAdmin(), 
                        dbResultSet.getString("name"), dbResultSet.getString("phone"), 
                        dbResultSet.getString("url"));
                return hospital;
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
     * Gets the students information given a resume id
     * @param resume_id Int value of the resume id to get the corresponding person info for
     * @return ResultSet object
     */
    public ResultSet getStudentInfo(int resume_id) {
        String sql = "SELECT lname, fname, address1, address2, city, state, "+
                     "phone, email FROM person, resume r WHERE person.id=r.person_id "+
                     "and r.id=" + resume_id;
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
