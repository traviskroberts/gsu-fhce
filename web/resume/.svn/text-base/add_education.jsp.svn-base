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
    
    String in_process = "yes";
    if(request.getAttribute("in_process") != null) {
        in_process = (String)request.getAttribute("in_process");
    }
    
    // get the resume id
    int resume_id = Integer.parseInt((String)request.getAttribute("resume_id"));
%>

<% if(in_process.equals("yes")) { %>
    <img src="/gsu_fhce/images/resume_step1.png" />
<% } %>

<h1>Add Education</h1>

<form action="/gsu_fhce/resume" method="post">
    <p>
        Degree<br />
        <input type="text" name="degree" id="degree" class="formfield" />
    </p>
    <p>
        School<br />
        <input type="text" name="school" id="school" class="formfield" />
    </p>
    <p>
        City, State<br />
        <input type="text" name="city" id="city" class="smallfield" />
        <select name="state" id="state" class="selectfield">
            <option value=""></option>
            <option value="AL">Alabama</option>
            <option value="AK">Alaska</option>
            <option value="AZ">Arizona</option>
            <option value="AR">Arkansas</option>
            <option value="CA">California</option>
            <option value="CO">Colorado</option>
            <option value="CT">Connecticut</option>
            <option value="DE">Delaware</option>
            <option value="FL">Florida</option>
            <option value="GA">Georgia</option>
            <option value="HI">Hawaii</option>
            <option value="ID">Idaho</option>
            <option value="IL">Illinois</option>
            <option value="IN">Indiana</option>
            <option value="IA">Iowa</option>
            <option value="KS">Kansas</option>
            <option value="KY">Kentucky</option>
            <option value="LA">Louisiana</option>
            <option value="ME">Maine</option>
            <option value="MD">Maryland</option>
            <option value="MA">Massachusetts</option>
            <option value="MI">Michigan</option>
            <option value="MN">Minnesota</option>
            <option value="MS">Mississippi</option>
            <option value="MO">Missouri</option>
            <option value="MT">Montana</option>
            <option value="NE">Nebraska</option>
            <option value="NV">Nevada</option>
            <option value="NH">New Hampshire</option>
            <option value="NJ">New Jersey</option>
            <option value="NM">New Mexico</option>
            <option value="NY">New York</option>
            <option value="NC">North Carolina</option>
            <option value="ND">North Dakota</option>
            <option value="OH">Ohio</option>
            <option value="OK">Oklahoma</option>
            <option value="OR">Oregon</option>
            <option value="PA">Pennsylvania</option>
            <option value="RI">Rhode Island</option>
            <option value="SC">South Carolina</option>
            <option value="SD">South Dakota</option>
            <option value="TN">Tennessee</option>
            <option value="TX">Texas</option>
            <option value="UT">Utah</option>
            <option value="VT">Vermont</option>
            <option value="VA">Virginia</option>
            <option value="WA">Washington</option>
            <option value="WV">West Virginia</option>
            <option value="WI">Wisconsin</option>
            <option value="WY">Wyoming</option>
	</select>
    </p>
    <p>
        Start Date<br />
        <select name="start_month" id="start_month" class="selectfield">
            <option value="">month</option>
            <option value="01">January</option>
            <option value="02">February</option>
            <option value="03">March</option>
            <option value="04">April</option>
            <option value="05">May</option>
            <option value="06">June</option>
            <option value="07">July</option>
            <option value="08">August</option>
            <option value="09">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>
        </select>&nbsp;
        <select name="start_year" id="start_year" class="selectfield">
            <option value="">year</option>
            <option value="1990">1990</option>
            <option value="1991">1991</option>
            <option value="1992">1992</option>
            <option value="1993">1993</option>
            <option value="1994">1994</option>
            <option value="1995">1995</option>
            <option value="1996">1996</option>
            <option value="1997">1997</option>
            <option value="1998">1998</option>
            <option value="1999">1999</option>
            <option value="2000">2000</option>
            <option value="2001">2001</option>
            <option value="2002">2002</option>
            <option value="2003">2003</option>
            <option value="2004">2004</option>
            <option value="2005">2005</option>
            <option value="2006">2006</option>
            <option value="2007">2007</option>
        </select>
    </p>
    <p>
        Graduation Date<br />
        <select name="grad_month" id="grad_month" class="selectfield">
            <option value="">month</option>
            <option value="01">January</option>
            <option value="02">February</option>
            <option value="03">March</option>
            <option value="04">April</option>
            <option value="05">May</option>
            <option value="06">June</option>
            <option value="07">July</option>
            <option value="08">August</option>
            <option value="09">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>
        </select>&nbsp;
        <select name="grad_year" id="grad_year" class="selectfield">
            <option value="">year</option>
            <option value="1990">1990</option>
            <option value="1991">1991</option>
            <option value="1992">1992</option>
            <option value="1993">1993</option>
            <option value="1994">1994</option>
            <option value="1995">1995</option>
            <option value="1996">1996</option>
            <option value="1997">1997</option>
            <option value="1998">1998</option>
            <option value="1999">1999</option>
            <option value="2000">2000</option>
            <option value="2001">2001</option>
            <option value="2002">2002</option>
            <option value="2003">2003</option>
            <option value="2004">2004</option>
            <option value="2005">2005</option>
            <option value="2006">2006</option>
            <option value="2007">2007</option>
        </select>
    </p>
    <p>
        Description (optional)<br />
        <textarea name="description" id="description" class="formfield" rows="5"></textarea>
    </p>
    <p>
        <input type="hidden" name="resume_id" value="<%= resume_id %>" />
        <input type="hidden" name="action" value="" />
    <% if(in_process.equals("yes")) { %>
        <input type="button" name="add_more" value="Add More Education" onclick="checkEducation(this.form, 'ed_add_more'); return false" />
        &nbsp;&nbsp;&nbsp;
        <input type="button" name="continue" value="Continue to Work Experience" onclick="checkEducation(this.form, 'ed_continue'); return false" />
    <% } else { %>
        <input type="button" name="additional" value="Add Education" onclick="checkEducation(this.form, 'save_more_education'); return false" />
    <% } %>
    </p>
</form>


<%@include file="/common/footer.jsp" %>