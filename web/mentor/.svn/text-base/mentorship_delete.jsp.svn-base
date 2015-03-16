<%@include file="/common/header.jsp" %>

 <% ResultSet result = (ResultSet)request.getAttribute("result"); %>
 
 <form method="post" action="del_mship">
     <select name="Mentorship" id="id" class="selectfield">
         <option value=""></option>
         <% while (result.next()) { %>
         <option value="<% result.getString("a_lname") %>, " <% result.getString("a_fname") %> &amp; <% result.getString("s_lname") %>, <% result.getString("s_fname") %>></option> 
         <% } %>
     </select>
     <input type="submit" value="Delete" />
 </form>

<%@include file="/common/footer.jsp" %>