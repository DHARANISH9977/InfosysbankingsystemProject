const BASE_URL = "http://localhost:8080/customer";

// ADD
function addCustomer() {

    const data = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        phoneno: document.getElementById("phone").value,
        address: document.getElementById("address").value,
        pincode: document.getElementById("pincode").value,
        acc: {
            accno: document.getElementById("accno").value
        }
    };

    fetch(`${BASE_URL}/addc`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(res => res.text())
    .then(msg => {
        document.getElementById("msg").innerText = msg;
    })
    .catch(err => console.error(err));
}

// GET
function getCustomer() {
    const id = document.getElementById("cid").value;

    fetch(`${BASE_URL}/detailc/${id}`)
    .then(res => res.json())
    .then(data => {
        document.getElementById("output").innerText =
            JSON.stringify(data, null, 2);
    })
    .catch(err => console.error(err));
}

// DELETE
function deleteCustomer() {
    const id = document.getElementById("delid").value;

    fetch(`${BASE_URL}/deletec/${id}`, {
        method: "DELETE"
    })
    .then(res => res.text())
    .then(msg => {
        document.getElementById("delmsg").innerText = msg;
    })
    .catch(err => console.error(err));
}
