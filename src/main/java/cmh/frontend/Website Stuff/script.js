function addGuest() {
    var guestsContainer = document.getElementById("guestsContainer");
    var guestNumber = guestsContainer.children.length + 1;

    var guestDiv = document.createElement("div");
    guestDiv.classList.add("guest");

    guestDiv.innerHTML = `
        <h3>Guest ${guestNumber}</h3>
        <label for="name${guestNumber}">Name:</label>
        <input type="text" id="name${guestNumber}" name="name${guestNumber}" required><br><br>
        
        <label for="gender${guestNumber}">Gender:</label>
        <input type="text" id="gender${guestNumber}" name="gender${guestNumber}" required><br><br>
        
        <label for="dateIn${guestNumber}">Date In:</label>
        <input type="date" id="dateIn${guestNumber}" name="dateIn${guestNumber}" required><br><br>
        
        <label for="dateOut${guestNumber}">Date Out:</label>
        <input type="date" id="dateOut${guestNumber}" name="dateOut${guestNumber}" required><br><br>
        
        <!-- Add other fields for additional guest information here -->
    `;

    guestsContainer.appendChild(guestDiv);
}

function submitRequest() {
    var guestsContainer = document.getElementById("guestsContainer");
    var guests = [];

    for (var i = 0; i < guestsContainer.children.length; i++) {
        var guest = {
            name: document.getElementById(`name${i + 1}`).value,
            gender: document.getElementById(`gender${i + 1}`).value,
            dateIn: document.getElementById(`dateIn${i + 1}`).value,
            dateOut: document.getElementById("dateOut").value
        };
        guests.push(guest);
    }

    document.getElementById("guests").value = JSON.stringify(guests);
    document.getElementById("roomAssignmentForm").submit();
}

window.onload = function() {
    addGuest(); // Add one guest by default
};
