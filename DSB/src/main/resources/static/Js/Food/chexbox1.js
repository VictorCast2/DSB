const selectBtn1 = document.querySelector(".select-btn1"),
  listItems1 = document.querySelector(".list-items1"),
  checkboxes1 = document.querySelectorAll(".checkbox1"),
  btnText1 = document.querySelector(".btn-text1"),
  searchInput1 = document.querySelector(".search1 input");

// Variable para almacenar la opción seleccionada
let selectedOption1 = null;

// Toggle dropdown visibility when the button is clicked
selectBtn1.addEventListener("click", () => {
  selectBtn1.classList.toggle("open");
  listItems1.classList.toggle("open");
});

// Update button text based on selected checkbox
checkboxes1.forEach((checkbox) => {
  checkbox.addEventListener("change", () => {
    // Desmarcar todas las casillas excepto la seleccionada
    checkboxes1.forEach((cb) => {
      if (cb !== checkbox) cb.checked = false;
    });

    // Actualizar la opción seleccionada
    if (checkbox.checked) {
      selectedOption1 = checkbox.nextElementSibling.innerText;
    } else {
      selectedOption1 = null;
    }

    // Actualizar el texto del botón
    btnText1.innerText = selectedOption1 || "Comida Desayuno";
  });
});

// Implement search functionality
searchInput1.addEventListener("input", () => {
  const filter = searchInput1.value.toLowerCase();
  const items1 = listItems1.querySelectorAll(".item1");

  items1.forEach((item) => {
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
  if (
    !selectBtn1.contains(event.target) &&
    !listItems1.contains(event.target)
  ) {
    selectBtn1.classList.remove("open");
    listItems1.classList.remove("open");
  }
});
