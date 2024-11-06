/* Menu de NOMBRE EJERCICIO*/
const selectBtn1 = document.querySelector(".select-btn1"),
    listItems1 = document.querySelector(".list-items1"),
    checkboxes1 = document.querySelectorAll(".checkbox1"),
    btnText1 = document.querySelector(".btn-text1"),
    searchInput1 = document.querySelector(".search1 input");

// Array para almacenar opciones seleccionadas en el orden en que se seleccionan
let selectedOptions1 = [];

// Toggle dropdown visibility when the button is clicked
selectBtn1.addEventListener("click", () => {
    selectBtn1.classList.toggle("open");
    listItems1.classList.toggle("open");
});

// Update button text based on selected checkboxes
checkboxes1.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        const labelText = checkbox.nextElementSibling.innerText;

        if (checkbox.checked) {
            // Agregar al final si se selecciona
            selectedOptions1.push(labelText);
        } else {
            // Remover si se deselecciona
            selectedOptions1 = selectedOptions1.filter(item => item !== labelText);
        }

        const selectedCount = selectedOptions1.length;

        if (selectedCount > 0) {
            if (selectedCount >= 3) {
                btnText1.innerText = `All selected (${selectedCount})`;
            } else {
                btnText1.innerText = selectedOptions1.join(", ");
            }
        } else {
            btnText1.innerText = "Nombre Ejercicio";
        }
    });
});

// Implement search functionality
searchInput1.addEventListener("input", () => {
    const filter = searchInput1.value.toLowerCase();
    const items1 = listItems1.querySelectorAll(".item1");

    items1.forEach(item => {
        const label = item.querySelector(".item-text1").innerText.toLowerCase();

        if (label.includes(filter)) {
            item.style.display = "";
        } else {
            item.style.display = "none";
        }
    });
});

// Close the dropdown when clicking outside of it
document.addEventListener("click", (event) => {
    if (!selectBtn1.contains(event.target) && !listItems1.contains(event.target)) {
        selectBtn1.classList.remove("open");
        listItems1.classList.remove("open");
    }
});
