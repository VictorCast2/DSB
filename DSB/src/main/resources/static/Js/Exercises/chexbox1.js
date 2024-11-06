const selectBtn1 = document.querySelector(".select-btn1"),
    listItems1 = document.querySelector(".list-items1"),
    checkboxes1 = document.querySelectorAll(".checkbox1"),
    btnText1 = document.querySelector(".btn-text1"),
    searchInput1 = document.querySelector(".search1 input");

let selectedOption1 = null;

// Mostrar u ocultar el dropdown
selectBtn1.addEventListener("click", () => {
    selectBtn1.classList.toggle("open");
    listItems1.classList.toggle("open");
});

// Cambiar el texto del botón según la opción seleccionada
checkboxes1.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        // Desmarcar todas las casillas excepto la seleccionada
        checkboxes1.forEach(cb => {
            if (cb !== checkbox) cb.checked = false;
        });

        // Actualizar la opción seleccionada
        if (checkbox.checked) {
            selectedOption1 = checkbox.nextElementSibling.innerText;
        } else {
            selectedOption1 = null;
        }

        // Actualizar el texto del botón
        btnText1.innerText = selectedOption1 || "Nombre Ejercicio";
    });
});

// Función de búsqueda
searchInput1.addEventListener("input", () => {
    const filter = searchInput1.value.toLowerCase();
    const items1 = listItems1.querySelectorAll(".item1");

    items1.forEach(item => {
        const label = item.querySelector(".item-text1").innerText.toLowerCase();
        item.style.display = label.includes(filter) ? "" : "none";
    });
});

// Cerrar el dropdown si se hace clic fuera de él
document.addEventListener("click", (event) => {
    if (!selectBtn1.contains(event.target) && !listItems1.contains(event.target)) {
        selectBtn1.classList.remove("open");
        listItems1.classList.remove("open");
    }
});