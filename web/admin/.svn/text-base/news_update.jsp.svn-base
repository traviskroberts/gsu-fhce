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
    
    //String notice = (String)request.getAttribute("notice");
    if (notice == null) {notice = "";}
    News news = new News();
    String title = " ";
    String year = " ";
    String month = " ";
    String day = " ";
    String content = " ";
    String id = " ";
    if(request.getAttribute("news") != null) {
        news = (News)request.getAttribute("news");
        title = news.getTitle();
        year = news.getYear();
        month = news.getMonth();
        day = news.getDay();
        content = news.getContent();
        id = (String)request.getAttribute("id");
    }
%>

<h1>Update News Here</h1>
    
    
<!-- view list of news stories -->
   
<!-- update title, date and content of a news story -->
    
<form action="/gsu_fhce/admin " method="post">
    
    
    
       <p>
           Title<br>
           <td><input name="title" type="text" class="formfield" value="<%= title %>" </td>
       </p>
       <p>
           Date<br>
           <select name="month" id="month" class="selectfield">
                <option value=""></option>
                <option value="01"<% if(news != null && news.getMonth().equals("01")){ %>selected="selected"<% } %>>January</option>
                <option value="02"<% if(news != null && news.getMonth().equals("02")){ %>selected="selected"<% } %>>February</option>
                <option value="03"<% if(news != null && news.getMonth().equals("03")){ %>selected="selected"<% } %>>March</option>
                <option value="04"<% if(news != null && news.getMonth().equals("04")){ %>selected="selected"<% } %>>April</option>
                <option value="05"<% if(news != null && news.getMonth().equals("05")){ %>selected="selected"<% } %>>May</option>
                <option value="06"<% if(news != null && news.getMonth().equals("06")){ %>selected="selected"<% } %>>June</option>
                <option value="07"<% if(news != null && news.getMonth().equals("07")){ %>selected="selected"<% } %>>July</option>
                <option value="08"<% if(news != null && news.getMonth().equals("08")){ %>selected="selected"<% } %>>August</option>
                <option value="09"<% if(news != null && news.getMonth().equals("09")){ %>selected="selected"<% } %>>September</option>
                <option value="10"<% if(news != null && news.getMonth().equals("10")){ %>selected="selected"<% } %>>October</option>
                <option value="11"<% if(news != null && news.getMonth().equals("11")){ %>selected="selected"<% } %>>November</option>
                <option value="12"<% if(news != null && news.getMonth().equals("12")){ %>selected="selected"<% } %>>December</option>
            </select>&nbsp;
            <select name="day" id="day" class="selectfield">
                <option value=""></option>
                <option value="01"<% if(news != null && news.getDay().equals("01")){ %>selected="selected"<% } %>>01</option>
                <option value="02"<% if(news != null && news.getDay().equals("02")){ %>selected="selected"<% } %>>02</option>
                <option value="03"<% if(news != null && news.getDay().equals("03")){ %>selected="selected"<% } %>>03</option>
                <option value="04"<% if(news != null && news.getDay().equals("04")){ %>selected="selected"<% } %>>04</option>
                <option value="05"<% if(news != null && news.getDay().equals("05")){ %>selected="selected"<% } %>>05</option>
                <option value="06"<% if(news != null && news.getDay().equals("06")){ %>selected="selected"<% } %>>06</option>
                <option value="07"<% if(news != null && news.getDay().equals("07")){ %>selected="selected"<% } %>>07</option>
                <option value="08"<% if(news != null && news.getDay().equals("08")){ %>selected="selected"<% } %>>08</option>
                <option value="09"<% if(news != null && news.getDay().equals("09")){ %>selected="selected"<% } %>>09</option>
                <option value="10"<% if(news != null && news.getDay().equals("10")){ %>selected="selected"<% } %>>10</option>
                <option value="11"<% if(news != null && news.getDay().equals("11")){ %>selected="selected"<% } %>>11</option>
                <option value="12"<% if(news != null && news.getDay().equals("12")){ %>selected="selected"<% } %>>12</option>
                <option value="13"<% if(news != null && news.getDay().equals("13")){ %>selected="selected"<% } %>>13</option>
                <option value="14"<% if(news != null && news.getDay().equals("14")){ %>selected="selected"<% } %>>14</option>
                <option value="15"<% if(news != null && news.getDay().equals("15")){ %>selected="selected"<% } %>>15</option>
                <option value="16"<% if(news != null && news.getDay().equals("16")){ %>selected="selected"<% } %>>16</option>
                <option value="17"<% if(news != null && news.getDay().equals("17")){ %>selected="selected"<% } %>>17</option>
                <option value="18"<% if(news != null && news.getDay().equals("18")){ %>selected="selected"<% } %>>18</option>
                <option value="19"<% if(news != null && news.getDay().equals("19")){ %>selected="selected"<% } %>>19</option>
                <option value="20"<% if(news != null && news.getDay().equals("20")){ %>selected="selected"<% } %>>20</option>
                <option value="21"<% if(news != null && news.getDay().equals("21")){ %>selected="selected"<% } %>>21</option>
                <option value="22"<% if(news != null && news.getDay().equals("22")){ %>selected="selected"<% } %>>22</option>
                <option value="23"<% if(news != null && news.getDay().equals("23")){ %>selected="selected"<% } %>>23</option>
                <option value="24"<% if(news != null && news.getDay().equals("24")){ %>selected="selected"<% } %>>24</option>
                <option value="25"<% if(news != null && news.getDay().equals("25")){ %>selected="selected"<% } %>>25</option>
                <option value="26"<% if(news != null && news.getDay().equals("26")){ %>selected="selected"<% } %>>26</option>
                <option value="27"<% if(news != null && news.getDay().equals("27")){ %>selected="selected"<% } %>>27</option>
                <option value="28"<% if(news != null && news.getDay().equals("28")){ %>selected="selected"<% } %>>28</option>
                <option value="29"<% if(news != null && news.getDay().equals("29")){ %>selected="selected"<% } %>>29</option>
                <option value="30"<% if(news != null && news.getDay().equals("30")){ %>selected="selected"<% } %>>30</option>
                <option value="31"<% if(news != null && news.getDay().equals("31")){ %>selected="selected"<% } %>>31</option>
            </select>&nbsp;
            <select name="year" id="year" class="selectfield">
                <option value=""></option>
                <option value="2006"<% if(news != null && news.getYear().equals("2006")){ %>selected="selected"<% } %>>2006</option>
                <option value="2007"<% if(news != null && news.getYear().equals("2007")){ %>selected="selected"<% } %>>2007</option>
                <option value="2008"<% if(news != null && news.getYear().equals("2008")){ %>selected="selected"<% } %>>2008</option>
                <option value="2009"<% if(news != null && news.getYear().equals("2009")){ %>selected="selected"<% } %>>2009</option>
                <option value="2010"<% if(news != null && news.getYear().equals("2010")){ %>selected="selected"<% } %>>2010</option>
                <option value="2011"<% if(news != null && news.getYear().equals("2011")){ %>selected="selected"<% } %>>2011</option>
                <option value="2012"<% if(news != null && news.getYear().equals("2012")){ %>selected="selected"<% } %>>2012</option>
            </select>
       </p>
       <p>
           Content<br>
           <textarea name="content" cols="40" rows="10" class="formfield"><%= content%></textarea>
           <input type="hidden" name="newsid" value="<%= id %>" />
       </p>
       <p>
           <input type="submit" name="action" value="Update News">&nbsp;
           <a href="/gsu_fhce/admin?action=Get Admin News List">cancel</a>
       </p>
    
</form>


<%@include file="/common/footer.jsp" %>