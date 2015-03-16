<ul class="user_nav">
    <% if(person != null) { %>
        <% if(person.isAdmin()) { %>
            <li><a href="/gsu_fhce/admin/">Admin Functions</a></li>
        <% } %>
    <% } %>
    <li><a href="/gsu_fhce/residency?action=current_residencies">Manage Residencies</a></li>
    <li><a href="/gsu_fhce/resume?action=list_resumes">View Resumes</a></li>
</ul>