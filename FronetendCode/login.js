let timeLeft = 60;
let timerInterval;

function sendOtp() {
    const gmail = document.getElementById("gmail").value;

    if (gmail === "") {
        alert("Please enter email");
        return;
    }

    fetch(`http://localhost:8080/login?gmail=${gmail}&otp=0`, {
        method: "POST"
    })
    .then(res => res.text())
    .then(data => {
        document.getElementById("message").innerText =
            "✅ Successfully OTP sent";
        document.getElementById("message").style.color = "green";

        startTimer();
    })
    .catch(err => {
        document.getElementById("message").innerText =
            "❌ Failed to send OTP";
        document.getElementById("message").style.color = "red";
        console.error(err);
    });
}

function startTimer() {
    timeLeft = 60;
    clearInterval(timerInterval);

    timerInterval = setInterval(() => {
        document.getElementById("timer").innerText =
            `OTP expires in ${timeLeft} seconds`;

        timeLeft--;

        if (timeLeft < 0) {
            clearInterval(timerInterval);
            document.getElementById("timer").innerText = "OTP expired";
        }
    }, 1000);
}

function verifyOtp() {
    const gmail = document.getElementById("gmail").value;
    const otp = document.getElementById("otp").value;

    if (otp === "") {
        alert("Enter OTP");
        return;
    }

    fetch(`http://localhost:8080/login?gmail=${gmail}&otp=${otp}`, {
        method: "POST"
    })
    .then(res => res.text())
    .then(data => {
        if (data.includes("Sucessfully")) {
            window.location.href = "dashboard.html";
        } else {
            document.getElementById("message").innerText = data;
            document.getElementById("message").style.color = "red";
        }
    })
    .catch(err => console.error(err));
}
