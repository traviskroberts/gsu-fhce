function showLogin() {
    if(Element.visible('member_login')) {
        Element.hide('member_login');
    }
    else {
        Element.show('member_login');
    }
}

function showRegister() {
    if(Element.visible('register')) {
        Element.hide('register');
    }
    else {
        Element.show('register');
    }
}

//change

// function to validate student registration input
function checkStudent(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.fname.value=='') {
        errors.push("You must provide your first name.");
        $('fname').addClassName('fieldWithError');
    }
    if(form.lname.value=='') {
        $('lname').addClassName('fieldWithError');
        errors.push("You must provide your last name.");
    }
    if(form.address1.value=='') {
        $('address1').addClassName('fieldWithError');
        errors.push("You must provide your address.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide your address city.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide your address state.");
    }
    if(form.zip.value=='') {
        $('zip').addClassName('fieldWithError');
        errors.push("You must provide your address zip code.");
    }
    if(form.email.value=='') {
        $('email').addClassName('fieldWithError');
        errors.push("You must provide your email address.");
    }
    if(form.password.value=='') {
        $('pass').addClassName('fieldWithError');
        errors.push("You must create a password.");
    }
    if(form.start_month.value=='') {
        $('start_month').addClassName('fieldWithError');
        errors.push("You must provide your school start date (month).");
    }
    if(form.start_year.value=='') {
        $('start_year').addClassName('fieldWithError');
        errors.push("You must provide your school start date (year).");
    }
    if(form.grad_month.value=='') {
        $('grad_month').addClassName('fieldWithError');
        errors.push("You must provide your estimated graduation date (month).");
    }
    if(form.grad_year.value=='') {
        $('grad_year').addClassName('fieldWithError');
        errors.push("You must provide your estimated graduation date (year).");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}

// function to validate student update input
function checkStudentUpdate(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.fname.value=='') {
        errors.push("You must provide your first name.");
        $('fname').addClassName('fieldWithError');
    }
    if(form.lname.value=='') {
        $('lname').addClassName('fieldWithError');
        errors.push("You must provide your last name.");
    }
    if(form.address1.value=='') {
        $('address1').addClassName('fieldWithError');
        errors.push("You must provide your address.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide your address city.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide your address state.");
    }
    if(form.zip.value=='') {
        $('zip').addClassName('fieldWithError');
        errors.push("You must provide your address zip code.");
    }
    if(form.email.value=='') {
        $('email').addClassName('fieldWithError');
        errors.push("You must provide your email address.");
    }
    if(form.start_month.value=='') {
        $('start_month').addClassName('fieldWithError');
        errors.push("You must provide your school start date (month).");
    }
    if(form.start_year.value=='') {
        $('start_year').addClassName('fieldWithError');
        errors.push("You must provide your school start date (year).");
    }
    if(form.grad_month.value=='') {
        $('grad_month').addClassName('fieldWithError');
        errors.push("You must provide your estimated graduation date (month).");
    }
    if(form.grad_year.value=='') {
        $('grad_year').addClassName('fieldWithError');
        errors.push("You must provide your estimated graduation date (year).");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}

// function to validate alumni registration input
function checkAlumni(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.fname.value=='') {
        errors.push("You must provide your first name.");
        $('fname').addClassName('fieldWithError');
    }
    if(form.lname.value=='') {
        $('lname').addClassName('fieldWithError');
        errors.push("You must provide your last name.");
    }
    if(form.address1.value=='') {
        $('address1').addClassName('fieldWithError');
        errors.push("You must provide your address.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide your address city.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide your address state.");
    }
    if(form.zip.value=='') {
        $('zip').addClassName('fieldWithError');
        errors.push("You must provide your address zip code.");
    }
    if(form.email.value=='') {
        $('email').addClassName('fieldWithError');
        errors.push("You must provide your email address.");
    }
    if(form.password.value=='') {
        $('pass').addClassName('fieldWithError');
        errors.push("You must create a password.");
    }
    if(form.graduation_month.value=='') {
        $('graduation_month').addClassName('fieldWithError');
        errors.push("You must provide your graduation date (month).");
    }
    if(form.graduation_year.value=='') {
        $('graduation_year').addClassName('fieldWithError');
        errors.push("You must provide your graduation date (year).");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}

