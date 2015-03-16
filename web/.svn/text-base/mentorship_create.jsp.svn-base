<%@include file="/common/header.jsp" %>
 <%
        ResultSet result = (ResultSet)request.getAttribute("result");
%>
<%
        ResultSet result2 = (ResultSet)request.getAttribute("result2");
%>
<form method="post" action="create_mentorship">
    <select name="student" id="student" class="selectfield">
            <option value=""></option>
            <% while (result.next()) { %>
            <option value="<% result.getString("fname")+ " " + result.getString("lname") %>"></option> 
            <% } %>
    </select><br /><br />
    <select name="alumni" id="alumni" class="selectfield">
        <option value=""></option>
        <% while (result.next()) { %>
            <option value="<% result2.getString("fname")+ " " + result2.getString("lname") %>"></option> 
            <% } %>
    </select><br /><br />
    <input type="submit" />    
</form>
<%@include file="/common/footer.jsp" %>
