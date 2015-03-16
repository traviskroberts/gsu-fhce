<%@include file="/common/header.jsp" %> 
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!-- author: Adrian Flynt-->

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
    
    String message = (String)request.getAttribute("notice");
    if (notice == null) notice = "";
%>

    
    
    <%
        ResultSet result = (ResultSet)request.getAttribute("result");
%>
<h1>News List</h1>

<h3><a href="/gsu_fhce/admin/add_news.jsp" class="add_button">Add News</a></h3>
<div class="clear"></div>

<table width="100%">
    <tr>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
        <th>Title</th>
        <th>Date</th>
    </tr>
    <% while(result.next()) { %>
    <tr>
        <td class= "residency_link"><a href="admin?action=edit&amp;id=<%= result.getInt("id") %>"><img src="/gsu_fhce/images/edit.gif" alt="Edit" /></a></td>  
        <td class= "residency_link"><a href="admin?action=delete&amp;id=<%= result.getInt("id") %>" onclick="return confirm('Are you sure you want to delete this news item?');"><img src="/gsu_fhce/images/trash.gif" alt="Delete" /></a></td>
        <td><%= result.getString("title") %></td>
        <td>
            <%
            String DateYear = result.getString("date").substring(0,4);
            String DateMonth = result.getString("date").substring(5,7);
            String DateDay = result.getString("date").substring(8,10);
            String Date = DateMonth + "-" + DateDay + "-" + DateYear;
            %>
            <%= Date%>
        </td>
    </tr>
    <% } %>
 </table>
  
    
<%@include file="/common/footer.jsp" %>