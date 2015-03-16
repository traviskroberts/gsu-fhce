<ul class="user_nav">
    <% if(person != null) { %>
        <% if(person.isAdmin()) { %>
            <li><a href="/gsu_fhce/admin/">Admin Functions</a></li>
        <% } %>
    <% } %>
    <li><a href="">Request Mentorship</a></li>
</ul>