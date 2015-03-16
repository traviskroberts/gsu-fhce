<%@include file="/common/header.jsp" %> 
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!-- author: Adrian Flynt-->

<%
    String message = (String)request.getAttribute("message");
    if (message == null) message = "";
%>

    
    
    <%
        ResultSet result = (ResultSet)request.getAttribute("result");
%>
<h1>News List</h1>

<% if (!message.equals("")) { %>
    <h3> <%= message %> </h3>
<% } %>

<table>
  <tr>
    <th>News List</th>
  </tr>
    <tr>
        <th>Title</th>
        <th>Date</th>
        <th>Content</th>
    </tr>
            <% while(result.next()) { %>
            <tr>
                <td><%= result.getString("title") %></td>
                <td><%= result.getString("date") %></td>
                 
              <td>&nbsp;&nbsp;<a href="admin?action=detail&amp;id=<%= result.getString("id") %>">details</a></td>
              
            </tr>
             <% } %>
 </table>

 
    
<%@include file="/common/footer.jsp" %>