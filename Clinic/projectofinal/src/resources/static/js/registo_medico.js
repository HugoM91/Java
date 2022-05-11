const check = function () {
    if (document.getElementById('password_doctor').value ===
        document.getElementById('check_password_doctor').value) {
        document.getElementById('message').innerHTML = '';
    } else {
        document.getElementById('message').innerHTML = 'A password tem de ser idêntica';
    }
};