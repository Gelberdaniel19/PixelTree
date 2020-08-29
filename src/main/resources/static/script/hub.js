let password = null;
let confirm = null;

// Make it so passwords must match
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

// Update the credit USD amount when the credit amount changes
$(document).ready(function() {
    $("#creditAmountInput")[0].oninput = function() {
        let dollars = $("#creditAmountInput").val() / 100;
        dollars = parseInt(dollars, 10);
        $("#creditAmountUSD").text("USD $" + dollars + ".00");
    }
});