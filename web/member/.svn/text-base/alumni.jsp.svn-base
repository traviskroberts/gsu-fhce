<%@include file="/common/header.jsp" %>

<%
    Alumni alumni = new Alumni();
    if(request.getAttribute("alumni") != null) {
        alumni = (Alumni)request.getAttribute("alumni");
    }
%>

<h1>Edit Your Profile (Alumni)</h1>

<form method="post" action="/gsu_fhce/my_account">
    
    <%@include file="/common/alumni_form.jsp" %>
    
    <input type="hidden" name="action" value="save_alumni" />
    <p>
        <input type="button" value="Update Member Info" onclick="checkAlumniUpdate(this.form); return false;" />
        &nbsp;&nbsp;
        <a href="/gsu_fhce/index.jsp">cancel</a>
    </p>
    
    
</form>

<%@include file="/common/footer.jsp" %>