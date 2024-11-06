package com.DevSalud.DSB.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping(path = "/Api/Users/Exercises")
public class ExercisesController {

    @ModelAttribute("allTipEjercicios")
    public List<String> tiposDeEjercicios() {
        return Arrays.asList("Aerobico", "Anaerobicos", "Fuerza", "Resistencia", "Pecho", "Pierna", "Hombro", 
                "Espalda", "Biceps", "Triceps", "Abdominales", "Antebrazo", "Pantorrilla", 
                "Equilibrio", "Fortalecimiento", "Flexibilidad"
        );
    }

    @ModelAttribute("allNameEjercicios")
    public Map<String, List<String>> nombreDeLosEjercicios() {
        Map<String, List<String>> ejercicios = new HashMap<>();

        ejercicios.put("Aerobico", Arrays.asList(
        "Flexiones De Brazo (Push-ups)", "Flexiones De Diamante", "Flexiones Declinadas", "Flexiones Inclinadas",
        "Flexiones Con Palmada", "Flexiones De Pica (Pike push-ups)", "Flexiones De Brazos Abiertas", 
        "Flexiones Con Pierna Elevada", "Flexiones Hindúes (Hindu push-ups)", "Fondos De Tríceps En Silla",
        "Sentadillas", "Sentadillas Con Salto", "Sentadillas Búlgaras", "Sentadillas De Sumo",
        "Sentadillas Con Una Pierna (Pistol squats)", "Estocadas", "Estocadas Laterales", "Estocadas Inversas",
        "Estocadas Con Salto", "Puentes De Glúteos", "Elevaciones De Talón", "Elevaciones De Pierna En Decúbito Supino",
        "Elevaciones De Pierna En Decúbito Lateral", "Elevaciones De Pierna En Decúbito Prono", "Elevaciones De Rodilla",
        "Elevaciones De Cadera", "Planchas", "Planchas Laterales", "Planchas Con Toque De Hombro",
        "Planchas Con Elevación De Pierna", "Burpees", "Alpinistas", "Abdominales Tradicionales",
        "Abdominales Tipo Bicicleta", "Abdominales Con Toque De Talones", "Abdominales Con Piernas Elevadas",
        "Abdominales Laterales", "Abdominales En V", "Levantamiento De Cadera", "Escaladores En El Suelo",
        "Escaladores Cruzados", "Tuck Jumps", "Rodillas Al Pecho", "Sentadillas Tipo Sumo Con Peso Corporal",
        "Patadas Laterales", "Patadas Frontales", "Elevaciones De Talones Sobre Un Escalón", "Fondos De Tríceps Con Una Silla",
        "Flexiones Con Las Rodillas En El Suelo", "Flexiones De Bíceps Con Bandas Elásticas", 
        "Flexiones De Tríceps Con Bandas Elásticas", "Elevaciones Laterales Con Bandas Elásticas", 
        "Elevaciones Frontales Con Bandas Elásticas", "Elevaciones De Cadera Con Bandas Elásticas", 
        "Peso Muerto Con Bandas Elásticas", "Sentadillas Con Bandas Elásticas", "Prensa De Hombros Con Bandas Elásticas",
        "Desplantes Con Bandas Elásticas", "Remo Con Bandas Elásticas", "Desplantes Laterales Con Bandas Elásticas",
        "Tirones De Banda Elástica", "Flexiones De Bíceps Con Mancuernas", "Flexiones De Tríceps Con Mancuernas",
        "Prensa De Pecho Con Mancuernas", "Peso Muerto Con Mancuernas", "Remo Con Mancuernas", 
        "Prensa De Hombros Con Mancuernas", "Elevaciones Laterales Con Mancuernas", "Elevaciones Frontales Con Mancuernas",
        "Sentadillas Con Mancuernas", "Desplantes Con Mancuernas", "Fondos Con Mancuernas", 
        "Extensiones De Tríceps Con Mancuernas", "Elevaciones De Talón Con Mancuernas", 
        "Peso Muerto A Una Pierna Con Mancuernas", "Remo Unilateral Con Mancuernas", 
        "Flexiones De Bíceps Con Mancuernas De Martillo", "Flexiones De Bíceps Alternadas Con Mancuernas",
        "Flexiones Con Mancuernas Tipo Martillo", "Peso Muerto Rumano Con Mancuernas", "Curl De Bíceps En Martillo",
        "Prensa De Pecho Con Mancuernas En Banco", "Sentadillas Tipo Sumo Con Mancuernas", 
        "Elevaciones De Talón Con Mancuernas En Banco", "Peso Muerto Rumano A Una Pierna Con Mancuernas",
        "Sentadillas De Sumo Con Bandas Elásticas", "Desplantes Inversos Con Bandas Elásticas", 
        "Peso Muerto A Una Pierna Con Bandas Elásticas", "Fondos De Tríceps Con Bandas Elásticas",
        "Abdominales Tipo Bicicleta Con Bandas Elásticas", "Flexiones De Pecho Con Bandas Elásticas", 
        "Remo Con Bandas Elásticas En Una Pierna", "Desplantes Laterales Con Bandas Elásticas",
        "Planchas Con Bandas Elásticas", "Flexiones Con Bandas Elásticas En Brazos", 
        "Abdominales Laterales Con Bandas Elásticas", "Abdominales Tipo Bicicleta Con Bandas Elásticas",
        "Fondos De Tríceps En Silla Con Bandas Elásticas", "Prensa De Pecho Con Bandas Elásticas En Banco"
    ));

    ejercicios.put("Anaerobicos", Arrays.asList(
        "Saltos De Tijera", "Burpees", "Escaladores De Montaña", "Saltos De Cuerda", "Correr En El Lugar",
        "Correr Con Elevación De Rodillas", "Correr Con Talones Hacia Atrás", "Tuck Jumps", "Pasos Laterales",
        "Saltos Laterales", "Saltos En Caja", "Saltos En Cuclillas", "Patadas Altas", "Patadas De Bicicleta En El Suelo",
        "Abdominales Tipo Bicicleta", "Escaladores Cruzados", "Rodillas Al Pecho", "Skipping", "Skaters", 
        "Salto De Estrella", "Saltos De Cangrejo", "Saltos A Una Pierna", "Sentadillas Con Salto", 
        "Sentadillas Con Toque De Tobillo", "Tabata De Burpees", "Tabata De Saltos De Tijera", "Tabata De Escaladores",
        "Sentadillas Con Desplazamiento Lateral", "Saltos En Zig-Zag", "Pasos Altos En El Sitio", "Saltos De Rana",
        "Lunge Con Salto", "Sentadillas Laterales Con Salto", "Salto Con Giro", "Saltos Con Codos A Las Rodillas",
        "Step-up Con Salto", "Salto Lateral De Tronco", "Saltos De Estrella Con Giros", "Salto Con Patada Frontal",
        "Salto Con Patada Lateral", "Saltos Con Patada Trasera", "Sentadillas Con Desplazamiento Circular", 
        "Saltos En V", "Correr Subiendo Escaleras", "Jump Squat En Cruz", "Saltos Laterales Con Rodilla Arriba",
        "Sentadillas Pliométricas", "Salto En Cruz Alternando Manos Y Pies", "Saltos De Conejo", 
        "Jumping Jacks Con Salto Frontal", "Jumping Jacks Con Salto Trasero", "Patadas Laterales En Desplazamiento",
        "Patadas Frontales En Desplazamiento", "Step-up Rápido", "Pasos Laterales Rápidos", "Correr Tocando El Suelo",
        "Escaladores De Montaña Lentos Y Rápidos", "Jump Squat Con Rodillas Altas", "Sentadillas Con Toque De Talón",
        "Escaladores Con Toque De Codo", "Sentadillas Con Salto Y Toque De Mano", "Jump Squat Con Toque De Suelo",
        "Correr En Círculos", "Patadas De Burro", "Plancha Con Toque De Pie", "Saltos De Tijera Con Variaciones",
        "Saltos Con Talones A Las Manos", "Correr Lateral", "Sentadillas En 360 Grados", "Saltos En Estrellas Laterales",
        "Pasos Cruzados Rápidos", "Step-up En Cruz", "Patadas Con Salto Y Giro", "Sentadillas Con Patadas Altas",
        "Escaladores Con Salto", "Lunge Con Salto Cruzado", "Planchas Con Salto Y Elevación", "Saltos De Tríceps",
        "Sentadilla Con Salto Y Elevacion", "Salto En Estrella En El Suelo", "Escaladores De Montaña Con Patada Lateral",
        "Jumping Jacks En Rotación", "Burpees Con Salto Y Toque", "Saltos Con Elevación De Brazos", 
        "Saltos En Tijera Alternando Manos Y Pies", "Saltos En Cruz Con Elevación", "Sentadillas Con Salto Y Giro",
        "Jumping Jacks Con Elevación Frontal", "Pasos Laterales Con Salto", "Correr Con Salto Frontal",
        "Sentadillas Con Salto Y Patada", "Escaladores De Montaña Con Rotación", "Correr Con Elevación De Brazos",
        "Saltos En Estrella Con Elevación", "Saltos Laterales Con Patada Frontal", "Sentadillas Con Desplazamiento Y Salto",
        "Lunge Con Giro Y Salto", "Saltos En Círculo Con Elevación", "Correr Con Elevación De Rodillas",
        "Jump Squat Con Giro", "Sentadillas Con Salto Y Toque Frontal", "Jumping Jacks Con Giro Y Salto",
        "Patadas Altas Con Salto", "Escaladores Con Rotación Y Salto", "Sentadillas Laterales Con Salto Y Giro",
        "Jump Squat En Círculo", "Correr Con Elevación De Rodillas Y Giro", "Sentadillas Con Desplazamiento Circular Y Salto"
    ));

    ejercicios.put("Pecho", Arrays.asList(
        "Flexiones De Brazo", "Flexiones De Diamante", "Flexiones Inclinadas", 
        "Flexiones Declinadas", "Flexiones Con Palmada", "Flexiones Hindúes",
        "Flexiones Con Pies Elevados", "Flexiones Con Una Mano", "Flexiones Con Toque De Hombro",
        "Flexiones Escalonadas", "Flexiones Con Dedos", "Flexiones Arqueras",
        "Flexiones En Anillo", "Flexiones Con Deslizamiento Lateral", "Flexiones Con Cuerpo Recto",
        "Flexiones Con Brazos Abiertos", "Flexiones En Forma De T", "Flexiones Con Rodillas Al Pecho",
        "Flexiones Con Toque De Pie", "Flexiones Con Elevación De Pierna", "Flexiones Con Una Pierna Elevada",
        "Flexiones De Cangrejo", "Flexiones Con Desplazamiento Lateral", "Flexiones Con Rotación",
        "Flexiones Con Rebote", "Flexiones Con Rebote En Balón Medicinal", "Flexiones Cruzadas",
        "Flexiones Con Toque De Codo", "Flexiones Estilo Spiderman", "Flexiones Con Giro",
        "Flexiones Con Pies En Superficie Inestable", "Flexiones Con Cuerpo Recto En Balón",
        "Flexiones Con Desplazamiento Circular", "Flexiones De Pecho En Anillos", "Flexiones Con Brazo Elevado",
        "Flexiones Con Toque De Hombro Alterno", "Flexiones En Puente", "Flexiones En V",
        "Flexiones Con Anillo Y Giro", "Flexiones De Pecho Con Salto", "Flexiones Con Banda Elástica",
        "Flexiones Tipo Superman", "Flexiones En X", "Flexiones En Y", "Flexiones Con Salto Y Giro",
        "Flexiones Con Caída", "Flexiones Con Elevación De Hombro", "Flexiones Alternadas",
        "Flexiones Con Elevación De Rodillas", "Prensa De Pecho Con Mancuernas", "Prensa De Pecho Con Bandas Elásticas",
        "Aperturas De Pecho Con Mancuernas", "Aperturas De Pecho Con Bandas Elásticas", "Pasos Laterales Rápidos",
        "Flexiones De Pecho Con Bandas Elásticas", "Prensa De Pecho En Banco Con Mancuernas", "Prensa De Pecho En Banco Declinado Con Mancuernas",
        "Prensa De Pecho En Banco Inclinado Con Mancuernas", "Prensa De Pecho En Banco Con Bandas Elásticas",
        "Prensa De Pecho Con Mancuernas En El Suelo", "Prensa De Pecho Con Bandas Elásticas En El Suelo",
        "Aperturas De Pecho Con Bandas Elásticas En Banco", "Prensa De Pecho Alternando Mancuernas",
        "Flexiones Con Mancuernas Con Rotación", "Prensa De Pecho Con Bandas Elásticas Y Giros",
        "Prensa De Pecho Con Mancuernas Y Elevación De Piernas", "Prensa De Pecho Con Bandas Elásticas Y Elevación De Piernas",
        "Flexiones De Pecho Con Mancuernas Y Elevación De Pies", "Prensa De Pecho Con Mancuernas Alternando Brazos",
        "Aperturas De Pecho Con Mancuernas Con Rotación", "Prensa De Pecho Con Bandas Elásticas En Banco Declinado",
        "Prensa De Pecho Con Bandas Elásticas En Banco Inclinado", "Flexiones Con Bandas Elásticas Y Elevación De Pies",
        "Aperturas De Pecho Con Bandas Elásticas Y Elevación De Pies", "Prensa De Pecho Con Bandas Elásticas Alternando Brazos",
        "Prensa De Pecho Con Bandas Elásticas Y Elevación De Piernas", "Prensa De Pecho Con Mancuernas Y Elevación De Pies",
        "Flexiones De Pecho Con Bandas Elásticas Y Elevación De Pies", "Flexiones De Pecho Con Mancuernas Y Rotación",
        "Flexiones Con Bandas Elásticas Y Giro De Torso", "Flexiones Con Bandas Elásticas Y Elevación De Pierna",
        "Prensa De Pecho En Banco Plano Con Mancuernas", "Flexiones Con Mancuernas Y Elevación De Pies",
        "Prensa De Pecho Con Bandas Elásticas Y Giro", "Flexiones De Pecho Con Mancuernas Y Elevación De Pies",
        "Flexiones De Pecho En Banco Plano Con Mancuernas", "Flexiones Con Bandas Elásticas Y Giro De Torso",
        "Prensa De Pecho Con Bandas Elásticas Y Elevación De Piernas", "Flexiones De Pecho Con Bandas Elásticas Y Elevación De Pies",
        "Aperturas De Pecho Con Mancuernas Con Rotación", "Prensa De Pecho En Banco Plano Con Mancuernas",
        "Flexiones Con Bandas Elásticas Y Giro De Torso", "Prensa De Pecho Con Bandas Elásticas En Banco Declinado",
        "Flexiones Con Bandas Elásticas Y Elevación De Piernas", "Flexiones De Pecho En Banco Plano Con Mancuernas",
        "Prensa De Pecho Con Bandas Elásticas Y Elevación De Pies", "Flexiones Pe Pecho Con Mancuernas Y Rotación",
        "Aperturas De Pecho Con Bandas Elásticas Y Elevación De Piernas", "Flexiones De Pecho En Banco Plano Con Bandas Elásticas",
        "Flexiones Con Bandas Elásticas Y Elevación De Pies"
    ));

    ejercicios.put("Pierna", Arrays.asList(
        "Sentadillas", "Sentadillas Con Salto", "Sentadillas De Sumo", 
        "Sentadillas Búlgaras", "Sentadillas De Pistola", "Sentadillas Con Una Pierna En Banco", 
        "Sentadillas Pliométricas", "Sentadillas Con Pies Juntos", "Sentadillas Con Pies Anchos", 
        "Sentadillas Con Mancuernas", "Sentadillas Con Banda Elástica", "Sentadillas Con Barra", 
        "Sentadillas En Máquina Smith", "Sentadillas Frontales", "Sentadillas Hack", 
        "Sentadillas Con Balón Medicinal", "Sentadillas En Cajón", "Sentadillas Con Barra Frontal", 
        "Sentadillas Con Barra Trasera", "Sentadillas Con Banda Elástica Alrededor De Las Rodillas", 
        "Sentadillas Con Elevación De Talones", "Sentadillas Con Elevación De Rodillas", 
        "Sentadillas Con Elevación De Pierna", "Sentadillas Con Giro", "Sentadillas Con Paso Lateral", 
        "Sentadillas Con Paso Hacia Adelante", "Sentadillas Con Paso Hacia Atrás", 
        "Sentadillas Con Desplazamiento Lateral", "Sentadillas Con Desplazamiento Circular", 
        "Sentadillas Con Peso Corporal", "Sentadillas Con Banda Elástica Alrededor De Los Muslos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos", "Sentadillas Con Peso Corporal Y Banda Elástica", 
        "Sentadillas Con Peso Corporal Y Banda Elástica Alrededor De Las Rodillas", 
        "Sentadillas Con Peso Corporal Y Banda Elástica Alrededor De Los Muslos", 
        "Sentadillas Con Peso Corporal Y Banda Elástica Alrededor De Los Tobillos", 
        "Sentadillas Con Peso Corporal Y Banda Elástica En Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Las Rodillas Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Muslos Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos Y Las Manos", 
        "Sentadillas Con Peso Corporal Y Banda Elástica En Los Hombros", 
        "Sentadillas Con Peso Corporal Y Banda Elástica Alrededor De Los Hombros", 
        "Sentadillas Con Peso Corporal Y Banda Elástica Alrededor Del Pecho", 
        "Sentadillas Con Peso Corporal Y Banda Elástica En Los Hombros Y Las Manos", 
        "Sentadillas Con Peso Corporal Y Banda Elástica Alrededor De Los Hombros Y Las Manos", 
        "Sentadillas Con Peso Corporal Y Banda Elástica Alrededor Del Pecho Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Muslos Y Los Hombros", 
        "Sentadillas Con Banda Elástica Alrededor De Los Muslos Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Muslos, Los Hombros Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos Y Los Hombros", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos, Los Hombros Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Hombros Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Hombros, El Pecho Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Las Rodillas Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Las Rodillas, El Pecho Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Muslos Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Muslos, El Pecho Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos, El Pecho Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Las Rodillas Y El Pecho Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Las Rodillas, Los Hombros Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Las Rodillas, El Pecho, Los Hombros Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Las Rodillas, Los Hombros Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Muslos, El Pecho Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Muslos, Los Hombros Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos, Los Muslos Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos, Los Muslos Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos, Los Muslos, Las Manos Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos, Los Muslos, El Pecho Y Las Manos", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos, Los Muslos, Los Hombros Y El Pecho", 
        "Sentadillas Con Banda Elástica Alrededor De Los Tobillos, Los Muslos, Los Hombros, El Pecho Y Las Manos"
    ));
        return ejercicios;
    }

    @GetMapping("/RegistroEjercicio")
    public String formularioRegistroEjercicio() {
        return "/Exercises/FormularioRegistroEjercicio";
    }

    @GetMapping("/Home")
    public String homeRegistroEjercicio() {
        return "/Exercises/HomeRegistroEjercicio";
    }

    @GetMapping("/EditarEjercicio")
    public String formularioEditarEjercicio() {
        return "/Exercises/FormularioEditarEjercicio";
    }

    @GetMapping("/TablaEjercicio")
    public String TablaRegistroEjercicio() {
        return "/Exercises/TablaRegistroEjercicio";
    }

}