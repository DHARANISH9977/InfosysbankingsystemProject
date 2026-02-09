const CUSTOMER_URL = "http://localhost:8080/customer";

// ADD CUSTOMER
function addCustomer() {
    const phone = document.getElementById("phone").value.trim();

    if (phone.length < 8 || phone.length > 10 || !/^[0-9]+$/.test(phone)) {
        alert("Phone number must be 8–10 digits");
        return;
    }

    const data = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        phoneno: phone,
        address: document.getElementById("address").value,
        pincode: document.getElementById("pincode").value,
        acc: {
            accno: document.getElementById("accno").value
        }
    };

    fetch(`${CUSTOMER_URL}/addc`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
    .then(res => res.text())
    .then(msg => {
        document.getElementById("msg").innerText = msg;
        loadCustomers();
    })
    .catch(() => alert("Error adding customer"));
}

// LOAD ALL CUSTOMERS
function loadCustomers() {
    fetch(`${CUSTOMER_URL}/all`)
        .then(res => res.json())
        .then(customers => {
            const list = document.getElementById("customerList");
            list.innerHTML = "";

            customers.forEach(c => {
                const div = document.createElement("div");
                div.className = "customer";

                div.innerHTML = `
                    <b>Customer ID:</b> ${c.cusid}<br>
                    <b>Name:</b> ${c.name}<br>
                    <b>Email:</b> ${c.email}<br>
                    <b>Phone:</b> ${c.phoneno}<br>
                    <b>Address:</b> ${c.address}<br>
                    <b>Account No:</b> ${c.acc.accno}<br><br>

                    <button class="delete" onclick="deleteCustomer(${c.cusid})">
                        Delete Customer
                    </button>
                `;

                list.appendChild(div);
            });
        })
        .catch(() => alert("Error loading customers"));
}

// DELETE CUSTOMER WITH WARNING
function deleteCustomer(id) {
    const confirmed = confirm(
        "⚠️ WARNING!\n\n" +
        "Deleting this customer will ALSO delete the linked account.\n\n" +
        "Click OK to continue or Cancel to stop."
    );

    if (!confirmed) return;

    fetch(`${CUSTOMER_URL}/deletec/${id}`, {
        method: "DELETE"
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadCustomers();
    })
    .catch(() => alert("Delete failed"));
}
