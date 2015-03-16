<%@include file="/common/header.jsp" %>

<%
    String message = (String)request.getAttribute("message");
    if (message == null) message = "";
%>

<h1>Press Room</h1>
    
<% if (!message.equals("")) { %>
    <h3> <%= message %> </h3>
<% } %>
    
<!-- view list of news stories -->
   
<!-- enter a news story -->
    
<form action="/gsu_fhce/news" method="post">
    <table>
       <tr>
           <th>Title</th>
           <td><input name="title" type="text" size="20"></td>
       </tr>
       <tr>
           <th>Date</th>
           <td><select name="month" id="month" class="selectfield">
                <option value=""></option>
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">06</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>&nbsp;
            <select name="day" id="day" class="selectfield">
                <option value=""></option>
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
                <option value=""></option>
                <option value="2006">2006</option>
                <option value="2007">2007</option>
                <option value="2008">2008</option>
                <option value="2009">2009</option>
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2012">2012</option>
            </select></td>
       </tr>
       <tr>
           <th>Content</th>
           <td><textarea name="content" rows="5" cols="35"></textarea></td>
       </tr>
    </table>
    <br><br>
    <!--input type="hidden" name="action" value="add_news"-->
    <input type="submit" name="action" value="Add News">&nbsp;
    <input type="submit" name="action" value="Get News List">
    <input type="reset" value="Reset Form">
</form>

<%@include file="/common/footer.jsp" %>