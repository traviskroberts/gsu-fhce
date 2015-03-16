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
    // get the title
    String title = (String)request.getAttribute("title");
    // get the resume id
    int resume_id = Integer.parseInt((String)request.getAttribute("resume_id"));
%>

<h1>Resume Title</h1>

<form action="/gsu_fhce/resume" method="post">
    <p>
        Name Your Resume<br />
        <input type="text" name="name" id="name" value="<%= title %>" class="formfield" />
    </p>
    <p>
        <input type="button" value="Update Title" onclick="checkResume(this.form); return false" />
    </p>
    <input type="hidden" name="action" value="update_title" />
    <input type="hidden" name="resume_id" value="<%= resume_id %>" />
</form>


<%@include file="/common/footer.jsp" %>