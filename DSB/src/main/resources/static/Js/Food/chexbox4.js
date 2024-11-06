const selectBtn4 = document.querySelector(".select-btn4"),
    listItems4 = document.querySelector(".list-items4"),
    checkboxes4 = document.querySelectorAll(".checkbox4"),
    btnText4 = document.querySelector(".btn-text4"),
    searchInput4 = document.querySelector(".search4 input");

let selectedOption4 = null;

// Mostrar u ocultar el dropdown
selectBtn4.addEventListener("click", () => {
    selectBtn4.classList.toggle("open");
    listItems4.classList.toggle("open");
});

// Cambiar el texto del botón según la opción seleccionada
checkboxes4.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        // Desmarcar todas las casillas excepto la seleccionada
        checkboxes4.forEach(cb => {
            if (cb !== checkbox) cb.checked = false;
        });

        // Actualizar la opción seleccionada
        if (checkbox.checked) {
            selectedOption4 = checkbox.nextElementSibling.innerText;
        } else {
            selectedOption4 = null;
        }

        // Actualizar el texto del botón
        btnText4.innerText = selectedOption4 || "Comida Almuerzo";
    });
});

// Función de búsqueda
searchInput4.addEventListener("input", () => {
    const filter = searchInput4.value.toLowerCase();
    const items4 = listItems4.querySelectorAll(".item4");

    items4.forEach(item => {
        const label = item.querySelector(".item-text4").innerText.toLowerCase();
        item.style.display = label.includes(filter) ? "" : "none";
    });
});

// Cerrar el dropdown si se hace clic fuera de él
document.addEventListener("click", (event) => {
    if (!selectBtn4.contains(event.target) && !listItems4.contains(event.target)) {
        selectBtn4.classList.remove("open");
        listItems4.classList.remove("open");
    }
});
