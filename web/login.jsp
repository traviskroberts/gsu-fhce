<%@include file="/common/header.jsp" %>

<h1>Login</h1>

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

<%@include file="/common/footer.jsp" %>