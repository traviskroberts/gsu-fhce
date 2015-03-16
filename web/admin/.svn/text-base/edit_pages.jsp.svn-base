<%@include file="/common/header.jsp" %>

<%
    // checks to see if they really are an admin
    if(person != null) {
        if(!person.isAdmin()) {
            String error = "You don't have permission to view that page!";
            session.setAttribute("error", error);
            response.sendRedirect("/gsu_fhce/error.jsp");
        }
    }
    else {
        String error = "You don't have permission to view that page!";
        session.setAttribute("error", error);
        response.sendRedirect("/gsu_fhce/error.jsp");
    }
    
    // get the result set from the request
    ResultSet resultset = (ResultSet)request.getAttribute("resultset");
    Page pge = new Page();
%>

<h1>Manage Content Pages</h1>

<h3><a href="/gsu_fhce/admin?action=add_page" class="add_button">Add New Page</a></h3>

<div class="clear"></div>

<table width="100%">
    <tr>
        <th width="15%">&nbsp;</th>
        <th width="50%">Page Title</th>
        <th width="35%">Subpages</th>
    </tr>
    <% while(resultset.next()) { %>
    <tr>
        <td>
            <a href="/gsu_fhce/admin?action=edit_page&amp;id=<%= resultset.getInt("id") %>">
                <img src="/gsu_fhce/images/edit.gif" alt="Edit" />
            </a>
        <%
            // shouldn't be able to delete home page
            if(resultset.getInt("id") > 1) {
        %>
            &nbsp;&nbsp;
            <a href="/gsu_fhce/admin?action=delete_page&amp;id=<%= resultset.getInt("id") %>" onclick="return confirm('NOTE: Deleting this page will also delete all sub pages.  Are you sure you want to delete this page?');">
                <img src="/gsu_fhce/images/trash.gif" alt="Delete" />
            </a>
        <% } %>
        </td>
        <td><%= resultset.getString("title").equals("root") ? "Home Page" : resultset.getString("title") %></td>
        <td>
            <% if(pge.checkForSubPages(resultset.getInt("id")) && !resultset.getString("title").equals("root")) { %>
                <a href="/gsu_fhce/admin?action=manage_pages&amp;id=<%= resultset.getInt("id") %>">Manage</a>
            <% } %>
        </td>
    </tr>
    <% } %>
</table>

<%@include file="/common/footer.jsp" %>