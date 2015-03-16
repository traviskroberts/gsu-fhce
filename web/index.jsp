<%@include file="/common/header.jsp" %>

<%
    // get objects for recent news and events
    News news = new News();
    Event event = new Event();
%>

<img src="/gsu_fhce/images/RCBbuilding.jpg" alt="" class="home_image" />

<%= pager.getContent("root") %>

<div id="recent_news">
    <h2>Recent News</h2>
    <%= news.buildRecentNews() %>
</div><!-- recent_news -->

<div id="upcoming_events">
    <h2>Upcoming Events</h2>
    <%= event.buildRecentEvents() %>
    <p class="cal_link"><a href="/gsu_fhce/calendar">View the Calendar of Events &raquo;</a></p>
</div>

<%@include file="/common/footer.jsp" %>