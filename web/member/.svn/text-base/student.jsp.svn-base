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
    
    <p>
        <input type="button" value="Update Member Info" onclick="checkStudentUpdate(this.form); return false;" />
        &nbsp;&nbsp;
        <a href="/gsu_fhce/index.jsp">cancel</a>
    </p>
    
    
</form>

<%@include file="/common/footer.jsp" %>