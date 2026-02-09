const baseUrl = "http://localhost:8080/Account";

function generateAccNo() {
    return Math.floor(1000000000 + Math.random() * 9000000000);
}

function createAccount() {
    let account = {
        accno: generateAccNo(),
        accounttype: document.getElementById("type").value,
        balance: document.getElementById("balance").value,
        email: document.getElementById("email").value,
        status: "ACTIVE"
    };

    fetch(baseUrl + "/addacc", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(account)
    })
    .then(res => res.json())
    .then(data => {
        document.getElementById("result").innerHTML =
            "Account Created! Account No: " + data.accno;

        addRow(data);
    });
}

function addRow(a) {
    let row = `<tr id="row-${a.accid}">
        <td>${a.accno}</td>
        <td>${a.accounttype}</td>
        <td>${a.ifsccode}</td>
        <td>${a.bankname}</td>
        <td>${a.bankaddress}</td>
        <td>${a.balance}</td>
        <td>${a.email}</td>
    </tr>`;

    document.getElementById("tableBody").innerHTML += row;
}

function deleteAcc(id) {
    fetch(baseUrl + "/delete/" + id, {
        method: "DELETE"
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        document.getElementById("row-" + id).remove();
    });
}
