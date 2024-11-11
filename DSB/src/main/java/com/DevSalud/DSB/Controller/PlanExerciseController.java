package com.DevSalud.DSB.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Service.PlanExerciseService;

@Controller
@RequestMapping("/Api/Users/Exercises")
public class PlanExerciseController {

    @Autowired
    private PlanExerciseService planExerciseService;

    @ModelAttribute("allNamePlanes")
    public Map<String, List<String>> PlanesMap() {
        Map<String, List<String>> planMap = new HashMap<>();

        planMap.put("hipertensosBajoDePeso", Arrays.asList(
                "Lunes - Aerobicos - Saltos De Cuerda - Moderada",
                "Lunes - Aerobicos - Saltos De Tijera- Moderada",
                "Lunes - Aerobicos - Caminata Rápida - Baja",
                "Lunes - Aerobicos - bicicleta Estática - Alta",
                "Lunes - Pierna - Sentadillas Sin Peso O Con Una Silla - Moderada",
                "Lunes - Pierna - Sentadillas Con Salto - Baja",
                "Lunes - Pierna - Elevaciones De Talones Con Elevación De Cadera - Moderada",
                "Lunes - Hombro - Elevaciones Laterales Con Bandas Elásticas - Moderada",
                "Lunes - Hombro - Elevaciones Frontales Con Bandas Elásticas Y Giro - Alta",
                "Lunes - Hombro - Elevaciones Frontales Con Bandas Elásticas Con Giro De Pie - Baja",
                //
                "Martes - Espalda - Flexiones Inclinadas - Baja",
                "Martes - Espalda - Escaladores De Montaña - Moderada",
                "Martes - Espalda - Remo Con Bandas Elásticas - Alta",
                "Martes - Triceps - Fondos En Silla - Moderada",
                "Martes - Triceps - Fondos En El Suelo - Baja",
                "Martes - Triceps - Fondos De Tríceps Con Elevación De Pierna- Moderada",
                "Martes - Equilibrio - Levantamiento de una pierna - Alta",
                "Martes - Equilibrio - Equilibrio En T - Alta",
                "Martes - Equilibrio - Equilibrio En Talones - Alta",
                //
                "Miercoles - Pecho - Flexiones De Brazo - Baja",
                "Miercoles - Pecho - Flexiones Con Brazos Abiertos - Baja",
                "Miercoles - Pecho - Flexiones Inclinadas - Alta",
                "Miercoles - Biceps - Curl De Bíceps Con Bandas Elásticas - Moderada",
                "Miercoles - Biceps - Curl De Bíceps Con Bandas Elásticas Alternado - Moderada",
                "Miercoles - Biceps - Curl De Bíceps Con Bandas Elásticas Cruzadas - Moderada",
                "Miercoles - Antebrazo - Curl De Muñeca Con Bandas Elásticas - Moderada",
                "Miercoles - Antebrazo - Extensión De Muñeca Con Bandas Elásticas - Moderada",
                "Miercoles - Antebrazo - Extensión De Muñeca Con Bandas Elásticas Y Giro De Torso - Moderada",
                //
                "Jueves - Abdominales - Abdominales Tradicionales - Moderada",
                "Jueves - Abdominales - Abdominales Tipo Bicicleta - Moderada",
                "Jueves - Abdominales - Abdominales Con Piernas Elevadas - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón Con Una Pierna - Baja",
                "Jueves - Pantorrilla - Elevaciones De Talón En Escalón - Moderada",
                "Jueves - Flexibilidad - Estiramiento De Cuádriceps - Alta",
                "Jueves - Flexibilidad - Estiramiento De Pantorrillas - Alta",
                "Jueves - Flexibilidad - Estiramiento De Cadera - Alta",
                //
                "Viernes - Fuerza - Flexiones De Brazo (Push-Ups) - Baja",
                "Viernes - Fuerza - Flexiones Inclinadas - Baja",
                "Viernes - Fuerza - Fondos De Tríceps En Silla - Baja",
                "Viernes - Resistencia - Saltos De Tijera - Moderada",
                "Viernes - Resistencia - Sentadillas Con Salto - Baja",
                "Viernes - Resistencia - Flexiones Declinadas - Baja",
                "Viernes - Aerobico - Rodillas Al Pecho - Alta",
                "Viernes - Aerobico - Skipping - Alta",
                "Viernes - Aerobico - Salto De Estrella - Alta",
                //
                "Sabado - Fortalecimiento - Estocadas Con Salto - Moderada",
                "Sabado - Fortalecimiento - Desplantes Laterales - Moderada",
                "Sabado - Fortalecimiento - Abdominales Laterales - Alta",
                "Sabado - Anaerobicos - Elevaciones De Cadera - Baja",
                "Sabado - Anaerobicos - Abdominales En V - Baja",
                "Sabado - Anaerobicos -Escaladores Cruzados - Baja",
                "Sabado - Aerobico - Correr Con Elevación De Rodillas - Alta",
                "Sabado - Aerobico - Saltos En Zig-Zag - Moderada",
                "Sabado - Aerobico - Saltos De Rana - Alta",
                //
                "Domingo - Flexibilidad - Estiramiento De Flexores De Cadera - Alta",
                "Domingo - Flexibilidad - Estiramiento De Antebrazos - Alta",
                "Domingo - Flexibilidad - Estiramiento De Abductores - Alta",
                "Domingo - Flexibilidad - Estiramiento De Hombros - Alta",
                "Domingo - Flexibilidad - Estiramiento De Isquiotibiales - Alta"));
        //
        planMap.put("hipertensosSobrePeso", Arrays.asList(
                "Lunes - Aerobicos - Trote Moderado - Moderado",
                "Lunes - Aerobicos - Saltos Laterales - Alta",
                "Lunes - Aerobicos - Abdominales Tipo Bicicleta - Moderada",
                "Lunes - Pierna - Sentadillas - Moderada",
                "Lunes - Pierna - Sentadillas De Sumo - Moderada",
                "Lunes - Pierna - Sentadillas Con Elevación De Brazos - Moderada",
                "Lunes - Hombro - Elevaciones Laterales Con Bandas Elásticas Cruzadas - Moderada",
                "Lunes - Hombro - Elevaciones Laterales Con Bandas Elásticas Y Elevación De Brazo - Moderada",
                //
                "Martes - Espalda - Remo Con Bandas Elásticas - Alta",
                "Martes - Espalda - Pull-ups De Barra Casera - Moderada",
                "Martes - Espalda - Remo Con Bandas Elásticas Alternando Brazos - Alta",
                "Martes - Triceps - Fondos Con Elevación De Talones - Baja",
                "Martes - Triceps - Fondos Con Rotación De Torso - Baja",
                "Martes - Triceps - Extensión De Tríceps Con Bandas Elásticas Desde Banco - Baja",
                //
                "Miercoles - Pecho - Flexiones Con Bandas Elásticas Y Elevación De Pies - Moderada",
                "Miercoles - Pecho - Aperturas De Pecho Con Bandas Elásticas Y Elevación De Piernas - Moderada",
                "Miercoles - Pecho - Flexiones De Brazo - Moderada",
                "Miercoles - Biceps - Flexiones Con Agarre Estrecho - Moderada",
                "Miercoles - Biceps - Flexión De Bíceps Con Bandas Elásticas Cruzada Desde Banco Inclinado - Moderada",
                "Miercoles - Biceps - Flexión De Bíceps Con Bandas Elásticas Con Elevación De Talones - Moderada",
                //
                "Jueves - Abdominales - Abdominales Tradicionales - Moderada",
                "Jueves - Abdominales - Abdominales Tipo Bicicleta - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón Con Una Pierna - Baja",
                "Jueves - Pantorrilla - Elevaciones De Talón En Escalón - Moderada",
                "Jueves - Flexibilidad - Estiramiento De Pantorrillas - Alta",
                "Jueves - Flexibilidad - Estiramiento De Cadera - Alta",
                //
                "Viernes - Fuerza - Burpees Con Flexiones - Baja",
                "Viernes - Fuerza - Sentadillas Con Bandas Elásticas - Baja",
                "Viernes - Aerobico - Tabata De Escaladores - Moderada",
                "Viernes - Aerobico - Tabata De Saltos De Tijera - Alta",
                "Viernes - Resistencia - Escaladores De Montaña - Moderada",
                "Viernes - Resistencia - Flexiones Con Pica - Moderada",
                //
                "Sabado - Fortalecimiento - Abdominales En V - Moderada",
                "Sabado - Fortalecimiento - Burpees Con Salto - Baja",
                "Sabado - Flexibilidad - Estiramiento De Cuádriceps - Alta",
                "Sabado - Flexibilidad - Estiramiento De Trapecio - Alta",
                //
                "Domingo - Flexibilidad - Estiramiento De Gemelos - Alta",
                "Domingo - Flexibilidad - Estiramiento De Pectorales - Alta",
                "Domingo - Flexibilidad - Postura Del Guerrero I - Alta",
                "Domingo - Equilibrio - Equilibrio Con Movimiento De Brazos - Alta"));
        //
        planMap.put("hipertensosObesidadTipo1y2", Arrays.asList(
                "Lunes - Aeróbico - Saltos En Caja - Moderada",
                "Lunes - Aerobico - Abdominales Tipo Bicicleta - Moderada",
                "Lunes - Pierna - Sentadillas - Baja",
                "Lunes - Hombro - Elevaciones Laterales Con Bandas Elásticas - Baja",
                //
                "Martes - Espalda - Elevación De Cadera Con Una Pierna - Baja",
                "Martes - Espalda - Remo Con Bandas Elásticas En Banco Con Elevación De Cadera - Baja",
                "Martes - Triceps - Extensión De Tríceps En Banco Con Bandas Elásticas Con Giro De Torso - Baja",
                "Martes - Triceps - Extensión De Tríceps En Banco Con Bandas Elásticas Con Elevación De Cadera - Baja",
                //
                "Miercoles - Pecho - Flexiones Hindúes - Baja",
                "Miercoles - Pecho - Flexiones Con Brazos Abiertos - Baja",
                "Miercoles - Antebrazo - Extensión De Muñeca Con Bandas Elásticas Y Giro De Torso - Moderada",
                "Miercoles - Antebrazo - Flexión De Muñeca Con Bandas Elásticas Con Rotación - Moderada",
                //
                "Jueves - Abdominales - Abdominales De Doble Pierna - Baja",
                "Jueves - Pantorrilla - Elevaciones De Talón Con Rebote Y Salto - Moderada",
                "Jueves - Flexibilidad - Estiramiento De Cuádriceps - Baja",
                "Jueves - Resistencia - Escaladores De Montaña - Moderada",
                //
                "Viernes - Fuerza - Sentadillas Búlgaras - Baja",
                "Viernes - Fortalecimiento - Elevación De Talones Con Una Pierna - Moderada",
                "Viernes - Equilibrio - Equilibrio Con Banda Elástica Y Elevación De Pierna - Baja",
                "Viernes - Anaerbico - Abdominales Tipo Bicicleta Con Bandas Elásticas - Baja",
                //
                "Sabado - Flexibilidad - Estiramiento De La Parte Baja De La Espalda - Alta",
                "Sabado - Equilibrio - Equilibrio Con Elevación Frontal De Pierna - Alta",
                "Sabado - Fuerza - Peso Muerto Con Mochila Cargada - Moderada",
                "Sabado - Flexibilidad - Estiramiento De Hombros - Alta",
                //
                "Domingo - Flexibilidad - Estiramiento De Aductores - Alta",
                "Domingo - Flexibilidad - Estiramiento De Cuádriceps - Alta",
                "Domingo - Flexibilidad - Estiramiento De Cadera - Alta",
                "Domingo - Equilibrio - Equilibrio Sobre Una Superficie Inestable - Alta"));
        //
        planMap.put("diabetesTipo1BajoDePeso", Arrays.asList(
                "Lunes - Aerobicos - Saltos En Cuclillas - Alta",
                "Lunes - Aerobicos - Saltos Con Patada Trasera - Alta",
                "Lunes - Aerobicos - Sentadilla Con Salto Y Elevacion - Moderada",
                "Lunes - Pierna - Sentadillas Con Mancuernas Y Salto - Baja",
                "Lunes - Pierna - Puentes De Glúteos Con Mancuernas - Baja",
                "Lunes - Pierna - Elevaciones De Cadera Con Mancuernas - Baja",
                "Lunes - Hombro - Elevaciones Laterales - Moderada",
                "Lunes - Hombro - Press De Hombros Con Mancuernas - Moderada",
                "Lunes - Hombro - Prensa De Hombro Con Bandas Elásticas Y Salto - Moderada",
                //
                "Martes - Espalda - Planchas Laterales Con Elevación De Pierna - Baja",
                "Martes - Espalda - Remo Con Bandas Elásticas Y Elevación De Cadera - Moderada",
                "Martes - Espalda - Pull-aparts Con Bandas Elásticas En Banco - Moderada",
                "Martes - Triceps - Flexiones Con Peso En Espalda - Baja",
                "Martes - Triceps - Fondos Con Rotación - Baja",
                "Martes - Triceps - Extensión De Tríceps En Posición De Flexión - Baja",
                "Martes - Anaerobicos - Remo Unilateral Con Mancuernas - Baja",
                "Martes - Anaerobicos - Flexiones De Bíceps Alternadas Con Mancuernas - Moderada",
                "Martes - Anaerobicos - Abdominales Tipo Bicicleta Con Bandas Elásticas - Baja",
                //
                "Miercoles - Pecho - Aperturas De Pecho Con Mancuernas - Baja",
                "Miercoles - Pecho - Flexiones De Pecho Con Bandas Elásticas - Baja",
                "Miercoles - Pecho - Prensa De Pecho En Banco Inclinado Con Mancuernas - Baja",
                "Miercoles - Biceps - Extensión De Tríceps Sobre La Cabeza Con Bandas Elásticas - Moderada",
                "Miercoles - Biceps - Extensión De Tríceps Con Bandas Elásticas Y Giro De Torso - Baja",
                "Miercoles - Biceps - Extensión De Tríceps Con Mancuernas - Baja",
                "Miercoles - Antebrazos - Curl De Muñeca Con Mancuernas - Baja",
                "Miercoles - Antebrazos - Flexión De Muñeca Con Bandas Elásticas Con Elevación De Cadera - Moderada",
                "Miercoles - Antebrazos - Flexiones Con Toque De Codo - Moderada",
                //
                "Jueves - Abdominales - Abdominales Tipo Puente - Baja",
                "Jueves - Abdominales - Escaladores De Montaña - Moderada",
                "Jueves - Abdominales - Abdominales Laterales - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón En Banco Con Toque De Cadera Y Salto - Alta",
                "Jueves - Pantorrilla - Elevaciones De Talón En Banco Con Una Pierna Y Rebote - Alta",
                "Jueves - Flexibilidad - Postura Del Árbol - Alta",
                "Jueves - Flexibilidad - Estiramiento De Cuádriceps - Alta",
                "Jueves - Equilibrio - Equilibrio En T - Alta",
                "Jueves - Equilibrio - Equilibrio Con Extensión De Brazos Y Piernas - Alta",
                //
                "Viernes - Fuerza - Estocadas Con Salto - Baja",
                "Viernes - Fuerza - Estocadas Con Mochila Cargada - Baja",
                "Viernes - Resistencia - Flexiones Declinadas - Baja",
                "Viernes - Resistencia - Escaladores De Montaña Con Giro - Baja",
                "Viernes - Fortalecimiento - Saltos Laterales - Moderada",
                "Viernes - Fortalecimiento - Plancha Con Elevación De Pierna - Moderada",
                "Viernes - Fortalecimiento - Plancha Con Elevación De Cadera - Moderada",
                "Viernes - Anaerbico - Abdominales Laterales Con Bandas Elásticas - Alta",
                "Viernes - Anaerbico - Abdominales Tipo Bicicleta Con Bandas Elásticas - Alta",
                //
                "Sabado - Equilibrio - Equilibrio A Una Pierna - Alta",
                "Sabado - Equilibrio - Equilibrio Con Pierna Cruzada - Alta",
                "Sabado - Flexibilidad - Estiramiento De Hombros - Alta",
                "Sabado - Flexibilidad - Estiramiento De Antebrazos - Alta",
                "Sabado - Flexibilidad - Estiramiento De Aductores - Alta",
                //
                "Domingo - Flexibilidad - Postura Del Perro Mirando Hacia Abajo - Alta",
                "Domingo - Flexibilidad - Postura Del Niño - Alta",
                "Domingo - Equilibrio - Equilibrio Con Bandas Y Elevación De Piernas - Alta",
                "Domingo - Equilibrio - Salto Y Equilibrio A Una Pierna - Alta",
                "Domingo - Equilibrio - Equilibrio Con Banda Elástica - Alta"));
        //
        planMap.put("diabetesTipo1SobrePeso", Arrays.asList(
                "Lunes - Pierna - Sentadillas Con Peso Corporal - Moderada",
                "Lunes - Pierna - Estocadas - Alta",
                "Lunes - Pierna - Peso Muerto Con Piernas Rectas - Baja",
                "Lunes - Hombro - Prensa De Hombro Con Bandas Elásticas Con Elevación De Pie - Baja",
                "Lunes - Hombro - Prensa De Hombro Con Bandas Elásticas Y Elevación De Pie - Baja",
                "Lunes - Aerobico - Jumping Jacks En Rotación - Moderada",
                "Lunes - Aerobico - Lunge Con Salto Y Toque De Suelo - Moderada",
                "Lunes - Aerobico - Planchas Con Salto Y Patadas Laterales - Moderada",
                //
                "Martes - Espalda - Remo Con Mancuernas - Moderada",
                "Martes - Espalda - Pull-downs con banda de resistencia - Moderada",
                "Martes - Espalda - Chin-ups En Barra Casera - Moderada",
                "Martes - Triceps - Fondos en banco - Alta",
                "Martes - Triceps - Extensiones de tríceps - Moderada",
                "Martes - Triceps - Extensión De Tríceps En Banco Inclinado - Baja",
                "Martes - Anerobicos - Planchas Con Bandas Elásticas - Moderada",
                "Martes - Anerobicos - Elevaciones De Talón Con Mancuernas En Banco - Moderada",
                //
                "Miercoles - Pecho - Flexiones De Pecho - Moderada",
                "Miercoles - Pecho - Press De Pecho Con Mancuernas - Moderada",
                "Miercoles - Pecho - Flexiones Con Brazos Abiertos - Moderada",
                "Miercoles - Biceps - Curl De bíceps Con Mancuernas - Baja",
                "Miercoles - Biceps - Curl De Martillo - Baja",
                "Miercoles - Biceps - Curl De Bíceps Con Bandas Elásticas Cruzadas - Baja",
                "Miercoles - Antebrazo - Flexiones De Muñeca - Alta",
                "Miercoles - Antebrazo - Extensiones De Muñeca - Alta",
                //
                "Jueves - Abdominales - Crunches - Moderada",
                "Jueves - Abdominales - Abdominales Tipo Bicicleta - Moderada",
                "Jueves - Abdominales - Plancha - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón - Alta",
                "Jueves - Pantorrilla - Elevaciones De Talón En Banco Con Salto - Alta",
                "Jueves - Resistencia - Flexiones De Puente - Baja",
                "Jueves - Resistencia - Flexiones Con Codos Cerrados - Baja",
                "Jueves - Flexibilidad - Estiramientos De Cuerpo Completo - Alta",
                //
                "Viernes - Fuerza - Sentadillas De Sumo - Baja",
                "Viernes - Fuerza - Flexiones De Pecho Con Bandas Elásticas - Baja",
                "Viernes - Fuerza - Prensa De Hombros Con Bandas Elásticas - Baja",
                "Viernes - Fortalecimiento - Plancha - Moderada",
                "Viernes - Fortalecimiento - Bird-Dog - Moderada",
                "Viernes - Anaerobicos - Estocadas Con Salto - Baja",
                "Viernes - Anaerobicos - Patadas Frontales - Baja",
                "Viernes - Anaerobicos - Elevaciones Laterales Con Bandas Elásticas - Baja",
                //
                "Sabado - Equilibrio - Postura Del Arbol - -",
                "Sabado - Equilibrio - Elevación De Una Pierna - -",
                "Sabado - Flexibilidad - Estiramientos De Espalda - -",
                "Sabado - Flexibilidad - Estiramientos De Hombros Y Cuello - -",
                //
                "Domingo - Flexibilidad - Estiramientos De Cuádriceps - Alta",
                "Domingo - Flexibilidad - Estiramientos De Isquiotibiales - Alta",
                "Domingo - Flexibilidad - Estiramientos De Pantorrillas - Alta",
                "Domingo - Flexibilidad - Sesión de yoga suave - Alta"));
        //
        planMap.put("diabetesTipo1ObesidadTipo1y2", Arrays.asList(
                "Lunes - Pierna - Sentadillas - Moderada",
                "Lunes - Pierna - Puente De Glúteos - Moderada",
                "Lunes - Pierna - Zancadas - Moderada",
                "Lunes - Hombro - Elevaciones Laterales - Alta",
                "Lunes - Hombro - Press De Hombros Con Mancuernas - Moderada",
                "Lunes - Aerobico - Trote Suave - Moderada",
                //
                "Martes - Espalda - Remo Con Mancuernas - Moderada",
                "Martes - Espalda - Superman - Alta",
                "Martes - Triceps - Fondos De Tríceps En Banco - Moderada",
                "Martes - Triceps - Extensión De Tríceps Con Mancuernas - Baja",
                "Martes - Anaerobicos - Elevaciones Laterales Con Bandas Elásticas - Moderada",
                "Martes - Anaerobicos - Escaladores En El Suelo - Baja",
                //
                "Miercoles - Pecho - Flexiones De Brazo - Moderada",
                "Miercoles - Pecho - Press De Banca Con Mancuernas - Baja",
                "Miercoles - Biceps - Flexión De Bíceps Con Bandas Elásticas Y Rotación De Torso - Baja",
                "Miercoles - Biceps - Flexión De Bíceps Con Bandas Elásticas Desde Banco Inclinado Con Giro De Torso - Moderada",
                "Miercoles - Antebrazo - Flexión De Muñeca Con Mancuernas - Baja",
                "Miercoles - Antebrazo - Flexiones Con Cuerpo Recto Con Elevación De Cadera - Baja",
                //
                "Jueves - Abdominales - Bicicletas - Alta",
                "Jueves - Abdominales - Russian Twists - Moderada",
                "Jueves - Pantorrilla - Mountain Climbers - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Pantorrillas - Alta",
                "Jueves - Resistencia - Burpees Con Salto Y Elevación De Rodillas - Moderada",
                "Jueves - Resistencia - Escaladores De Montaña Cruzados - Baja",
                //
                "Viernes - Fuerza - Curl De Bíceps Con Mancuernas - Baja",
                "Viernes - Fuerza - Peso Muerto Con Mochila - Baja",
                "Viernes - Fortalecimiento - Plancha Con Toque De Hombro - Moderada",
                "Viernes - Fortalecimiento - Abdominales Tipo Rana - Moderada",
                "Viernes - Anaerobico - Elevaciones Frontales Con Mancuernas - Baja",
                "Viernes - Anaerobico - Abdominales Laterales Con Bandas Elásticas - Baja",
                //
                "Sabado - Aerobico - Saltos De Tijera - Alta",
                "Sabado - Aerobico - Mountain Climbers - Alta",
                "Sabado - Equilibrio - Elevación De Piernas En Plancha Con Pesas - Alta",
                "Sabado - Equilibrio - Equilibrio En T Con Mancuernas - Alta",
                "Sabado - Flexibilidad - Yoga o Pilates - Alta",
                "Sabado - Flexibilidad - Postura Del Puente - Alta",
                //
                "Domingo - Flexibilidad - Postura De La Silla - Alta",
                "Domingo - Flexibilidad - Postura Del Guerrero - Alta",
                "Domingo - Flexibilidad - Estiramiento De Aductores - Alta",
                "Domingo - Flexibilidad - Estiramiento De Cuádriceps - Alta",
                "Domingo - Flexibilidad - Estiramiento De Antebrazos - Alta",
                "Domingo - Flexibilidad - Estiramiento De Los Músculos Laterales Del Tronco - Alta"));
        //
        planMap.put("diabetesTipo1ObesiadaTipo3y4", Arrays.asList(
                "Lunes - Pierna - Sentadillas - Moderada",
                "Lunes - Pierna - Puente De Glúteos - Moderada",
                "Lunes - Pierna - Zancadas - Moderada",
                "Lunes - Hombro - Elevaciones Laterales - Alta",
                "Lunes - Hombro - Press De Hombros Con Mancuernas - Moderada",
                "Lunes - Aerobico - Trote Suave - Moderada",
                //
                "Martes - Espalda - Remo Con Mancuernas - Moderada",
                "Martes - Espalda - Superman - Alta",
                "Martes - Triceps - Fondos De Tríceps En Banco - Moderada",
                "Martes - Triceps - Extensión De Tríceps Con Mancuernas - Baja",
                "Martes - Anaerobicos - Elevaciones Laterales Con Bandas Elásticas - Moderada",
                "Martes - Anaerobicos - Escaladores En El Suelo - Baja",
                //
                "Miercoles - Pecho - Flexiones De Brazo - Moderada",
                "Miercoles - Pecho - Press De Banca Con Mancuernas - Baja",
                "Miercoles - Biceps - Flexión De Bíceps Con Bandas Elásticas Y Rotación De Torso - Baja",
                "Miercoles - Biceps - Flexión De Bíceps Con Bandas Elásticas Desde Banco Inclinado Con Giro De Torso - Moderada",
                "Miercoles - Antebrazo - Flexión De Muñeca Con Mancuernas - Baja",
                "Miercoles - Antebrazo - Flexiones Con Cuerpo Recto Con Elevación De Cadera - Baja",
                //
                "Jueves - Abdominales - Bicicletas - Alta",
                "Jueves - Abdominales - Russian Twists - Moderada",
                "Jueves - Pantorrilla - Mountain Climbers - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Pantorrillas - Alta",
                "Jueves - Resistencia - Burpees Con Salto Y Elevación De Rodillas - Moderada",
                "Jueves - Resistencia - Escaladores De Montaña Cruzados - Baja",
                //
                "Viernes - Fuerza - Curl De Bíceps Con Mancuernas - Baja",
                "Viernes - Fuerza - Peso Muerto Con Mochila - Baja",
                "Viernes - Fortalecimiento - Plancha Con Toque De Hombro - Moderada",
                "Viernes - Fortalecimiento - Abdominales Tipo Rana - Moderada",
                "Viernes - Anaerobico - Elevaciones Frontales Con Mancuernas - Baja",
                "Viernes - Anaerobico - Abdominales Laterales Con Bandas Elásticas - Baja",
                //
                "Sabado - Aerobico - Saltos De Tijera - Alta",
                "Sabado - Aerobico - Mountain Climbers - Alta",
                "Sabado - Equilibrio - Elevación De Piernas En Plancha Con Pesas - Alta",
                "Sabado - Equilibrio - Equilibrio En T Con Mancuernas - Alta",
                "Sabado - Flexibilidad - Yoga o Pilates - Alta",
                "Sabado - Flexibilidad - Postura Del Puente - Alta",
                //
                "Domingo - Flexibilidad - Postura De La Silla - Alta",
                "Domingo - Flexibilidad - Postura Del Guerrero - Alta",
                "Domingo - Flexibilidad - Estiramiento De Aductores - Alta",
                "Domingo - Flexibilidad - Estiramiento De Cuádriceps - Alta",
                "Domingo - Flexibilidad - Estiramiento De Antebrazos - Alta",
                "Domingo - Flexibilidad - Estiramiento De Los Músculos Laterales Del Tronco - Alta"));
        //
        planMap.put("diabetesTipo2BajoDePeso", Arrays.asList(
                "Lunes - Piernas - Sentadillas - Moderada",
                "Lunes - Pierna - Puente De Glúteos - Moderada",
                "Lunes - Pierna - Zancadas - Moderada",
                "Lunes - Hombro - Elevaciones Laterales - Alta",
                "Lunes - Hombro - Press De Hombros Con Mancuernas - Moderada",
                "Lunes - Aerobico - Trote Suave - Moderada",
                "Lunes - Flexibilidad - Estiramiento De Cuádriceps - Alta",
                "Lunes - Flexibilidad - Estiramiento De Antebrazos - Alta",
                //
                "Martes - Aerobico - Saltos De Tijera - Alta",
                "Martes - Aerobico - Mountain Climbers - Alta",
                "Martes - Equilibrio - Elevación De Piernas En Plancha Con Pesas - Moderada",
                "Martes - Equilibrio - Equilibrio En T Con Mancuernas - Moderada",
                "Martes - Flexibilidad - Estiramiento De Antebrazos - Moderada",
                "Martes - Flexibilidad - Estiramiento De Antebrazos - Moderada",
                "Martes - Flexibilidad - Estiramiento De Los Músculos Laterales Del Tronco - Moderada",
                "Martes - Flexibilidad - Estiramiento De Aductores - Moderada",
                //
                "Miercoles - Pecho - Flexiones De Brazo - Moderada",
                "Miercoles - Pecho - Press De Banca Con Mancuernas - -",
                "Miercoles - Biceps - Flexión De Bíceps Con Bandas Elásticas Y Rotación De Torso - Moderada",
                "Miercoles - Biceps - Flexión De Bíceps Con Bandas Elásticas Desde Banco Inclinado Con Giro De Torso - Moderada",
                "Miercoles - Espalda - Remo Con Mancuernas - Alta",
                "Miercoles - Espalda - Superman - Alta",
                "Miercoles - Triceps - Fondos De Tríceps En Banco - Moderada",
                "Miercoles - Triceps - Extensión De Tríceps Con Mancuernas - Moderada",
                //
                "Jueves - Abdominales - Abdominales Tradicionales - Moderada",
                "Jueves - Abdominales - Abdominales Oblicuos - Baja",
                "Jueves - Abdominales - Plancha Tradicional - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón Con Salto - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón Alternadas - Moderada",
                "Jueves - Anaerobico - Sentadillas Con Una Pierna - Baja",
                "Jueves - Anaerobico - Estocadas Laterales - Moderada",
                "Jueves - Anaerobico - Elevaciones De Pierna En Decúbito Supino - Baja",
                //
                "Viernes - Flexibilidad - Postura Del Árbol - Moderada",
                "Viernes - Flexibilidad - Estiramiento De Cuádriceps - Moderada",
                "Viernes - Equilibrio - Equilibrio En T - Moderada",
                "Viernes - Equilibrio - Equilibrio Con Extensión De Brazos Y Piernas - Moderada",
                "Viernes - Anaerobicos - Elevaciones Laterales Con Bandas Elásticas - Moderada",
                "Viernes - Anaerobicos - Escaladores En El Suelo - Moderada",
                "Viernes - Flexibilidad - Estiramiento de los isquiotibiales - Moderada",
                "Viernes - Flexibilidad - Estiramiento de los cuádriceps - Moderada",
                //
                "Sabado - Aerobico - Salto En Tijeras - Alta",
                "Sabado - Aerobico - Trote Suave - Alta",
                "Sabado - Equilibrio - Equilibrio Con Elevación De Rodilla - Alta",
                "Sabado - Equilibrio - Equilibrio Con Elevación De Brazos - Alta",
                "Sabado - Equilibrio - Equilibrio En Posición De Yoga - Alta",
                //
                "Domingo - Flexibilidad - Yoga - Moderada",
                "Domingo - Flexibilidad - Postura Del Camello - Moderada",
                "Domingo - Flexibilidad - Postura Del Triángulo - Moderada"));
        //
        planMap.put("diabetesTipo2SobrePeso", Arrays.asList(
                "Lunes - Piernas - Sentadillas - Moderada",
                "Lunes - Piernas - Puente De Glúteos - Moderada",
                "Lunes - Flexibilidad - Estiramiento De Cuádriceps - Moderada",
                "Lunes - Flexibilidad - Postura Del Árbol - Moderada",
                "Lunes - Equilibrio - Equilibrio Con Extensión De Brazos Y Piernas - Moderada",
                "Lunes - Equilibrio - Equilibrio En T - Moderada",
                //
                "Martes - Pecho - Flexiones De Brazo - Alta",
                "Martes - Pecho - Press De Banca Con Mancuernas - Alta",
                "Martes - Hombro - Elevaciones Laterales - Moderada",
                "Martes - Hombro - Press De Hombros Con Mancuernas - Moderada",
                "Martes - Antebrazo - Flexiones De Muñeca - Moderada",
                "Martes - Antebrazo - Extensiones De Muñeca - Moderada",
                //
                "Miercoles - Espalda - Superman - Moderada",
                "Miercoles - Espalda - Remo Con Mancuernas - Moderada",
                "Miercoles - Antebrazo - Flexión De Muñeca Con Mancuernas - Moderada",
                "Miercoles - Antebrazo - Flexiones Con Cuerpo Recto Con Elevación De Cadera - Moderada",
                "Miercoles - Fuerza - Remo con barra - Moderada",
                "Miercoles - Fuerza - Elevaciones de pantorrillas - Moderada",
                //
                "Jueves - Equilibrio - Postura Del Árbol - Moderada",
                "Jueves - Equilibrio - Estiramiento De Cuádriceps - Moderada",
                "Jueves - Flexibilidad - Estiramiento de los isquiotibiales - Moderada",
                "Jueves - Flexibilidad - Estiramiento De Cuádriceps - Moderada",
                "Jueves - Aeróbico - Caminar a paso ligero - Moderada",
                "Jueves - Aeróbico - Trotar En El Mismo Lugar - Moderada",
                //
                "Viernes - Fortalecimiento - Estocadas Con Salto - Moderada",
                "Viernes - Fortalecimiento - Sentadillas Búlgaras - Moderada",
                "Viernes - Fuerza - Fondos De Tríceps En Silla - Baja",
                "Viernes - Fuerza - Plancha Lateral - Moderada",
                "Viernes - Flexibilidad - Estiramiento Cuerpo Completo - Alta",
                //
                "Sabado - Aeróbico - Caminar a paso ligero - Moderada",
                "Sabado - Aeróbico - Trote Suave - Moderada",
                //
                "Domingo - Flexibilidad - Estiramiento De Antebrazos - Alta",
                "Domingo - Flexibilidad - Estiramiento De Muñeca - Alta",
                "Domingo - Flexibilidad - Estiramiento De Gemelos - Alta",
                "Domingo - Equilibrio - Equilibrio En Talones - Alta",
                "Domingo - Equilibrio - Equilibrio Con Banda Elástica - Alta"));
        //
        planMap.put("diabetesTipo2ObesidadTipo1y2", Arrays.asList(
                "Lunes - Aeróbico - Saltos En Tijeras - Moderada",
                "Lunes - Aeróbico - Caminar a paso ligero durante - Moderada",
                "Lunes - Piernas - Sentadilla - Moderada",
                "Lunes - Pierna - Sentadilla En Sumo - Moderada",
                "Lunes - Hombro - Elevaciones Frontales De Hombro - Moderada",
                //
                "Martes - Fuerza - Remo con barra - Alta",
                "Martes - Fuerza - Press de banca - Alta",
                "Martes - Espalda - Flexiones De Pica Con Palma Hacia Abajo - Moderada",
                "Martes - Espalda - Elevaciones De Tronco - Moderada",
                //
                "Miercoles - Pecho - Flexiones Tradicionales - Moderada",
                "Miercoles - Pecho - Flexiones Con Banda Elastica - Moderada",
                "Miercoles - Equilibrio - Equilibrio En T - Moderada",
                "Miercoles - Equilibrio - Equilibrio Con Extensión De Brazos Y Piernas - Moderada",
                //
                "Jueves - Triceps - Fondos De Tríceps En Banco - Alta",
                "Jueves - Triceps - Press De Hombros Con Mancuernas - Alta",
                "Jueves - Antebrazo - Flexiones De Muñeca - Moderada",
                "Jueves - Antebrazo - Extensiones De Muñeca - Moderada",
                //
                "Viernes - Aeróbico - Saltos En Cajas - Moderada",
                "Viernes - Aeróbico - Skipping - Moderada",
                "Viernes - Anaerobico - Elevacion De Rodilla - Moderada",
                "Viernes - Anaerobico - Planchas - Moderada",
                //
                "Sabado - Equilibrio - Equilibrio Con Una Sola Pierna - Alta",
                "Sabado - Equilibrio - Elevacion De Talon - Alta",
                "Sabado - Abdominales - Abdominales Tradicionales - Moderada",
                "Sabado - Abdominales - Elevacion De Pierna - Moderada",
                //
                "Domingo - Flexibilidad - Postura Del Árbol - Moderada",
                "Domingo - Flexibilidad - Estiramiento De Cuádriceps - Moderada",
                "Domingo - Flexibilidad - Estiramiento de los isquiotibiales - -",
                "Domingo - Flexibilidad - Estiramiento del pecho - Moderada"));
        //
        planMap.put("diabetesTipo2ObesiadaTipo3y4", Arrays.asList(
                "Lunes - Aeróbico - Saltos En Tijeras - Moderada",
                "Lunes - Aeróbico - Caminar a paso ligero durante - Moderada",
                "Lunes - Piernas - Sentadilla - Moderada",
                "Lunes - Pierna - Sentadilla En Sumo - Moderada",
                "Lunes - Hombro - Elevaciones Frontales De Hombro - Moderada",
                //
                "Martes - Triceps - Fondo En Silla - Moderada",
                "Martes - Triceps - Extensión De Tríceps Con Mancuernas Y Elevación De Talones - Moderada",
                "Martes - Espalda - Flexiones De Pica Con Palma Hacia Abajo - Moderada",
                "Martes - Espalda - Elevaciones De Tronco - Moderada",
                //
                "Miercoles - Pecho - Flexiones Tradicionales - Moderada",
                "Miercoles - Pecho - Flexiones Con Banda Elastica - Moderada",
                "Miercoles - Pantorrilla - Elevacion De Talones Con Banda Elastica - Moderada",
                "Miercoles - Antebrazo - Extension De Muñeca Hacia Atras - Moderada",
                //
                "Jueves - Biceps - Flexiones Con Agarre Estrecho - Baja",
                "Jueves - Biceps - Curl De Bíceps Cruzado Con Mancuernas Desde Banco Inclinado - Baja",
                "Jueves - Antebrazo - Flexiones De Muñeca - Moderada",
                "Jueves - Antebrazo - Extensiones De Muñeca - Moderada",
                //
                "Viernes - Aeróbico - Saltos En Cajas - Moderada",
                "Viernes - Aeróbico - Skipping - Moderada",
                "Viernes - Anaerobico - Elevacion De Rodilla - Moderada",
                "Viernes - Anaerobico - Planchas - Moderada",
                //
                "Sabado - Equilibrio - Equilibrio Con Una Sola Pierna - Alta",
                "Sabado - Equilibrio - Elevacion De Talon - Alta",
                "Sabado - Abdominales - Abdominales Tradicionales - Moderada",
                "Sabado - Abdominales - Elevacion De Pierna - Moderada",
                //
                "Domingo - Flexibilidad - Postura Del Árbol - Moderada",
                "Domingo - Flexibilidad - Estiramiento De Cuádriceps - Moderada",
                "Domingo - Flexibilidad - Estiramiento de los isquiotibiales - -",
                "Domingo - Flexibilidad - Estiramiento del pecho - Moderada"));
        return planMap;
    }

    public String home() {
        return "home"; // Devuelve la vista de inicio
    }

    @GetMapping("/PlanEjercicio")
    public String listExercises(Model model) {
        List<ExerciseLogModel> exerciseLogs = planExerciseService.getAllExercise();
        model.addAttribute("exerciseLogs", exerciseLogs);
        return "listaEjercicio"; // Devuelve la vista de lista de ejercicios
    }
}
