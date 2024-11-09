const selectBtn6 = document.querySelector(".select-btn6"),
  listItems6 = document.querySelector(".list-items6"),
  checkboxes6 = document.querySelectorAll(".checkbox6"),
  btnText6 = document.querySelector(".btn-text6"),
  searchInput6 = document.querySelector(".search6 input");

let selectedOption6 = null;

// Mostrar u ocultar el dropdown
selectBtn6.addEventListener("click", () => {
  selectBtn6.classList.toggle("open");
  listItems6.classList.toggle("open");
});

// Cambiar el texto del botón según la opción seleccionada
checkboxes6.forEach((checkbox) => {
  checkbox.addEventListener("change", () => {
    // Desmarcar todas las casillas excepto la seleccionada
    checkboxes6.forEach((cb) => {
      if (cb !== checkbox) cb.checked = false;
    });

    // Actualizar la opción seleccionada
    if (checkbox.checked) {
      selectedOption6 = checkbox.nextElementSibling.innerText;
    } else {
      selectedOption6 = null;
    }

    // Actualizar el texto del botón
    btnText6.innerText = selectedOption6 || "Comida Cena";
  });
});

// Función de búsqueda
searchInput6.addEventListener("input", () => {
  const filter = searchInput6.value.toLowerCase();
  const items6 = listItems6.querySelectorAll(".item6");

  items6.forEach((item) => {
    const label = item.querySelector(".item-text6").innerText.toLowerCase();
    item.style.display = label.includes(filter) ? "" : "none";
  });
});

// Cerrar el dropdown si se hace clic fuera de él
document.addEventListener("click", (event) => {
  if (
    !selectBtn6.contains(event.target) &&
    !listItems6.contains(event.target)
  ) {
    selectBtn6.classList.remove("open");
    listItems6.classList.remove("open");
  }
});
