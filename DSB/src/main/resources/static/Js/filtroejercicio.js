document.addEventListener('DOMContentLoaded', function() {
    const tipoCheckboxes = document.querySelectorAll('.checkbox'); // Checkboxes de Tipo Ejercicio
    const nombreCheckboxes = document.querySelectorAll('.checkbox1'); // Checkboxes de Nombre Ejercicio

    tipoCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            const selectedTipos = Array.from(tipoCheckboxes)
                .filter(cb => cb.checked)
                .map(cb => cb.value); // Obtener los tipos seleccionados

            nombreCheckboxes.forEach(nombreCheckbox => {
                const tipoEjercicio = nombreCheckbox.getAttribute('data-tipo');
                if (selectedTipos.includes(tipoEjercicio)) {
                    nombreCheckbox.closest('li').style.display = ''; // Mostrar
                } else {
                    nombreCheckbox.closest('li').style.display = 'none'; // Ocultar
                }
            });
        });
    });
});