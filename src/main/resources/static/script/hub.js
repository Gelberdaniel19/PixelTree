let password = null;
let confirm = null;

$(document).ready(function() {
    password = $("#inputPassword");
    confirm = $("#inputConfirmPassword");

    password[0].onchange = validatePasswordMatch;
    confirm[0].onchange = validatePasswordMatch;

    password.val("");
    confirm.val("");
});

function validatePasswordMatch() {
    if (password.val() != confirm.val()) {
        confirm[0].setCustomValidity("Passwords need to match.");
    } else {
        confirm[0].setCustomValidity("");
    }
}