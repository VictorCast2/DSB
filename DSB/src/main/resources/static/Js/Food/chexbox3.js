const selectBtn3 = document.querySelector(".select-btn3"),
    listItems3 = document.querySelector(".list-items3"),
    checkboxes3 = document.querySelectorAll(".checkbox3"),
    btnText3 = document.querySelector(".btn-text3"),
    searchInput3 = document.querySelector(".search3 input");

let selectedOption3 = null;

// Mostrar u ocultar el dropdown
selectBtn3.addEventListener("click", () => {
    selectBtn3.classList.toggle("open");
    listItems3.classList.toggle("open");
});

// Cambiar el texto del botón según la opción seleccionada
checkboxes3.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        // Desmarcar todas las casillas excepto la seleccionada
        checkboxes3.forEach(cb => {
            if (cb !== checkbox) cb.checked = false;
        });

        // Actualizar la opción seleccionada
        if (checkbox.checked) {
            selectedOption3 = checkbox.nextElementSibling.innerText;
        } else {
            selectedOption3 = null;
        }

        // Actualizar el texto del botón
        btnText3.innerText = selectedOption3 || "Categoria Almuerzo";
    });
});

// Función de búsqueda
searchInput3.addEventListener("input", () => {
    const filter = searchInput3.value.toLowerCase();
    const items3 = listItems3.querySelectorAll(".item3");

    items3.forEach(item => {
        const label = item.querySelector(".item-text3").innerText.toLowerCase();
        item.style.display = label.includes(filter) ? "" : "none";
    });
});

// Cerrar el dropdown si se hace clic fuera de él
document.addEventListener("click", (event) => {
    if (!selectBtn3.contains(event.target) && !listItems3.contains(event.target)) {
        selectBtn3.classList.remove("open");
        listItems3.classList.remove("open");
    }
});
