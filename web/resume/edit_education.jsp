<%@include file="/common/header.jsp" %>

<%
    // checks to see if they are a student
    if(person != null && member_type != null) {
        if(!member_type.equals("student")) {
            String error = "You have to be logged in as a student to add a resume!";
            session.setAttribute("error", error);
            response.sendRedirect("/gsu_fhce/error.jsp");
        }
    }
    else {
        String error = "You have to be logged in as a student to add a resume!";
        session.setAttribute("error", error);
        response.sendRedirect("/gsu_fhce/error.jsp");
    }
    
    // get the resultSet
    ResultSet result = (ResultSet)request.getAttribute("result");
    result.next();
    // get the fields
    String degree = result.getString("degree");
    String school = result.getString("school_name");
    String city = result.getString("city");
    String state = result.getString("state");
    String description = result.getString("description");
    // separate the dates
    String start_year = result.getString("start_date").substring(0,4);
    String start_month = result.getString("start_date").substring(5,7);
    String end_year = "";
    String end_month = "";
    if(result.getString("end_date") != null) {
        end_year = result.getString("end_date").substring(0,4);
        end_month = result.getString("end_date").substring(5,7);
    }
    // get the education id
    int id = result.getInt("id");
%>

<h1>Update Education</h1>

<form action="/gsu_fhce/resume" method="post">
    <p>
        Degree<br />
        <input type="text" name="degree" id="degree" class="formfield" value="<%= degree %>" />
    </p>
    <p>
        School<br />
        <input type="text" name="school" id="school" class="formfield" value="<%= school %>" />
    </p>
    <p>
        City, State<br />
        <input type="text" name="city" id="city" class="smallfield" value="<%= city %>" />
        <select name="state" id="state" class="selectfield">
            <option value=""></option>
            <option value="AL"<% if(state.equals("AL")) { %> selected="selected" <% } %>>Alabama</option>
            <option value="AK"<% if(state.equals("AK")) { %> selected="selected" <% } %>>Alaska</option>
            <option value="AZ"<% if(state.equals("AZ")) { %> selected="selected" <% } %>>Arizona</option>
            <option value="AR"<% if(state.equals("AR")) { %> selected="selected" <% } %>>Arkansas</option>
            <option value="CA"<% if(state.equals("CA")) { %> selected="selected" <% } %>>California</option>
            <option value="CO"<% if(state.equals("CO")) { %> selected="selected" <% } %>>Colorado</option>
            <option value="CT"<% if(state.equals("CT")) { %> selected="selected" <% } %>>Connecticut</option>
            <option value="DE"<% if(state.equals("DE")) { %> selected="selected" <% } %>>Delaware</option>
            <option value="FL"<% if(state.equals("FL")) { %> selected="selected" <% } %>>Florida</option>
            <option value="GA"<% if(state.equals("GA")) { %> selected="selected" <% } %>>Georgia</option>
            <option value="HI"<% if(state.equals("HI")) { %> selected="selected" <% } %>>Hawaii</option>
            <option value="ID"<% if(state.equals("ID")) { %> selected="selected" <% } %>>Idaho</option>
            <option value="IL"<% if(state.equals("IL")) { %> selected="selected" <% } %>>Illinois</option>
            <option value="IN"<% if(state.equals("IN")) { %> selected="selected" <% } %>>Indiana</option>
            <option value="IA"<% if(state.equals("IA")) { %> selected="selected" <% } %>>Iowa</option>
            <option value="KS"<% if(state.equals("KS")) { %> selected="selected" <% } %>>Kansas</option>
            <option value="KY"<% if(state.equals("KY")) { %> selected="selected" <% } %>>Kentucky</option>
            <option value="LA"<% if(state.equals("LA")) { %> selected="selected" <% } %>>Louisiana</option>
            <option value="ME"<% if(state.equals("ME")) { %> selected="selected" <% } %>>Maine</option>
            <option value="MD"<% if(state.equals("MD")) { %> selected="selected" <% } %>>Maryland</option>
            <option value="MA"<% if(state.equals("MA")) { %> selected="selected" <% } %>>Massachusetts</option>
            <option value="MI"<% if(state.equals("MI")) { %> selected="selected" <% } %>>Michigan</option>
            <option value="MN"<% if(state.equals("MN")) { %> selected="selected" <% } %>>Minnesota</option>
            <option value="MS"<% if(state.equals("MS")) { %> selected="selected" <% } %>>Mississippi</option>
            <option value="MO"<% if(state.equals("MO")) { %> selected="selected" <% } %>>Missouri</option>
            <option value="MT"<% if(state.equals("MT")) { %> selected="selected" <% } %>>Montana</option>
            <option value="NE"<% if(state.equals("NE")) { %> selected="selected" <% } %>>Nebraska</option>
            <option value="NV"<% if(state.equals("NV")) { %> selected="selected" <% } %>>Nevada</option>
            <option value="NH"<% if(state.equals("NH")) { %> selected="selected" <% } %>>New Hampshire</option>
            <option value="NJ"<% if(state.equals("NJ")) { %> selected="selected" <% } %>>New Jersey</option>
            <option value="NM"<% if(state.equals("NM")) { %> selected="selected" <% } %>>New Mexico</option>
            <option value="NY"<% if(state.equals("NY")) { %> selected="selected" <% } %>>New York</option>
            <option value="NC"<% if(state.equals("NC")) { %> selected="selected" <% } %>>North Carolina</option>
            <option value="ND"<% if(state.equals("ND")) { %> selected="selected" <% } %>>North Dakota</option>
            <option value="OH"<% if(state.equals("OH")) { %> selected="selected" <% } %>>Ohio</option>
            <option value="OK"<% if(state.equals("OK")) { %> selected="selected" <% } %>>Oklahoma</option>
            <option value="OR"<% if(state.equals("OR")) { %> selected="selected" <% } %>>Oregon</option>
            <option value="PA"<% if(state.equals("PA")) { %> selected="selected" <% } %>>Pennsylvania</option>
            <option value="RI"<% if(state.equals("RI")) { %> selected="selected" <% } %>>Rhode Island</option>
            <option value="SC"<% if(state.equals("SC")) { %> selected="selected" <% } %>>South Carolina</option>
            <option value="SD"<% if(state.equals("SD")) { %> selected="selected" <% } %>>South Dakota</option>
            <option value="TN"<% if(state.equals("TN")) { %> selected="selected" <% } %>>Tennessee</option>
            <option value="TX"<% if(state.equals("TX")) { %> selected="selected" <% } %>>Texas</option>
            <option value="UT"<% if(state.equals("UT")) { %> selected="selected" <% } %>>Utah</option>
            <option value="VT"<% if(state.equals("VT")) { %> selected="selected" <% } %>>Vermont</option>
            <option value="VA"<% if(state.equals("VA")) { %> selected="selected" <% } %>>Virginia</option>
            <option value="WA"<% if(state.equals("WA")) { %> selected="selected" <% } %>>Washington</option>
            <option value="WV"<% if(state.equals("WV")) { %> selected="selected" <% } %>>West Virginia</option>
            <option value="WI"<% if(state.equals("WI")) { %> selected="selected" <% } %>>Wisconsin</option>
            <option value="WY"<% if(state.equals("WY")) { %> selected="selected" <% } %>>Wyoming</option>
	</select>
    </p>
    <p>
        Start Date<br />
        <select name="start_month" id="start_month" class="selectfield">
            <option value="">month</option>
            <option value="01"<% if(start_month.equals("01")) { %> selected="selected" <% } %>>January</option>
            <option value="02"<% if(start_month.equals("02")) { %> selected="selected" <% } %>>February</option>
            <option value="03"<% if(start_month.equals("03")) { %> selected="selected" <% } %>>March</option>
            <option value="04"<% if(start_month.equals("04")) { %> selected="selected" <% } %>>April</option>
            <option value="05"<% if(start_month.equals("05")) { %> selected="selected" <% } %>>May</option>
            <option value="06"<% if(start_month.equals("06")) { %> selected="selected" <% } %>>June</option>
            <option value="07"<% if(start_month.equals("07")) { %> selected="selected" <% } %>>July</option>
            <option value="08"<% if(start_month.equals("08")) { %> selected="selected" <% } %>>August</option>
            <option value="09"<% if(start_month.equals("09")) { %> selected="selected" <% } %>>September</option>
            <option value="10"<% if(start_month.equals("10")) { %> selected="selected" <% } %>>October</option>
            <option value="11"<% if(start_month.equals("11")) { %> selected="selected" <% } %>>November</option>
            <option value="12"<% if(start_month.equals("12")) { %> selected="selected" <% } %>>December</option>
        </select>&nbsp;
        <select name="start_year" id="start_year" class="selectfield">
            <option value="">year</option>
            <option value="1990"<% if(start_year.equals("1990")) { %> selected="selected" <% } %>>1990</option>
            <option value="1991"<% if(start_year.equals("1991")) { %> selected="selected" <% } %>>1991</option>
            <option value="1992"<% if(start_year.equals("1992")) { %> selected="selected" <% } %>>1992</option>
            <option value="1993"<% if(start_year.equals("1993")) { %> selected="selected" <% } %>>1993</option>
            <option value="1994"<% if(start_year.equals("1994")) { %> selected="selected" <% } %>>1994</option>
            <option value="1995"<% if(start_year.equals("1995")) { %> selected="selected" <% } %>>1995</option>
            <option value="1996"<% if(start_year.equals("1996")) { %> selected="selected" <% } %>>1996</option>
            <option value="1997"<% if(start_year.equals("1997")) { %> selected="selected" <% } %>>1997</option>
            <option value="1998"<% if(start_year.equals("1998")) { %> selected="selected" <% } %>>1998</option>
            <option value="1999"<% if(start_year.equals("1999")) { %> selected="selected" <% } %>>1999</option>
            <option value="2000"<% if(start_year.equals("2000")) { %> selected="selected" <% } %>>2000</option>
            <option value="2001"<% if(start_year.equals("2001")) { %> selected="selected" <% } %>>2001</option>
            <option value="2002"<% if(start_year.equals("2002")) { %> selected="selected" <% } %>>2002</option>
            <option value="2003"<% if(start_year.equals("2003")) { %> selected="selected" <% } %>>2003</option>
            <option value="2004"<% if(start_year.equals("2004")) { %> selected="selected" <% } %>>2004</option>
            <option value="2005"<% if(start_year.equals("2005")) { %> selected="selected" <% } %>>2005</option>
            <option value="2006"<% if(start_year.equals("2006")) { %> selected="selected" <% } %>>2006</option>
            <option value="2007"<% if(start_year.equals("2007")) { %> selected="selected" <% } %>>2007</option>
        </select>
    </p>
    <p>
        Graduation Date<br />
        <select name="grad_month" id="grad_month" class="selectfield">
            <option value="">month</option>
            <option value="01"<% if(end_month.equals("01")) { %> selected="selected" <% } %>>January</option>
            <option value="02"<% if(end_month.equals("02")) { %> selected="selected" <% } %>>February</option>
            <option value="03"<% if(end_month.equals("03")) { %> selected="selected" <% } %>>March</option>
            <option value="04"<% if(end_month.equals("04")) { %> selected="selected" <% } %>>April</option>
            <option value="05"<% if(end_month.equals("05")) { %> selected="selected" <% } %>>May</option>
            <option value="06"<% if(end_month.equals("06")) { %> selected="selected" <% } %>>June</option>
            <option value="07"<% if(end_month.equals("07")) { %> selected="selected" <% } %>>July</option>
            <option value="08"<% if(end_month.equals("08")) { %> selected="selected" <% } %>>August</option>
            <option value="09"<% if(end_month.equals("09")) { %> selected="selected" <% } %>>September</option>
            <option value="10"<% if(end_month.equals("10")) { %> selected="selected" <% } %>>October</option>
            <option value="11"<% if(end_month.equals("11")) { %> selected="selected" <% } %>>November</option>
            <option value="12"<% if(end_month.equals("12")) { %> selected="selected" <% } %>>December</option>
        </select>&nbsp;
        <select name="grad_year" id="grad_year" class="selectfield">
            <option value="">year</option>
            <option value="1990"<% if(end_year.equals("1990")) { %> selected="selected" <% } %>>1990</option>
            <option value="1991"<% if(end_year.equals("1991")) { %> selected="selected" <% } %>>1991</option>
            <option value="1992"<% if(end_year.equals("1992")) { %> selected="selected" <% } %>>1992</option>
            <option value="1993"<% if(end_year.equals("1993")) { %> selected="selected" <% } %>>1993</option>
            <option value="1994"<% if(end_year.equals("1994")) { %> selected="selected" <% } %>>1994</option>
            <option value="1995"<% if(end_year.equals("1995")) { %> selected="selected" <% } %>>1995</option>
            <option value="1996"<% if(end_year.equals("1996")) { %> selected="selected" <% } %>>1996</option>
            <option value="1997"<% if(end_year.equals("1997")) { %> selected="selected" <% } %>>1997</option>
            <option value="1998"<% if(end_year.equals("1998")) { %> selected="selected" <% } %>>1998</option>
            <option value="1999"<% if(end_year.equals("1999")) { %> selected="selected" <% } %>>1999</option>
            <option value="2000"<% if(end_year.equals("2000")) { %> selected="selected" <% } %>>2000</option>
            <option value="2001"<% if(end_year.equals("2001")) { %> selected="selected" <% } %>>2001</option>
            <option value="2002"<% if(end_year.equals("2002")) { %> selected="selected" <% } %>>2002</option>
            <option value="2003"<% if(end_year.equals("2003")) { %> selected="selected" <% } %>>2003</option>
            <option value="2004"<% if(end_year.equals("2004")) { %> selected="selected" <% } %>>2004</option>
            <option value="2005"<% if(end_year.equals("2005")) { %> selected="selected" <% } %>>2005</option>
            <option value="2006"<% if(end_year.equals("2006")) { %> selected="selected" <% } %>>2006</option>
            <option value="2007"<% if(end_year.equals("2007")) { %> selected="selected" <% } %>>2007</option>
        </select>
    </p>
    <p>
        Description (optional)<br />
        <textarea name="description" id="description" class="formfield" rows="5"><%= description %></textarea>
    </p>
    <p>
        <input type="hidden" name="id" value="<%= id %>" />
        <input type="hidden" name="action" value="" />
        <input type="button" name="update" value="Update Education" onclick="checkEducation(this.form, 'update_education'); return false" />
    </p>
</form>


<%@include file="/common/footer.jsp" %>