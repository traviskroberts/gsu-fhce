<%@include file="/common/header.jsp" %>

<%
    Hospital hospital = new Hospital();
    if(request.getAttribute("hospital") != null) {
        hospital = (Hospital)request.getAttribute("hospital");
    }
%>

<h1>Edit Your Profile (Hospital)</h1>

<form method="post" action="/gsu_fhce/admin">
    
    <%@include file="/common/hospital_form.jsp" %>
    
    <input type="hidden" name="action" value="update_hospital" />
    <input type="hidden" name="person_id" value="<%= hospital.getPersonId(hospital.getName()) %>" />
    
    <input type="button" value="Update Member Info" onclick="checkAdminHospitalUpdate(this.form); return false;" />
    &nbsp;&nbsp;
    <input type="button" value="Cancel" onclick="window.location='/gsu_fhce/admin?action=edit_members';" />
    
</form>

<%@include file="/common/footer.jsp" %>