const clockElement = document.getElementById("clock");
const dateElement = document.getElementById("date-display");
const dateTimeInput = document.getElementById("datetime");

let isCustomTime = false; // Marca si se está usando una hora personalizada

const daysOfWeek = [
  "Domingo",
  "Lunes",
  "Martes",
  "Miércoles",
  "Jueves",
  "Viernes",
  "Sábado",
];
const monthsOfYear = [
  "Enero",
  "Febrero",
  "Marzo",
  "Abril",
  "Mayo",
  "Junio",
  "Julio",
  "Agosto",
  "Septiembre",
  "Octubre",
  "Noviembre",
  "Diciembre",
];

// Formatear la fecha en el formato deseado
function formatDate(date) {
  const dayOfWeek = daysOfWeek[date.getDay()];
  const month = monthsOfYear[date.getMonth()];
  const day = date.getDate();
  const year = date.getFullYear();
  return `${dayOfWeek}, ${month} ${day}, ${year}`;
}

// Actualizar el reloj y la fecha según el valor seleccionado del input
function updateDisplay() {
  const selectedDateTime = dateTimeInput.value;

  if (selectedDateTime) {
    const customDate = new Date(selectedDateTime);
    const formattedTime = customDate.toTimeString().split(" ")[0]; // Obtiene la hora en formato HH:MM:SS

    clockElement.textContent = formattedTime; // Actualiza el reloj con la hora personalizada
    dateElement.textContent = formatDate(customDate); // Actualiza la fecha con el formato deseado
    isCustomTime = true; // Marca que se ha utilizado una hora personalizada
  }
}

// Mostrar la hora y fecha actuales
function showCurrentTime() {
  if (!isCustomTime) {
    const now = new Date();
    const hours = String(now.getHours()).padStart(2, "0");
    const minutes = String(now.getMinutes()).padStart(2, "0");
    const seconds = String(now.getSeconds()).padStart(2, "0");

    clockElement.textContent = `${hours}:${minutes}:${seconds}`; // Actualiza el reloj con la hora actual
    dateElement.textContent = formatDate(now); // Actualiza la fecha con el formato deseado
  } else {
    // Si se está utilizando una hora personalizada, la actualizamos cada segundo
    const customDate = new Date(dateTimeInput.value);
    const formattedTime = customDate.toTimeString().split(" ")[0]; // Obtiene la hora en formato HH:MM:SS

    clockElement.textContent = formattedTime; // Actualiza el reloj con la hora personalizada
    dateElement.textContent = formatDate(customDate); // Actualiza la fecha con el formato deseado
  }
}

// Restablecer a la hora y fecha actuales
function resetToCurrentTime() {
  isCustomTime = false; // Restablece la bandera de tiempo personalizado
  dateTimeInput.value = ""; // Limpia el input datetime
  showCurrentTime(); // Muestra la hora actual
}

// Actualizar el reloj cada segundo si no se usa una hora personalizada
setInterval(showCurrentTime, 1000);

// Inicializar con la hora y fecha actuales
showCurrentTime();

// Detectar cambios en el input datetime-local para actualizar el reloj digital
dateTimeInput.addEventListener("change", updateDisplay);
