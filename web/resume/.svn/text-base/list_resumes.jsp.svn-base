<%@include file="/common/header.jsp" %>
<!-- ===================================================
Shane  
========================================================-->
<%
    ResultSet result = (ResultSet)request.getAttribute("result");
%>
<h1>Resumes</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Graduation Date</th>

    </tr>
            <% while(result.next()) { %>
            <tr>
                <td><%= result.getString("lname") %>, <%= result.getString("fname") %></td>
                <td>
                    <% String gradDateYear = result.getString("graduation_date").substring(0,4);
                    String gradDateMonth = result.getString("graduation_date").substring(5,7);
                    String gradDateDay = result.getString("graduation_date").substring(8,10);
                    String gradDate = gradDateMonth + "-" + gradDateDay + "-" + gradDateYear;
                    %><%= gradDate%></td>
  
        
                <td>&nbsp;&nbsp;<a href="resume?action=detail_resume&amp;id=<%= result.getString("r.id") %>">details</a></td>
            </tr>
             <% } %>
 </table>


<%@include file="/common/footer.jsp" %>