/*
 * Skills.java
 *
 * Created on March 5, 2007, 8:00 PM
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
public class Skills extends Super {
    
    private String skill_name;
    private String exp_length;
    private String description;

    /* instantiates a new instance of Skills */
    public Skills() {} // empty constructor

    public Skills(String skill_name, String exp_length, String description) {
        this.skill_name = skill_name;
        this.exp_length = exp_length;
        this.description = description;
    }
    
    public String getSkillName() { return skill_name; }
    
    public void setSkillName(String value) { skill_name = value; }
    
    public String getExpLength() { return exp_length; }
    
    public void setExpLength(String value) { exp_length = value; }
    
    public String getDescription() { return description; }
    
    public void setDescription(String value) { description = value; }
    
    public boolean saveSkill(int resume_id) {
        String sql = "INSERT INTO skills(resume_id, skill_name, exp_length, description) VALUES("
                 + resume_id + ", '" + addSlashes(getSkillName()) + "', '" + addSlashes(getExpLength())
                 + "', '" + addSlashes(getDescription()) + "')";
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
    
    public boolean deleteSkill(int id) {
        String sql = "DELETE FROM skills WHERE id=" + id;
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
    
    public ResultSet getSkill(int id) {
        String sql = "SELECT * FROM skills WHERE id=" + id;
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
    
    public boolean updateSkill(int id) {
        String sql = "UPDATE skills SET skill_name='" + addSlashes(getSkillName()) + 
                "', exp_length='" + addSlashes(getExpLength()) + "', description='" +
                addSlashes(getDescription()) + "' WHERE id=" + id;
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
