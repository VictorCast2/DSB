package com.DevSalud.DSB.Controller;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.ExerciseLogServices;
import com.DevSalud.DSB.Service.UserServices;

import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
@Controller
@RequestMapping(path = "/Api/Users/Exercises")
public class ExercisesController {

    @Autowired
    private UserServices userService;

    @Autowired
    private ExerciseLogServices exerciseLogService;

    @ModelAttribute("allTipEjercicios")
    public List<String> tiposDeEjercicios() {
        return Arrays.asList("Aerobico", "Anaerobicos", "Fuerza", "Resistencia", "Pecho", "Pierna",
                "Hombro", "Espalda", "Biceps", "Triceps", "Abdominales", "Antebrazo", "Pantorrilla",
                "Equilibrio", "Fortalecimiento", "Flexibilidad");
    }

    @ModelAttribute("allIntecidadEjercicios")
    public List<String> intecidadDeEjercicios() {
        return Arrays.asList("Baja", "Media", "Alta");
    }

    @ModelAttribute("allNameEjercicios")
    public Map<String, List<String>> nombreDeLosEjercicios() {
        Map<String, List<String>> ejercicios = new HashMap<>();

        ejercicios.put("Aerobico", Arrays.asList(
                "Flexiones De Brazo (Push-ups)",
                "Flexiones De Diamante",
                "Flexiones Declinadas",
                "Flexiones Inclinadas",
                "Flexiones Con Palmada",
                "Flexiones De Pica (Pike push-ups)",
                "Flexiones De Brazos Abiertas",
                "Flexiones Con Pierna Elevada",
                "Flexiones Hindúes (Hindu push-ups)",
                "Fondos De Tríceps En Silla",
                "Sentadillas",
                "Sentadillas Con Salto",
                "Sentadillas Búlgaras",
                "Sentadillas De Sumo",
                "Sentadillas Con Una Pierna (Pistol squats)",
                "Estocadas", "Estocadas Laterales",
                "Estocadas Inversas",
                "Estocadas Con Salto",
                "Puentes De Glúteos",
                "Elevaciones De Talón",
                "Elevaciones De Pierna En Decúbito Supino",
                "Elevaciones De Pierna En Decúbito Lateral",
                "Elevaciones De Pierna En Decúbito Prono",
                "Elevaciones De Rodilla",
                "Elevaciones De Cadera",
                "Planchas"));

        ejercicios.put("Anaerobicos", Arrays.asList(
                "Saltos De Tijera",
                "Burpees",
                "Escaladores De Montaña",
                "Saltos De Cuerda",
                "Correr En El Lugar",
                "Correr Con Elevación De Rodillas",
                "Correr Con Talones Hacia Atrás",
                "Tuck Jumps",
                "Pasos Laterales",
                "Saltos Laterales",
                "Saltos En Caja",
                "Saltos En Cuclillas",
                "Patadas Altas",
                "Patadas De Bicicleta En El Suelo",
                "Abdominales Tipo Bicicleta",
                "Escaladores Cruzados",
                "Rodillas Al Pecho",
                "Skipping",
                "Skaters",
                "Salto De Estrella",
                "Saltos De Cangrejo",
                "Saltos A Una Pierna",
                "Sentadillas Con Salto"));

        ejercicios.put("Pecho", Arrays.asList(
                "Flexiones De Brazo",
                "Flexiones De Diamante",
                "Flexiones Inclinadas",
                "Flexiones Declinadas",
                "Flexiones Con Palmada",
                "Flexiones Hindúes",
                "Flexiones Con Pies Elevados",
                "Flexiones Con Una Mano",
                "Flexiones Con Toque De Hombro",
                "Flexiones Escalonadas",
                "Flexiones Con Dedos",
                "Flexiones Arqueras",
                "Flexiones En Anillo",
                "Flexiones Con Deslizamiento Lateral",
                "Flexiones Con Cuerpo Recto",
                "Flexiones Con Brazos Abiertos",
                "Flexiones En Forma De T",
                "Flexiones Con Rodillas Al Pecho",
                "Flexiones Con Toque De Pie",
                "Flexiones Con Elevación De Pierna",
                "Flexiones Con Una Pierna Elevada",
                "Flexiones De Cangrejo",
                "Flexiones Con Desplazamiento Lateral",
                "Flexiones Con Rotación"));

        ejercicios.put("Pierna", Arrays.asList(
                "Sentadillas",
                "Sentadillas Con Salto",
                "Sentadillas De Sumo",
                "Sentadillas Búlgaras",
                "Sentadillas De Pistola",
                "Sentadillas Con Una Pierna En Banco",
                "Sentadillas Pliométricas",
                "Sentadillas Con Pies Juntos",
                "Sentadillas Con Pies Separados",
                "Sentadillas Con Paso Lateral",
                "Sentadillas Con Elevación De Talones",
                "Sentadillas Con Elevación De Brazos",
                "Sentadillas Con Elevación De Rodillas",
                "Sentadillas Con Salto Y Rotación",
                "Sentadillas Tipo Box",
                "Sentadillas Con Toque De Tobillo",
                "Sentadillas Con Puente De Glúteos",
                "Sentadillas Con Elevación De Cadera",
                "Sentadillas Con Giro De Torso",
                "Sentadillas Con Desplazamiento Lateral",
                "Desplantes",
                "Desplantes Con Salto"));

        ejercicios.put("Hombro", Arrays.asList(
                "Flexiones De Pica", "Flexiones Hindúes", "Flexiones Declinadas",
                "Flexiones De Brazo Inclinadas",
                "Flexiones En Plancha",
                "Flexiones En T", "Flexiones Arqueras", "Flexiones Con Rotación",
                "Flexiones Con Toque De Hombro",
                "Flexiones De Tríceps",
                "Flexiones Con Desplazamiento Lateral", "Flexiones Con Rotación Del Tronco",
                "Flexiones Declinadas Con Pica",
                "Flexiones Con Cuerpo Recto", "Flexiones De Hombro En Pica",
                "Flexiones Con Desplazamiento Circular",
                "Flexiones Con Salto",
                "Flexiones Con Salto Y Giro", "Flexiones En Anillos", "Flexiones Con Dedos",
                "Fondos En Silla",
                "Fondos De Tríceps En Silla",
                "Fondos Entre Dos Sillas", "Flexiones Con Palmas Hacia Adentro",
                "Flexiones Con Banda Elástica"));

        ejercicios.put("Triceps", Arrays.asList(
                "Fondos En Silla",
                "Fondos Entre Dos Sillas",
                "Fondos En El Suelo",
                "Flexiones De Diamante",
                "Flexiones Declinadas Con Agarre Cerrado",
                "Flexiones Declinadas Con Diamante",
                "Flexiones Inclinadas Con Agarre Cerrado",
                "Flexiones Inclinadas Con Diamante",
                "Flexiones De Tríceps Con El Torso Recto",
                "Flexiones De Pica Con Agarre Cerrado",
                "Flexiones Con Toque De Hombro",
                "Flexiones Con Agarre Estrecho",
                "Flexiones Escalonadas",
                "Flexiones Con Rotación",
                "Fondos De Tríceps En Banco",
                "Fondos Con Salto",
                "Fondos De Tríceps Con Elevación De Pierna",
                "Fondos De Tríceps Con Elevación De Cadera",
                "Flexiones Con Elevación De Pierna",
                "Flexiones Con Codos Hacia Atrás",
                "Flexiones En Forma De V",
                "Fondos De Tríceps Con Toque De Codo",
                "Flexiones De Diamante Con Elevación De Pierna",
                "Flexiones De Diamante En Pica",
                "Flexiones De Tríceps En Banco",
                "Fondos De Tríceps Con Rotación"));

        ejercicios.put("Biceps", Arrays.asList(
                "Flexiones Con Agarre Estrecho",
                "Flexiones De Diamante",
                "Flexiones Escalonadas",
                "Flexiones Arqueras",
                "Flexiones Con Rotación Del Torso",
                "Flexiones Con Rotación De Brazos",
                "Flexiones De Cuerpo Recto",
                "Flexiones De Manos Invertidas",
                "Flexiones Con Palma Hacia Arriba",
                "Flexiones Con Toque De Hombro",
                "Flexiones Con Peso En Espalda",
                "Flexiones Con Elevación De Pies",
                "Flexiones De Diamante Con Toque De Codo",
                "Flexiones Inclinadas Con Agarre Estrecho",
                "Flexiones Declinadas Con Agarre Estrecho",
                "Flexiones Escalonadas Con Rotación",
                "Flexiones De Cangrejo",
                "Flexiones De Diamante En Pica",
                "Flexiones De Diamante Con Elevación De Pierna",
                "Flexiones Con Manos Invertidas Y Toque De Hombro",
                "Flexiones Con Palma Hacia Abajo",
                "Flexiones De Diamante Declinadas",
                "Flexiones Con Toque De Hombro Y Palma Invertida",
                "Flexiones De Diamante Con Elevación De Cadera",
                "Flexiones Con Elevación De Talones",
                "Flexiones De Diamante Con Elevación De Pie",
                "Flexiones Con Codos Hacia Afuera",
                "Flexiones De Diamante Con Elevación De Cadera",
                "Flexiones Con Rotación De Codo",
                "Flexiones Escalonadas Con Elevación De Pierna",
                "Flexiones En Pica Con Agarre Estrecho",
                "Flexiones De Diamante Con Rotación",
                "Flexiones Con Agarre Estrecho Con Giro",
                "Flexiones De Diamante Con Rotación De Torso"));

        ejercicios.put("Espalda", Arrays.asList(
                "Flexiones Hindúes",
                "Flexiones Con Pica",
                "Flexiones Arqueras",
                "Flexiones Con Giro De Torso",
                "Flexiones En T",
                "Flexiones Con Toque De Hombro",
                "Flexiones Con Rotación",
                "Flexiones Con Codo Cruzado",
                "Flexiones Tipo Spiderman",
                "Flexiones Con Pica Y Desplazamiento Lateral",
                "Flexiones Estilo Cangrejo",
                "Puente De Glúteos",
                "Puente De Cadera Con Elevación De Pierna",
                "Elevación De Pelvis",
                "Plancha Con Giro De Torso",
                "Plancha Lateral Con Elevación De Brazo",
                "Plancha Con Elevación De Pierna",
                "Planchas Laterales",
                "Flexiones Declinadas",
                "Flexiones Inclinadas",
                "Escaladores De Montaña",
                "Pull-ups Dn Barra Casera",
                "Chin-ups En Barra Casera",
                "Flexiones De Tríceps",
                "Flexiones De Puente",
                "Plancha En Posición De Superman"));

        ejercicios.put("Abdominales", Arrays.asList(
                "Abdominales Tradicionales",
                "Abdominales Tipo Bicicleta",
                "Abdominales Con Piernas Elevadas",
                "Abdominales Oblicuos",
                "Abdominales En V",
                "Plancha Tradicional",
                "Plancha Lateral",
                "Plancha Lateral Con Elevación De Pierna",
                "Plancha Con Elevación De Brazo",
                "Plancha Con Toque De Hombro",
                "Plancha Con Elevación De Pierna",
                "Plancha Con Desplazamiento Lateral",
                "Plancha Con Elevación De Cadera",
                "Plancha Con Toque De Codo",
                "Abdominales Invertidos",
                "Abdominales Con Rodillas Al Pecho",
                "Abdominales Con Torsión De Cadera",
                "Abdominales Tipo Rana",
                "Abdominales De Doble Pierna",
                "Abdominales Con Toque De Tobillo",
                "Abdominales Tipo Puente",
                "Abdominales Con Toque De Codo",
                "Plancha Con Giro De Torso",
                "Plancha Con Giro De Cadera",
                "Plancha Con Elevación De Pie",
                "Plancha Con Desplazamiento Circular",
                "Escaladores De Montaña",
                "Abdominales Con Elevación De Pierna Y Giro De Torso",
                "Abdominales Con Toque De Pie",
                "Abdominales Con Elevación De Cadera",
                "Abdominales Con Toque De Talón"));

        ejercicios.put("Pantorrilla", Arrays.asList(
                "Elevaciones De Talón",
                "Elevaciones De Talón Con Una Pierna",
                "Elevaciones De Talón En Escalón",
                "Elevaciones De Talón Con Pies Juntos",
                "Elevaciones De Talón Con Pies Separados",
                "Elevaciones De Talón Con Pies Hacia Afuera",
                "Elevaciones De Talón Con Pies Hacia Adentro",
                "Elevaciones De Talón Con Rebote",
                "Elevaciones De Talón Con Salto",
                "Elevaciones De Talón Con Toque De Cadera",
                "Elevaciones De Talón Con Elevación De Cadera",
                "Elevaciones De Talón Con Flexión De Rodilla",
                "Elevaciones De Talón En Banco",
                "Elevaciones De Talón Con Rotación",
                "Elevaciones De Talón Alternadas",
                "Elevaciones De Talón En Forma De Estrella",
                "Elevaciones De Talón En Cruz"));

        ejercicios.put("Antebrazo", Arrays.asList(
                "Flexiones Con Manos Invertidas",
                "Flexiones Con Agarre Estrecho",
                "Flexiones De Diamante",
                "Flexiones Con Dedos",
                "Flexiones Con Pica",
                "Flexiones Con Toque De Hombro",
                "Flexiones Arqueras (Archer Push-Ups)",
                "Flexiones Con Rotación",
                "Flexiones Con Cuerpo Recto (Planche Push-Ups)",
                "Flexiones Escalonadas (Staggered Push-Ups)",
                "Flexiones Tipo Spiderman",
                "Flexiones De Pica Con Palma Hacia Arriba",
                "Flexiones De Pica Con Palma Hacia Abajo",
                "Flexiones Con Toque De Hombro Y Rotación",
                "Flexiones Con Dedos Y Desplazamiento Lateral",
                "Flexiones Con Peso En Espalda",
                "Flexiones Con Toque De Codo",
                "Flexiones De Diamante Con Salto",
                "Flexiones Con Toque De Codo Y Rotación",
                "Flexiones Con Dedos Y Salto",
                "Flexiones Con Cuerpo Recto Y Giro De Torso",
                "Flexiones Inclinadas Con Manos Invertidas",
                "Flexiones Declinadas Con Manos Invertidas",
                "Flexiones Con Toque De Hombro Y Elevación De Cadera",
                "Flexiones Con Dedos Y Toque De Codo",
                "Flexiones Con Agarre Estrecho Y Rotación",
                "Flexiones Con Desplazamiento Lateral",
                "Flexiones Con Toque De Codo Y Rotación De Torso",
                "Flexiones Con Dedos En Forma De T",
                "Flexiones Con Cuerpo Recto Con Elevación De Cadera",
                "Flexiones Con Dedos Y Salto Hacia Adelante",
                "Flexiones De Diamante Con Toque De Codo",
                "Flexiones Con Cuerpo Recto Y Salto",
                "Flexiones Con Dedos Y Rotación"));

        ejercicios.put("Flexibilidad", Arrays.asList(
                "Estiramiento De Cuádriceps",
                "Estiramiento De Isquiotibiales",
                "Estiramiento De Pantorrillas",
                "Estiramiento De La Parte Baja De La Espalda",
                "Estiramiento De Glúteos",
                "Estiramiento De Cadera",
                "Estiramiento De Flexores De Cadera",
                "Estiramiento De Los Músculos De La Ingle",
                "Estiramiento De Aductores",
                "Estiramiento De Abductores",
                "Estiramiento De Tríceps",
                "Estiramiento De Bíceps",
                "Estiramiento De Deltoides",
                "Estiramiento De Trapecio",
                "Estiramiento De Cuello",
                "Estiramiento De Antebrazos",
                "Estiramiento De Pecho",
                "Estiramiento De Hombros",
                "Estiramiento De La Parte Alta De La Espalda",
                "Estiramiento De Muñeca"));

        ejercicios.put("Equilibrio", Arrays.asList(
                "Equilibrio A Una Pierna",
                "Equilibrio A Una Pierna Con Ojo Cerrado",
                "Equilibrio En Puntillas",
                "Equilibrio En Talones",
                "Estocadas Con Equilibrio",
                "Equilibrio Con Pierna Cruzada",
                "Equilibrio Con Movimiento De Brazos",
                "Equilibrio Con Elevación Lateral De Pierna",
                "Equilibrio Con Elevación Frontal De Pierna",
                "Flexión A Una Pierna",
                "Sentadillas A Una Pierna",
                "Equilibrio Con Elevación De Cadera",
                "Equilibrio Con Elevación De Rodilla",
                "Estocada Inversa Con Equilibrio",
                "Sentadilla De Pistola",
                "Salto Y Equilibrio A Una Pierna",
                "Saltos Laterales Con Equilibrio",
                "Equilibrio En Silla",
                "Planchas Laterales",
                "Equilibrio En T"));

        ejercicios.put("Fortalecimiento", Arrays.asList(
                "Flexiones De Brazo (Push-Ups)",
                "Flexiones De Diamante",
                "Flexiones Arqueras (Archer Push-Ups)",
                "Flexiones Hindúes (Hindu Push-Ups)",
                "Flexiones Escalonadas (Staggered Push-Ups)",
                "Fondos De Tríceps En Silla",
                "Sentadillas (Squats)",
                "Sentadillas Con Salto",
                "Sentadillas De Sumo",
                "Sentadillas Con Elevación De Talón",
                "Estocadas (Lunges)",
                "Estocadas Con Salto",
                "Desplantes Laterales",
                "Sentadillas Búlgaras",
                "Sentadillas Con Una Pierna (Pistol Squats)",
                "Plancha Tradicional",
                "Plancha Lateral",
                "Plancha Con Elevación De Pierna",
                "Plancha Con Toque De Hombro",
                "Plancha Con Giro De Torso",
                "Puentes De Glúteos"));

        ejercicios.put("Fuerza", Arrays.asList(
                "Flexiones De Brazo (Push-Ups)",
                "Flexiones De Diamante",
                "Flexiones Inclinadas",
                "Flexiones Declinadas",
                "Flexiones Con Aplauso",
                "Fondos De Tríceps En Silla",
                "Sentadillas (Squats)",
                "Sentadillas Con Salto",
                "Sentadillas De Sumo",
                "Sentadillas Con Elevación De Talón",
                "Estocadas (Lunges)",
                "Desplantes Laterales",
                "Estocadas Con Salto",
                "Sentadillas Búlgaras",
                "Puentes De Glúteos",
                "Puentes De Glúteos Con Elevación De Pierna",
                "Plancha Tradicional",
                "Plancha Lateral",
                "Plancha Con Elevación De Pierna",
                "Abdominales Tipo Bicicleta",
                "Abdominales Tradicionales (Crunches)",
                "Abdominales Laterales (Russian Twists)",
                "Escaladores De Montaña (Mountain Climbers)",
                "Burpees"));

        ejercicios.put("Resistencia", Arrays.asList(
                "Saltos De Tijera (Jumping Jacks)",
                "Burpees",
                "Escaladores De Montaña (Mountain Climbers)",
                "Flexiones De Brazo (Push-Ups)",
                "Fondos De Tríceps En Silla",
                "Sentadillas (Squats)",
                "Sentadillas Con Salto",
                "Estocadas (Lunges)",
                "Desplantes Laterales",
                "Sentadillas De Pistola",
                "Puentes De Glúteos",
                "Plancha Tradicional",
                "Plancha Lateral",
                "Abdominales Tipo Bicicleta",
                "Abdominales Tradicionales (Crunches)",
                "Tuck Jumps",
                "Saltos Laterales (Lateral Jumps)",
                "Sentadillas Con Paso Lateral",
                "Plancha Con Toque De Hombro",
                "Flexiones Declinadas",
                "Flexiones Con Pica",
                "Flexiones Con Salto Y Palmada",
                "Flexiones Con Toque De Codo",
                "Flexiones En Plancha",
                "Flexiones Escalonadas",
                "Flexiones De Diamante",
                "Sentadillas De Sumo",
                "Burpees Con Salto"));

        return ejercicios;
    }

