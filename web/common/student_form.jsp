<%
    String state = "";
    if(student.getState() != null) {
        state = student.getState();
    }
    // get the start date
    String start_month = "";
    String start_year = "";
    if(student.getStartDate() != null) {
        start_year = student.getStartDate().substring(0,4);
        start_month = student.getStartDate().substring(5,7);
    }
    // get the graduation date
    String grad_month = "";
    String grad_year = "";
    if(student.getGraduationDate() != null && !student.getGraduationDate().equals("")) {
        grad_year = student.getGraduationDate().substring(0,4);
        grad_month = student.getGraduationDate().substring(5,7);
    }
%>
<p>(*)Required fields</p>
<p>
	*First Name<br />
	<input type="text" name="fname" id="fname"
	    <% if(student.getFname() != null) { %>
	        value="<%= student.getFname() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield" />
</p>
<p>
	*Last Name<br />
	<input type="text" name="lname" id="lname" 
	    <% if(student.getLname() != null) { %>
	        value="<%= student.getLname() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield" />
</p>
<p>
	*Address<br />
	<input type="text" name="address1" id="address1" 
	    <% if(student.getAddress1() != null) { %>
	        value="<%= student.getAddress1() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield formspace" /><br />
	<input type="text" name="address2" id="address2" 
	    <% if(student.getAddress2() != null) { %>
	        value="<%= student.getAddress2() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield" />
</p>
<p>
	*City, State Zip<br />
	<input type="text" name="city" id="city" 
	    <% if(student.getCity() != null) { %>
	        value="<%= student.getCity() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="smallfield" />
        <select name="state" id="state" class="selectfield">
            <option value=""></option>
            <option value="AL" <% if(state.equals("AL")) { %> selected="selected" <% }%>>Alabama</option>
            <option value="AK" <% if(state.equals("AK")) { %> selected="selected" <% }%>>Alaska</option>
            <option value="AZ" <% if(state.equals("AZ")) { %> selected="selected" <% }%>>Arizona</option>
            <option value="AR" <% if(state.equals("AR")) { %> selected="selected" <% }%>>Arkansas</option>
            <option value="CA" <% if(state.equals("CA")) { %> selected="selected" <% }%>>California</option>
            <option value="CO" <% if(state.equals("CO")) { %> selected="selected" <% }%>>Colorado</option>
            <option value="CT" <% if(state.equals("CT")) { %> selected="selected" <% }%>>Connecticut</option>
            <option value="DE" <% if(state.equals("DE")) { %> selected="selected" <% }%>>Delaware</option>
            <option value="FL" <% if(state.equals("FL")) { %> selected="selected" <% }%>>Florida</option>
            <option value="GA" <% if(state.equals("GA")) { %> selected="selected" <% }%>>Georgia</option>
            <option value="HI" <% if(state.equals("HI")) { %> selected="selected" <% }%>>Hawaii</option>
            <option value="ID" <% if(state.equals("ID")) { %> selected="selected" <% }%>>Idaho</option>
            <option value="IL" <% if(state.equals("IL")) { %> selected="selected" <% }%>>Illinois</option>
            <option value="IN" <% if(state.equals("IN")) { %> selected="selected" <% }%>>Indiana</option>
            <option value="IA" <% if(state.equals("IA")) { %> selected="selected" <% }%>>Iowa</option>
            <option value="KS" <% if(state.equals("KS")) { %> selected="selected" <% }%>>Kansas</option>
            <option value="KY" <% if(state.equals("KY")) { %> selected="selected" <% }%>>Kentucky</option>
            <option value="LA" <% if(state.equals("LA")) { %> selected="selected" <% }%>>Louisiana</option>
            <option value="ME" <% if(state.equals("ME")) { %> selected="selected" <% }%>>Maine</option>
            <option value="MD" <% if(state.equals("MD")) { %> selected="selected" <% }%>>Maryland</option>
            <option value="MA" <% if(state.equals("MA")) { %> selected="selected" <% }%>>Massachusetts</option>
            <option value="MI" <% if(state.equals("MI")) { %> selected="selected" <% }%>>Michigan</option>
            <option value="MN" <% if(state.equals("MN")) { %> selected="selected" <% }%>>Minnesota</option>
            <option value="MS" <% if(state.equals("MS")) { %> selected="selected" <% }%>>Mississippi</option>
            <option value="MO" <% if(state.equals("MO")) { %> selected="selected" <% }%>>Missouri</option>
            <option value="MT" <% if(state.equals("MT")) { %> selected="selected" <% }%>>Montana</option>
            <option value="NE" <% if(state.equals("NE")) { %> selected="selected" <% }%>>Nebraska</option>
            <option value="NV" <% if(state.equals("NV")) { %> selected="selected" <% }%>>Nevada</option>
            <option value="NH" <% if(state.equals("NH")) { %> selected="selected" <% }%>>New Hampshire</option>
            <option value="NJ" <% if(state.equals("NJ")) { %> selected="selected" <% }%>>New Jersey</option>
            <option value="NM" <% if(state.equals("NM")) { %> selected="selected" <% }%>>New Mexico</option>
            <option value="NY" <% if(state.equals("NY")) { %> selected="selected" <% }%>>New York</option>
            <option value="NC" <% if(state.equals("NC")) { %> selected="selected" <% }%>>North Carolina</option>
            <option value="ND" <% if(state.equals("ND")) { %> selected="selected" <% }%>>North Dakota</option>
            <option value="OH" <% if(state.equals("OH")) { %> selected="selected" <% }%>>Ohio</option>
            <option value="OK" <% if(state.equals("OK")) { %> selected="selected" <% }%>>Oklahoma</option>
            <option value="OR" <% if(state.equals("OR")) { %> selected="selected" <% }%>>Oregon</option>
            <option value="PA" <% if(state.equals("PA")) { %> selected="selected" <% }%>>Pennsylvania</option>
            <option value="RI" <% if(state.equals("RI")) { %> selected="selected" <% }%>>Rhode Island</option>
            <option value="SC" <% if(state.equals("SC")) { %> selected="selected" <% }%>>South Carolina</option>
            <option value="SD" <% if(state.equals("SD")) { %> selected="selected" <% }%>>South Dakota</option>
            <option value="TN" <% if(state.equals("TN")) { %> selected="selected" <% }%>>Tennessee</option>
            <option value="TX" <% if(state.equals("TX")) { %> selected="selected" <% }%>>Texas</option>
            <option value="UT" <% if(state.equals("UT")) { %> selected="selected" <% }%>>Utah</option>
            <option value="VT" <% if(state.equals("VT")) { %> selected="selected" <% }%>>Vermont</option>
            <option value="VA" <% if(state.equals("VA")) { %> selected="selected" <% }%>>Virginia</option>
            <option value="WA" <% if(state.equals("WA")) { %> selected="selected" <% }%>>Washington</option>
            <option value="WV" <% if(state.equals("WV")) { %> selected="selected" <% }%>>West Virginia</option>
            <option value="WI" <% if(state.equals("WI")) { %> selected="selected" <% }%>>Wisconsin</option>
            <option value="WY" <% if(state.equals("WY")) { %> selected="selected" <% }%>>Wyoming</option>
        </select>
        <input type="text" name="zip" id="zip" 
	    <% if(student.getZip() != null) { %>
	        value="<%= student.getZip() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="tinyfield" />
</p>
<p>
	*Email Address (this will be your username)<br />
	<input type="text" name="email" id="email" 
	    <% if(student.getEmail() != null) { %>
	        value="<%= student.getEmail() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield" />
</p>
<p>
	<% if(student.getPassword() == null) { %>
		*Password<br />
		<input type="password" name="password" id="pass" value="" class="formfield" />
	<% } else { %>
		<span id="password_link"><a href="#" onclick="showPassword(); return false">Change Password</a></span>
		<span id="password_input" style="display:none;">
			Password:<br />
			<input type="password" name="password" id="pass" class="formfield" /><br />
			<a href="#" class="elevenpx" onclick="hidePassword(); return false">Cancel</a>
		</span>
	<% } %>
</p>
<p>
	*Start Date<br />
	<select name="start_month" id="start_month" class="selectfield">
            <option value="">month</option>
            <option value="01" <% if(start_month.equals("01")) { %>selected="selected"<% } %> >January</option>
            <option value="02" <% if(start_month.equals("02")) { %>selected="selected"<% } %> >February</option>
            <option value="03" <% if(start_month.equals("03")) { %>selected="selected"<% } %> >March</option>
            <option value="04" <% if(start_month.equals("04")) { %>selected="selected"<% } %> >April</option>
            <option value="05" <% if(start_month.equals("05")) { %>selected="selected"<% } %> >May</option>
            <option value="06" <% if(start_month.equals("06")) { %>selected="selected"<% } %> >June</option>
            <option value="07" <% if(start_month.equals("07")) { %>selected="selected"<% } %> >July</option>
            <option value="08" <% if(start_month.equals("08")) { %>selected="selected"<% } %> >August</option>
            <option value="09" <% if(start_month.equals("09")) { %>selected="selected"<% } %> >September</option>
            <option value="10" <% if(start_month.equals("10")) { %>selected="selected"<% } %> >October</option>
            <option value="11" <% if(start_month.equals("11")) { %>selected="selected"<% } %> >November</option>
            <option value="12" <% if(start_month.equals("12")) { %>selected="selected"<% } %> >December</option>
        </select>&nbsp;
        <select name="start_year" id="start_year" class="selectfield">
            <option value="">year</option>
            <option value="1995" <% if(start_year.equals("1995")) { %>selected="selected"<% } %> >1995</option>
            <option value="1996" <% if(start_year.equals("1996")) { %>selected="selected"<% } %> >1996</option>
            <option value="1997" <% if(start_year.equals("1997")) { %>selected="selected"<% } %> >1997</option>
            <option value="1998" <% if(start_year.equals("1998")) { %>selected="selected"<% } %> >1998</option>
            <option value="1999" <% if(start_year.equals("1999")) { %>selected="selected"<% } %> >1999</option>
            <option value="2000" <% if(start_year.equals("2000")) { %>selected="selected"<% } %> >2000</option>
            <option value="2001" <% if(start_year.equals("2001")) { %>selected="selected"<% } %> >2001</option>
            <option value="2002" <% if(start_year.equals("2002")) { %>selected="selected"<% } %> >2002</option>
            <option value="2003" <% if(start_year.equals("2003")) { %>selected="selected"<% } %> >2003</option>
            <option value="2004" <% if(start_year.equals("2004")) { %>selected="selected"<% } %> >2004</option>
            <option value="2005" <% if(start_year.equals("2005")) { %>selected="selected"<% } %> >2005</option>
            <option value="2006" <% if(start_year.equals("2006")) { %>selected="selected"<% } %> >2006</option>
            <option value="2007" <% if(start_year.equals("2007")) { %>selected="selected"<% } %> >2007</option>
        </select>
</p>
<p>
	*Expected Graduation Date<br />
        <select name="grad_month" id="grad_month" class="selectfield">
            <option value="">month</option>
            <option value="01" <% if(grad_month.equals("01")) { %>selected="selected"<% } %> >January</option>
            <option value="02" <% if(grad_month.equals("02")) { %>selected="selected"<% } %> >February</option>
            <option value="03" <% if(grad_month.equals("03")) { %>selected="selected"<% } %> >March</option>
            <option value="04" <% if(grad_month.equals("04")) { %>selected="selected"<% } %> >April</option>
            <option value="05" <% if(grad_month.equals("05")) { %>selected="selected"<% } %> >May</option>
            <option value="06" <% if(grad_month.equals("06")) { %>selected="selected"<% } %> >June</option>
            <option value="07" <% if(grad_month.equals("07")) { %>selected="selected"<% } %> >July</option>
            <option value="08" <% if(grad_month.equals("08")) { %>selected="selected"<% } %> >August</option>
            <option value="09" <% if(grad_month.equals("09")) { %>selected="selected"<% } %> >September</option>
            <option value="10" <% if(grad_month.equals("10")) { %>selected="selected"<% } %> >October</option>
            <option value="11" <% if(grad_month.equals("11")) { %>selected="selected"<% } %> >November</option>
            <option value="12" <% if(grad_month.equals("12")) { %>selected="selected"<% } %> >December</option>
        </select>&nbsp;
        <select name="grad_year" id="grad_year" class="selectfield">
            <option value="">year</option>
            <option value="2000" <% if(grad_year.equals("2000")) { %>selected="selected"<% } %> >2000</option>
            <option value="2001" <% if(grad_year.equals("2001")) { %>selected="selected"<% } %> >2001</option>
            <option value="2002" <% if(grad_year.equals("2002")) { %>selected="selected"<% } %> >2002</option>
            <option value="2003" <% if(grad_year.equals("2003")) { %>selected="selected"<% } %> >2003</option>
            <option value="2004" <% if(grad_year.equals("2004")) { %>selected="selected"<% } %> >2004</option>
            <option value="2005" <% if(grad_year.equals("2005")) { %>selected="selected"<% } %> >2005</option>
            <option value="2006" <% if(grad_year.equals("2006")) { %>selected="selected"<% } %> >2006</option>
            <option value="2007" <% if(grad_year.equals("2007")) { %>selected="selected"<% } %> >2007</option>
            <option value="2008" <% if(grad_year.equals("2008")) { %>selected="selected"<% } %> >2008</option>
            <option value="2009" <% if(grad_year.equals("2009")) { %>selected="selected"<% } %> >2009</option>
            <option value="2010" <% if(grad_year.equals("2010")) { %>selected="selected"<% } %> >2010</option>
            <option value="2011" <% if(grad_year.equals("2011")) { %>selected="selected"<% } %> >2011</option>
            <option value="2012" <% if(grad_year.equals("2012")) { %>selected="selected"<% } %> >2012</option>
            <option value="2013" <% if(grad_year.equals("2013")) { %>selected="selected"<% } %> >2013</option>
            <option value="2014" <% if(grad_year.equals("2014")) { %>selected="selected"<% } %> >2014</option>
            <option value="2015" <% if(grad_year.equals("2015")) { %>selected="selected"<% } %> >2015</option>
        </select>
</p>
<p>
<%
    if(person != null && person.isAdmin()) {
        if(student != null && student.isAdmin()) {
%>
<input type="checkbox" name="is_admin" checked="checked" />&nbsp;This person is an admin
<%
        }
        else {
%>
<input type="checkbox" name="is_admin" />&nbsp;This person is an admin
<%
        }
    }
%>
</p>