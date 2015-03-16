/*
 * resume.java
 *
 * Created on October 13, 2006, 6:58 PM
 */

package gsu;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import models.*;

/**
 *
 * @author Travis Roberts
 * @version 1.0
 */
public class resume extends HttpServlet {

    private Statement dbStatement;
    private ResultSet dbResultSet;
    private ResultSetMetaData dbResultSetMetaData;
    private Connection connection;
    
    public void init() throws ServletException {
        super.init();
    }
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // get the session
        HttpSession session = request.getSession();
        // set timeout value for 5 minutes
        session.setMaxInactiveInterval(300);
        
        // set the servlet-wide variables
        String action = "";
        String notice = "";
        String error = "";
        
        // see if there is an action
        if(request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        if(action.equals("get_resume") || action.equals("")) { // otherwise, forward them to the intial screen
            // make sure they are logged in
            if(session.getAttribute("person") != null) {
                Person person = (Person)session.getAttribute("person");
                Resume resume = new Resume();
                dbResultSet = resume.getResume(person.getID());
                int resume_id;
                // if they already have a resume, get details and forward to edit page
                if(dbResultSet != null) {
                    // get all of their education, work, and skills
                    ResultSet education_results = null;
                    ResultSet work_results = null;
                    ResultSet skills_results = null;
                    try {
                        resume_id = dbResultSet.getInt("id");
                        education_results = resume.getEducation(resume_id);
                        work_results = resume.getWorkExperience(resume_id);
                        skills_results = resume.getSkills(resume_id);
                    }
                    catch(SQLException e) {
                        error = "There was an error retreiving your resume.";
                        session.setAttribute("error", error);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                        dispatcher.forward(request, response);
                        return;
                    }
                    // set request attributes and forward to edit page
                    request.setAttribute("resume_id", Integer.toString(resume_id));
                    request.setAttribute("resume_result", dbResultSet);
                    request.setAttribute("education_results", education_results);
                    request.setAttribute("work_results", work_results);
                    request.setAttribute("skills_results", skills_results);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/edit_resume.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                // don't have a resume yet? forward then to the index
                else {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/index.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // now check for actions and process accordingly
        // Step 1 of the resume addition process
        if(action.equals("create_resume")) {
            // get the person from the session
            Person person = (Person)session.getAttribute("person");
            String name = request.getParameter("name");
            Resume resume = new Resume(person.getID(), name, "");
            if(resume.saveResume()) {
                int resume_id = resume.getID(person.getID());
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_education.jsp");
                dispatcher.forward(request, response);
                return;
            }
            else {
                notice = "There was an error creating your resume.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/index.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        // save off the education and either add another or go on to work exp
        else if(action.equals("ed_add_more") || action.equals("ed_continue")) {
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String degree = request.getParameter("degree");
            String school = request.getParameter("school");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String description = request.getParameter("description");
            // build the dates to be SQL-friendly
            // start date
            String start_month = request.getParameter("start_month");
            String start_year = request.getParameter("start_year");
            String start_date = start_year + "-" + start_month + "-01";
            // graduation date
            String grad_month = request.getParameter("grad_month");
            String grad_year = request.getParameter("grad_year");
            String grad_date = "";
            if(!grad_month.equals("") && !grad_year.equals("")) {
                grad_date = grad_year + "-" + grad_month + "-01";
            }
            // create an Education object
            Education education = new Education(degree, school, city, state, start_date, grad_date, description);
            if(education.saveEducation(resume_id)) {
                notice = "Education successfully added.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                if(action.equals("ed_add_more")) {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_education.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_work.jsp");
                    dispatcher.forward(request, response);
                }
                return;
            }
            else {
                notice = "There was an error saving your education.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_education.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        // add work experience
        else if(action.equals("work_add_more") || action.equals("work_continue")) {
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String company = request.getParameter("company");
            String position = request.getParameter("position");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String description = request.getParameter("description");
            // build the dates to be SQL-friendly
            // start date
            String start_month = request.getParameter("start_month");
            String start_year = request.getParameter("start_year");
            String start_date = start_year + "-" + start_month + "-01";
            // end date
            String end_month = request.getParameter("end_month");
            String end_year = request.getParameter("end_year");
            String end_date = "";
            if(!end_month.equals("") && !end_year.equals("")) {
                end_date = end_year + "-" + end_month + "-01";
            }
            // create a Work object
            Work work = new Work(company, city, state, position, start_date, end_date, description);
            if(work.saveWork(resume_id)) {
                notice = "Work experience successfully added.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                if(action.equals("work_add_more")) {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_work.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_skill.jsp");
                    dispatcher.forward(request, response);
                }
                return;
            }
            else {
                notice = "There was an error saving your work experience.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_work.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        // add skills
        else if(action.equals("skill_add_more") || action.equals("skill_continue")) {
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String skill_name = request.getParameter("name");
            String exp_length = request.getParameter("exp_length");
            String description = request.getParameter("description");
            // create a Skills object
            Skills skill = new Skills(skill_name, exp_length, description);
            if(skill.saveSkill(resume_id)) {
                notice = "Skill successfully added.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                if(action.equals("skill_add_more")) {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_skill.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/finalize.jsp");
                    dispatcher.forward(request, response);
                }
                return;
            }
            else {
                notice = "There was an error saving your skill.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_work.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        // finalize the resume
        else if(action.equals("finalize")) {
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String comments = request.getParameter("comments");
            // get the person from the session
            Person person = (Person)session.getAttribute("person");
            Resume resume = new Resume(person.getID(), "", comments);
            if(resume.finalizeResume()) {
                notice = "Resume successfully saved.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/confirm.jsp");
                dispatcher.forward(request, response);
            }
            else {
                notice = "There was an error completing your resume.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/finalize.jsp");
                dispatcher.forward(request, response);
            }
            return;
            
        }
        
        // delete operations for resume
        // delete education
        else if(action.equals("delete_education")) {
            int id = Integer.parseInt(request.getParameter("id"));
            // create an Education object so we can delete education entry
            Education education = new Education();
            if(education.deleteEducation(id)) {
                notice = "Education successfully deleted.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
            }
            else {
                notice = "There was an error deleting the education.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
        // delete work experience
        else if(action.equals("delete_work")) {
            int id = Integer.parseInt(request.getParameter("id"));
            // create a Work object so we can delete work entry
            Work work = new Work();
            if(work.deleteWork(id)) {
                notice = "Work experience successfully deleted.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
            }
            else {
                notice = "There was an error deleting the work experience.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
        // delete skill
        else if(action.equals("delete_skill")) {
            int id = Integer.parseInt(request.getParameter("id"));
            // create a Skills object so we can delete skill entry
            Skills skills = new Skills();
            if(skills.deleteSkill(id)) {
                notice = "Skill successfully deleted.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
            }
            else {
                notice = "There was an error deleting the skill.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
        
        // edit operations for resume
        // edit education
        else if(action.equals("edit_education")) {
            int id = Integer.parseInt(request.getParameter("id"));
            // create an Education object so we can get the education from the db
            Education education = new Education();
            ResultSet result = education.getEducation(id);
            if(result != null) {
                request.setAttribute("result", result);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/edit_education.jsp");
                dispatcher.forward(request, response);
            }
            else {
                notice = "There was an error retrieving education.";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
        // edit work experience
        else if(action.equals("edit_work")) {
            int id = Integer.parseInt(request.getParameter("id"));
            // create a Work object so we can get the work from the db
            Work work = new Work();
            ResultSet result = work.getWork(id);
            if(result != null) {
                request.setAttribute("result", result);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/edit_work.jsp");
                dispatcher.forward(request, response);
            }
            else {
                notice = "There was an error retrieving work experience.";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
        // edit skill
        else if(action.equals("edit_skill")) {
            int id = Integer.parseInt(request.getParameter("id"));
            // create a Skills object so we can get the skill from the db
            Skills skills = new Skills();
            ResultSet result = skills.getSkill(id);
            if(result != null) {
                request.setAttribute("result", result);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/edit_skill.jsp");
                dispatcher.forward(request, response);
            }
            else {
                notice = "There was an error retrieving skill.";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
        // edit resume title
        else if(action.equals("edit_title")) {
            // get the parameters
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String title = request.getParameter("title");
            request.setAttribute("resume_id", Integer.toString(resume_id));
            request.setAttribute("title", title);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/edit_title.jsp");
            dispatcher.forward(request, response);
            return;
        }
        // edit comments
        else if(action.equals("edit_comments")) {
            // get the parameters
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String comments = request.getParameter("comments");
            request.setAttribute("resume_id", Integer.toString(resume_id));
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/edit_comments.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // update operations for resume
        // update education
        else if(action.equals("update_education")) {
            // get the request parameters
            int id = Integer.parseInt(request.getParameter("id"));
            String degree = request.getParameter("degree");
            String school = request.getParameter("school");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String description = request.getParameter("description");
            // build the dates to be SQL-friendly
            // start date
            String start_month = request.getParameter("start_month");
            String start_year = request.getParameter("start_year");
            String start_date = start_year + "-" + start_month + "-01";
            // graduation date
            String grad_month = request.getParameter("grad_month");
            String grad_year = request.getParameter("grad_year");
            String grad_date = "";
            if(!grad_month.equals("") && !grad_year.equals("")) {
                grad_date = grad_year + "-" + grad_month + "-01";
            }
            // create an Education object
            Education education = new Education(degree, school, city, state, start_date, grad_date, description);
            // update education
            if(education.updateEducation(id)) {
                // success
                notice = "Education successfully updated.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
                return;
            }
            else {
                notice = "There was an error updating the education.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        
        // update work experience
        else if(action.equals("update_work")) {
            // get the request parameters
            int id = Integer.parseInt(request.getParameter("id"));
            String company_name = request.getParameter("company");
            String position = request.getParameter("position");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String description = request.getParameter("description");
            // build the dates to be SQL-friendly
            // start date
            String start_month = request.getParameter("start_month");
            String start_year = request.getParameter("start_year");
            String start_date = start_year + "-" + start_month + "-01";
            // graduation date
            String end_month = request.getParameter("end_month");
            String end_year = request.getParameter("end_year");
            String end_date = "";
            if(!end_month.equals("") && !end_year.equals("")) {
                end_date = end_year + "-" + end_month + "-01";
            }
            // create a Work object
            Work work = new Work(company_name, city, state, position, start_date, end_date, description);
            // update work experience
            if(work.updateWork(id)) {
                // success
                notice = "Work experience successfully updated.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
                return;
            }
            else {
                notice = "There was an error updating the work experience.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        
        // update skill
        else if(action.equals("update_skill")) {
            // get request parameters
            int id = Integer.parseInt(request.getParameter("id"));
            String skill_name = request.getParameter("name");
            String exp_length = request.getParameter("exp_length");
            String description = request.getParameter("description");
            // create a Skill object
            Skills skill = new Skills(skill_name, exp_length, description);
            // update skill
            if(skill.updateSkill(id)) {
                // success
                notice = "Skill successfully updated.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
                return;
            }
            else {
                notice = "There was an error updating the skill.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        // update the resume title
        else if(action.equals("update_title")) {
            // get the parameters
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String title = request.getParameter("name");
            // create a Resume object so we can save the update
            Resume resume = new Resume();
            if(resume.updateTitle(resume_id, title)) {
                // success
                notice = "Resume title successfully updated.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
                return;
            }
            else {
                notice = "There was an error updating the resume title.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        // update the resume comments
        else if(action.equals("update_comments")) {
            // get the parameters
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String comments = request.getParameter("comments");
            // create a Resume object so we can save the update
            Resume resume = new Resume();
            if(resume.updateComments(resume_id, comments)) {
                // success
                notice = "Resume comments successfully updated.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
                return;
            }
            else {
                notice = "There was an error updating the resume comments.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        
        // add additional resume entries
        // add additional education
        else if(action.equals("additional_education")) {
            // get the resume_id
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            // add resume_id to request and send to form
            request.setAttribute("resume_id", Integer.toString(resume_id));
            String in_process = "no";
            request.setAttribute("in_process", in_process);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_education.jsp");
            dispatcher.forward(request, response);
            return;
        }
        // add additional work_experience
        else if(action.equals("additional_work")) {
            // get the resume_id
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            // add resume_id to request and send to form
            request.setAttribute("resume_id", Integer.toString(resume_id));
            String in_process = "no";
            request.setAttribute("in_process", in_process);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_work.jsp");
            dispatcher.forward(request, response);
            return;
        }
        // add additional skills
        else if(action.equals("additional_skill")) {
            // get the resume_id
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            // add resume_id to request and send to form
            request.setAttribute("resume_id", Integer.toString(resume_id));
            String in_process = "no";
            request.setAttribute("in_process", in_process);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_skill.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // save the additional resume elements
        // save additional education
        else if(action.equals("save_more_education")) {
            // get the request parameters
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String degree = request.getParameter("degree");
            String school = request.getParameter("school");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String description = request.getParameter("description");
            // build the dates to be SQL-friendly
            // start date
            String start_month = request.getParameter("start_month");
            String start_year = request.getParameter("start_year");
            String start_date = start_year + "-" + start_month + "-01";
            // graduation date
            String grad_month = request.getParameter("grad_month");
            String grad_year = request.getParameter("grad_year");
            String grad_date = "";
            if(!grad_month.equals("") && !grad_year.equals("")) {
                grad_date = grad_year + "-" + grad_month + "-01";
            }
            // create an Education object
            Education education = new Education(degree, school, city, state, start_date, grad_date, description);
            if(education.saveEducation(resume_id)) {
                notice = "Education successfully added.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
                return;
            }
            else {
                notice = "There was an error saving your education.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_education.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        // save additional work
        else if(action.equals("save_more_work")) {
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String company = request.getParameter("company");
            String position = request.getParameter("position");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String description = request.getParameter("description");
            // build the dates to be SQL-friendly
            // start date
            String start_month = request.getParameter("start_month");
            String start_year = request.getParameter("start_year");
            String start_date = start_year + "-" + start_month + "-01";
            // end date
            String end_month = request.getParameter("end_month");
            String end_year = request.getParameter("end_year");
            String end_date = "";
            if(!end_month.equals("") && !end_year.equals("")) {
                end_date = end_year + "-" + end_month + "-01";
            }
            // create a Work object
            Work work = new Work(company, city, state, position, start_date, end_date, description);
            if(work.saveWork(resume_id)) {
                notice = "Work experience successfully added.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
                return;
            }
            else {
                notice = "There was an error saving your work experience.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_work.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        // save additional skill
        else if(action.equals("save_more_skill")) {
            int resume_id = Integer.parseInt(request.getParameter("resume_id"));
            String skill_name = request.getParameter("name");
            String exp_length = request.getParameter("exp_length");
            String description = request.getParameter("description");
            // create a Skills object
            Skills skill = new Skills(skill_name, exp_length, description);
            if(skill.saveSkill(resume_id)) {
                notice = "Skill successfully added.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume?action=get_resume");
                dispatcher.forward(request, response);
                return;
            }
            else {
                notice = "There was an error saving your skill.";
                request.setAttribute("notice", notice);
                request.setAttribute("resume_id", Integer.toString(resume_id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/add_work.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        else if(action.equals("list_resumes")) {
            Resume resume = new Resume();
             if(resume.listResumes() != null) {
                dbResultSet = resume.listResumes();
                
                request.setAttribute("result", dbResultSet);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/list_resumes.jsp");
                dispatcher.forward(request, response); 
             }
             else {
                notice = "There are no current resumes available.";
                request.setAttribute("notice", notice);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response); 
             }
        }
        
        else if(action.equals("detail_resume")) {
                int resume_id = Integer.parseInt(request.getParameter("id"));
                Resume resume = new Resume();
                dbResultSet = resume.getResumeDetail(resume_id);
                // if there is a resume, get details and forward to details page
                if(dbResultSet != null) {
                    // get all of their education, work, skills, and student information
                    ResultSet education_results = null;
                    ResultSet work_results = null;
                    ResultSet skills_results = null;
                    ResultSet student_results = null;
                    
                    Person person = new Person();
                    
                    student_results = person.getStudentInfo(resume_id);
                    education_results = resume.getEducation(resume_id);
                    work_results = resume.getWorkExperience(resume_id);
                    skills_results = resume.getSkills(resume_id);

                    // set request attributes and forward to edit page
                    request.setAttribute("resume_id", Integer.toString(resume_id));
                    request.setAttribute("student_results", student_results);
                    request.setAttribute("education_results", education_results);
                    request.setAttribute("work_results", work_results);
                    request.setAttribute("skills_results", skills_results);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/detail_resume.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                // can not find resume
                else {
                    error = "There was an error retreiving your resume.";
                    session.setAttribute("error", error);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resume/index.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
    }
        // fall through catch-all
        else {
            notice = "I don't understand your request.  Please try again.";
            request.setAttribute("notice", notice);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
