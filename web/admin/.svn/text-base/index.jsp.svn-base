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
%>

<h1>Admin Area</h1>

<p>Choose from one of the following options:</p>

<ul>
    <li><a href="/gsu_fhce/admin?action=edit_events">Manage Calendar Events</a></li>
    <li><a href="/gsu_fhce/admin?action=edit_members">Manage Members</a></li>
    <li><a href="/gsu_fhce/admin?action=list_residencies">Manage Residencies</a></li>
    <li><a href="/gsu_fhce/admin?action=manage_pages">Manage Content Pages</a></li>
    <li><a href="/gsu_fhce/admin?action=manage_mship">Manage Mentorships</a></li>
    <li><a href="/gsu_fhce/admin?action=Get Admin News List">Manage News</a></li>

</ul>

<%@include file="/common/footer.jsp" %>