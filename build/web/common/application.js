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
    if(form.start_date.value=='') {
        $('start_date').addClassName('fieldWithError');
        errors.push("You must provide your school start date.");
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
    if(form.start_date.value=='') {
        $('start_date').addClassName('fieldWithError');
        errors.push("You must provide your school start date.");
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
    if(form.graduation_date.value=='') {
        $('graduation_date').addClassName('fieldWithError');
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
    if(form.graduation_date.value=='') {
        $('graduation_date').addClassName('fieldWithError');
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
    var busy = link + '_busy';
    if($(link)) { Element.hide(link); }
    if($(busy)) { Element.show(busy); }
}

// function to hide busy div for calendar month change
function hideBusyCalendar(direction) {
    var link = direction + '_link';
    var busy = link + '_busy';
    if($(link)) { Element.show(link); }
    if($(busy)) { Element.hide(busy); }
}