// function to validate alumni update input
function checkAlumniUpdate(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.fname.value=='') {
        errors.push("You must provide your first name.");
        $('fname').addClassName('fieldWithError');
    }
    if(form.lname.value=='') {
        $('lname').addClassName('fieldWithError');
        errors.push("You must provide your last name.");
    }
    if(form.address1.value=='') {
        $('address1').addClassName('fieldWithError');
        errors.push("You must provide your address.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide your address city.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide your address state.");
    }
    if(form.zip.value=='') {
        $('zip').addClassName('fieldWithError');
        errors.push("You must provide your address zip code.");
    }
    if(form.email.value=='') {
        $('email').addClassName('fieldWithError');
        errors.push("You must provide your email address.");
    }
    if(form.graduation_month.value=='') {
        $('graduation_month').addClassName('fieldWithError');
        errors.push("You must provide your graduation date (month).");
    }
    if(form.graduation_year.value=='') {
        $('graduation_year').addClassName('fieldWithError');
        errors.push("You must provide your graduation date (year).");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}

// function to validate hospital registration input
function checkHospital(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.fname.value=='') {
        errors.push("You must provide your first name.");
        $('fname').addClassName('fieldWithError');
    }
    if(form.lname.value=='') {
        $('lname').addClassName('fieldWithError');
        errors.push("You must provide your last name.");
    }
    if(form.address1.value=='') {
        $('address1').addClassName('fieldWithError');
        errors.push("You must provide your address.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide your address city.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide your address state.");
    }
    if(form.zip.value=='') {
        $('zip').addClassName('fieldWithError');
        errors.push("You must provide your address zip code.");
    }
    if(form.email.value=='') {
        $('email').addClassName('fieldWithError');
        errors.push("You must provide your email address.");
    }
    if(form.password.value=='') {
        $('pass').addClassName('fieldWithError');
        errors.push("You must create a password.");
    }
    if(form.name.value=='') {
        $('name').addClassName('fieldWithError');
        errors.push("You must provide your graduation date.");
    }
    if(form.url.value=='http://') {
        $('url').value='';
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}

