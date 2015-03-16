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
    
    // get the resultSet
    ResultSet result = (ResultSet)request.getAttribute("result");
    result.next();
    // get the fields
    String skill_name = result.getString("skill_name");
    String exp_length = result.getString("exp_length");
    String description = result.getString("description");
    // get the skill id
    int id = result.getInt("id");
%>

<h1>Update Skill</h1>

<form action="/gsu_fhce/resume" method="post">
    <p>
        Skill Name<br />
        <input type="text" name="name" id="name" class="formfield" value="<%= skill_name %>" />
    </p>
    <p>
        Length of Experience<br />
        <input type="text" name="exp_length" id="exp_length" class="formfield" value="<%= exp_length %>" />
    </p>
    <p>
        Description (optional)<br />
        <textarea name="description" id="description" class="formfield" rows="5" value=""><%= description %></textarea>
    </p>
    <p>
        <input type="hidden" name="action" value="" />
        <input type="hidden" name="id" value="<%= id %>" />
        <input type="button" name="update" value="Update Skill" onclick="checkSkill(this.form, 'update_skill'); return false" />
    </p>
</form>


<%@include file="/common/footer.jsp" %>