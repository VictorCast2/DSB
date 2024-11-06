const selectBtn = document.querySelector(".select-btn"),
    listItems = document.querySelector(".list-items"),
    checkboxes = document.querySelectorAll(".checkbox"),
    btnText = document.querySelector(".btn-text"),
    searchInput = document.querySelector(".search input");

let selectedOption = null;

// Mostrar u ocultar el dropdown
selectBtn.addEventListener("click", () => {
    selectBtn.classList.toggle("open");
    listItems.classList.toggle("open");
});

// Cambiar el texto del botón según la opción seleccionada
checkboxes.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        // Desmarcar todas las casillas excepto la seleccionada
        checkboxes.forEach(cb => {
            if (cb !== checkbox) cb.checked = false;
        });

        // Actualizar la opción seleccionada
        if (checkbox.checked) {
            selectedOption = checkbox.nextElementSibling.innerText;
        } else {
            selectedOption = null;
        }

        // Actualizar el texto del botón
        btnText.innerText = selectedOption || "Categoria Desayuno";
    });
});

// Función de búsqueda
searchInput.addEventListener("input", () => {
    const filter = searchInput.value.toLowerCase();
    const items = listItems.querySelectorAll(".item");

    items.forEach(item => {
        const label = item.querySelector(".item-text").innerText.toLowerCase();
        item.style.display = label.includes(filter) ? "" : "none";
    });
});

// Cerrar el dropdown si se hace clic fuera de él
document.addEventListener("click", (event) => {
    if (!selectBtn.contains(event.target) && !listItems.contains(event.target)) {
        selectBtn.classList.remove("open");
        listItems.classList.remove("open");
    }
});
