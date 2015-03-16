<%
    String state = "";
    if(hospital.getState() != null) {
        state = hospital.getState();
    }
%>
<h2>Hospital Information</h2>

<p>(*)Required fields</p>
<p>
    *Hospital Name<br />
    <input type="text" name="name" id="name" 
        <% if(hospital.getName() != null) { %>
            value="<%= hospital.getName() %>"
        <% } else { %>
            value="" 
        <% } %> class="formfield" />
</p>
<p>
    Hospital Web Site<br />
    <input type="text" name="url" id="url" 
        <% if(hospital.getURL() != null) { %>
            value="<%= hospital.getURL() %>"
        <% } else { %>
            value="http://" 
        <% } %> class="formfield" />
</p>
<p>
    *Email Address (this will be your username)<br />
    <input type="text" name="email" id="email" 
        <% if(hospital.getEmail() != null) { %>
            value="<%= hospital.getEmail() %>"
        <% } else { %>
            value="" 
        <% } %> class="formfield" />
</p>
<p>
    <% if(hospital.getPassword() == null) { %>
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

<h2>Contact Person</h2>
<p>
    *First Name<br />
    <input type="text" name="fname" id="fname"
        <% if(hospital.getFname() != null) { %>
            value="<%= hospital.getFname() %>"
        <% } else { %>
            value="" 
        <% } %> class="formfield" />
</p>
<p>
    *Last Name<br />
    <input type="text" name="lname" id="lname" 
        <% if(hospital.getLname() != null) { %>
            value="<%= hospital.getLname() %>"
        <% } else { %>
            value="" 
        <% } %> class="formfield" />
</p>
<p>
    Phone Number<br />
    <input type="text" name="phone" id="phone" 
        <% if(hospital.getPhone() != null) { %>
            value="<%= hospital.getPhone() %>"
        <% } else { %>
            value="" 
        <% } %> class="formfield" />
</p>
<p>
    *Address<br />
    <input type="text" name="address1" id="address1" 
        <% if(hospital.getAddress1() != null) { %>
            value="<%= hospital.getAddress1() %>"
        <% } else { %>
            value="" 
        <% } %> class="formfield formspace" /><br />
    <input type="text" name="address2" id="address2" 
        <% if(hospital.getAddress2() != null) { %>
            value="<%= hospital.getAddress2() %>"
        <% } else { %>
            value="" 
        <% } %> class="formfield" />
</p>
<p>
	*City, State Zip<br />
	<input type="text" name="city" id="city" 
	    <% if(hospital.getCity() != null) { %>
	        value="<%= hospital.getCity() %>"
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
	    <% if(hospital.getZip() != null) { %>
	        value="<%= hospital.getZip() %>"
	    <% } else { %>
	        value="" 
	    <% } %> class="tinyfield" />
</p>
<p>
<%
    if(person != null && person.isAdmin()) {
        if(hospital != null && hospital.isAdmin()) {
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