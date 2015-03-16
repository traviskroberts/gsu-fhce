<%@include file="/common/header.jsp" %>

<%
    // checks to see if they are a student
    if(person != null && member_type != null) {
        if(!member_type.equals("student")) {
            String error = "You have to be logged in as a student to add a resume!";
            session.setAttribute("error", error);
            response.sendRedirect("/gsu_fhce/error.jsp");
        }
    }
    else {
        String error = "You have to be logged in as a student to add a resume!";
        session.setAttribute("error", error);
        response.sendRedirect("/gsu_fhce/error.jsp");
    }
    // get the resume id
    int resume_id = Integer.parseInt((String)request.getAttribute("resume_id"));
    // create a new Resume object so we can call date functions
    Resume resume = new Resume();
    // get the result sets from the request
    ResultSet result = (ResultSet)request.getAttribute("resume_result");
    ResultSet education = (ResultSet)request.getAttribute("education_results");
    ResultSet work = (ResultSet)request.getAttribute("work_results");
    ResultSet skills = (ResultSet)request.getAttribute("skills_results");
%>

<h1>Edit Resume</h1>

<p>
    Resume name: <strong><%= result.getString("title") %></strong> 
    <span class="edit_link">
        <a href="/gsu_fhce/resume?action=edit_title&amp;resume_id=<%= resume_id %>&amp;title=<%= result.getString("title") %>">[edit]</a>
    </span>
</p>

<h2>Education</h2>
<%
    if(education != null) {
        while(education.next()) { 
%>
    <table rules="all" class="resume">
        <tr>
            <td class="resume_actions" colspan="2">
                <a href="/gsu_fhce/resume?action=edit_education&amp;id=<%= education.getInt("id") %>">[Edit]</a>&nbsp;
                <a href="/gsu_fhce/resume?action=delete_education&amp;id=<%= education.getInt("id") %>">[Delete]</a>
            </td>
        </tr>
        <tr>
            <td class="title">Degree Earned:</td>
            <td><%= education.getString("degree") %></td>
        </tr>
        <tr>
            <td class="title">School:</td>
            <td><%= education.getString("school_name") %></td>
        </tr>
        <tr>
            <td class="title">Location:</td>
            <td><%= education.getString("city") %>, <%= education.getString("state") %></td>
        </tr>
        <tr>
            <td class="title">Attendance:</td>
            <td><%= resume.formatDates(education.getString("start_date"), education.getString("end_date")) %></td>
        </tr>
        <tr>
            <td class="title">Description:</td>
            <td><%= education.getString("description") %></td>
        </tr>
    </table>
<%
    }
        }
%>
<p><a href="/gsu_fhce/resume?action=additional_education&amp;resume_id=<%= resume_id %>">Add More Education &raquo;</a></p>
<br />
<h2>Work Experience</h2>
<%
    if(work != null) {
        while(work.next()) {
%>
    <table rules="all" class="resume">
        <tr>
            <td class="resume_actions" colspan="2">
                <a href="/gsu_fhce/resume?action=edit_work&amp;id=<%= work.getInt("id") %>">[Edit]</a>&nbsp;
                <a href="/gsu_fhce/resume?action=delete_work&amp;id=<%= work.getInt("id") %>">[Delete]</a>
            </td>
        </tr>
        <tr>
            <td class="title">Company Name:</td>
            <td><%= work.getString("company_name") %></td>
        </tr>
        <tr>
            <td class="title">Location:</td>
            <td><%= work.getString("city") %>, <%= work.getString("state") %></td>
        </tr>
        <tr>
            <td class="title">Position:</td>
            <td><%= work.getString("position") %></td>
        </tr>
        <tr>
            <td class="title">Employment Term:</td>
            <td><%= resume.formatDates(work.getString("start_date"), work.getString("end_date")) %></td>
        </tr>
        <tr>
            <td class="title">Description:</td>
            <td><%= work.getString("description") %></td>
        </tr>
    </table>
<%
    }
        }
%>
<p><a href="/gsu_fhce/resume?action=additional_work&amp;resume_id=<%= resume_id %>">Add More Work Experience &raquo;</a></p>
<br />
<h2>Skills</h2>
<%
    if(skills != null) {
        while(skills.next()) {
%>
    <table rules="all" class="resume">
        <tr>
            <td class="resume_actions" colspan="2">
                <a href="/gsu_fhce/resume?action=edit_skill&amp;id=<%= skills.getInt("id") %>">[Edit]</a>&nbsp;
                <a href="/gsu_fhce/resume?action=delete_skill&amp;id=<%= skills.getInt("id") %>">[Delete]</a>
            </td>
        </tr>
        <tr>
            <td class="title">Skill Name:</td>
            <td><%= skills.getString("skill_name") %></td>
        </tr>
        <tr>
            <td class="title">Experience:</td>
            <td><%= skills.getString("exp_length") %></td>
        </tr>
        <tr>
            <td class="title">Description:</td>
            <td><%= skills.getString("description") %></td>
        </tr>
    </table>
<%
    }
        }
%>
<p><a href="/gsu_fhce/resume?action=additional_skill&amp;resume_id=<%= resume_id %>">Add More Skills &raquo;</a></p>
<br />
<h2>
    Additional Comments
    <span class="edit_link">
        <a href="/gsu_fhce/resume?action=edit_comments&amp;resume_id=<%= resume_id %>&amp;comments=<%= result.getString("additional_comments") %>">[Edit]</a>
    </span>
</h2>
<p><%= result.getString("additional_comments") %></p>


<%@include file="/common/footer.jsp" %>