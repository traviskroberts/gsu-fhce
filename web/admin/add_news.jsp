<%@include file="/common/header.jsp" %>

<%
    String message = (String)request.getAttribute("message");
    if (message == null) message = "";
%>

<h1>Add News</h1>
    
<% if (!message.equals("")) { %>
    <h3> <%= message %> </h3>
<% } %>
    
<!-- view list of news stories -->
   
<!-- enter a news story -->
    
<form action="/gsu_fhce/admin" method="post">
    
       <p>
           Title<br>
           <input name="title" type="text" class="formfield">
       </p>
       <p>
           Date<br>
           <select name="month" id="month" class="selectfield">
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
            <select name="day" id="day" class="selectfield">
                <option value="">day</option>
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
            </select>&nbsp;
            <select name="year" id="year" class="selectfield">
                <option value="">year</option>
                <option value="2006">2006</option>
                <option value="2007">2007</option>
                <option value="2008">2008</option>
                <option value="2009">2009</option>
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2012">2012</option>
            </select>
       </p>
       <p>
           Content<br>
           <td><textarea name="content" rows="5" cols="35" class="formfield"></textarea></td>
       </p>
    
    <br><br>
    <!--input type="hidden" name="action" value="add_news"-->
    <input type="submit" name="action" value="Add News">&nbsp;
    
    <input type="reset" value="Reset Form">
</form>
<br>
<a href="/gsu_fhce/admin?action=Get Admin News List">&laquo;Back to news list</a>
<%@include file="/common/footer.jsp" %>