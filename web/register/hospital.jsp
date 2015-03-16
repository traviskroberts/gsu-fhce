<%@include file="/common/header.jsp" %>

<%
    Hospital hospital = new Hospital();
    if(request.getAttribute("hospital") != null) {
        hospital = (Hospital)request.getAttribute("hospital");
    }
%>

<h1>Hospital Registration</h1>

<form method="post" action="member_register">
    
    <%@include file="/common/hospital_form.jsp" %>
    
    <input type="button" value="Register" onclick="checkHospital(this.form); return false;" />
    &nbsp;&nbsp;
    <input type="reset" value="Clear Form" />
    
    <input type="hidden" name="action" value="save" />
    <input type="hidden" name="member_type" value="hospital" />
    
</form>

<%@include file="/common/footer.jsp" %>