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

<img src="/gsu_fhce/images/resume_step5.png" />

<h1>Resume Saved</h1>

<p>You're resume has been saved.  You may come back at any time and add, edit, and delete your information</p>

<p><a href="/gsu_fhce/resume">&laquo;Resume Home</a></p>

<%@include file="/common/footer.jsp" %>