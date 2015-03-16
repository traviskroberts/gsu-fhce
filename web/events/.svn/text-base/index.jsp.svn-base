<%@include file="/common/header.jsp" %>
<%@page import="java.util.Calendar" %>

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

<h1>Calendar of Events</h1>

<div id="calendar_wrapper">
    <%= event.buildCalendar() %>
</div><!-- calendar_wrapper -->

<div id="event_detail_wrapper">
    <h2>Event Details</h2>
    <span id="event_busy" style="display:none;">
        <p>
            <img src="/gsu_fhce/images/bigbusy.gif" alt="Loading..." /><br />
            Loading...
        </p>
    </span><!-- event_busy -->
    <span id="event_details"><p><em>Select an event to see details</em></p></span>
</div><!-- event_detail_wrapper -->

<div class="clear"></div>

<%@include file="/common/footer.jsp" %>