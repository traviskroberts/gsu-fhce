<%@include file="/common/header.jsp" %>
<!-- author: Shane Severy-->
<%
        //Gets both result sets the residency for the first and the hospitals for the second.
        ResultSet result = (ResultSet)request.getAttribute("result");
        ResultSet result2 = (ResultSet)request.getAttribute("result2");
        String hName = (String)request.getAttribute("hName");
        String email = (String)request.getAttribute("email");
%>
<h1>Residency Detail</h1>
        
      <br />

     <% while(result.next()) { %>
     
      <h2><%=hName%></h2>
      <br />
      <table rules = "all" class = "resume">
            <tr>
                <td class = "title">Application deadline:</td>
                <td>  
                    <% //Formats the date from the sql string. 
                    String deadlineDateYear = result.getString("deadline_date").substring(0,4);
                    String deadlineDateMonth = result.getString("deadline_date").substring(5,7);
                    String deadlineDateDay = result.getString("deadline_date").substring(8,10);
                    String deadlineDate = deadlineDateMonth + "-" + deadlineDateDay + "-" + deadlineDateYear;
                    %><%= deadlineDate%>
                </td>
            </tr>
            <tr>
                <td class = "title">Start Date: </td>
                <td>
                    <% //Formats the date from the sql string.
                    String startDateYear = result.getString("start_date").substring(0,4);
                    String startDateMonth = result.getString("start_date").substring(5,7);
                    String startDateDay = result.getString("start_date").substring(8,10);
                    String startDate = startDateMonth + "-" + startDateDay + "-" + startDateYear;
                    %><%= startDate%>
                </td>
            </tr>
            <tr>
                <td class = "title">End Date: </td>
                <td>
                    <% //Formats the date from the sql string.
                    String endDateYear = result.getString("end_date").substring(0,4);
                    String endDateMonth = result.getString("end_date").substring(5,7);
                    String endDateDay = result.getString("end_date").substring(8,10);
                    String endDate = endDateMonth + "-" + endDateDay + "-" + endDateYear;
                    %><%= startDate%>
                </td>
            </tr>
            <tr>
                <td class = "title">Description:</td>
                <td><%= result.getString("description") %></td>
            </tr>
<% while(result2.next()) {%>

            <tr>
                <td class = "title">Contact email:</td>
                <td><a href="mailto:<%=email%>"><%=email%></a></td>
            </tr>
            <tr>
                <td class = "title">Phone Number:</td>
                <td><%= result2.getString("phone") %></td>
            </tr>
            <tr>
                <td class = "title">Website:</td>
                <td><a href="<%= result2.getString("url") %>" target="_blank"><%= result2.getString("url") %></a></td>
            </tr>
       <% } %>
     <% } %>
 
<%@include file="/common/footer.jsp" %>