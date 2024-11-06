const selectBtn2 = document.querySelector(".select-btn2"),
    listItems2 = document.querySelector(".list-items2"),
    checkboxes2 = document.querySelectorAll(".checkbox2"),
    btnText2 = document.querySelector(".btn-text2"),
    searchInput2 = document.querySelector(".search2 input");

// Array para almacenar opciones seleccionadas en el orden en que se seleccionan
let selectedOptions2 = [];

// Toggle dropdown visibility when the button is clicked
selectBtn2.addEventListener("click", () => {
    selectBtn2.classList.toggle("open");
    listItems2.classList.toggle("open");
});

// Update button text based on selected checkboxes
checkboxes2.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        const labelText = checkbox.nextElementSibling.innerText;
        if (checkbox.checked) {
            // Agregar al final si se selecciona
            selectedOptions2.push(labelText);
        } else {
            // Remover si se deselecciona
            selectedOptions2 = selectedOptions2.filter(item => item !== labelText);
        }
        const selectedCount = selectedOptions2.length;
        if (selectedCount > 0) {
            if (selectedCount >= 3) {
                btnText2.innerText = `All selected (${selectedCount})`;
            } else {
                btnText2.innerText = selectedOptions2.join(", ");
            }
        } else {
            btnText2.innerText = "Intensidad Ejercicio";
        }
    });
});

// Implement search functionality
searchInput2.addEventListener("input", () => {
    const filter = searchInput2.value.toLowerCase();
    const items2 = listItems2.querySelectorAll(".item2");
    items2.forEach(item => {
        const label = item.querySelector(".item-text2").innerText.toLowerCase();
        if (label.includes(filter)) {
            item.style.display = "";
        } else {
            item.style.display = "none";
        }
    });
});

// Close the dropdown when clicking outside of it
document.addEventListener("click", (event) => {
    if (!selectBtn2.contains(event.target) && !listItems2.contains(event.target)) {
        selectBtn2.classList.remove("open");
        listItems2.classList.remove("open");
    }
});