const API = "http://localhost:8080";

function addCustomer() {
  fetch(API + "/customer/save", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      name: name.value,
      email: email.value,
      mobile: mobile.value
    })
  }).then(r => alert("Customer Added"));
}

function loadCustomers() {
  fetch(API + "/customer/all")
    .then(r => r.json())
    .then(data => {
      let table = "<tr><th>ID</th><th>Name</th></tr>";
      data.forEach(c => {
        table += `<tr><td>${c.id}</td><td>${c.name}</td></tr>`;
      });
      customers.innerHTML = table;
    });
}

function createAccount() {
  fetch(API + "/account/save", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      accno: accNo.value,
      balance: balance.value,
      customerId: custId.value
    })
  }).then(r => alert("Account Created"));
}

function doTransfer() {
  fetch(API + "/transfer", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      fromAcc: from.value,
      toAcc: to.value,
      amount: amt.value,
      type: type.value
    })
  }).then(r => alert("Transaction Done"));
}
