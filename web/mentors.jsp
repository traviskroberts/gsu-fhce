<%@include file="/common/header.jsp" %>
 <%
        ResultSet result = (ResultSet)request.getAttribute("result");
%>

<h1>Available Mentors</h1>
<table>
  <tr>
     <th>ID</th>
     <th>First Name</th>
     <th>Last Name</th>
     <th>E-mail</th>
     <th>City</th>
     <th>State</th>
  </tr>
            <% while(result.next()) { %>
            <tr>
                <td><%= result.getString("id") %></td>
                <td><%= result.getString("fname") %></td>
                <td><%= result.getString("lname") %></td> 
                <td><a href="mailto:<%= result.getString("email") %>">Contact</a></td> 
                <td><%= result.getString("city") %></td>
                <td><%= result.getString("state") %></td> 
            </tr>
             <% } %>
 </table>
<%@include file="/common/footer.jsp" %>
