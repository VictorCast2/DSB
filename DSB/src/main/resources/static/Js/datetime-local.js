// Configuración para el primer reloj (Fecha Inicial)
const clockElement1 = document.getElementById("clock");
const dateElement1 = document.getElementById("date-display");
const datetimeInput1 = document.getElementById("datetime");
let isCustomTime1 = false;

// Configuración para el segundo reloj (Fecha Final)
const clockElement2 = document.getElementById("clock1");
const dateElement2 = document.getElementById("date-display1");
const datetimeInput2 = document.getElementById("datetime1");
let isCustomTime2 = false;

// Días y meses en español
const daysOfWeek = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
const monthsOfYear = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];

// Función para formatear la fecha
function formatDate(date) {
    const dayOfWeek = daysOfWeek[date.getDay()];
    const month = monthsOfYear[date.getMonth()];
    const day = date.getDate();
    const year = date.getFullYear();
    return `${dayOfWeek}, ${month} ${day}, ${year}`;
}

// Función para actualizar el primer reloj al cambiar la fecha/hora
function updateDisplay1() {
    const selectedDateTime = datetimeInput1.value;
    if (selectedDateTime) {
        const customDate = new Date(selectedDateTime);
        const formattedTime = `${String(customDate.getHours()).padStart(2, '0')}:${String(customDate.getMinutes()).padStart(2, '0')}:00`;
        
        clockElement1.textContent = formattedTime;
        dateElement1.textContent = formatDate(customDate);
        isCustomTime1 = true;
    }
}

// Función para actualizar el segundo reloj al cambiar la fecha/hora
function updateDisplay2() {
    const selectedDateTime = datetimeInput2.value;
    if (selectedDateTime) {
        const customDate = new Date(selectedDateTime);
        const formattedTime = `${String(customDate.getHours()).padStart(2, '0')}:${String(customDate.getMinutes()).padStart(2, '0')}:00`;
        
        clockElement2.textContent = formattedTime;
        dateElement2.textContent = formatDate(customDate);
        isCustomTime2 = true;
    }
}

// Función para mostrar la hora actual en el primer reloj si no es personalizada
function showCurrentTime1() {
    if (!isCustomTime1) {
        const now = new Date();
        const hours = String(now.getHours()).padStart(2, '0');
        const minutes = String(now.getMinutes()).padStart(2, '0');
        const seconds = String(now.getSeconds()).padStart(2, '0');
        
        clockElement1.textContent = `${hours}:${minutes}:${seconds}`;
        dateElement1.textContent = formatDate(now);
    }
}

// Función para mostrar la hora actual en el segundo reloj si no es personalizada
function showCurrentTime2() {
    if (!isCustomTime2) {
        const now = new Date();
        const hours = String(now.getHours()).padStart(2, '0');
        const minutes = String(now.getMinutes()).padStart(2, '0');
        const seconds = String(now.getSeconds()).padStart(2, '0');
        
        clockElement2.textContent = `${hours}:${minutes}:${seconds}`;
        dateElement2.textContent = formatDate(now);
    }
}

// Función para restablecer el primer reloj a la hora actual
function resetToCurrentTime1() {
    isCustomTime1 = false;
    showCurrentTime1();
}

// Función para restablecer el segundo reloj a la hora actual
function resetToCurrentTime2() {
    isCustomTime2 = false;
    showCurrentTime2();
}

// Actualizar cada reloj cada segundo
setInterval(showCurrentTime1, 1000);
setInterval(showCurrentTime2, 1000);

// Inicializar con la hora y fecha actuales
showCurrentTime1();
showCurrentTime2();

// Asignar los eventos de cambio de fecha/hora para cada input
datetimeInput1.addEventListener("change", updateDisplay1);
datetimeInput2.addEventListener("change", updateDisplay2);
