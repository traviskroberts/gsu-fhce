<%@include file="/common/header.jsp" %>

<%
   String error = (String)session.getAttribute("error");
%>

<div id="notice">
<% if(error != null) { %>
    <p>
        There was an error with your request:<br />
        <%= error %>
    </p>
<% } %>
</div>

<%@include file="/common/footer.jsp" %>