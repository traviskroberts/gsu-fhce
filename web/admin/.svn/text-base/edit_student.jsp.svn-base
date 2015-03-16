<%@include file="/common/header.jsp" %>

<%
    Student student = new Student();
    if(request.getAttribute("student") != null) {
        student = (Student)request.getAttribute("student");
    }
%>

<h1>Edit Your Profile (Student)</h1>

<form method="post" action="/gsu_fhce/admin">
    
    <%@include file="/common/student_form.jsp" %>
    
    <input type="hidden" name="action" value="update_student" />
    <input type="hidden" name="person_id" value="<%= student.getID() %>" />
    
    <input type="button" value="Update Member Info" onclick="checkStudentUpdate(this.form); return false;" />
    &nbsp;&nbsp;
    <input type="button" value="Cancel" onclick="window.location='/gsu_fhce/admin?action=edit_members';" />
    
</form>

<%@include file="/common/footer.jsp" %>