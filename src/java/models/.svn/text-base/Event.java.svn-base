/*
 * Event.java
 *
 * Created on November 19, 2006, 1:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package models;

import java.util.Calendar;

import java.sql.*;

/**
 * Event object to represent a calendar event
 * @author travis
 */
public class Event extends Super {
    
    private Calendar calendar;
    private String title;
    private String description;
    private String month;
    private String day;
    private String year;
    private String start_time;
    private String end_time;
    
    
    
    /** Creates a new instance of Event */
    public Event() {
        calendar = Calendar.getInstance();
    }
    
    /**
     * Creates a new instance of Event when passed the month, day, and year
     * @param y Value of year
     * @param m Value of month
     * @param d Value of day
     */
    public Event(int y, int m, int d) {
        calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(y, m, d);
    }
    
    /**
     * Creates a new instance of Event when passed all attributes
     * @param title Value of the title
     * @param description Value of the description
     * @param month Value of the month
     * @param day Value of the day
     * @param year Value of the year
     * @param start_time Value of the start time
     * @param end_time Value of the end time
     */
    public Event(String title, String description, String month, String day, String year, String start_time, String end_time) {
        this.title = title;
        this.description = description;
        this.month = month;
        this.day = day;
        this.year = year;
        this.start_time = start_time;
        this.end_time = end_time;
    }
    
    /**
     * Creates a new instance of Event when passed all attributes except start time and end time
     * @param title Value of the title
     * @param description Value of the description
     * @param month Value of the month
     * @param day Value of the day
     * @param year Value of the year
     */
    public Event(String title, String description, String month, String day, String year) {
        this.title = title;
        this.description = description;
        this.month = month;
        this.day = day;
        this.year = year;
        start_time = "";
        end_time = "";
    }
    
    /**
     * Gets the value of title
     * @return Value of the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the value of title
     * @param value New value of the title
     */
    public void setTitle(String value) {
        title = value;
    }
    
    /**
     * Gets the value of description
     * @return Value of the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the value of description
     * @param value New value of the description
     */
    public void setDescription(String value) {
        description = value;
    }
    
    /**
     * Gets the value of month
     * @return Value of the month
     */
    public String getMonth() {
        return month;
    }
    
    /**
     * Sets the value of month
     * @param value New value of the month
     */
    public void setMonth(String value) {
        month = value;
    }
    
    /**
     * Gets the value of day
     * @return Value of the day
     */
    public String getDay() {
        return day;
    }
    
    /**
     * Sets the value of day
     * @param value New value of the day
     */
    public void setDay(String value) {
        day = value;
    }
    
    /**
     * Gets the value of year
     * @return Value of the year
     */
    public String getYear() {
        return year;
    }
    
    /**
     * Sets the value of year
     * @param value New value of the year
     */
    public void setYear(String value) {
        year = value;
    }
    
    /**
     * Gets the value of start time
     * @return Value of the start time
     */
    public String getStartTime() {
        return start_time;
    }
    
    /**
     * Sets the value of start time
     * @param value New value of the start time
     */
    public void setStartTime(String value) {
        start_time = value;
    }
    
    /**
     * Gets the value of end time
     * @return Value of the end time
     */
    public String getEndTime() {
        return end_time;
    }
    
    /**
     * Sets the value of end time
     * @param value New value of the end time
     */
    public void setEndTime(String value) {
        end_time = value;
    }
    
    /**
     * Gets the Calendar object for the Event object
     * @return Calendar object
     */
    public Calendar getCalendar() {
        return calendar;
    }
    
    /**
     * Sets the Calendar object for the Event object
     * @param value New value of the Calendar
     */
    public void setCalendar(Calendar value) {
        calendar = value;
    }
    
    /**
     * Returns the month number (1-12)
     * @return Int month number
     */
    public int getMonthNumber() {
        return calendar.get(2);
    }
    
    /**
     * Returns the year number
     * @return Int year number
     */
    public int getYearNumber() {
        return calendar.get(1);
    }
    