    @ModelAttribute("allTiposEjercicio")
    public List<String> tiposDeEjercicio() {
        return Arrays.asList(
                "Aerobico", "Anaerobicos", "Fuerza", "Resistencia",
                "Pierna", "Hombro", "Espalda", "Biceps",
                "Triceps", "Abdominales", "Antebrazo",
                "Pantorrilla", "Equilibrio", "Fortalecimiento",
                "Flexibilidad");
    }

    @ModelAttribute("allNombresEjercicio")
    public List<String> nombresDeEjercicio() {
        return Arrays.asList(
                "Flexiones De Brazo", "Flexiones Diamante", "Flexiones Declinadas",
                "Flexiones Inclinadas", "Flexiones Con Palma");
    }

    @GetMapping("/RegistroEjercicio")
    public String showExerciseForm(Model model) {
        model.addAttribute("exerciseLog", new ExerciseLogModel());
        return "Exercises/FormularioRegistroEjercicio";
    }

    @PostMapping("/RegistroEjercicio")
    public String registerExercise(@ModelAttribute("exerciseLog") ExerciseLogModel exerciseLog, Model model,
            HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            UserModel user = userService.getUserById(userId);
            exerciseLog.setUser(user);
            exerciseLogService.saveExerciseLog(exerciseLog);
            model.addAttribute("message", "Registro exitoso");
            System.out.println("Fecha de inicio: " + exerciseLog.getStrartDate());
            System.out.println("Fecha final: " + exerciseLog.getFinalDate());
            return "redirect:/Api/Users/Exercises/TablaEjercicio";
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login";
        }
    }

    @GetMapping("/TablaEjercicio")
    public String TablaRegistroEjercicio(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm a");
            List<ExerciseLogModel> exerciseLogs = exerciseLogService.getAllExerciseLogs()
                    .stream()
                    .filter(exerciseLog -> exerciseLog.getUser().getId().equals(userId))
                    .collect(Collectors.toList());
            // Formatear las fechas antes de añadirlas al modelo
            exerciseLogs.forEach(log -> {
                log.setFormattedStartDate(log.getStrartDate().format(formatter));
                log.setFormattedFinalDate(log.getFinalDate().format(formatter));
            });
            model.addAttribute("exerciseLogs", exerciseLogs);
            return "Exercises/TablaRegistroEjercicio";
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login";
        }
    }

    @GetMapping("/EditarEjercicio/{id}")
    public String showEditEjercicio(@PathVariable Long id, Model model) {
        // Obtener el ejercicio específico a editar
        ExerciseLogModel exerciseLog = exerciseLogService.getExerciseLogById(id);
        // Agregar atributos al modelo
        model.addAttribute("exerciseLog", exerciseLog);
        return "Exercises/FormularioEditarEjercicio";
    }

    @PostMapping("/EditarEjercicio")
    public String editarEjercicio(@ModelAttribute ExerciseLogModel exerciseLog) {
        exerciseLogService.UpdateExerciseLog(exerciseLog);
        return "redirect:/Api/Users/Exercises/TablaEjercicio"; // Redirige después de la edición
    }

    @GetMapping("/EliminarEjercicio/{id}")
    public String deleteExercise(@PathVariable Long id) {
        exerciseLogService.DeleteExerciseLog(id);
        return "redirect:/Api/Users/Exercises/TablaEjercicio";
    }

    @GetMapping("/Home")
    public String homeRegistroEjercicio() {
        return "/Exercises/HomeRegistroEjercicio";
    }

}
