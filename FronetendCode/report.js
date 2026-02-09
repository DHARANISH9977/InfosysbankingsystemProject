const BASE="http://localhost:8080";

function downloadCSV(){
window.location.href=BASE+"/report/csv";
}

function sendMail(){
fetch(BASE+"/mail/send",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({
to:mail.value,
text:msg.value
})
}).then(r=>r.text()).then(alert);
}
  
