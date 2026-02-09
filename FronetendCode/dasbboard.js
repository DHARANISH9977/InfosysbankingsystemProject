// TYPING EFFECT
const text = "Welcome to BOI Internet Banking";
let index = 0;

function typeEffect() {
    if (index < text.length) {
        document.getElementById("typing").innerHTML += text.charAt(index);
        index++;
        setTimeout(typeEffect, 100);
    }
}
typeEffect();

// FEEDBACK SUBMIT 
document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("feedbackForm");
    const msg = document.getElementById("thankYouMsg");

    if (form) {
        form.addEventListener("submit", function (e) {
            e.preventDefault();

            msg.innerText = "Thank you for submitting your feedback!";
            msg.style.color = "green";
            msg.style.fontWeight = "bold";
            msg.style.marginTop = "10px";

            form.reset(); 
        });
    }
});

// LOGOUT 
function logout() {
    alert("Logged out successfully!");
    window.location.href = "index.html";
}
