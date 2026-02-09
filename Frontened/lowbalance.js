const api = "http://localhost:8080/Account/lowbalance";

function loadLowBalance() {
  fetch(api)
    .then(res => res.json())
    .then(data => {
      let rows = "";
      data.forEach(acc => {
        rows += `
          <tr>
            <td>${acc.accno}</td>
            <td>${acc.email}</td>
            <td class="low">₹ ${acc.balance}</td>
            <td>📧 Email Sent</td>
          </tr>
        `;
      });
      document.getElementById("tableBody").innerHTML = rows;
    });
}

loadLowBalance();
setInterval(loadLowBalance, 10000);   
