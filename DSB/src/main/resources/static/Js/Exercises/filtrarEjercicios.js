document.addEventListener('DOMContentLoaded', function () {
    const tipoEjercicioCheckboxes = document.querySelectorAll('.contenido-registroejercicio .checkbox');
    const nombreEjercicioItems = document.querySelectorAll('.contenido-registroejercicio .scrollable-content1 li');

    // Función para filtrar los ejercicios
    function filterEjercicios() {
        // Obtener todos los tipos seleccionados
        const selectedTipos = Array.from(tipoEjercicioCheckboxes)
            .filter(checkbox => checkbox.checked)
            .map(checkbox => checkbox.value);
    }
})