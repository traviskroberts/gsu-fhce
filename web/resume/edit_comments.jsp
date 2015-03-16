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
    // get the comments
    String comments = (String)request.getAttribute("comments");
    // get the resume id
    int resume_id = Integer.parseInt((String)request.getAttribute("resume_id"));
%>

<h1>Resume Comments</h1>

<form action="/gsu_fhce/resume" method="post">
    <p>
        Additional Comments<br />
        <textarea name="comments" class="formfield"><%= comments %></textarea>
    </p>
    <p>
        <input type="button" value="Update Comments" onclick="checkResume(this.form); return false" />
    </p>
    <input type="hidden" name="action" value="update_comments" />
    <input type="hidden" name="resume_id" value="<%= resume_id %>" />
</form>


<%@include file="/common/footer.jsp" %>