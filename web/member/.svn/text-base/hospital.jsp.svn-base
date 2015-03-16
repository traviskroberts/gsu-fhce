<%@include file="/common/header.jsp" %>

<%
    Hospital hospital = new Hospital();
    if(request.getAttribute("hospital") != null) {
        hospital = (Hospital)request.getAttribute("hospital");
    }
%>

<h1>Edit Your Profile (Hospital)</h1>

<form method="post" action="/gsu_fhce/my_account">
    
    <%@include file="/common/hospital_form.jsp" %>
    
    <input type="hidden" name="action" value="save_hospital" />
    
    <p>
        <input type="button" value="Update Member Info" onclick="checkHospitalUpdate(this.form); return false;" />
        &nbsp;&nbsp;
        <a href="/gsu_fhce/index.jsp">cancel</a>
    </p>
    
    
</form>

<%@include file="/common/footer.jsp" %>