// function to validate hospital update input
function checkHospitalUpdate(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.fname.value=='') {
        errors.push("You must provide your first name.");
        $('fname').addClassName('fieldWithError');
    }
    if(form.lname.value=='') {
        $('lname').addClassName('fieldWithError');
        errors.push("You must provide your last name.");
    }
    if(form.address1.value=='') {
        $('address1').addClassName('fieldWithError');
        errors.push("You must provide your address.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide your address city.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide your address state.");
    }
    if(form.zip.value=='') {
        $('zip').addClassName('fieldWithError');
        errors.push("You must provide your address zip code.");
    }
    if(form.email.value=='') {
        $('email').addClassName('fieldWithError');
        errors.push("You must provide your email address.");
    }
    if(form.name.value=='') {
        $('name').addClassName('fieldWithError');
        errors.push("You must provide your graduation date.");
    }
    if(form.url.value=='http://') {
        $('url').value='';
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}
function checkAdminHospitalUpdate(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();

    if(form.lname.value=='') {
        $('lname').addClassName('fieldWithError');
        errors.push("You must provide your last name.");
    }
    if(form.address1.value=='') {
        $('address1').addClassName('fieldWithError');
        errors.push("You must provide your address.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide your address city.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide your address state.");
    }
    if(form.zip.value=='') {
        $('zip').addClassName('fieldWithError');
        errors.push("You must provide your address zip code.");
    }
    if(form.name.value=='') {
        $('name').addClassName('fieldWithError');
        errors.push("You must provide your graduation date.");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}

// function to show busy div for calendar month change
function showBusyCalendar(direction) {
    var link = direction + '_link';
    var busy = direction + '_busy';
    if($(link)) { Element.hide(link); }
    if($(busy)) { Element.show(busy); }
}

// function to hide busy div for calendar month change
function hideBusyCalendar(direction) {
    var link = direction + '_link';
    var busy = direction + '_busy';
    if($(link)) { Element.show(link); }
    if($(busy)) { Element.hide(busy); }
}

// function to validate calendar event input
function checkEvent(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.title.value=='') {
        $('title').addClassName('fieldWithError');
        errors.push("You must provide the event title.");
    }
    if(form.month.value=='') {
        $('month').addClassName('fieldWithError');
        errors.push("You must provide the month.");
    }
    if(form.day.value=='') {
        $('day').addClassName('fieldWithError');
        errors.push("You must provide the day.");
    }
    if(form.year.value=='') {
        $('year').addClassName('fieldWithError');
        errors.push("You must provide the year.");
    }
    if(!form.all_day.checked) {
        if(form.start_hour.value=='') {
            $('start_hour').addClassName('fieldWithError');
            errors.push("If it's not an all-day event, you must provide the starting time(hour).");
        }
        if(form.start_minutes.value=='') {
            $('start_minutes').addClassName('fieldWithError');
            errors.push("If it's not an all-day event, you must provide the starting time(minutes).");
        }
        if(form.end_hour.value=='') {
            $('end_hour').addClassName('fieldWithError');
            errors.push("If it's not an all-day event, you must provide the ending time(hour).");
        }
        if(form.end_minutes.value=='') {
            $('end_minutes').addClassName('fieldWithError');
            errors.push("If it's not an all-day event, you must provide the ending time(minutes).");
        }
    }
    if(form.description.value=='') {
        $('description').addClassName('fieldWithError');
        errors.push("You must provide the event description.");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else {
        form.submit();
    }
}

// function to show busy div when retrieving an event
function showBusyEvent() {
    $('event_details').innerHTML = '';
    Element.show('event_details');
    Element.show('event_busy');
}

// function to hide busy div for event retrieval
function hideBusyEvent() {
    Element.hide('event_busy');
}

// function to show password input when updating info
function showPassword() {
    Element.show('password_input');
    Element.hide('password_link');
}

// function to hide password input when updating info
function hidePassword() {
    Element.hide('password_input');
    Element.show('password_link');
}

// function to filter edit member page by member type
function get_members() {
    var member_type = $F('member');
    window.location = '/gsu_fhce/admin?action=edit_members&member_type=' + member_type;
}

// function to validate content page input
function checkPage(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.title.value=='') {
        $('title').addClassName('fieldWithError');
        errors.push("You must provide the page title.");
    }
    if(form.content.value=='') {
        $('content').addClassName('fieldWithError');
        errors.push("You must provide the page content.");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else {
        form.submit();
    }
}

// function to validate resume education input
function checkEducation(form, action) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.degree.value=='') {
        $('degree').addClassName('fieldWithError');
        errors.push("You must provide the degree.");
    }
    if(form.school.value=='') {
        $('school').addClassName('fieldWithError');
        errors.push("You must provide the school.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide the city of the school.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide the state of the school.");
    }
    if(form.start_month.value=='') {
        $('start_month').addClassName('fieldWithError');
        errors.push("You must provide the your start date (month).");
    }
    if(form.start_year.value=='') {
        $('start_year').addClassName('fieldWithError');
        errors.push("You must provide the your start date (year).");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else {
        form.action.value = action;
        form.submit();
    }
}

// function to validate resume work experience input
function checkWork(form, action) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.company.value=='') {
        $('company').addClassName('fieldWithError');
        errors.push("You must provide the company.");
    }
    if(form.position.value=='') {
        $('position').addClassName('fieldWithError');
        errors.push("You must provide the position.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide the city.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide the state.");
    }
    if(form.start_month.value=='') {
        $('start_month').addClassName('fieldWithError');
        errors.push("You must provide the your start date (month).");
    }
    if(form.start_year.value=='') {
        $('start_year').addClassName('fieldWithError');
        errors.push("You must provide the your start date (year).");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else {
        form.action.value = action;
        form.submit();
    }
}

// function to validate resume skill input
function checkSkill(form, action) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.name.value=='') {
        $('name').addClassName('fieldWithError');
        errors.push("You must provide the skill name.");
    }
    if(form.exp_length.value=='') {
        $('exp_length').addClassName('fieldWithError');
        errors.push("You must provide the experience length.");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else {
        form.action.value = action;
        form.submit();
    }
}

// function to validate resume naming
function checkResume(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.name.value=='') {
        $('name').addClassName('fieldWithError');
        errors.push("You must provide the resume name.");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else {
        form.submit();
    }
}

