<%@include file="/common/header.jsp" %>

<%
    Alumni alumni = new Alumni();
    if(request.getAttribute("alumni") != null) {
        alumni = (Alumni)request.getAttribute("alumni");
    }
%>

<h1>Edit Your Profile (Alumni)</h1>

<form method="post" action="/gsu_fhce/admin">
    
    <%@include file="/common/alumni_form.jsp" %>
    
    <input type="hidden" name="action" value="update_alumni" />
    <input type="hidden" name="person_id" value="<%= alumni.getID() %>" />
    
    <input type="button" value="Update Member Info" onclick="checkAlumniUpdate(this.form); return false;" />
    &nbsp;&nbsp;
    <input type="button" value="Cancel" onclick="window.location='/gsu_fhce/admin?action=edit_members';" />
    
</form>

<%@include file="/common/footer.jsp" %>