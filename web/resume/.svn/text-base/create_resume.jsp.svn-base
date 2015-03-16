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

<img src="/gsu_fhce/images/resume_step0.png" />

<h1>Create a Resume</h1>

<form action="/gsu_fhce/resume" method="post">
    <p>
        Name Your Resume<br />
        <input type="text" name="name" id="name" value="" class="formfield" />
    </p>
    <p>
        <input type="button" value="Continue" onclick="checkResume(this.form); return false" />
    </p>
    <input type="hidden" name="action" value="create_resume" />
</form>


<%@include file="/common/footer.jsp" %>