    /**
     * Saves the Event into the database
     * @return boolean
     */
    public boolean saveEvent() {
        String date = getYear() + "-" + getMonth() + "-" + getDay();
        String sql = "INSERT INTO event(title, description, date, start_time, end_time) " +
                "VALUES('" + addSlashes(getTitle()) + "', '" + addSlashes(getDescription()) + "', '" + 
                date + "', '" + getStartTime() + "', '" + getEndTime() + "')";
        try{
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(sql);
            ;
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    /**
     * Updates the event record in the database with the value of the object
     * @param id Int value of the id of the event record to update
     * @return Boolean to indicate success or failure
     */
    public boolean updateEvent(int id) {
        String date = getYear() + "-" + getMonth() + "-" + getDay();
        String sql = "UPDATE event SET title='" + addSlashes(getTitle()) + "', description='" + 
                addSlashes(getDescription()) + "', date='" + date + "', start_time='" + 
                getStartTime() + "', end_time='" + getEndTime() + "' WHERE id=" + id;
        try{
            dbStatement = connection.createStatement();
            dbStatement.executeUpdate(sql);
            ;
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    /**
     * Deletes event record from the database
     * @param id Int value of the event id to delete
     * @return Boolean to indicate success or failure
     */
    public boolean deleteEvent(int id) {
        String sql = "DELETE FROM event WHERE id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbStatement.execute(sql);
            ;
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    /**
     * Builds output for three most recent events
     * @return String of HTML formatted list of events
     */
    public String buildRecentEvents() {
        String output = "";
        // get today's date
        String year = Integer.toString(calendar.get(1));
        
        int month_num = calendar.get(2)+1;
        String month = "";
        if(month_num < 10) { month = "0" + Integer.toString(month_num); }
        else { month = Integer.toString(month_num); }
        
        int day_num = calendar.get(5);
        String day = "";
        if(day_num < 10) { day = "0" + Integer.toString(day_num); }
        else { day = Integer.toString(day_num); }
        
        String date = year + "-" + month + "-" + day;
        
        String sql = "SELECT * FROM event WHERE date > '" + date + "' ORDER BY date LIMIT 3";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            while(dbResultSet.next()) {
                // build an attractive date
                String nice_date = "";
                if(!dbResultSet.getString("date").equals("")) {
                    nice_date = getMonthNameForEvent(dbResultSet.getString("date").substring(5,7)) + 
                            " " + dbResultSet.getString("date").substring(8,10) + ", " + 
                            dbResultSet.getString("date").substring(0,4);
                }
                output += "<div class=\"event\">";
                output += "<p class=\"event_title\"><strong>" + dbResultSet.getString("title") + "</strong> - ";
                output += nice_date + "</p>";
                if(!dbResultSet.getString("start_time").equals("") && !dbResultSet.getString("end_time").equals("")) {
                    output += "<p><strong>" + dbResultSet.getString("start_time") + "-" + 
                            dbResultSet.getString("end_time") + "</strong></p>";
                }
                output += "<p>" + truncate(dbResultSet.getString("description"), 115) + "</p>";
                output += "</div><!-- event -->";
            }
        }
        catch(SQLException e) {
            return "There are no upcoming events scheduled at this time.";
        }
        return output;
    }
    
    /**
     * Checks to see if an event is scheduled on a given date
     * @param date Value of date to check for
     * @return boolean
     */
    public boolean eventIsScheduled(String date) {
        String sql = "SELECT * FROM event WHERE date LIKE '" + date + "'";
        try{
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.last() && (dbResultSet.getRow() > 0)) {
                return true;
            }
            else {
                return false;
            }
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    /**
     * Gets the month name
     * @return String
     */
    public String getMonthName() {
        int month_number = calendar.get(2);
        if(month_number == 0) { return "January"; }
        else if(month_number == 1) { return "February"; }
        else if(month_number == 2) { return "March"; }
        else if(month_number == 3) { return "April"; }
        else if(month_number == 4) { return "May"; }
        else if(month_number == 5) { return "June"; }
        else if(month_number == 6) { return "July"; }
        else if(month_number == 7) { return "August"; }
        else if(month_number == 8) { return "September"; }
        else if(month_number == 9) { return "October"; }
        else if(month_number == 10) { return "November"; }
        else if(month_number == 11) { return "December"; }
        else { return ""; }
    }
    
    /**
     * Gets the month name
     * @return String
     */
    public String getMonthNameForEvent(String month_number) {
        if(month_number.equals("01")) { return "January"; }
        else if(month_number.equals("02")) { return "February"; }
        else if(month_number.equals("03")) { return "March"; }
        else if(month_number.equals("04")) { return "April"; }
        else if(month_number.equals("05")) { return "May"; }
        else if(month_number.equals("06")) { return "June"; }
        else if(month_number.equals("07")) { return "July"; }
        else if(month_number.equals("08")) { return "August"; }
        else if(month_number.equals("09")) { return "September"; }
        else if(month_number.equals("10")) { return "October"; }
        else if(month_number.equals("11")) { return "November"; }
        else if(month_number.equals("12")) { return "December"; }
        else { return ""; }
    }
    
    /**
     * Gets the day of week that is the first day of the month for a given month
     * @return String
     */
    public int getFirstWeekDayOfMonth() {
        Calendar copy = (Calendar)calendar.clone();
        // copy.add(5, -(copy.get(5)+1));
        copy.add(5, -(copy.get(5)-1));
        int temp = copy.get(7);
        return copy.get(7)-1;
    }
    
    /**
     * Gets the number of days in a given month
     * @return int
     */
    public int getMonthDayCount() {
        String month_name = getMonthName();
        if(month_name.equals("April") || month_name.equals("June") || 
                month_name.equals("September") || month_name.equals("November")) {
            return 30;
        }
        else if(month_name.equals("February")){
            return 28;
        }
        else {
            return 31;
        }
    }
    
    /**
     * Builds the output for the calendar
     * @return String
     */
    public String buildCalendar() {
        String output = "";
        int first_day_of_week = getFirstWeekDayOfMonth();
        int last_day_of_month = getMonthDayCount();
        int today = calendar.get(5);
        int day_marker = 0;
        String date_to_check = "";
        // build initial static part of calendar table
        output += "<table class=\"calendar\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n";
        output += "<tr>\n";
        output += "<td class=\"ajax_link\">" +
                "<span id=\"previous_link\"><a href=\"#\" onclick=\"new Ajax.Updater('calendar_wrapper', '/gsu_fhce/events/previous_month.jsp', {onLoading:function(){showBusyCalendar('previous')}, onComplete:function(){hideBusyCalendar('previous')}, asynchronous:true, evalScripts:true}); return false\">&lt;</a></span>" +
                "<div id=\"previous_busy\" style=\"display:none;\"><img src=\"/gsu_fhce/images/busy.gif\" alt=\"Loading...\">" +
                "</td>\n";
        output += "<td colspan=\"5\" class=\"month_name\">" + getMonthName() + "</td>\n";
        output += "<td class=\"ajax_link\">" +
                "<span id=\"next_link\"><a href=\"#\" onclick=\"new Ajax.Updater('calendar_wrapper', '/gsu_fhce/events/next_month.jsp', {onLoading:function(){showBusyCalendar('next')}, onComplete:function(){hideBusyCalendar('next')}, asynchronous:true, evalScripts:true}); return false\">&gt;</a></span>" +
                "<div id=\"next_busy\" style=\"display:none;\"><img src=\"/gsu_fhce/images/busy.gif\" alt=\"Loading...\">" +
                "</td>\n";
        output += "</tr>\n";
        output += "<tr class=\"days\">\n";
        output += "<td>Sun</td>\n";
        output += "<td>Mon</td>\n";
        output += "<td>Tue</td>\n";
        output += "<td>Wed</td>\n";
        output += "<td>Thu</td>\n";
        output += "<td>Fri</td>\n";
        output += "<td>Sat</td>\n";
        output += "</tr>\n";
        output += "<tr>\n";
        for(int x = 0; x < first_day_of_week; x++, day_marker++) {
            output += "<td>&nbsp;</td>\n";
        }
        for(int i=7; i < (last_day_of_month+7); i++, day_marker++) {
            // put a beginning <tr> and the start of the week
            if(day_marker%7 == 0) {
                output += "<tr>\n";
            }
            // build the date for checking to see if
            // an event is scheduled for that day
            String month = "";
            // build month (make sure it is double digit)
            if((calendar.get(2)+1) < 10) { month = "0" + Integer.toString(calendar.get(2)+1); }
            else { month = Integer.toString(calendar.get(2)+1); }
            // build date to check String
            if((i-6) < 10) {
                date_to_check = calendar.get(1) + "-" + month + "-0" + (i-6);
            }
            else {
                date_to_check = calendar.get(1) + "-" + month + "-" + (i-6);
            }
            // if an event IS scheduled, link to it
            if(eventIsScheduled(date_to_check)) {
                output += "<td><a href=\"#\" onclick=\"new Ajax.Updater('event_details', " +
                        "'/gsu_fhce/events/event_details.jsp?date=" + date_to_check + "', " +
                        "{onLoading:function(){showBusyEvent()}, " +
                        "onComplete:function(){hideBusyEvent()}, " +
                        "asynchronous:true, evalScripts:true}); " +
                        "return false\">" + (i - 6) + "</a></td>\n";
            }
            else {
                output += "<td>" + (i - 6) + "</td>\n";
            }
            // put an ending <tr> at the end of the week
            if(day_marker%7 == 6) {
                output += "</tr>\n";
            }
        }
        while(day_marker%7 != 0) {
            output += "<td>&nbsp;</td>\n";
            day_marker++;
        }
        output += "</tr>\n";
        output += "</table>\n";
        return output;
    }
    
    /**
     * Builds the output for the calendar
     * @return String
     */
    public String buildNextMonth() {
        String output = "";
        calendar.set(5, 1);
        calendar.add(2, 1);
        int first_day_of_week = getFirstWeekDayOfMonth();
        int last_day_of_month = getMonthDayCount();
        int today = calendar.get(5);
        int day_marker = 0;
        String date_to_check = "";
        // build initial static part of calendar table
        output += "<table class=\"calendar\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n";
        output += "<tr>\n";
        output += "<td class=\"ajax_link\">" +
                "<a href=\"#\" id=\"previous_link\" onclick=\"new Ajax.Updater('calendar_wrapper', '/gsu_fhce/events/previous_month.jsp', {onLoading:function(){showBusyCalendar('previous')}, onComplete:function(){hideBusyCalendar('previous')}, asynchronous:true, evalScripts:true}); return false\">&lt;</a>" +
                "<div id=\"previous_busy\" style=\"display:none;\"><img src=\"/gsu_fhce/images/busy.gif\" alt=\"Loading...\">" +
                "</td>\n";
        output += "<td colspan=\"5\" class=\"month_name\">" + getMonthName() + "</td>\n";
        output += "<td class=\"ajax_link\">" +
                "<a href=\"#\" id=\"next_link\" onclick=\"new Ajax.Updater('calendar_wrapper', '/gsu_fhce/events/next_month.jsp', {onLoading:function(){showBusyCalendar('next')}, onComplete:function(){hideBusyCalendar('next')}, asynchronous:true, evalScripts:true}); return false\">&gt;</a>" +
                "<div id=\"next_busy\" style=\"display:none;\"><img src=\"/gsu_fhce/images/busy.gif\" alt=\"Loading...\">" +
                "</td>\n";
        output += "</tr>\n";
        output += "<tr class=\"days\">\n";
        output += "<td>Sun</td>\n";
        output += "<td>Mon</td>\n";
        output += "<td>Tue</td>\n";
        output += "<td>Wed</td>\n";
        output += "<td>Thu</td>\n";
        output += "<td>Fri</td>\n";
        output += "<td>Sat</td>\n";
        output += "</tr>\n";
        output += "<tr>\n";
        for(int x = 0; x < first_day_of_week; x++, day_marker++) {
            output += "<td>&nbsp;</td>\n";
        }
        for(int i=7; i < (last_day_of_month+7); i++, day_marker++) {
            // put a beginning <tr> and the start of the week
            if(day_marker%7 == 0) {
                output += "<tr>\n";
            }
            // build the date for checking to see if
            // an event is scheduled for that day
            String y = Integer.toString(calendar.get(1));
            String month = "";
            // build month
            if((calendar.get(2)+1) < 10) { month = "0" + Integer.toString(calendar.get(2)+1); }
            else { month = Integer.toString(calendar.get(2)+1); }
            // build date to check String
            if((i-6) < 10) {
                date_to_check = calendar.get(1) + "-" + month + "-0" + (i-6);
            }
            else {
                date_to_check = calendar.get(1) + "-" + month + "-" + (i-6);
            }
            // if an event IS scheduled, link to it
            if(eventIsScheduled(date_to_check)) {
                output += "<td><a href=\"#\" onclick=\"new Ajax.Updater('event_details', " +
                        "'/gsu_fhce/events/event_details.jsp?date=" + date_to_check + "', " +
                        "{onLoading:function(){showBusyEvent()}, " +
                        "onComplete:function(){hideBusyEvent()}, " +
                        "asynchronous:true, evalScripts:true}); " +
                        "return false\">" + (i - 6) + "</a></td>\n";
            }
            else {
                output += "<td>" + (i - 6) + "</td>\n";
            }
            // put an ending <tr> at the end of the week
            if(day_marker%7 == 6) {
                output += "</tr>\n";
            }
        }
        while(day_marker%7 != 0) {
            output += "<td>&nbsp;</td>\n";
            day_marker++;
        }
        output += "</tr>\n";
        output += "</table>\n";
        return output;
    }
    
    /**
     * Builds the output for the calendar
     * @return String
     */
    public String buildPreviousMonth() {
        String output = "";
        calendar.set(5, 1);
        calendar.add(2, -1);
        int first_day_of_week = getFirstWeekDayOfMonth();
        int last_day_of_month = getMonthDayCount();
        int today = calendar.get(5);
        int day_marker = 0;
        String date_to_check = "";
        // build initial static part of calendar table
        output += "<table class=\"calendar\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n";
        output += "<tr>\n";
        output += "<td class=\"ajax_link\">" +
                "<a href=\"#\" id=\"previous_link\" onclick=\"new Ajax.Updater('calendar_wrapper', '/gsu_fhce/events/previous_month.jsp', {onLoading:function(){showBusyCalendar('previous')}, onComplete:function(){hideBusyCalendar('previous')}, asynchronous:true, evalScripts:true}); return false\">&lt;</a>" +
                "<div id=\"previous_busy\" style=\"display:none;\"><img src=\"/gsu_fhce/images/busy.gif\" alt=\"Loading...\">" +
                "</td>\n";
        output += "<td colspan=\"5\" class=\"month_name\">" + getMonthName() + "</td>\n";
        output += "<td class=\"ajax_link\">" +
                "<a href=\"#\" id=\"next_link\" onclick=\"new Ajax.Updater('calendar_wrapper', '/gsu_fhce/events/next_month.jsp', {onLoading:function(){showBusyCalendar('next')}, onComplete:function(){hideBusyCalendar('next')}, asynchronous:true, evalScripts:true}); return false\">&gt;</a>" +
                "<div id=\"next_busy\" style=\"display:none;\"><img src=\"/gsu_fhce/images/busy.gif\" alt=\"Loading...\">" +
                "</td>\n";
        output += "</tr>\n";
        output += "<tr class=\"days\">\n";
        output += "<td>Sun</td>\n";
        output += "<td>Mon</td>\n";
        output += "<td>Tue</td>\n";
        output += "<td>Wed</td>\n";
        output += "<td>Thu</td>\n";
        output += "<td>Fri</td>\n";
        output += "<td>Sat</td>\n";
        output += "</tr>\n";
        output += "<tr>\n";
        for(int x = 0; x < first_day_of_week; x++) {
            if(first_day_of_week > 0) {
                output += "<td>&nbsp;</td>\n";
                day_marker++;
            }
        }
        for(int i=7; i < (last_day_of_month+7); i++, day_marker++) {
            // put a beginning <tr> and the start of the week
            if(day_marker%7 == 0) {
                output += "<tr>\n";
            }
            // build the date for checking to see if
            // an event is scheduled for that day
            String month = "";
            // build month (make sure it is double digit)
            if((calendar.get(2)+1) < 10) { month = "0" + Integer.toString(calendar.get(2)+1); }
            else { month = Integer.toString(calendar.get(2)+1); }
            // build date to check String
            if((i-6) < 10) {
                date_to_check = calendar.get(1) + "-" + month + "-0" + (i-6);
            }
            else {
                date_to_check = calendar.get(1) + "-" + month + "-" + (i-6);
            }
            // if an event IS scheduled, link to it
            if(eventIsScheduled(date_to_check)) {
                output += "<td><a href=\"#\" onclick=\"new Ajax.Updater('event_details', " +
                        "'/gsu_fhce/events/event_details.jsp?date=" + date_to_check + "', " +
                        "{onLoading:function(){showBusyEvent()}, " +
                        "onComplete:function(){hideBusyEvent()}, " +
                        "asynchronous:true, evalScripts:true}); " +
                        "return false\">" + (i - 6) + "</a></td>\n";
            }
            else {
                output += "<td>" + (i - 6) + "</td>\n";
            }
            // put an ending <tr> at the end of the week
            if(day_marker%7 == 6) {
                output += "</tr>\n";
            }
        }
        output += "";
        while(day_marker%7 != 0) {
            output += "<td>&nbsp;</td>\n";
            day_marker++;
        }
        output += "</tr>\n";
        output += "</table>\n";
        return output;
    }
    
    /**
     * Gets the event(s) for a given date
     * @param date The date to get the events for
     * @return String
     */
    public String getEvent(String date) {
        String sql = "SELECT * FROM event WHERE date LIKE '" + date + "'";
        String output = "<h3>" + date.substring(5,7) + "/" + date.substring(8,10) + "/" + date.substring(0,4) + "</h3>\n";
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            while(dbResultSet.next()) {
                output += "<p class=\"event\"><strong>" + dbResultSet.getString("title") + 
                        "</strong><br />\n";
                if(!dbResultSet.getString("start_time").equals("") && !dbResultSet.getString("end_time").equals("")) {
                    output += dbResultSet.getString("start_time") +
                            " - " + dbResultSet.getString("end_time") + "</p>\n";
                }
                output += "<p>" + dbResultSet.getString("description") + "</p>\n";
            }
        }
        catch(SQLException e) {
            return "There was an error with your request.<br />" + e.getMessage();
        }
        return output;
    }
    
    /**
     * Retrieve the details of the event from the database
     * @param id Int value of the event id to retrieve
     * @return Event object
     */
    public Event getEvent(int id) {
        String sql = "SELECT * FROM event WHERE id=" + id;
        try {
            dbStatement = connection.createStatement();
            dbResultSet = dbStatement.executeQuery(sql);
            ;
            if(dbResultSet.next()) {
                String title = dbResultSet.getString("title");
                String description = dbResultSet.getString("description");
                String date = dbResultSet.getString("date");
                String start_time = dbResultSet.getString("start_time");
                String end_time = dbResultSet.getString("end_time");
                // get the date stuff
                String year = date.substring(0,4);
                String month = date.substring(5,7);
                String day = date.substring(8,10);
                Event event = new Event(title, description, month, day, year, start_time, end_time);
                return event;
            }
            else {
                return null;
            }
        }
        catch(SQLException e) {
            return null;
        }
    }
    
}
