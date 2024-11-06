// Esta función se llama cuando cambia el tipo de ejercicio
function cargarEjercicios() {
    var tipoEjercicio = document.getElementById("tipoEjercicio").value;
    var nombreEjercicio = document.getElementById("nombreEjercicio");
    nombreEjercicio.innerHTML = '<option value="" selected disabled>Seleccione un ejercicio</option>'; // Limpiar la lista de ejercicios

    / Obtener los ejercicios del tipo seleccionado desde Thymeleaf
    var ejerciciosPorTipo = /*[[${ejerciciosPorTipo}]]*/ {};
    var ejercicios = ejerciciosPorTipo[tipoEjercicio] || [];

    // Añadir los ejercicios correspondientes a la lista desplegable
    ejercicios.forEach(function (ejercicio) {
        var option = document.createElement("option");
        option.value = ejercicio;
        option.text = ejercicio;
        nombreEjercicio.appendChild(option);
    });
}