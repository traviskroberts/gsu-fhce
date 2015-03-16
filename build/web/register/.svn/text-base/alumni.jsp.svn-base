<%@include file="/common/header.jsp" %>

<%
    Alumni alumni = new Alumni();
    if(request.getAttribute("alumni") != null) {
        alumni = (Alumni)request.getAttribute("alumni");
    }
%>

<h1>Alumni Registration</h1>

<form method="post" action="member_register">
    
    <%@include file="/common/alumni_form.jsp" %>
    
    <input type="button" value="Register" onclick="checkAlumni(this.form); return false;" />
    &nbsp;&nbsp;
    <input type="reset" value="Clear Form" />
    
    <input type="hidden" name="action" value="save" />
    <input type="hidden" name="member_type" value="alumni" />
    
</form>

<%@include file="/common/footer.jsp" %>