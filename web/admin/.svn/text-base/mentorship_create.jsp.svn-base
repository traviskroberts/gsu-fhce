<%@include file="/common/header.jsp" %>
 <% ResultSet result = (ResultSet)request.getAttribute("result"); %>
 <% ResultSet result2 = (ResultSet)request.getAttribute("result2"); %>
<form method="post" action="add_mship">
    <select name="student" id="student" class="selectfield">
            <option value=""></option>
            <% while (result.next()) { %>
            <option value="<% result.getString("lname")+ ", " + result.getString("fname") %>"></option> 
            <% } %>
    </select><br /><br />
    <select name="alumni" id="alumni" class="selectfield">
        <option value=""></option>
        <% while (result2.next()) { %>
            <option value="<% result2.getString("lname")+ ", " + result2.getString("fname") %>"></option> 
            <% } %>
    </select><br /><br />
    <input type="submit" />    
</form>
<%@include file="/common/footer.jsp" %>
