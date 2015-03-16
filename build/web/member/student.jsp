<%@include file="/common/header.jsp" %>

<%
    Student student = new Student();
    if(request.getAttribute("student") != null) {
        student = (Student)request.getAttribute("student");
    }
%>

<h1>Edit Your Profile (Student)</h1>

<form method="post" action="/gsu_fhce/my_account">
    
    <%@include file="/common/student_form.jsp" %>
    
    <input type="hidden" name="action" value="save_student" />
    
    <input type="button" value="Update Member Info" onclick="checkStudentUpdate(this.form); return false;" />
    &nbsp;&nbsp;
    <input type="button" value="Cancel" onclick="window.location='/gsu_fhce/';" />
    
</form>

<%@include file="/common/footer.jsp" %>