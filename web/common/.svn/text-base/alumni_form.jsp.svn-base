<%
    // get the state
    String state = "";
    if(alumni.getState() != null) {
        state = alumni.getState();
    }
    // get the graduation date
    String month = "";
    String year = "";
    if(alumni.getGraduationDate() != null && !alumni.getGraduationDate().equals("")) {
        year = alumni.getGraduationDate().substring(0,4);
        month = alumni.getGraduationDate().substring(5,7);
    }
%>
<p>(*)Required fields</p>
<p>
	*First Name<br />
	<input type="text" name="fname" id="fname"
	    <% if(alumni.getFname() != null) { %>
	        value="<%= alumni.getFname() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield" />
</p>
<p>
	*Last Name<br />
	<input type="text" name="lname" id="lname" 
	    <% if(alumni.getLname() != null) { %>
	        value="<%= alumni.getLname() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield" />
</p>
<p>
	*Address:<br />
	<input type="text" name="address1" id="address1" 
	    <% if(alumni.getAddress1() != null) { %>
	        value="<%= alumni.getAddress1() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield formspace" /><br />
	<input type="text" name="address2" id="address2" 
	    <% if(alumni.getAddress2() != null) { %>
	        value="<%= alumni.getAddress2() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield" />
</p>
<p>
	*City, State Zip<br />
	<input type="text" name="city" id="city" 
	    <% if(alumni.getCity() != null) { %>
	        value="<%= alumni.getCity() %>"
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
	    <% if(alumni.getZip() != null) { %>
	        value="<%= alumni.getZip() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="tinyfield" />
</p>
<p>
	*Email Address (this will be your username)<br />
	<input type="text" name="email" id="email" 
	    <% if(alumni.getEmail() != null) { %>
	        value="<%= alumni.getEmail() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="formfield" />
</p>
<p>
    <% if(alumni.getPassword() == null) { %>
    	*Password<br />
	<input type="password" name="password" id="pass" class="formfield" />
    <% } else { %>
        <span id="password_link"><a href="#" onclick="showPassword(); return false">Change Password</a></span>
        <span id="password_input" style="display:none;">
            Password<br />
            <input type="password" name="password" id="pass" class="formfield" /><br />
            <a href="#" class="elevenpx" onclick="hidePassword(); return false">Cancel</a>
        </span>
    <% } %>
</p>
<p>
	 Company Name<br />
	<input type="text" name="company_name" id="company_name" 
	     <% if(alumni.getCompanyName() != null) { %>
	         value="<%= alumni.getCompanyName() %>"
	     <% } else { %>
	         value="" 
	     <% } %> class="formfield" />
</p>
<p>
	 Position<br />
	<input type="text" name="position" id="position" 
	     <% if(alumni.getPosition() != null) { %>
	         value="<%= alumni.getPosition() %>"
	     <% } else { %>
	         value="" 
	     <% } %> class="formfield" />
</p>
<p>
    *Graduation Date<br />
    <select name="graduation_month" id="graduation_month" class="selectfield">
        <option value="">month</option>
        <option value="01" <% if(month.equals("01")) { %>selected="selected"<% } %> >January</option>
        <option value="02" <% if(month.equals("02")) { %>selected="selected"<% } %> >February</option>
        <option value="03" <% if(month.equals("03")) { %>selected="selected"<% } %> >March</option>
        <option value="04" <% if(month.equals("04")) { %>selected="selected"<% } %> >April</option>
        <option value="05" <% if(month.equals("05")) { %>selected="selected"<% } %> >May</option>
        <option value="06" <% if(month.equals("06")) { %>selected="selected"<% } %> >June</option>
        <option value="07" <% if(month.equals("07")) { %>selected="selected"<% } %> >July</option>
        <option value="08" <% if(month.equals("08")) { %>selected="selected"<% } %> >August</option>
        <option value="09" <% if(month.equals("09")) { %>selected="selected"<% } %> >September</option>
        <option value="10" <% if(month.equals("10")) { %>selected="selected"<% } %> >October</option>
        <option value="11" <% if(month.equals("11")) { %>selected="selected"<% } %> >November</option>
        <option value="12" <% if(month.equals("12")) { %>selected="selected"<% } %> >December</option>
    </select>&nbsp;
    <select name="graduation_year" id="graduation_year" class="selectfield">
        <option value="">year</option>
        <option value="1980" <% if(year.equals("1980")) { %>selected="selected"<% } %> >1980</option>
        <option value="1981" <% if(year.equals("1981")) { %>selected="selected"<% } %> >1981</option>
        <option value="1982" <% if(year.equals("1982")) { %>selected="selected"<% } %> >1982</option>
        <option value="1983" <% if(year.equals("1983")) { %>selected="selected"<% } %> >1983</option>
        <option value="1984" <% if(year.equals("1984")) { %>selected="selected"<% } %> >1984</option>
        <option value="1985" <% if(year.equals("1985")) { %>selected="selected"<% } %> >1985</option>
        <option value="1986" <% if(year.equals("1986")) { %>selected="selected"<% } %> >1986</option>
        <option value="1987" <% if(year.equals("1987")) { %>selected="selected"<% } %> >1987</option>
        <option value="1988" <% if(year.equals("1988")) { %>selected="selected"<% } %> >1988</option>
        <option value="1989" <% if(year.equals("1989")) { %>selected="selected"<% } %> >1989</option>
        <option value="1990" <% if(year.equals("1990")) { %>selected="selected"<% } %> >1990</option>
        <option value="1991" <% if(year.equals("1991")) { %>selected="selected"<% } %> >1991</option>
        <option value="1992" <% if(year.equals("1992")) { %>selected="selected"<% } %> >1992</option>
        <option value="1993" <% if(year.equals("1993")) { %>selected="selected"<% } %> >1993</option>
        <option value="1994" <% if(year.equals("1994")) { %>selected="selected"<% } %> >1994</option>
        <option value="1995" <% if(year.equals("1995")) { %>selected="selected"<% } %> >1995</option>
        <option value="1996" <% if(year.equals("1996")) { %>selected="selected"<% } %> >1996</option>
        <option value="1997" <% if(year.equals("1997")) { %>selected="selected"<% } %> >1997</option>
        <option value="1998" <% if(year.equals("1998")) { %>selected="selected"<% } %> >1998</option>
        <option value="1999" <% if(year.equals("1999")) { %>selected="selected"<% } %> >1999</option>
        <option value="2000" <% if(year.equals("2000")) { %>selected="selected"<% } %> >2000</option>
        <option value="2001" <% if(year.equals("2001")) { %>selected="selected"<% } %> >2001</option>
        <option value="2002" <% if(year.equals("2002")) { %>selected="selected"<% } %> >2002</option>
        <option value="2003" <% if(year.equals("2003")) { %>selected="selected"<% } %> >2003</option>
        <option value="2004" <% if(year.equals("2004")) { %>selected="selected"<% } %> >2004</option>
        <option value="2005" <% if(year.equals("2005")) { %>selected="selected"<% } %> >2005</option>
        <option value="2006" <% if(year.equals("2006")) { %>selected="selected"<% } %> >2006</option>
        <option value="2007" <% if(year.equals("2007")) { %>selected="selected"<% } %> >2007</option>
    </select>
</p>
<p>
    <input type="checkbox" name="mentor" value="1" 
    <% if(alumni.getMentor()==1) { %>
        checked="checked"
    <% } %> />&nbsp;
    I am interested in being a mentor to a current student.
</p>
<p>
<%
    if(person != null && person.isAdmin()) {
        if(alumni != null && alumni.isAdmin()) {
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