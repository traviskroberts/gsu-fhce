<%@include file="/common/header.jsp" %>

<%
    Student student = new Student();
    if(request.getAttribute("student") != null) {
        student = (Student)request.getAttribute("student");
    }
%>

<h1>Student Registration</h1>

<form method="post" action="member_register">
    
    <%@include file="/common/student_form.jsp" %>
    
    <input type="button" value="Register" onclick="checkStudent(this.form); return false;" />
    &nbsp;&nbsp;
    <input type="reset" value="Clear Form" />
    
    <input type="hidden" name="action" value="save" />
    <input type="hidden" name="member_type" value="student" />
    
</form>

<%@include file="/common/footer.jsp" %>