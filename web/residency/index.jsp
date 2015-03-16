<%@include file="/common/header.jsp" %>
<!-- author: Shane Severy-->
<%  //Gets the hospital name and the result.
    String hospital_name = (String) session.getAttribute("hospital_name");
    String note = "";
    ResultSet result = (ResultSet)request.getAttribute("result");
    
    //Checks for a result and displays the appropiate message.    
    if (result != null){

        note = "These are the current residencies.";

    }
    else {
       note = "You do not have any current residencies.";
    }
%>
<h1>Residency Listings</h1>
    
<h3><%= hospital_name %></h3>
<p><h4><%= note %></h4></p> <br />

    <h3><a href="/gsu_fhce/residency/add_residency.jsp" class="add_button">Add Residency</a> </h3>

    <div class="clear"></div>
   <% if (result!=null) { %>    
<table div id = "residency_list">
    <tr>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
        <th class= "residency_name">Position</th>
        <th>Start Date</th>
        <th>End Date</th>

    </tr>
   

     <% while(result.next()) { %>
     <tr>
        <td class= "residency_link"><a href="residency?action=edit_residency&amp;id=<%= result.getString("id") %>"><img src="/gsu_fhce/images/edit.gif" alt="Edit" /></a></td>  
        <td class= "residency_link"><a href="residency?action=delete&amp;id=<%= result.getString("id") %>" onclick="return confirm('Are you sure you want to delete this person?');"><img src="/gsu_fhce/images/trash.gif" alt="Delete" /></a</td>
        <td class= "residency_name"><%= result.getString("position_title") %></td>
        <td class= "residency_date">
            <%//Formats the date from the sql string. 
            String startDateYear = result.getString("start_date").substring(0,4);
            String startDateMonth = result.getString("start_date").substring(5,7);
            String startDateDay = result.getString("start_date").substring(8,10);
            String startDate = startDateMonth + "-" + startDateDay + "-" + startDateYear;
            %><%= startDate%></td>
        <td class= "residency_date">
            <%//Formats the date from the sql string. 
            String endDateYear = result.getString("end_date").substring(0,4);
            String endDateMonth = result.getString("end_date").substring(5,7);
            String endDateDay = result.getString("end_date").substring(8,10);
            String endDate = endDateMonth + "-" + endDateDay + "-" + endDateYear;
            %><%= endDate%></td>
    
     </tr>
     <% }
     } %>
</table>
</div>


<%@include file="/common/footer.jsp" %>
