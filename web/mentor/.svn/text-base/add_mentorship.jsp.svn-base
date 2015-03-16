<%@include file="/common/header.jsp" %>
<%
    // checks to see if they really are an admin
    if(person != null) {
        if(!person.isAdmin()) {
            String error = "You don't have permission to view that page!";
            session.setAttribute("error", error);
            response.sendRedirect("/gsu_fhce/error.jsp");
        }
    }
    else {
        String error = "You don't have permission to view that page!";
        session.setAttribute("error", error);
        response.sendRedirect("/gsu_fhce/error.jsp");
    }
    
    // get the result set from the request
    ResultSet resultset = (ResultSet)request.getAttribute("resultset");
    Mentor mentor = new Mentor();
%>

<h1>Add a New Mentorship</h1>



<%@include file="/common/footer.jsp" %>