// function to validate residency input
function checkResidency(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.title.value=='') {
        errors.push("You must provide a position title.");
        $('title').addClassName('fieldWithError');
    }
    if(form.startDateMonth.value=='') {
        $('startDateMonth').addClassName('fieldWithError');
        errors.push("You must provide the start date (month).");
    }
    if(form.startDateDay.value=='') {
        $('startDateDay').addClassName('fieldWithError');
        errors.push("You must provide the start date (day).");
    }
    if(form.startDateYear.value=='') {
        $('startDateYear').addClassName('fieldWithError');
        errors.push("You must provide the start date (year).");
    }
    if(form.endDateMonth.value=='') {
        $('endDateMonth').addClassName('fieldWithError');
        errors.push("You must provide the end date (month).");
    }
    if(form.startDateDay.value=='') {
        $('endDateDay').addClassName('fieldWithError');
        errors.push("You must provide the end date (day).");
    }
    if(form.startDateYear.value=='') {
        $('endDateYear').addClassName('fieldWithError');
        errors.push("You must provide the end date (year).");
    }
    if(form.deadlineDateMonth.value=='') {
        $('deadlineDateMonth').addClassName('fieldWithError');
        errors.push("You must provide the deadline date (month).");
    }
    if(form.deadlineDateDay.value=='') {
        $('deadlineDateDay').addClassName('fieldWithError');
        errors.push("You must provide the deadline date (day).");
    }
    if(form.deadlineDateYear.value=='') {
        $('deadlineDateYear').addClassName('fieldWithError');
        errors.push("You must provide the deadline date (year).");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}

// function to validate residency, admin input
function checkResidencyAdmin(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.hId.value=='') {
        errors.push("You must provide a hospital name.");
        $('hId').addClassName('fieldWithError');
    }
    if(form.title.value=='') {
        errors.push("You must provide a position title.");
        $('title').addClassName('fieldWithError');
    }
    if(form.startDateMonth.value=='') {
        $('startDateMonth').addClassName('fieldWithError');
        errors.push("You must provide the start date (month).");
    }
    if(form.startDateDay.value=='') {
        $('startDateDay').addClassName('fieldWithError');
        errors.push("You must provide the start date (day).");
    }
    if(form.startDateYear.value=='') {
        $('startDateYear').addClassName('fieldWithError');
        errors.push("You must provide the start date (year).");
    }
    if(form.endDateMonth.value=='') {
        $('endDateMonth').addClassName('fieldWithError');
        errors.push("You must provide the end date (month).");
    }
    if(form.startDateDay.value=='') {
        $('endDateDay').addClassName('fieldWithError');
        errors.push("You must provide the end date (day).");
    }
    if(form.startDateYear.value=='') {
        $('endDateYear').addClassName('fieldWithError');
        errors.push("You must provide the end date (year).");
    }
    if(form.deadlineDateMonth.value=='') {
        $('deadlineDateMonth').addClassName('fieldWithError');
        errors.push("You must provide the deadline date (month).");
    }
    if(form.deadlineDateDay.value=='') {
        $('deadlineDateDay').addClassName('fieldWithError');
        errors.push("You must provide the deadline date (day).");
    }
    if(form.deadlineDateYear.value=='') {
        $('deadlineDateYear').addClassName('fieldWithError');
        errors.push("You must provide the deadline date (year).");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}

// function to validate hospital registration input
function checkHospitalAdd(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.name.value=='') {
        $('name').addClassName('fieldWithError');
        errors.push("You must provide a hospital name.");
    }

    if(form.address1.value=='') {
        $('address1').addClassName('fieldWithError');
        errors.push("You must provide your address.");
    }
    if(form.city.value=='') {
        $('city').addClassName('fieldWithError');
        errors.push("You must provide your address city.");
    }
    if(form.state.value=='') {
        $('state').addClassName('fieldWithError');
        errors.push("You must provide your address state.");
    }
    if(form.zip.value=='') {
        $('zip').addClassName('fieldWithError');
        errors.push("You must provide your address zip code.");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}

function validateMship(form) {
    for(i = 0; i < form.length; i++) {
        if($(form.elements[i]).hasClassName('fieldWithError')) {
            $(form.elements[i]).removeClassName('fieldWithError');
        }
    }
    var errors = new Array();
    if(form.student_id.value=='0') {
        $('student_id').addClassName('fieldWithError');
        errors.push("You must select a student.");
    }
    if(form.alumni_id.value=='0') {
        $('alumni_id').addClassName('fieldWithError');
        errors.push("You must select an alumni.");
    }
    if(errors.length > 0) {
        $('error_div').innerHTML = "<h3>There were errors with your submission.</h3>" + 
            "<p>Please correct the following:</p><ul id=\"error_list\">"
        for(i=0; i < errors.length; i++) {
            $('error_list').innerHTML += "<li>" + errors[i] + "</li>";
        }
        Element.show('error_div');
    }
    else { form.submit(); }
}