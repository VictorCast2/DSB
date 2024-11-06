function onTipoEjercicioChange() {
            var selectedTipo = document.getElementById('tipoEjercicioSelect').value;
            window.location.href = '/Api/Users/Exercises/RegistroEjercicio?selectedTipo=' + selectedTipo;
        }