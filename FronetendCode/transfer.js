const baseUrl = "http://localhost:8080/transfer";

function depositWithdraw() {
    let acc = dwAcc.value;
    let amt = dwAmt.value;
    let type = dwType.value;

    fetch(`${baseUrl}/depositwithdraw/${acc}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ balance: amt, check: type })
    })
    .then(res => {
        if (!res.ok) return res.text().then(msg => { throw msg });
        return res.text();
    })
    .then(() => {
        dwResult.style.color = "green";
        dwResult.innerText = "✅ Transaction completed successfully";
    })
    .catch(err => {
        dwResult.style.color = "red";
        dwResult.innerText = "❌ " + err;
    });
}

function checkBalance() {
    let acc = balAcc.value;

    fetch(`${baseUrl}/checkbalance/${acc}`)
    .then(res => {
        if (!res.ok) return res.text().then(msg => { throw msg });
        return res.text();
    })
    .then(data => {
        balResult.style.color = "green";
        balResult.innerText = `💰 Available Balance: ₹ ${data}`;
    })
    .catch(err => {
        balResult.style.color = "red";
        balResult.innerText = "❌ " + err;
    });
}

function transfer() {
    let a1 = fromAcc.value;
    let a2 = toAcc.value;
    let amt = trAmt.value;

    fetch(`${baseUrl}/transfer/${a1}/${a2}/${amt}`)
    .then(res => {
        if (!res.ok) return res.text().then(msg => { throw msg });
        return res.text();
    })
    .then(() => {
        trResult.style.color = "green";
        trResult.innerText = "✅ Amount transferred successfully";
    })
    .catch(err => {
        trResult.style.color = "red";
        trResult.innerText = "❌ " + err;
    });
}
