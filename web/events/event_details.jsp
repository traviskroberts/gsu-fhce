<%@page import="java.util.Calendar, models.Event" %>

<%
    String details = "There was an error loading the event.  Please try again.";
    String date = "";
    Event event = new Event();
    if(request.getParameter("date") != null) {
        date = request.getParameter("date");
    }
    details = event.getEvent(date);
%>

<%= details %>