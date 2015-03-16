<%@include file="/common/header.jsp" %>

<%
    // checks first to see if they really are an admin
    if(person != null) {
        if(!person.isAdmin()) {
            String error = "You don't have permission to view that page!";
            session.setAttribute("error", error);
            response.sendRedirect("/gsu_fhce/error.jsp");
        }
    }
    // if they aren't an admin, kick them out
    else {
        String error = "You don't have permission to view that page!";
        session.setAttribute("error", error);
        response.sendRedirect("/gsu_fhce/error.jsp");
    }
    
    // get the member_type, if it exists
    // so that we can keep that option selected for drop-down
    String mem_type = "";
    if(request.getAttribute("member_type") != null) {
        mem_type = (String)request.getAttribute("member_type");
    }
    
    // get the result set from the request
    ResultSet resultset = (ResultSet)request.getAttribute("resultset");
%>

<h1>Edit Members</h1>

<p>Filter by member type: 
<select id="member" name="member">
        <option value="all" 
            <% if(mem_type.equals("")) { %>
                selected="selected" 
            <% } %>>all</option>
        <option value="student" 
            <% if(mem_type.equals("student")) { %>
                selected="selected" 
            <% } %>>Student</option>
        <option value="alumni" 
            <% if(mem_type.equals("alumni")) { %>
                selected="selected" 
            <% } %>>Alumni</option>
        <option value="hospital" 
            <% if(mem_type.equals("hospital")) { %>
                selected="selected" 
            <% } %>>Hospital</option>
</select></p>

<script type="text/javascript">
    //<![CDATA[
    new Form.Element.EventObserver('member', function(element, value) {get_members()})
    //]]>
</script>

<table width="100%">
    <tr>
        <th width="15%">&nbsp;</th>
        <th width="25%">Name</th>
        <th width="30%">Email Address</th>
        <th width="20%">Member Type</th>
        <th width="10%">Admin?</th>
    </tr>
    <% while(resultset.next()) { %>
    <tr>
        <td>
            <a href="/gsu_fhce/admin?action=edit_person&amp;id=<%= resultset.getInt("id") %>&amp;member_type=<%= resultset.getString("member_type") %>">
                <img src="/gsu_fhce/images/edit.gif" alt="Edit" />
            </a>
            &nbsp;&nbsp;
            <a href="/gsu_fhce/admin?action=delete_person&amp;id=<%= resultset.getInt("id") %>&amp;member_type=<%= resultset.getString("member_type") %>" onclick="return confirm('Are you sure you want to delete this person?');">
                <img src="/gsu_fhce/images/trash.gif" alt="Delete" />
            </a>
        </td>
        <td>
            <%= resultset.getString("lname") %><% if(resultset.getString("fname") != null) { %>, <%= resultset.getString("fname") %><% } %>
        </td>
        <td><%= resultset.getString("email") %></td>
        <td><%= resultset.getString("member_type") %></td>
        <td class="center">
            <% if(resultset.getString("is_admin").equals("1")) { %>Yes<% } %>
        </td>
    </tr>
    <% } %>
</table>

<%@include file="/common/footer.jsp" %>