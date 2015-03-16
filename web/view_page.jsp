<%@include file="/common/header.jsp" %>

<%
    // get the page and page id from the request
    Page pg = (Page)request.getAttribute("page");
    int id = Integer.parseInt((String)request.getAttribute("id"));
    // now get the title and the content
    String title = pg.getTitle();
    String content = pg.getContent();
%>

<h1><%= title %></h1>

<% if(pg.hasSubNavigation(id)) { %>
    <div class="subnav">
        <p><%= title %></p>
        <ul>
            <%= pg.buildSubNavigation(id) %>
        </ul>
    </div><!-- subnav -->
<% } %>

<%= content %>

<%@include file="/common/footer.jsp" %>