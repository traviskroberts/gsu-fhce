/*
 * Mentor.java
 *
 * Created on March 17, 2007, 7:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;
import java.sql.*;
import javax.servlet.http.HttpSession;
import org.omg.CORBA.MARSHAL;
/**
 *
 * @author Charles
 */
/*
 * Mentor.java
 *
 */

public class Mentor extends Super {
    
    private int id;
    private int student_id;
    private int alumni_id;
    
    /**
     * Creates a new instance of the mentorship.
     */
    public Mentor(){
        super();
    }
    /**
     * Creates a new instance of Mentor with all of the attributes
     * @param id value of the id
     * @param student_id value of the student
     * @param alumni_id value of alumni
     */
    public Mentor(int id, int student_id, int alumni_id) {
        this.id = id;
        this.student_id = student_id;
        this.alumni_id = alumni_id;
     }
    /**
     * Sets the value of the id.
     * @param value of the id
     */
    public void setId (int value){
        id = value;
    }
    
    /**
     * Gets the value of the mentorship id.
     * @return value of the id
     */
    public int getId (){
        return id;
    }
    
    /**
     * Sets the value of the Student ID.
     * @param value of the student ID
     */
    public void setStudent_id (int value){
        student_id = value;
    }
    
    /**
     * Gets the value of the Student ID.
     * @return value of the student ID
     */
    public int getStudent_id(){
        return student_id;
    }
    
    /**
     * Sets the value of the Alumni ID.
     * @param value of the Alumni ID
     */
    public void setAlumni_id (int value){
        alumni_id = value;
    }
    
    /**
     * Gets the value of the mentorship description.
     * @return value of the description
     */
    public int getAlumni_id(){
        return alumni_id;
    }

    public boolean addMentorship(int student_id, int alumni_id) {
        String sql = "INSERT INTO mentorship(alumni_id, student_id) " +
                "VALUES(" + student_id + ", " + alumni_id + ");";
        try{
            dbStatement = connection.createStatement();
            dbStatement.execute(sql);
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    public boolean delMentorship(int id) {
        String sql = "DELETE FROM mentorship WHERE id = " + id + ";";
        try{
            dbStatement = connection.createStatement();
            dbStatement.execute(sql);
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    public ResultSet getMentorships() {
        String sql = "SELECT * FROM mentorship";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            return dbResultSet;
        }
        catch(SQLException e) {
            return null;
        }
    }
    
    public ResultSet getAlumnis() {
        String sql = "SELECT a.id, p.fname, p.lname FROM alumni a, person p WHERE a.person_id=p.id AND " +
                "a.id NOT IN (SELECT alumni_id FROM mentorship)";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            return dbResultSet;
        }
        catch(SQLException e) {
            return null;
        }
    }
    
    public ResultSet getStudents() {
        String sql = "SELECT s.id, p.fname, p.lname FROM student s, person p WHERE s.person_id=p.id AND " +
                "s.id NOT IN (SELECT student_id FROM mentorship)";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            return dbResultSet;
        }
        catch(SQLException e) {
            return null;
        }
    }
   
}
