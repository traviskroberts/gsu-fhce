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
    
    String in_process = "yes";
    if(request.getAttribute("in_process") != null) {
        in_process = (String)request.getAttribute("in_process");
    }
    
    int resume_id = Integer.parseInt((String)request.getAttribute("resume_id"));
%>

<% if(in_process.equals("yes")) { %>
    <img src="/gsu_fhce/images/resume_step3.png" />
<% } %>

<h1>Add Skill</h1>

<form action="/gsu_fhce/resume" method="post">
    <p>
        Skill Name<br />
        <input type="text" name="name" id="name" class="formfield" />
    </p>
    <p>
        Length of Experience<br />
        <input type="text" name="exp_length" id="exp_length" class="formfield" />
    </p>
    <p>
        Description (optional)<br />
        <textarea name="description" id="description" class="formfield" rows="5" value=""></textarea>
    </p>
    <p>
        <input type="hidden" name="action" value="" />
        <input type="hidden" name="resume_id" value="<%= resume_id %>" />
    <% if(in_process.equals("yes")) { %>
        <input type="button" name="add_more" value="Add Another Skill" onclick="checkSkill(this.form, 'skill_add_more'); return false" />
        &nbsp;&nbsp;&nbsp;
        <input type="button" name="continue" value="Finish Resume" onclick="checkSkill(this.form, 'skill_continue'); return false" />
    <% } else { %>
        <input type="button" name="additional" value="Add Skill" onclick="checkSkill(this.form, 'save_more_skill'); return false" />
    <% } %>
    </p>
</form>


<%@include file="/common/footer.jsp" %>