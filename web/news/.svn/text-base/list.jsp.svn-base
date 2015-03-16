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

<%
    if(result != null) {
        while(result.next()) { 
%>
    <div class="story">
        <p class="news_title">
            <a href="/gsu_fhce/news?action=detail&amp;id=<%= result.getInt("id") %>">
            <%= result.getString("title") %></a> - 
            <%=
                // build a pretty date!
                result.getString("date").substring(5,7) + "/" + 
                    result.getString("date").substring(8,10) + "/" +
                    result.getString("date").substring(0,4)
            %>
        </p>
        <p><%= (result.getString("content").length() > 225) ? (result.getString("content").substring(0,225)) : result.getString("content")  %></p>
        <p class="news_link"><a href="/gsu_fhce/news?action=detail&amp;id=<%= result.getInt("id") %>">Read full story&raquo;</a></p>
    </div><!-- story -->
<%
    }
        }
%>
 
    
<%@include file="/common/footer.jsp" %>