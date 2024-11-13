document.addEventListener("DOMContentLoaded", function () {
  // Obtener el formulario y los campos de contraseña
  const form = document.querySelector(
    'form[th\\:action="@{/Api/Users/Registro}"]'
  );
  const passwordField = form.querySelector('input[name="password"]');
  const newPasswordField = form.querySelector('input[name="NewPassword"]');

  // Añadir evento al enviar el formulario
  form.addEventListener("submit", function (event) {
    // Prevenir el envío del formulario
    event.preventDefault();

    // Verificar si las contraseñas coinciden
    if (passwordField.value !== newPasswordField.value) {
      alert("Las contraseñas no coinciden.");
    } else {
      // Si coinciden, enviar el formulario
      form.submit();
    }
  });
});

// Menu desplegable de enfermedades cronicas
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
checkboxes6.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        // Desmarcar todas las casillas excepto la seleccionada
        checkboxes6.forEach(cb => {
            if (cb !== checkbox) cb.checked = false;
        });

        // Actualizar la opción seleccionada
        if (checkbox.checked) {
            selectedOption6 = checkbox.nextElementSibling.innerText;
        } else {
            selectedOption6 = null;
        }

        // Actualizar el texto del botón
        btnText6.innerText = selectedOption6 || "Enfermedades Crónicas";
    });
});

// Función de búsqueda
searchInput6.addEventListener("input", () => {
    const filter6 = searchInput6.value.toLowerCase();
    const items6 = listItems6.querySelectorAll(".item6");

    items6.forEach(item => {
        const label6 = item.querySelector(".item-text6").innerText.toLowerCase();
        item.style.display = label6.includes(filter6) ? "" : "none";
    });
});

// Cerrar el dropdown si se hace clic fuera de él
document.addEventListener("click", (event) => {
    if (!selectBtn6.contains(event.target) && !listItems6.contains(event.target)) {
        selectBtn6.classList.remove("open");
        listItems6.classList.remove("open");
    }
});

// Menu desplegable de sexo
const selectBtn7 = document.querySelector(".select-btn7"),
    listItems7 = document.querySelector(".list-items7"),
    checkboxes7 = document.querySelectorAll(".checkbox7"),
    btnText7 = document.querySelector(".btn-text7"),
    searchInput7 = document.querySelector(".search7 input");

let selectedOption7 = null;

// Mostrar u ocultar el dropdown
selectBtn7.addEventListener("click", () => {
    selectBtn7.classList.toggle("open");
    listItems7.classList.toggle("open");
});

// Cambiar el texto del botón según la opción seleccionada
checkboxes7.forEach(checkbox => {
    checkbox.addEventListener("change", () => {
        // Desmarcar todas las casillas excepto la seleccionada
        checkboxes7.forEach(cb => {
            if (cb !== checkbox) cb.checked = false;
        });

        // Actualizar la opción seleccionada
        if (checkbox.checked) {
            selectedOption7 = checkbox.nextElementSibling.innerText;
        } else {
            selectedOption7 = null;
        }

        // Actualizar el texto del botón
        btnText7.innerText = selectedOption7 || "Sexo";
    });
});

// Función de búsqueda
searchInput7.addEventListener("input", () => {
    const filter7 = searchInput7.value.toLowerCase();
    const items7 = listItems7.querySelectorAll(".item7");

    items7.forEach(item => {
        const label7 = item.querySelector(".item-text7").innerText.toLowerCase();
        item.style.display = label7.includes(filter7) ? "" : "none";
    });
});

// Cerrar el dropdown si se hace clic fuera de él
document.addEventListener("click", (event) => {
    if (!selectBtn7.contains(event.target) && !listItems7.contains(event.target)) {
        selectBtn7.classList.remove("open");
        listItems7.classList.remove("open");
    }
});

