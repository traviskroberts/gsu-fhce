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
    
    // check to see if there is a Page object in the request
    Page pge = null;
    if(request.getAttribute("page") != null) {
        pge = (Page)request.getAttribute("page");
    }
    ResultSet result = null;
    if(request.getAttribute("resultset") != null) {
        result = (ResultSet)request.getAttribute("resultset");
    }
    int id = 0;
    if(request.getAttribute("id") != null) {
        id = Integer.parseInt((String)request.getAttribute("id"));
    }
%>

<h1>Add Content Page</h1>

<form action="/gsu_fhce/admin" method="post">
    <p>
        Page Title<br />
        <input type="text" name="title" id="title" 
            <% if(pge == null) { %>
                value=""
            <% } else { %>
                <% if(pge.getTitle().equals("root")) { %>disabled="true"<% } %>
                value="<%= pge.getTitle() %>"
            <% } %> class="formfield" />
    </p>
    
    <% if(pge != null && pge.getParentID() > 0) { %>
    <p>
        Parent Page<br />
        <select name="parent_id" class="selectfield">
            <% if(result != null) { while(result.next()) { %>
            <option value="<%= result.getInt("id") %>" <% if(pge.getParentID()==result.getInt("id")) { %> selected="selected" <% } %>><%= result.getString("title") %></option>
            <% } } %>
        </select>
        &nbsp;<span class="elevenpx">(If you select 'root', the page will appear in the main nav on the left)</span>
    </p>
    <% } %>
    <% if(pge == null) { %>
    <p>
        Parent Page<br />
        <select name="parent_id" class="selectfield">
            <% if(result != null) { while(result.next()) { %>
            <option value="<%= result.getInt("id") %>"><%= result.getString("title") %></option>
            <% } } %>
        </select>
        &nbsp;<span class="elevenpx">(If you select 'root', the page will appear in the main nav on the left)</span>
    </p>
    <% } %>
    
    <p>
        Page Content 
        <span class="help_link">(<a href="/gsu_fhce/common/html_help.html" onclick="window.open('/gsu_fhce/common/html_help.html','HTML Help', 'toolbar=0, resize=1, width=600, height=600'); return false;">HTML Formatting Help</a>)</span>
        <br />
        <% if(pge == null) { %>
            <textarea name="content" id="pg_content" rows="15" cols="30" class="formfield area"></textarea>
        <% } else { %>
            <textarea name="content" id="pg_content" rows="15" cols="30" class="formfield area"><%= pge.getContent() %></textarea>
        <% } %>
    </p>
    
    <% if(pge == null) { %>
        <input type="hidden" name="action" value="save_page" />
    <% } else { %>
        <input type="hidden" name="action" value="update_page" />
        <input type="hidden" name="id" value="<%= id %>" />
    <% } %>
    
    <p>
        <input type="button" value="Save Page" onclick="checkPage(this.form); return false;" />&nbsp;
        <a href="/gsu_fhce/admin?action=manage_pages">Cancel</a>
    </p>
</form>

<%@include file="/common/footer.jsp" %>