<ul class="user_nav">
    <% if(person != null) { %>
        <% if(person.isAdmin()) { %>
            <li><a href="/gsu_fhce/admin/">Admin Functions</a></li>
        <% } %>
    <% } %>
    <li><a href="/gsu_fhce/resume">Add/Edit Resume</a></li>
    <li><a href="/gsu_fhce/residency?action=open_residencies">View Open Residencies</a></li>
    <li><a href="/gsu_fhce/mentor?action=view_mentors">View Available Mentorships</a></li>
</ul>