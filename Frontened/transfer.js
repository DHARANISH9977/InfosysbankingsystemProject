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
    .then(async res => {
        let msg = await res.text();
        if (!res.ok) throw msg;
        return msg;
    })
    .then(msg => {
        dwResult.style.color = "green";
        dwResult.innerText = "✅ " + msg;
    })
    .catch(err => {
        dwResult.style.color = "red";
        dwResult.innerText = "❌ " + err;
    });
}


function checkBalance() {

    let acc = balAcc.value;

    fetch(`${baseUrl}/checkbalance/${acc}`)
    .then(async res => {
        let msg = await res.text();
        if (!res.ok) throw msg;
        return msg;
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
    .then(async res => {
        let msg = await res.text();
        if (!res.ok) throw msg;
        return msg;
    })
    .then(msg => {
        trResult.style.color = "green";
        trResult.innerText = "✅ " + msg;
    })
    .catch(err => {
        trResult.style.color = "red";
        trResult.innerText = "❌ " + err;
    });
}
