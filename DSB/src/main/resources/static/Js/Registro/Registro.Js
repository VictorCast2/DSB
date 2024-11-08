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
