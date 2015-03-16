<%@page import="java.util.Calendar, models.Event" %>

<%
    Calendar calendar = null;
    Event event = null;
    int first_day_of_week = 0;
    int last_day_of_month = 0;
    if(session.getAttribute("event") != null) {
        // get the Calendar object from the request
        event = (Event)session.getAttribute("event");
        calendar = event.getCalendar();
        // get the first day of the month
        first_day_of_week = event.getFirstWeekDayOfMonth();
        // get the number of days in month
        last_day_of_month = event.getMonthDayCount();
    }
%>

<%= event.buildNextMonth() %>