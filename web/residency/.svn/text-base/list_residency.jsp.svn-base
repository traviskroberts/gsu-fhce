<%@include file="/common/header.jsp" %>
<!-- author: Shane Severy-->
<%
        // Gets the result set from the controller.
        ResultSet result = (ResultSet)request.getAttribute("result");
%>
<h1>Available Residencies</h1>
<table width="100%" div id = "residency_list">
    <tr>
        <th width = "30%">Hospital Name</th>
        <th width = "30%">Position </th>
        <th width = 20%>Start Date</th>
        <th width = "20%">End Date</th>

    </tr>
    <%
        if(result != null) {
            while(result.next()) {
    %>
            <tr>
                <td class= "residency_name"><%= result.getString("hName") %></td>
                <td class= "residency_name"><%= result.getString("title") %></td>
                <td class= "residency_date">
                    <% //Formats the date from the sql string.
                    String startDateYear = result.getString("start_date").substring(0,4);
                    String startDateMonth = result.getString("start_date").substring(5,7);
                    String startDateDay = result.getString("start_date").substring(8,10);
                    String startDate = startDateMonth + "-" + startDateDay + "-" + startDateYear;
                    %><%= startDate%></td>
                <td class= "residency_date">
                    <% //Formats the date from the sql string.
                    String endDateYear = result.getString("end_date").substring(0,4);
                    String endDateMonth = result.getString("end_date").substring(5,7);
                    String endDateDay = result.getString("end_date").substring(8,10);
                    String endDate = endDateMonth + "-" + endDateDay + "-" + endDateYear;
                    %><%= endDate%></td>
                <td>&nbsp;&nbsp;<a href="residency?action=get_residency&amp;id=<%= result.getString("id") %>">details</a></td>
            </tr>
    <%
        }
            }
    %>
 </table>


<%@include file="/common/footer.jsp" %>