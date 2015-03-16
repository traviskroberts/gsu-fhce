<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="models.*, java.sql.*" %>

<%
    String notice = (String)request.getAttribute("notice");
    Person person = null;
    if(session.getAttribute("person") != null) {
        person = (Person)session.getAttribute("person");
    }
    String member_type = (String)session.getAttribute("member_type");
    
    // create Page model for generating content navigation
    Page pager = new Page();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="title" content="" />
        <meta name="keywords" content="" />

	<title>Georgia State University - Future Healthcare Executives</title>
        
        <link rel="stylesheet" type="text/css" href="/gsu_fhce/common/gsufhce.css" media="screen" />
        <script type="text/javascript" src="/gsu_fhce/common/prototype.js"></script>
        <script type="text/javascript" src="/gsu_fhce/common/scriptaculous.js"></script>
        <script type="text/javascript" src="/gsu_fhce/common/application.js"></script>
	
</head>

<body>
<!--cool dude-->
    <div id="wrapper">
        <div id="header">
            <div id="logolink" onclick="window.location='/gsu_fhce/';"></div>
        </div><!-- end header div -->
        
        <div id="nav">
            <div class="padding">
                
            <% if(person != null) { %>
            
                <div id="signed_in_area">
                    <p class="center">
                        <a href="/gsu_fhce/my_account">My Account</a> | <a href="/gsu_fhce/logout">Logout</a>
                    </p>
                </div><!-- signed_in_area -->
                
                <% if(member_type != null && !member_type.equals("alumni")) { %>
                    <p class="nav_header">Member Functions</p>
                    <% if(member_type.equals("student")) { %>
                        <%@include file="/common/student_nav.jsp" %>
                    <% } else if(member_type.equals("hospital")) { %>
                        <%@include file="/common/hospital_nav.jsp" %>
                    <% } %>
                <% } %>
                
            <% } else { %>
            
                <div id="login_area">
                    <p class="link"><a href="/gsu_fhce/login.jsp" onclick="showLogin(); return false">Member Login</a></p>
                    <div id="member_login" style="display:none;">
                        <form action="/gsu_fhce/login" method="post">
                            <p>
                                <label for="username">Username:</label><br />
                                <input type="text" name="username" id="username" value="" length="15" style="width:150px;" />
                            </p>
                            <p>
                                <label for="password">Password:</label><br />
                                <input type="password" name="password" id="password" value="" length="15" style="width:150px;" />
                            </p>
                            <input type="hidden" name="action" value="login" />
                            <input type="submit" value="Login" class="reg_button" />
                        </form>
                    </div><!-- end member_login div -->
                </div><!-- end login_area div -->
                <p class="link"><a href="#" onclick="showRegister(); return false;">Register</a></p>
                <div id="register" style="display:none;">
                    <form method="post" action="member_register">
                        <p class="link">
                            I am. . .
                            <select name="register_type" onchange="this.form.submit();">
                                <option value="">(select)</option>
                                <option value="student">a Student</option>
                                <option value="alumni">an Alumni</option>
                                <option value="hospital">a Hospital</option>
                            </select>
                        </p>
                        <input type="hidden" name="action" value="register" />
                    </form>
                </div><!-- end register div -->
                
            <% } %>
                <!-- Adrian added link to pressroom.jsp -->
                <ul>
                    <li><a href="/gsu_fhce/">Home</a></li>
                    <li><a href="/gsu_fhce/news?action=get_list">Press Room</a></li>
                    <li><a href="/gsu_fhce/calendar">Calendar of Events</a></li>
                    <%= pager.buildNavigation() %>
                </ul>
                
            </div><!-- end padding div -->
        </div><!-- end nav div -->
        
        <div id="content">
            <% if(notice != null) { %>
            <div id="notice">
		<p>
                    <span class="xlink"><a href="#" onclick="Effect.Fade('notice');; return false;">X</a></span>
                    <%= notice %>
		</p>
            </div><!-- end notice div -->
            <script type="text/javascript">new Effect.Highlight('notice');</script>
            <% } %>
            <div id="error_div" style="display:none;"></div>