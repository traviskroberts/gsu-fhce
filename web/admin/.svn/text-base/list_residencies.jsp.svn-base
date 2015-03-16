<%@include file="/common/header.jsp" %>
<!-- author: Shane Severy-->
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
    ResultSet result = (ResultSet)request.getAttribute("result");
%>    

<h1>Current Residency Listings</h1>

<h3><a href="/gsu_fhce/admin?action=new_residency" class="add_button">Add Residency</a></h3>

<div class="clear"></div>

<table width="100%" div id = "residency_list">
    <tr>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
        <th class= "residency_name">Hospital</th>
        <th class= "residency_name">Position</th>
        <th>Start Date</th>
        <th>End Date</th>

    </tr>
     
     <% if (result != null) {
            while(result.next()) { %>
     <tr>
        <td class= "residency_link"><a href="admin?action=edit_residency&amp;id=<%= result.getInt("id") %>"><img src="/gsu_fhce/images/edit.gif" alt="Edit" /></a></td>  
        <td class= "residency_link"><a href="admin?action=delete_residency&amp;id=<%= result.getInt("id") %>" onclick="return confirm('Are you sure you want to delete this person?');"><img src="/gsu_fhce/images/trash.gif" alt="Delete" /></a></td>    
     
        <td class= "residency_name"><%= result.getString("hName") %></td>
        <td class= "residency_name"><%= result.getString("title") %></td>
        <td class= "residency_date">
            <% String startDateYear = result.getString("start_date").substring(0,4);
            String startDateMonth = result.getString("start_date").substring(5,7);
            String startDateDay = result.getString("start_date").substring(8,10);
            String startDate = startDateMonth + "-" + startDateDay + "-" + startDateYear;
            %><%= startDate%></td>
        <td class= "residency_date">
            <% String endDateYear = result.getString("end_date").substring(0,4);
            String endDateMonth = result.getString("end_date").substring(5,7);
            String endDateDay = result.getString("end_date").substring(8,10);
            String endDate = endDateMonth + "-" + endDateDay + "-" + endDateYear;
            %><%= endDate%></td>
        </tr>
     <% } 
     }       %>
</table>    
    
    </body>
</html>
