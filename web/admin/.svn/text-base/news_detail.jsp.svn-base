<%@include file="/common/header.jsp" %>
<%@page import="java.sql.*"%>

<!-- ===================================================
Adrian Flynt  
========================================================-->
<%
        ResultSet result = (ResultSet)request.getAttribute("result");
        // create a faux news object so we can use the getMonthName() method
        News news = new News();
%>

<% while(result.next()) { %>
    <%
        String date = "";
        if(!result.getString("date").equals("")) {
            date = news.getMonthName(result.getString("date").substring(5,7)) + " " +
                    result.getString("date").substring(8,10) + ", " +
                    result.getString("date").substring(0,4);
        }
    %>
    <h1><%= result.getString("title") %></h1>
    <p><strong><%= date %></strong></p>
    <p><%= result.getString("content") %></p>
<% } %>

<p><a href="/gsu_fhce/admin?action=Get Admin News List">&laquo;Back to news list</a></p>
 
<%@include file="/common/footer.jsp" %>