<%@include file="/common/header.jsp" %>

<%
    // checks first to see if they really are an admin
    if(person != null) {
        if(!person.isAdmin()) {
            String error = "You don't have permission to view that page!";
            session.setAttribute("error", error);
            response.sendRedirect("/gsu_fhce/error.jsp");
        }
    }
    // if they aren't an admin, kick them out
    else {
        String error = "You don't have permission to view that page!";
        session.setAttribute("error", error);
        response.sendRedirect("/gsu_fhce/error.jsp");
    }
    
    // get the month name and number from the request
    // so we can build links to next and previous
    String month_name = (String)request.getAttribute("month_name");
    String m = (String)request.getAttribute("month");
    String y = (String)request.getAttribute("year");
    int month = Integer.parseInt(m);
    int year = Integer.parseInt(y);
    int prev_year;
    int next_year;
    int next_month;
    int prev_month;
    
    if(month == 1) {
        prev_month = 12;
        prev_year = (year-1);
    }
    else {
        prev_month = month-1;
        prev_year = year;
    }
    if(month == 12) {
        next_month = 1;
        next_year = (year+1);
    }
    else {
        next_month = (month+1);
        next_year = year;
    }
    
    // get the result set from the request
    ResultSet resultset = (ResultSet)request.getAttribute("resultset");
%>

<h1>Edit Calendar</h1>

<h3><a href="/gsu_fhce/admin/add_event.jsp" class="add_button">Add New Event</a></h3>

<div class="clear"></div>

<table width="75%" cellspacing="0" cellpadding="0">
    <tr>
        <td width="25%" align="right"><a href="/gsu_fhce/admin?action=edit_events&amp;year_num=<%= prev_year %>&amp;month=<%= prev_month %>"><span class="elevenpx">&laquo; prev month</span></a></td>
        <td width="20%" align="center"><strong class="month"><%= month_name %> <%= year %></strong></td>
        <td width="25%" align="left"><a href="/gsu_fhce/admin?action=edit_events&amp;year_num=<%= next_year %>&amp;month=<%= next_month %>"><span class="elevenpx">next month &raquo;</span></a></td>
    </tr>
</table>

<table width="100%">
    <tr>
        <th>&nbsp;</th>
        <th>Event Title</th>
        <th>Date</th>
    </tr>
    <% while(resultset.next()) { %>
    <tr>
        <td>
            <a href="/gsu_fhce/admin?action=edit_event&amp;id=<%= resultset.getInt("id") %>">
                <img src="/gsu_fhce/images/edit.gif" alt="Edit" />
            </a>
            &nbsp;&nbsp;
            <a href="/gsu_fhce/admin?action=delete_event&amp;id=<%= resultset.getInt("id") %>" onclick="return confirm('Are you sure you want to delete this event?');">
                <img src="/gsu_fhce/images/trash.gif" alt="Delete" />
            </a>
        </td>
        <td><%= resultset.getString("title") %></td>
        <td><%= resultset.getString("date") %></td>
    </tr>
    <% } %>
</table>

<%@include file="/common/footer.jsp" %>