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
    
    int resume_id = Integer.parseInt((String)request.getAttribute("resume_id"));
%>

<img src="/gsu_fhce/images/resume_step4.png" />

<h1>Finalize Resume</h1>

<p>You're almost done!  Would you like to add any additional comments to your saved resume?</p>

<form action="/gsu_fhce/resume" method="post">
    <p>
        Comments<br />
        <textarea name="comments" id="comments" class="formfield" value=""></textarea>
    </p>
    <p>
        <input type="hidden" name="action" value="finalize" />
        <input type="hidden" name="resume_id" value="<%= resume_id %>" />
        <input type="submit" name="submit" value="Finalize" />
    </p>
</form>


<%@include file="/common/footer.jsp" %>