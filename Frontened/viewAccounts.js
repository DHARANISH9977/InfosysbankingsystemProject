const baseUrl = "http://localhost:8080/Account";

function loadAccounts() {
    fetch(baseUrl + "/all")
        .then(res => res.json())
        .then(data => {
            let rows = "";
            data.forEach(a => {
                rows += `<tr>
                    <td>${a.accno}</td>
                    <td>${a.accounttype}</td>
                    <td>${a.ifsccode}</td>
                    <td>${a.bankname}</td>
                    <td>${a.bankaddress}</td>
                    <td>${a.balance}</td>
                    <td>${a.email}</td>
                   <td>
            <button onclick="deleteAcc(${a.accid})">Delete</button>
         </td>
                </tr>`;
            });
            document.getElementById("tableBody").innerHTML = rows;
        });
}

function deleteAcc(id) {
    fetch(baseUrl + "/delete/" + id, {
        method: "DELETE"
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
         loadAccounts();
    });
}

// AUTO LOAD
window.onload = loadAccounts;