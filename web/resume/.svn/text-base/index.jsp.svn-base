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
%>

<h1>Add Your Resume</h1>

<p>You don't have a resume on file yet.</p>

<p><a href="/gsu_fhce/resume/create_resume.jsp">Add Resume &raquo;</a></p>


<%@include file="/common/footer.jsp" %>