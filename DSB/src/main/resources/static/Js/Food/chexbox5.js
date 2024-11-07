const selectBtn5 = document.querySelector(".select-btn5"),
  listItems5 = document.querySelector(".list-items5"),
  checkboxes5 = document.querySelectorAll(".checkbox5"),
  btnText5 = document.querySelector(".btn-text5"),
  searchInput5 = document.querySelector(".search5 input");

let selectedOption5 = null;

// Mostrar u ocultar el dropdown
selectBtn5.addEventListener("click", () => {
  selectBtn5.classList.toggle("open");
  listItems5.classList.toggle("open");
});

// Cambiar el texto del botón según la opción seleccionada
checkboxes5.forEach((checkbox) => {
  checkbox.addEventListener("change", () => {
    // Desmarcar todas las casillas excepto la seleccionada
    checkboxes5.forEach((cb) => {
      if (cb !== checkbox) cb.checked = false;
    });

    // Actualizar la opción seleccionada
    if (checkbox.checked) {
      selectedOption5 = checkbox.nextElementSibling.innerText;
    } else {
      selectedOption5 = null;
    }

    // Actualizar el texto del botón
    btnText5.innerText = selectedOption5 || "Categoria Cena";
  });
});

// Función de búsqueda
searchInput5.addEventListener("input", () => {
  const filter = searchInput5.value.toLowerCase();
  const items5 = listItems5.querySelectorAll(".item5");

  items5.forEach((item) => {
    const label = item.querySelector(".item-text5").innerText.toLowerCase();
    item.style.display = label.includes(filter) ? "" : "none";
  });
});

// Cerrar el dropdown si se hace clic fuera de él
document.addEventListener("click", (event) => {
  if (
    !selectBtn5.contains(event.target) &&
    !listItems5.contains(event.target)
  ) {
    selectBtn5.classList.remove("open");
    listItems5.classList.remove("open");
  }
});
