const selectBtn = document.querySelector(".select-btn"),
    listItems = document.querySelector(".list-items"),
    checkboxes = document.querySelectorAll(".checkbox"),
    btnText = document.querySelector(".btn-text"),
    searchInput = document.querySelector(".search input");

// Array para almacenar opciones seleccionadas en el orden en que se seleccionan
let selectedOptions = [];

// Toggle dropdown visibility when the button is clicked
selectBtn.addEventListener("click", () => {
    selectBtn.classList.toggle("open");
    listItems.classList.toggle("open");
});

// Update button text based on selected checkboxes
checkboxes.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        const labelText = checkbox.nextElementSibling.innerText;
        if (checkbox.checked) {
            // Agregar al final si se selecciona
            selectedOptions.push(labelText);
        } else {
            // Remover si se deselecciona
            selectedOptions = selectedOptions.filter(item => item !== labelText);
        }
        const selectedCount = selectedOptions.length;
        if (selectedCount > 0) {
            if (selectedCount >= 3) {
                btnText.innerText = `All selected (${selectedCount})`;
            } else {
                btnText.innerText = selectedOptions.join(", ");
            }
        } else {
            btnText.innerText = "Tipo Ejercicio";
        }
    });
});

// Implement search functionality
searchInput.addEventListener("input", () => {
    const filter = searchInput.value.toLowerCase();
    const items = listItems.querySelectorAll(".item");
    items.forEach(item => {
        const label = item.querySelector(".item-text").innerText.toLowerCase();
        if (label.includes(filter)) {
            item.style.display = "";
        } else {
            item.style.display = "none";
        }
    });
});

// Close the dropdown when clicking outside of it
document.addEventListener("click", (event) => {
    if (!selectBtn.contains(event.target) && !listItems.contains(event.target)) {
        selectBtn.classList.remove("open");
        listItems.classList.remove("open");
    }
});