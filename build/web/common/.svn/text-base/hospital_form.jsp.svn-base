<h2>Hospital Information</h2>

<table class="register_info" cellspacing="5">
    <tr>
        <td>
            Hospital Name: <input type="text" name="name" id="name" 
                <% if(hospital.getName() != null) { %>
                    value="<%= hospital.getName() %>"
                <% } else { %>
                    value="" 
                <% } %>/>
        </td>
    </tr>
    <tr>
        <td>
            Email Address (this will be your username): <input type="text" name="email" id="email" 
                <% if(hospital.getEmail() != null) { %>
                    value="<%= hospital.getEmail() %>"
                <% } else { %>
                    value="" 
                <% } %>/>
        </td>
    </tr>
    <% if(hospital.getPassword() == null) { %>
    <tr>
        <td>Password: <input type="password" name="password" id="pass" /></td>
    </tr>
    <% } %>
</table>
<br />

<h2>Contact Person</h2>
<table class="register_info" cellspacing="5">
    <tr>
        <td>
            First Name: <input type="text" name="fname" id="fname"
                <% if(hospital.getFname() != null) { %>
                    value="<%= hospital.getFname() %>"
                <% } else { %>
                    value="" 
                <% } %>/>
        </td>
        <td>
            Last Name: <input type="text" name="lname" id="lname" 
                <% if(hospital.getLname() != null) { %>
                    value="<%= hospital.getLname() %>"
                <% } else { %>
                    value="" 
                <% } %>/>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            Address:<br />
            <input type="text" name="address1" id="address1" 
                <% if(hospital.getAddress1() != null) { %>
                    value="<%= hospital.getAddress1() %>"
                <% } else { %>
                    value="" 
                <% } %>/><br />
            <input type="text" name="address2" id="address2" 
                <% if(hospital.getAddress2() != null) { %>
                    value="<%= hospital.getAddress2() %>"
                <% } else { %>
                    value="" 
                <% } %>/>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            City: <input type="text" name="city" id="city" 
                <% if(hospital.getCity() != null) { %>
                    value="<%= hospital.getCity() %>"
                <% } else { %>
                    value="" 
                <% } %>/>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            State: <input type="text" name="state" id="state" 
                <% if(hospital.getState() != null) { %>
                    value="<%= hospital.getState() %>"
                <% } else { %>
                    value="" 
                <% } %>/>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            Zip: <input type="text" name="zip" id="zip" 
                <% if(hospital.getZip() != null) { %>
                    value="<%= hospital.getZip() %>"
                <% } else { %>
                    value="" 
                <% } %>/>
        </td>
    </tr>
</table>