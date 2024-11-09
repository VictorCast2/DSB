const selectBtn2 = document.querySelector(".select-btn2"),
  listItems2 = document.querySelector(".list-items2"),
  checkboxes2 = document.querySelectorAll(".checkbox2"),
  btnText2 = document.querySelector(".btn-text2"),
  searchInput2 = document.querySelector(".search2 input");

let selectedOption2 = null;

// Mostrar u ocultar el dropdown
selectBtn2.addEventListener("click", () => {
  selectBtn2.classList.toggle("open");
  listItems2.classList.toggle("open");
});

// Cambiar el texto del botón según la opción seleccionada
checkboxes2.forEach((checkbox) => {
  checkbox.addEventListener("change", () => {
    // Desmarcar todas las casillas excepto la seleccionada
    checkboxes2.forEach((cb) => {
      if (cb !== checkbox) cb.checked = false;
    });

    // Actualizar la opción seleccionada
    if (checkbox.checked) {
      selectedOption2 = checkbox.nextElementSibling.innerText;
    } else {
      selectedOption2 = null;
    }

    // Actualizar el texto del botón
    btnText2.innerText = selectedOption2 || "Intensidad Ejercicio";
  });
});

// Función de búsqueda
searchInput2.addEventListener("input", () => {
  const filter = searchInput2.value.toLowerCase();
  const items2 = listItems2.querySelectorAll(".item2");

  items2.forEach((item) => {
    const label = item.querySelector(".item-text2").innerText.toLowerCase();
    item.style.display = label.includes(filter) ? "" : "none";
  });
});

// Cerrar el dropdown si se hace clic fuera de él
document.addEventListener("click", (event) => {
  if (
    !selectBtn2.contains(event.target) &&
    !listItems2.contains(event.target)
  ) {
    selectBtn2.classList.remove("open");
    listItems2.classList.remove("open");
  }
});
