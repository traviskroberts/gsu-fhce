<%@include file="/common/header.jsp" %>

<%
    // get the resume id
    int resume_id = Integer.parseInt((String)request.getAttribute("resume_id"));
    // create a new Resume object so we can call date functions
    Resume resume = new Resume();
    // get the result sets from the request
    ResultSet result = (ResultSet)request.getAttribute("resume_result");
    ResultSet student = (ResultSet)request.getAttribute("student_results");
    ResultSet education = (ResultSet)request.getAttribute("education_results");
    ResultSet work = (ResultSet)request.getAttribute("work_results");
    ResultSet skills = (ResultSet)request.getAttribute("skills_results");
%>

<h1>Resume</h1>

<p> 
    <% while(student.next()) {%>
    Student name: <strong><%= student.getString("fname")%> <%= student.getString("lname")%> </strong>
    <br />
    <table rules="all" class="resume">
        <tr>
            <td class="title">Address:</td>
            <td>
                <%= student.getString("address1") %><br />
            <% if(!student.getString("address2").equals("")) { %>
                <%= student.getString("address2") %><br />
            <% } %>
                <%= student.getString("city") %>, <%=student.getString("state")%>
            </td>
        </tr>
        <tr>
            <td class="title">Phone Number:</td>
            <td><%= student.getString("phone") %></td>
        </tr>
        <tr>
            <td class="title">Email:</td>
            <td><a href="mailto:<%= student.getString("email") %>"><%= student.getString("email") %></a></td>
        </tr>
    </table>
   <% } %>     
</p>

<h2>Education</h2>
<%
    if(education != null) {
        while(education.next()) { 
%>
    <table rules="all" class="resume">
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

<br />
<h2>Work Experience</h2>
<%
    if(work != null) {
        while(work.next()) {
%>
    <table rules="all" class="resume">
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
<br />
<h2>Skills</h2>
<%
    if(skills != null) {
        while(skills.next()) {
%>
    <table rules="all" class="resume">
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
<br />
<h2>
    Additional Comments
</h2>
<%
    if(result != null) {
        while(result.next()) {
%>
<p><%= result.getString("additional_comments") %></p>

<%
    }
        }
%>

<%@include file="/common/footer.jsp" %>