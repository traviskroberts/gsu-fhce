<%@include file="/common/header.jsp" %>

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
    
    Event event = null;
    String title = "";
    String start_time = " ";
    String end_time = " ";
    String description = " ";
    String start_hour = "";
    String start_minutes = "";
    String start_ampm = "";
    String end_hour = "";
    String end_minutes = "";
    String end_ampm = "";
    String id = "";
    if(request.getAttribute("event") != null) {
        event = (Event)request.getAttribute("event");
        title = event.getTitle();
        start_time = event.getStartTime();
        end_time = event.getEndTime();
        description = event.getDescription();
        if(!start_time.equals("") && !end_time.equals("")) {
            start_hour = start_time.substring(0,2);
            start_minutes = start_time.substring(3,5);
            start_ampm = start_time.substring(6,8);
            end_hour = end_time.substring(0,2);
            end_minutes = end_time.substring(3,5);
            end_ampm = end_time.substring(6,8);
        }
        id = (String)request.getAttribute("id");
    }
%>

<h1>Add Calendar Event</h1>

<form action="/gsu_fhce/admin" method="post">
    <p>
        Event Title<br />
        <input type="text" name="title" id="title" value="<%= title %>" class="formfield" />
    </p>
    
    <p>
        Date<br />
            <select name="month" id="month" class="selectfield">
                <option value=""></option>
                <option value="01"<% if(event != null && event.getMonth().equals("01")){ %>selected="selected"<% } %>>January</option>
                <option value="02"<% if(event != null && event.getMonth().equals("02")){ %>selected="selected"<% } %>>February</option>
                <option value="03"<% if(event != null && event.getMonth().equals("03")){ %>selected="selected"<% } %>>March</option>
                <option value="04"<% if(event != null && event.getMonth().equals("04")){ %>selected="selected"<% } %>>April</option>
                <option value="05"<% if(event != null && event.getMonth().equals("05")){ %>selected="selected"<% } %>>May</option>
                <option value="06"<% if(event != null && event.getMonth().equals("06")){ %>selected="selected"<% } %>>June</option>
                <option value="07"<% if(event != null && event.getMonth().equals("07")){ %>selected="selected"<% } %>>July</option>
                <option value="08"<% if(event != null && event.getMonth().equals("08")){ %>selected="selected"<% } %>>August</option>
                <option value="09"<% if(event != null && event.getMonth().equals("09")){ %>selected="selected"<% } %>>September</option>
                <option value="10"<% if(event != null && event.getMonth().equals("10")){ %>selected="selected"<% } %>>October</option>
                <option value="11"<% if(event != null && event.getMonth().equals("11")){ %>selected="selected"<% } %>>November</option>
                <option value="12"<% if(event != null && event.getMonth().equals("12")){ %>selected="selected"<% } %>>December</option>
            </select>&nbsp;
            <select name="day" id="day" class="selectfield">
                <option value=""></option>
                <option value="01"<% if(event != null && event.getDay().equals("01")){ %>selected="selected"<% } %>>01</option>
                <option value="02"<% if(event != null && event.getDay().equals("02")){ %>selected="selected"<% } %>>02</option>
                <option value="03"<% if(event != null && event.getDay().equals("03")){ %>selected="selected"<% } %>>03</option>
                <option value="04"<% if(event != null && event.getDay().equals("04")){ %>selected="selected"<% } %>>04</option>
                <option value="05"<% if(event != null && event.getDay().equals("05")){ %>selected="selected"<% } %>>05</option>
                <option value="06"<% if(event != null && event.getDay().equals("06")){ %>selected="selected"<% } %>>06</option>
                <option value="07"<% if(event != null && event.getDay().equals("07")){ %>selected="selected"<% } %>>07</option>
                <option value="08"<% if(event != null && event.getDay().equals("08")){ %>selected="selected"<% } %>>08</option>
                <option value="09"<% if(event != null && event.getDay().equals("09")){ %>selected="selected"<% } %>>09</option>
                <option value="10"<% if(event != null && event.getDay().equals("10")){ %>selected="selected"<% } %>>10</option>
                <option value="11"<% if(event != null && event.getDay().equals("11")){ %>selected="selected"<% } %>>11</option>
                <option value="12"<% if(event != null && event.getDay().equals("12")){ %>selected="selected"<% } %>>12</option>
                <option value="13"<% if(event != null && event.getDay().equals("13")){ %>selected="selected"<% } %>>13</option>
                <option value="14"<% if(event != null && event.getDay().equals("14")){ %>selected="selected"<% } %>>14</option>
                <option value="15"<% if(event != null && event.getDay().equals("15")){ %>selected="selected"<% } %>>15</option>
                <option value="16"<% if(event != null && event.getDay().equals("16")){ %>selected="selected"<% } %>>16</option>
                <option value="17"<% if(event != null && event.getDay().equals("17")){ %>selected="selected"<% } %>>17</option>
                <option value="18"<% if(event != null && event.getDay().equals("18")){ %>selected="selected"<% } %>>18</option>
                <option value="19"<% if(event != null && event.getDay().equals("19")){ %>selected="selected"<% } %>>19</option>
                <option value="20"<% if(event != null && event.getDay().equals("20")){ %>selected="selected"<% } %>>20</option>
                <option value="21"<% if(event != null && event.getDay().equals("21")){ %>selected="selected"<% } %>>21</option>
                <option value="22"<% if(event != null && event.getDay().equals("22")){ %>selected="selected"<% } %>>22</option>
                <option value="23"<% if(event != null && event.getDay().equals("23")){ %>selected="selected"<% } %>>23</option>
                <option value="24"<% if(event != null && event.getDay().equals("24")){ %>selected="selected"<% } %>>24</option>
                <option value="25"<% if(event != null && event.getDay().equals("25")){ %>selected="selected"<% } %>>25</option>
                <option value="26"<% if(event != null && event.getDay().equals("26")){ %>selected="selected"<% } %>>26</option>
                <option value="27"<% if(event != null && event.getDay().equals("27")){ %>selected="selected"<% } %>>27</option>
                <option value="28"<% if(event != null && event.getDay().equals("28")){ %>selected="selected"<% } %>>28</option>
                <option value="29"<% if(event != null && event.getDay().equals("29")){ %>selected="selected"<% } %>>29</option>
                <option value="30"<% if(event != null && event.getDay().equals("30")){ %>selected="selected"<% } %>>30</option>
                <option value="31"<% if(event != null && event.getDay().equals("31")){ %>selected="selected"<% } %>>31</option>
            </select>&nbsp;
            <select name="year" id="year" class="selectfield">
                <option value=""></option>
                <option value="2006"<% if(event != null && event.getYear().equals("2006")){ %>selected="selected"<% } %>>2006</option>
                <option value="2007"<% if(event != null && event.getYear().equals("2007")){ %>selected="selected"<% } %>>2007</option>
                <option value="2008"<% if(event != null && event.getYear().equals("2008")){ %>selected="selected"<% } %>>2008</option>
                <option value="2009"<% if(event != null && event.getYear().equals("2009")){ %>selected="selected"<% } %>>2009</option>
                <option value="2010"<% if(event != null && event.getYear().equals("2010")){ %>selected="selected"<% } %>>2010</option>
                <option value="2011"<% if(event != null && event.getYear().equals("2011")){ %>selected="selected"<% } %>>2011</option>
                <option value="2012"<% if(event != null && event.getYear().equals("2012")){ %>selected="selected"<% } %>>2012</option>
            </select>
    </p>
    
    <p>
        <input type="checkbox" name="all_day" <% if(event != null && start_time.equals("")) { %>checked="checked"<% } %> onclick="Element.toggle('times');" />
        All day event
    </p>
    
    <div id="times" <% if(event != null && start_time.equals("")) { %>style="display:none"<% } %>>
        <p>
            Time<br />
            <input type="text" name="start_hour" id="start_hour" value="<%= start_hour %>" maxlength="2" class="timefield" />
            :
            <input type="text" name="start_minutes" id="start_minutes" value="<%= start_minutes %>" maxlength="2" class="timefield" />&nbsp;
            <select name="start_ampm" id="start_ampm" class="selectfield">
                <option value="pm" <% if(event != null && start_ampm.equals("pm")) { %>selected="selected"<% } %>>pm</option>
                <option value="am" <% if(event != null && start_ampm.equals("am")) { %>selected="selected"<% } %>>am</option>
            </select>
            &nbsp;<strong>-</strong>&nbsp;
            <input type="text" name="end_hour" id="end_hour" value="<%= end_hour %>" maxlength="2" class="timefield" />
            :
            <input type="text" name="end_minutes" id="end_minutes" value="<%= end_minutes %>" maxlength="2" class="timefield" />&nbsp;
            <select name="end_ampm" id="end_ampm" class="selectfield">
                <option value="pm" <% if(event != null && end_ampm.equals("pm")) { %>selected="selected"<% } %>>pm</option>
                <option value="am" <% if(event != null && end_ampm.equals("am")) { %>selected="selected"<% } %>>am</option>
            </select>
        </p>
    </div>
    
    <p>
        Description:<br />
        <textarea name="description" id="description" cols="35" rows="5" class="formfield"><% if(event != null && description != null) { %><%= description %><% } %></textarea>
    </p>
    
    <% if(event == null) { %>
        <input type="hidden" name="action" value="save_event" />
    <% } else { %>
        <input type="hidden" name="action" value="update_event" />
        <input type="hidden" name="id" value="<%= id %>" />
    <% } %>
    
    <p>
        <input type="button" value="Save Event" onclick="checkEvent(this.form); return false;" />&nbsp;
        <a href="/gsu_fhce/admin?action=edit_events">Cancel</a>
    </p>
</form>

<%@include file="/common/footer.jsp" %>