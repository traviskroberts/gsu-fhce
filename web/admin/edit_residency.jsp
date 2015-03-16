<%@include file="/common/header.jsp" %>
<!-- author: Shane Severy-->
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
    // get the result set from the request and the hospital name    
  ResultSet result = (ResultSet)request.getAttribute("result");
  String hName = (String)request.getAttribute("hName");
  while(result.next()){
 
  //read in the start date
  String startDateYear = result.getString("start_date").substring(0,4);
  String startDateMonth = result.getString("start_date").substring(5,7);
  String startDateDay = result.getString("start_date").substring(8,10);
  //read in the end date
  String endDateYear = result.getString("end_date").substring(0,4);
  String endDateMonth = result.getString("end_date").substring(5,7);
  String endDateDay = result.getString("end_date").substring(8,10);
  //read in the deadline date
  String deadlineDateYear = result.getString("deadline_date").substring(0,4);
  String deadlineDateMonth = result.getString("deadline_date").substring(5,7);
  String deadlineDateDay = result.getString("deadline_date").substring(8,10);
%>
<h1>Edit Residency</h1>
<form action="/gsu_fhce/admin" method="post">

        
<p>
    <h4><%= hName %></h4><br />
</p> 

<p>
    Position Title<br /> 
    <input type="text" name="title" id="title"             
           value="<%= result.getString("position_title") %>" class="formfield" />
</p>
 
<p>
    Start Date<br /> 
    <select name="startDateMonth" id="startDateMonth" class="selectfield">
        <option value="">month</option>
        <option value="01"<% if(startDateMonth.equals("01")) { %> selected="selected" <% } %>>January</option>
        <option value="02"<% if(startDateMonth.equals("02")) { %> selected="selected" <% } %>>February</option>
        <option value="03"<% if(startDateMonth.equals("03")) { %> selected="selected" <% } %>>March</option>
        <option value="04"<% if(startDateMonth.equals("04")) { %> selected="selected" <% } %>>April</option>
        <option value="05"<% if(startDateMonth.equals("05")) { %> selected="selected" <% } %>>May</option>
        <option value="06"<% if(startDateMonth.equals("06")) { %> selected="selected" <% } %>>June</option>
        <option value="07"<% if(startDateMonth.equals("07")) { %> selected="selected" <% } %>>July</option>
        <option value="08"<% if(startDateMonth.equals("08")) { %> selected="selected" <% } %>>August</option>
        <option value="09"<% if(startDateMonth.equals("09")) { %> selected="selected" <% } %>>September</option>
        <option value="10"<% if(startDateMonth.equals("10")) { %> selected="selected" <% } %>>October</option>
        <option value="11"<% if(startDateMonth.equals("11")) { %> selected="selected" <% } %>>November</option>
        <option value="12"<% if(startDateMonth.equals("12")) { %> selected="selected" <% } %>>December</option>
    </select>&nbsp;
    <select name="startDateDay" id="startDateDay" class="selectfield">
        <option value="">month</option>
        <option value="01"<% if(startDateDay.equals("01")) { %> selected="selected" <% } %>>1</option>
        <option value="02"<% if(startDateDay.equals("02")) { %> selected="selected" <% } %>>2</option>
        <option value="03"<% if(startDateDay.equals("03")) { %> selected="selected" <% } %>>3</option>
        <option value="04"<% if(startDateDay.equals("04")) { %> selected="selected" <% } %>>4</option>
        <option value="05"<% if(startDateDay.equals("05")) { %> selected="selected" <% } %>>5</option>
        <option value="06"<% if(startDateDay.equals("06")) { %> selected="selected" <% } %>>6</option>
        <option value="07"<% if(startDateDay.equals("07")) { %> selected="selected" <% } %>>7</option>
        <option value="08"<% if(startDateDay.equals("08")) { %> selected="selected" <% } %>>8</option>
        <option value="09"<% if(startDateDay.equals("09")) { %> selected="selected" <% } %>>9</option>
        <option value="10"<% if(startDateDay.equals("10")) { %> selected="selected" <% } %>>10</option>
        <option value="11"<% if(startDateDay.equals("11")) { %> selected="selected" <% } %>>11</option>
        <option value="12"<% if(startDateDay.equals("12")) { %> selected="selected" <% } %>>12</option>
        <option value="13"<% if(startDateDay.equals("13")) { %> selected="selected" <% } %>>13</option>
        <option value="14"<% if(startDateDay.equals("14")) { %> selected="selected" <% } %>>14</option>
        <option value="15"<% if(startDateDay.equals("15")) { %> selected="selected" <% } %>>15</option>
        <option value="16"<% if(startDateDay.equals("16")) { %> selected="selected" <% } %>>16</option>
        <option value="17"<% if(startDateDay.equals("17")) { %> selected="selected" <% } %>>17</option>
        <option value="18"<% if(startDateDay.equals("18")) { %> selected="selected" <% } %>>18</option>
        <option value="19"<% if(startDateDay.equals("19")) { %> selected="selected" <% } %>>19</option>
        <option value="20"<% if(startDateDay.equals("20")) { %> selected="selected" <% } %>>20</option>
        <option value="01"<% if(startDateDay.equals("21")) { %> selected="selected" <% } %>>21</option>
        <option value="02"<% if(startDateDay.equals("22")) { %> selected="selected" <% } %>>22</option>
        <option value="03"<% if(startDateDay.equals("23")) { %> selected="selected" <% } %>>23</option>
        <option value="04"<% if(startDateDay.equals("24")) { %> selected="selected" <% } %>>24</option>
        <option value="05"<% if(startDateDay.equals("25")) { %> selected="selected" <% } %>>25</option>
        <option value="06"<% if(startDateDay.equals("26")) { %> selected="selected" <% } %>>26</option>
        <option value="07"<% if(startDateDay.equals("27")) { %> selected="selected" <% } %>>27</option>
        <option value="08"<% if(startDateDay.equals("28")) { %> selected="selected" <% } %>>28</option>
        <option value="09"<% if(startDateDay.equals("29")) { %> selected="selected" <% } %>>29</option>
        <option value="10"<% if(startDateDay.equals("30")) { %> selected="selected" <% } %>>30</option>
        <option value="11"<% if(startDateDay.equals("31")) { %> selected="selected" <% } %>>31</option>
    </select>&nbsp;
    <select name="startDateYear" id="startDateYear" class="selectfield">
        <option value="">year</option>
        <option value="1990"<% if(startDateYear.equals("1990")) { %> selected="selected" <% } %>>1990</option>
        <option value="1991"<% if(startDateYear.equals("1991")) { %> selected="selected" <% } %>>1991</option>
        <option value="1992"<% if(startDateYear.equals("1992")) { %> selected="selected" <% } %>>1992</option>
        <option value="1993"<% if(startDateYear.equals("1993")) { %> selected="selected" <% } %>>1993</option>
        <option value="1994"<% if(startDateYear.equals("1994")) { %> selected="selected" <% } %>>1994</option>
        <option value="1995"<% if(startDateYear.equals("1995")) { %> selected="selected" <% } %>>1995</option>
        <option value="1996"<% if(startDateYear.equals("1996")) { %> selected="selected" <% } %>>1996</option>
        <option value="1997"<% if(startDateYear.equals("1997")) { %> selected="selected" <% } %>>1997</option>
        <option value="1998"<% if(startDateYear.equals("1998")) { %> selected="selected" <% } %>>1998</option>
        <option value="1999"<% if(startDateYear.equals("1999")) { %> selected="selected" <% } %>>1999</option>
        <option value="2000"<% if(startDateYear.equals("2000")) { %> selected="selected" <% } %>>2000</option>
        <option value="2001"<% if(startDateYear.equals("2001")) { %> selected="selected" <% } %>>2001</option>
        <option value="2002"<% if(startDateYear.equals("2002")) { %> selected="selected" <% } %>>2002</option>
        <option value="2003"<% if(startDateYear.equals("2003")) { %> selected="selected" <% } %>>2003</option>
        <option value="2004"<% if(startDateYear.equals("2004")) { %> selected="selected" <% } %>>2004</option>
        <option value="2005"<% if(startDateYear.equals("2005")) { %> selected="selected" <% } %>>2005</option>
        <option value="2006"<% if(startDateYear.equals("2006")) { %> selected="selected" <% } %>>2006</option>
        <option value="2007"<% if(startDateYear.equals("2007")) { %> selected="selected" <% } %>>2007</option>
        <option value="2008"<% if(startDateYear.equals("2008")) { %> selected="selected" <% } %>>2008</option>
        <option value="2009"<% if(startDateYear.equals("2009")) { %> selected="selected" <% } %>>2009</option>
        <option value="2010"<% if(startDateYear.equals("2010")) { %> selected="selected" <% } %>>2010</option>
        <option value="2011"<% if(startDateYear.equals("2011")) { %> selected="selected" <% } %>>2011</option>
        <option value="2012"<% if(startDateYear.equals("2012")) { %> selected="selected" <% } %>>2012</option>
    </select>
</p>
<p>
    End Date<br />
    <select name="endDateMonth" id="endDateMonth" class="selectfield">
        <option value="">month</option>
        <option value="01"<% if(endDateMonth.equals("01")) { %> selected="selected" <% } %>>January</option>
        <option value="02"<% if(endDateMonth.equals("02")) { %> selected="selected" <% } %>>February</option>
        <option value="03"<% if(endDateMonth.equals("03")) { %> selected="selected" <% } %>>March</option>
        <option value="04"<% if(endDateMonth.equals("04")) { %> selected="selected" <% } %>>April</option>
        <option value="05"<% if(endDateMonth.equals("05")) { %> selected="selected" <% } %>>May</option>
        <option value="06"<% if(endDateMonth.equals("06")) { %> selected="selected" <% } %>>June</option>
        <option value="07"<% if(endDateMonth.equals("07")) { %> selected="selected" <% } %>>July</option>
        <option value="08"<% if(endDateMonth.equals("08")) { %> selected="selected" <% } %>>August</option>
        <option value="09"<% if(endDateMonth.equals("09")) { %> selected="selected" <% } %>>September</option>
        <option value="10"<% if(endDateMonth.equals("10")) { %> selected="selected" <% } %>>October</option>
        <option value="11"<% if(endDateMonth.equals("11")) { %> selected="selected" <% } %>>November</option>
        <option value="12"<% if(endDateMonth.equals("12")) { %> selected="selected" <% } %>>December</option>
    </select>&nbsp;
    <select name="endDateDay" id="endDateDay" class="selectfield">
        <option value="">month</option>
        <option value="01"<% if(endDateDay.equals("01")) { %> selected="selected" <% } %>>1</option>
        <option value="02"<% if(endDateDay.equals("02")) { %> selected="selected" <% } %>>2</option>
        <option value="03"<% if(endDateDay.equals("03")) { %> selected="selected" <% } %>>3</option>
        <option value="04"<% if(endDateDay.equals("04")) { %> selected="selected" <% } %>>4</option>
        <option value="05"<% if(endDateDay.equals("05")) { %> selected="selected" <% } %>>5</option>
        <option value="06"<% if(endDateDay.equals("06")) { %> selected="selected" <% } %>>6</option>
        <option value="07"<% if(endDateDay.equals("07")) { %> selected="selected" <% } %>>7</option>
        <option value="08"<% if(endDateDay.equals("08")) { %> selected="selected" <% } %>>8</option>
        <option value="09"<% if(endDateDay.equals("09")) { %> selected="selected" <% } %>>9</option>
        <option value="10"<% if(endDateDay.equals("10")) { %> selected="selected" <% } %>>10</option>
        <option value="11"<% if(endDateDay.equals("11")) { %> selected="selected" <% } %>>11</option>
        <option value="12"<% if(endDateDay.equals("12")) { %> selected="selected" <% } %>>12</option>
        <option value="13"<% if(endDateDay.equals("13")) { %> selected="selected" <% } %>>13</option>
        <option value="14"<% if(endDateDay.equals("14")) { %> selected="selected" <% } %>>14</option>
        <option value="15"<% if(endDateDay.equals("15")) { %> selected="selected" <% } %>>15</option>
        <option value="16"<% if(endDateDay.equals("16")) { %> selected="selected" <% } %>>16</option>
        <option value="17"<% if(endDateDay.equals("17")) { %> selected="selected" <% } %>>17</option>
        <option value="18"<% if(endDateDay.equals("18")) { %> selected="selected" <% } %>>18</option>
        <option value="19"<% if(endDateDay.equals("19")) { %> selected="selected" <% } %>>19</option>
        <option value="20"<% if(endDateDay.equals("20")) { %> selected="selected" <% } %>>20</option>
        <option value="01"<% if(endDateDay.equals("21")) { %> selected="selected" <% } %>>21</option>
        <option value="02"<% if(endDateDay.equals("22")) { %> selected="selected" <% } %>>22</option>
        <option value="03"<% if(endDateDay.equals("23")) { %> selected="selected" <% } %>>23</option>
        <option value="04"<% if(endDateDay.equals("24")) { %> selected="selected" <% } %>>24</option>
        <option value="05"<% if(endDateDay.equals("25")) { %> selected="selected" <% } %>>25</option>
        <option value="06"<% if(endDateDay.equals("26")) { %> selected="selected" <% } %>>26</option>
        <option value="07"<% if(endDateDay.equals("27")) { %> selected="selected" <% } %>>27</option>
        <option value="08"<% if(endDateDay.equals("28")) { %> selected="selected" <% } %>>28</option>
        <option value="09"<% if(endDateDay.equals("29")) { %> selected="selected" <% } %>>29</option>
        <option value="10"<% if(endDateDay.equals("30")) { %> selected="selected" <% } %>>30</option>
        <option value="11"<% if(endDateDay.equals("31")) { %> selected="selected" <% } %>>31</option>
    </select>&nbsp;
    <select name="endDateYear" id="endDateYear" class="selectfield">
        <option value="">year</option>
        <option value="1990"<% if(endDateYear.equals("1990")) { %> selected="selected" <% } %>>1990</option>
        <option value="1991"<% if(endDateYear.equals("1991")) { %> selected="selected" <% } %>>1991</option>
        <option value="1992"<% if(endDateYear.equals("1992")) { %> selected="selected" <% } %>>1992</option>
        <option value="1993"<% if(endDateYear.equals("1993")) { %> selected="selected" <% } %>>1993</option>
        <option value="1994"<% if(endDateYear.equals("1994")) { %> selected="selected" <% } %>>1994</option>
        <option value="1995"<% if(endDateYear.equals("1995")) { %> selected="selected" <% } %>>1995</option>
        <option value="1996"<% if(endDateYear.equals("1996")) { %> selected="selected" <% } %>>1996</option>
        <option value="1997"<% if(endDateYear.equals("1997")) { %> selected="selected" <% } %>>1997</option>
        <option value="1998"<% if(endDateYear.equals("1998")) { %> selected="selected" <% } %>>1998</option>
        <option value="1999"<% if(endDateYear.equals("1999")) { %> selected="selected" <% } %>>1999</option>
        <option value="2000"<% if(endDateYear.equals("2000")) { %> selected="selected" <% } %>>2000</option>
        <option value="2001"<% if(endDateYear.equals("2001")) { %> selected="selected" <% } %>>2001</option>
        <option value="2002"<% if(endDateYear.equals("2002")) { %> selected="selected" <% } %>>2002</option>
        <option value="2003"<% if(endDateYear.equals("2003")) { %> selected="selected" <% } %>>2003</option>
        <option value="2004"<% if(endDateYear.equals("2004")) { %> selected="selected" <% } %>>2004</option>
        <option value="2005"<% if(endDateYear.equals("2005")) { %> selected="selected" <% } %>>2005</option>
        <option value="2006"<% if(endDateYear.equals("2006")) { %> selected="selected" <% } %>>2006</option>
        <option value="2007"<% if(endDateYear.equals("2007")) { %> selected="selected" <% } %>>2007</option>
        <option value="2008"<% if(endDateYear.equals("2008")) { %> selected="selected" <% } %>>2008</option>
        <option value="2009"<% if(endDateYear.equals("2009")) { %> selected="selected" <% } %>>2009</option>
        <option value="2010"<% if(endDateYear.equals("2010")) { %> selected="selected" <% } %>>2010</option>
        <option value="2011"<% if(endDateYear.equals("2011")) { %> selected="selected" <% } %>>2011</option>
        <option value="2012"<% if(endDateYear.equals("2012")) { %> selected="selected" <% } %>>2012</option>
    </select>
</p>

<p>
    Application Deadline Date<br />
    <select name="deadlineDateMonth" id="deadlineDateMonth" class="selectfield">
        <option value="">month</option>
        <option value="01"<% if(deadlineDateMonth.equals("01")) { %> selected="selected" <% } %>>January</option>
        <option value="02"<% if(deadlineDateMonth.equals("02")) { %> selected="selected" <% } %>>February</option>
        <option value="03"<% if(deadlineDateMonth.equals("03")) { %> selected="selected" <% } %>>March</option>
        <option value="04"<% if(deadlineDateMonth.equals("04")) { %> selected="selected" <% } %>>April</option>
        <option value="05"<% if(deadlineDateMonth.equals("05")) { %> selected="selected" <% } %>>May</option>
        <option value="06"<% if(deadlineDateMonth.equals("06")) { %> selected="selected" <% } %>>June</option>
        <option value="07"<% if(deadlineDateMonth.equals("07")) { %> selected="selected" <% } %>>July</option>
        <option value="08"<% if(deadlineDateMonth.equals("08")) { %> selected="selected" <% } %>>August</option>
        <option value="09"<% if(deadlineDateMonth.equals("09")) { %> selected="selected" <% } %>>September</option>
        <option value="10"<% if(deadlineDateMonth.equals("10")) { %> selected="selected" <% } %>>October</option>
        <option value="11"<% if(deadlineDateMonth.equals("11")) { %> selected="selected" <% } %>>November</option>
        <option value="12"<% if(deadlineDateMonth.equals("12")) { %> selected="selected" <% } %>>December</option>
    </select>&nbsp;
    <select name="deadlineDateDay" id="deadlineDateDay" class="selectfield">
        <option value="">month</option>
        <option value="01"<% if(deadlineDateDay.equals("01")) { %> selected="selected" <% } %>>1</option>
        <option value="02"<% if(deadlineDateDay.equals("02")) { %> selected="selected" <% } %>>2</option>
        <option value="03"<% if(deadlineDateDay.equals("03")) { %> selected="selected" <% } %>>3</option>
        <option value="04"<% if(deadlineDateDay.equals("04")) { %> selected="selected" <% } %>>4</option>
        <option value="05"<% if(deadlineDateDay.equals("05")) { %> selected="selected" <% } %>>5</option>
        <option value="06"<% if(deadlineDateDay.equals("06")) { %> selected="selected" <% } %>>6</option>
        <option value="07"<% if(deadlineDateDay.equals("07")) { %> selected="selected" <% } %>>7</option>
        <option value="08"<% if(deadlineDateDay.equals("08")) { %> selected="selected" <% } %>>8</option>
        <option value="09"<% if(deadlineDateDay.equals("09")) { %> selected="selected" <% } %>>9</option>
        <option value="10"<% if(deadlineDateDay.equals("10")) { %> selected="selected" <% } %>>10</option>
        <option value="11"<% if(deadlineDateDay.equals("11")) { %> selected="selected" <% } %>>11</option>
        <option value="12"<% if(deadlineDateDay.equals("12")) { %> selected="selected" <% } %>>12</option>
        <option value="13"<% if(deadlineDateDay.equals("13")) { %> selected="selected" <% } %>>13</option>
        <option value="14"<% if(deadlineDateDay.equals("14")) { %> selected="selected" <% } %>>14</option>
        <option value="15"<% if(deadlineDateDay.equals("15")) { %> selected="selected" <% } %>>15</option>
        <option value="16"<% if(deadlineDateDay.equals("16")) { %> selected="selected" <% } %>>16</option>
        <option value="17"<% if(deadlineDateDay.equals("17")) { %> selected="selected" <% } %>>17</option>
        <option value="18"<% if(deadlineDateDay.equals("18")) { %> selected="selected" <% } %>>18</option>
        <option value="19"<% if(deadlineDateDay.equals("19")) { %> selected="selected" <% } %>>19</option>
        <option value="20"<% if(deadlineDateDay.equals("20")) { %> selected="selected" <% } %>>20</option>
        <option value="01"<% if(deadlineDateDay.equals("21")) { %> selected="selected" <% } %>>21</option>
        <option value="02"<% if(deadlineDateDay.equals("22")) { %> selected="selected" <% } %>>22</option>
        <option value="03"<% if(deadlineDateDay.equals("23")) { %> selected="selected" <% } %>>23</option>
        <option value="04"<% if(deadlineDateDay.equals("24")) { %> selected="selected" <% } %>>24</option>
        <option value="05"<% if(deadlineDateDay.equals("25")) { %> selected="selected" <% } %>>25</option>
        <option value="06"<% if(deadlineDateDay.equals("26")) { %> selected="selected" <% } %>>26</option>
        <option value="07"<% if(deadlineDateDay.equals("27")) { %> selected="selected" <% } %>>27</option>
        <option value="08"<% if(deadlineDateDay.equals("28")) { %> selected="selected" <% } %>>28</option>
        <option value="09"<% if(deadlineDateDay.equals("29")) { %> selected="selected" <% } %>>29</option>
        <option value="10"<% if(deadlineDateDay.equals("30")) { %> selected="selected" <% } %>>30</option>
        <option value="11"<% if(deadlineDateDay.equals("31")) { %> selected="selected" <% } %>>31</option>
    </select>&nbsp;
    <select name="deadlineDateYear" id="deadlineDateYear" class="selectfield">
        <option value="">year</option>
        <option value="1990"<% if(deadlineDateYear.equals("1990")) { %> selected="selected" <% } %>>1990</option>
        <option value="1991"<% if(deadlineDateYear.equals("1991")) { %> selected="selected" <% } %>>1991</option>
        <option value="1992"<% if(deadlineDateYear.equals("1992")) { %> selected="selected" <% } %>>1992</option>
        <option value="1993"<% if(deadlineDateYear.equals("1993")) { %> selected="selected" <% } %>>1993</option>
        <option value="1994"<% if(deadlineDateYear.equals("1994")) { %> selected="selected" <% } %>>1994</option>
        <option value="1995"<% if(deadlineDateYear.equals("1995")) { %> selected="selected" <% } %>>1995</option>
        <option value="1996"<% if(deadlineDateYear.equals("1996")) { %> selected="selected" <% } %>>1996</option>
        <option value="1997"<% if(deadlineDateYear.equals("1997")) { %> selected="selected" <% } %>>1997</option>
        <option value="1998"<% if(deadlineDateYear.equals("1998")) { %> selected="selected" <% } %>>1998</option>
        <option value="1999"<% if(deadlineDateYear.equals("1999")) { %> selected="selected" <% } %>>1999</option>
        <option value="2000"<% if(deadlineDateYear.equals("2000")) { %> selected="selected" <% } %>>2000</option>
        <option value="2001"<% if(deadlineDateYear.equals("2001")) { %> selected="selected" <% } %>>2001</option>
        <option value="2002"<% if(deadlineDateYear.equals("2002")) { %> selected="selected" <% } %>>2002</option>
        <option value="2003"<% if(deadlineDateYear.equals("2003")) { %> selected="selected" <% } %>>2003</option>
        <option value="2004"<% if(deadlineDateYear.equals("2004")) { %> selected="selected" <% } %>>2004</option>
        <option value="2005"<% if(deadlineDateYear.equals("2005")) { %> selected="selected" <% } %>>2005</option>
        <option value="2006"<% if(deadlineDateYear.equals("2006")) { %> selected="selected" <% } %>>2006</option>
        <option value="2007"<% if(deadlineDateYear.equals("2007")) { %> selected="selected" <% } %>>2007</option>
        <option value="2008"<% if(deadlineDateYear.equals("2008")) { %> selected="selected" <% } %>>2008</option>
        <option value="2009"<% if(deadlineDateYear.equals("2009")) { %> selected="selected" <% } %>>2009</option>
        <option value="2010"<% if(deadlineDateYear.equals("2010")) { %> selected="selected" <% } %>>2010</option>
        <option value="2011"<% if(deadlineDateYear.equals("2011")) { %> selected="selected" <% } %>>2011</option>
        <option value="2012"<% if(deadlineDateYear.equals("2012")) { %> selected="selected" <% } %>>2012</option>
    </select>
</p>

<p>
    Description<br />
    <textarea name="description" id="description" rows="6" cols="50"><%= result.getString("description") %></textarea>
</p>


    <input type="hidden" name="job_id" value="<%= result.getString("id") %>" />
    <input type="hidden" name="hId" value="<%= result.getString("hospital_id") %>" />
    <input type="hidden" name="action" value="update_residency" />
    <input type="submit" name = "action" value="Submit" />
  <% } %> 
</form>

<%@include file="/common/footer.jsp" %>