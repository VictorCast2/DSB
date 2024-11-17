package com.DevSalud.DSB.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.DevSalud.DSB.Model.*;
import com.DevSalud.DSB.Service.UserServices;
import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
@Controller
@RequestMapping("/Api/Users/Exercises")
public class PlanExerciseController{

        @Autowired
        private UserServices userService;

        public void PlanesAlimenticios() {

                List<PlanesFoodModel> hipertensosBajoDePeso = new ArrayList<>();
                List<PlanesFoodModel> hipertensosSobrePeso = new ArrayList<>();
                List<PlanesFoodModel> hipertensosObesidadTipo1y2 = new ArrayList<>();
                List<PlanesFoodModel> hipertensosObesidadTipo3y4 = new ArrayList<>();
                List<PlanesFoodModel> diabetesTipo1BajoDePeso = new ArrayList<>();
                List<PlanesFoodModel> diabetesTipo1SobrePeso = new ArrayList<>();
                List<PlanesFoodModel> diabetesTipo1ObesidadTipo1y2 = new ArrayList<>();
                List<PlanesFoodModel> diabetesTipo1ObesiadaTipo3y4 = new ArrayList<>();
                List<PlanesFoodModel> diabetesTipo2BajoDePeso = new ArrayList<>();
                List<PlanesFoodModel> diabetesTipo2SobrePeso = new ArrayList<>();
                List<PlanesFoodModel> diabetesTipo2ObesidadTipo1y2 = new ArrayList<>();
                List<PlanesFoodModel> diabetesTipo2ObesiadaTipo3y4 = new ArrayList<>();

                /** PLANES ALIMENTICIOS PARA HIPERTENSOS BAJO PESO */

                hipertensosBajoDePeso.add(new PlanesFoodModel(null, "Lunes",
                                "1 Arepa Mediana,1 Pocillo De Cafe De Leche, 1 Tajada De Queso Bajo En Sal",
                                "3 Unidades Pequenas De Papa Criolla,1 Porcion De Pechuga Asada,1 Porcion De Ensalada",
                                "1 Porcion De Tortilla De Habichuela, 1 Porcion De Bollo Limpio"));

                hipertensosBajoDePeso.add(new PlanesFoodModel(null, "Martes",
                                "1 Unidad Mediana De Papa Cocida (Dividida En 4 Sin Cascara), 1 Huevo Cocido",
                                "1 Pocillo De Arrroz De Cerdo Bistec (Tomate y Cebolla), 1 Porcion De Ensalada",
                                "1 Porcion De Huevo Con Espinaca, 1 Arepa Asada"));

                hipertensosBajoDePeso.add(new PlanesFoodModel(null, "Miercoles",
                                "1 Porcion De Tortilla, 1 Unidad De Papa Mediana, Cebolla Blanca y 1 Huevo Batido",
                                "1 Pedazo De Ahuyama, 1 Porcion De Pollo Asado, 1 Porcion De Vegetales",
                                "1 Porcion De Pollo Hilachado, 2 Torrejas De Pan Integral"));

                hipertensosBajoDePeso.add(new PlanesFoodModel(null, "Jueves",
                                "1 Platano Amarillo, 2 Claras De Huevos Con Tomate y Cebolla, 1 Pocillo De Cafe Con Leche",
                                "1 Porcion De Filete De Pescado, 1 Porcion De Ensalada y Un Pocillo De Arroz",
                                "1 Arepa Mediana Rellena De Pollo Hilachado Con Vegetales"));

                hipertensosBajoDePeso.add(new PlanesFoodModel(null, "Viernes",
                                "1 Trozo Mediano De Yuca, 1 Torreja De Queso",
                                "1 Plato Mediano De Sopas De Cohete Con Verduras y Papas y Ñame",
                                "1 Porcion De Boronia (1/2 De Platano Amarillo), (1/2 Berenjenas), (1/2 Tomate), (1/2 Cebolla)"));

                hipertensosBajoDePeso.add(new PlanesFoodModel(null, "Sabado",
                                "1 Arepa Mediana, 1 Pocillo De Cafe De Leche, 1 Tajada De Queso Bajo En Sal",
                                "3 Unidades Pequenas De Papa Criolla, 1 Porcion De Pechuga Asada, 1 Porcion De Ensalada",
                                "1 Porcion De Tortilla De Habichuela, 1 Porcion De Bollo Limpio"));

                hipertensosBajoDePeso.add(new PlanesFoodModel(null, "Domingo",
                                "1 Unidad Mediana De Papa Cocida (Dividida En 4 Sin Cascara), 1 Huevo Cocido",
                                "1 Pocillo De Arrroz De Cerdo Bistec (Tomate y Cebolla), 1 Porcion De Ensalada",
                                "1 Porcion De Huevo Con Espinaca, 1 Arepa Asada"));

                /** PLANES ALIMENTICIOS PARA HIPERTENSOS SOBRE PESO */
                hipertensosSobrePeso.add(new PlanesFoodModel(null, "Lunes",
                                "1 Banano, Arepa De Maíz, Huevo Revuelto, Avena",
                                "Ensalada De Tomate, Lechuga Y Arvejas, Filete De Pescado, Aceite De Oliva",
                                "Uvas Con Pan Integral Con Ajo Y Aceite De Oliva, Agua De Avena"));

                hipertensosSobrePeso.add(new PlanesFoodModel(null, "Martes",
                                "1 Mango, Papa Criolla, Queso Bajo En Sal Y Leche De Almendras",
                                "Ensalada De Tomate, Papas Cocidas, Pechugas En Cuadros, Aceite De Oliva",
                                "Sándwich De Pollo, Fruta, Té De Menta"));

                hipertensosSobrePeso.add(new PlanesFoodModel(null, "Miércoles",
                                "Papaya Con Banano, Pan Integral, Guiso Con Pollo Y Avena",
                                "Ensalada De Lechuga Crespa, Arroz De Ají, Pescado Al Vapor, Aceite De Oliva",
                                "Tostadas Integrales, Zumo De Uvas"));

                hipertensosSobrePeso.add(new PlanesFoodModel(null, "Jueves",
                                "Avena Cocida Con Frutas Frescas (Plátano, Papaya, Arándanos) Y Un Puñado De Nueces",
                                "Ensalada De Zanahorias Con Puré De Papa, Crema De Lentejas, Aceite De Oliva",
                                "Sándwich De Atún, Agua De Avena"));

                hipertensosSobrePeso.add(new PlanesFoodModel(null, "Viernes",
                                "1 Mango, Bollo De Maíz, Huevo Revuelto, Leche De Almendras",
                                "Ensalada De Atún, Vegetales Y Garbanzos, Aceite De Oliva",
                                "Manzana Y Pan Integral Con Tahini"));

                hipertensosSobrePeso.add(new PlanesFoodModel(null, "Sábado",
                                "Arándanos, Arepa De Maíz Con Queso Bajo En Sal, Avena",
                                "Ensalada De Brócoli Y Pastas Con Verduras, Pavo Horneado, Aceite De Oliva",
                                "1/2 Taza De Arroz Con Pollo, 1 Rebanada De Pan Tostado Con Ajo"));

                hipertensosSobrePeso.add(new PlanesFoodModel(null, "Domingo",
                                "Avena Cocida Con Frutas Frescas (Plátano, Mango, Arándanos) Y Un Puñado De Nueces",
                                "Ensalada De Espinacas Con Tomate, Pepino Y Aguacate Con Salmón Al Horno, Aceite De Oliva",
                                "Té De Menta, 2 Rebanadas De Pan Integral Tostado, Ajo Y Aceite De Oliva"));

                /** PLANES ALIMENTICIOS PARA HIPERTENSOS CON OBESIDAD TIPO1Y2 */
                hipertensosObesidadTipo1y2.add(new PlanesFoodModel(null, "Lunes",
                                "Mandarina, Bollo De Maíz, Huevo Revuelto, Avena Con Un Puñado De Nueces",
                                "Ensalada De Lechuga Con Garbanzos Y Un Filete De Pescado, Aceite De Oliva",
                                "Sandwich Con Guacamole"));

                hipertensosObesidadTipo1y2.add(new PlanesFoodModel(null, "Martes",
                                "1 Manzana, Papas Criolla, Queso Bajo En Sal",
                                "Ensalada De Lechuga Zukini, Arroz Integral, Pescado, Aceite De Oliva",
                                "1 Arepa De Maíz Con Atún Y Té De Menta"));

                hipertensosObesidadTipo1y2.add(new PlanesFoodModel(null, "Miércoles",
                                "1 Mango Con Banano, Pan Integral Y Huevos Revueltos",
                                "Ensala De Lechuga Zukini Con Arroz Integral Con Pescado, Aceite De Oliva",
                                "Pollo A La Parrilla Con Vegetales (Zanahorias, Pimientos) Y Quinoa"));

                hipertensosObesidadTipo1y2.add(new PlanesFoodModel(null, "Jueves",
                                "1 Mandarina, Colada De Quinua Con Tostadas Integrales Y Queso Crema",
                                "Ensalada De Aguacate Con Pechuga, Frijoles Rojos, Aceite De Oliva",
                                "Palitos De Plátano, Queso Bajo En Sal Y Té De Menta"));

                hipertensosObesidadTipo1y2.add(new PlanesFoodModel(null, "Viernes",
                                "1 Naranja, Tortilla De Papa Con Claras De Huevo Con Vegetales",
                                "Ensalada De Pepino, Arroz Integral Con Albondigas, Aceite De Oliva",
                                "Fruta Con Pan Integral Y Guacamole"));

                hipertensosObesidadTipo1y2.add(new PlanesFoodModel(null, "Sábado",
                                "Papaya, Arepa De Maíz Y Guiso De Berenjena",
                                "Pechuga De Pollo A La Parrilla Con Ensalada De Col Y Zanahorias Ralladas, Aceite De Oliva",
                                "1 Arepa Rellana Con Pollo Y Té De Menta"));

                hipertensosObesidadTipo1y2.add(new PlanesFoodModel(null, "Domingo",
                                "1 Pera, Yuca Cocida, Pollo En Cuadros Y Zumo De Uva",
                                "Ensalada De Tomate, Arroz De Verduras, Pechuga Asada, Aceite De Oliva",
                                "1 Arepa Mediana Rellena De Pollo Hilachado Con Vegetales"));

                /** PLANES ALIMENTICIOS PARA HIPERTENSOS CON OBESIDAD TIPO3Y4 */
                hipertensosObesidadTipo3y4.add(new PlanesFoodModel(null, "Lunes",
                                "Yogur Desnatado Con Copos De Avena Con Fresas Y Frutos Secos",
                                "Pasta Integral, Verduras Salteadas Con Pollo Y Una Naranja, Aceite De Oliva",
                                "Crema De Verduras Y Tortillas A La Francesa Con Carne, Aceite De Oliva"));

                hipertensosObesidadTipo3y4.add(new PlanesFoodModel(null, "Martes",
                                "2 Pan Integral, Requesón Y Zumo De Naranja",
                                "Quinoa, Verduras Crudas, Legumbre Cocida, Yogur Desnatado, Aceite De Oliva",
                                "Fajita De Trigo Integral Con Pollo Y Verduras Salteadas, Aceite De Oliva"));

                hipertensosObesidadTipo3y4.add(new PlanesFoodModel(null, "Miércoles",
                                "Pan Integral, Queso Bajo En Sal Y Fresa, Tomate Y Kiwi",
                                "Arroz Caldoso, Bacalao Con Verduras, Melón, Aceite De Oliva",
                                "Ensalada Con Atún Bajo En Sal, Yogur Desnatado, Aceite De Oliva"));

                hipertensosObesidadTipo3y4.add(new PlanesFoodModel(null, "Jueves",
                                "Yogur Desnatado, Copos De Avena Y Cereza",
                                "Pasta Integral, Huevo, Verduras Salteadas Y Naranjas, Aceite De Oliva",
                                "Verduras Cocidas, Guisantes Salteados Al Ajillo, Kiwi, Aceite De Oliva"));

                hipertensosObesidadTipo3y4.add(new PlanesFoodModel(null, "Viernes",
                                "Pan Integral, Tomate Rallado Con Huevos Revueltos, Aceite De Oliva",
                                "Pollo, Verduras Asadas, Yogur Desnatado, Aceite De Oliva",
                                "Verduras Salteadas, Pollo A La Plancha, Fruta Fresca, Aceite De Oliva"));

                hipertensosObesidadTipo3y4.add(new PlanesFoodModel(null, "Sábado",
                                "Pan Integral, Queso Bajo En Sal Y Fresco Con Mango",
                                "Lentejas Salteadas Con Verduras, Sandía, Aceite De Oliva",
                                "Ensalada De Tomate Y Pepino Con Pescado A La Plancha Y Guisante, Aceite De Oliva"));

                hipertensosObesidadTipo3y4.add(new PlanesFoodModel(null, "Domingo",
                                "Queso Bajo En Sal Y Fresco Con Pan Integral Y Fresas",
                                "Pescado Con Verduras Con Arroz, Aceite De Oliva",
                                "Pavo A La Plancha Con Verduras, Pan Integral, Aceite De Oliva"));

                /** PLANES ALIMENTICIOS PARA DIABETICO TIPO 1 CON BAJO DE PESO */
                diabetesTipo1BajoDePeso.add(new PlanesFoodModel(null, "Lunes",
                                "1 Unidad De Bollo Limpio Con 2 Unidades Huevo Cocido, Cafe Sin Azucar",
                                "Tacos De Lechuga Con Carne De Res Magra Y Guacamole",
                                "Salmon Al Horno Con Brocoli"));

                diabetesTipo1BajoDePeso.add(new PlanesFoodModel(null, "Martes",
                                "1 Unidad De Arepa Asada Con Queso Cocido, Te Sin Azucar",
                                "Cerdo Con Ensalada De Vegetales 2 Unidades De Papa",
                                "Pechuga De Pollo A La Parrilla Con Esparragos"));

                diabetesTipo1BajoDePeso.add(new PlanesFoodModel(null, "Miércoles",
                                "1 Unidad Galleta De Soda Con 2 Unidades De Huevos Revueltos Con Vegetales, Cafe Tinto Sin Azucar",
                                "Sandwich De Pavo Y Aguacate Con Pan Integral Bajo En Carbohidratos",
                                "Ensalada De Atun Con Espinacas Y Aceitunas"));

                diabetesTipo1BajoDePeso.add(new PlanesFoodModel(null, "Jueves",
                                "4 Unidades De Tostadas Con Queso Cocido, Te Sin Azucar",
                                "Lomo De Cerdo Al Horno Con Col Rizada Y Zanahorias",
                                "Pavo Molido Con Brocoli Al Vapor"));

                diabetesTipo1BajoDePeso.add(new PlanesFoodModel(null, "Viernes",
                                "2 Huevos Revueltos Con 1 Unidad De Arepa Asada, Cafe Sin Azucar",
                                "1/2 Tazon De Arroz Integral Con Pollo A La Parrilla Y Espinacas",
                                "Berenjenas Rellenas De Carne"));

                diabetesTipo1BajoDePeso.add(new PlanesFoodModel(null, "Sábado",
                                "1 Unidad De Bollo Limpio Con 2 Unidades Huevo Cocido, Cafe Sin Azucar",
                                "Tacos De Lechuga Con Carne De Res Magra Y Guacamole",
                                "Salmon Al Horno Con Brocoli"));

                diabetesTipo1BajoDePeso.add(new PlanesFoodModel(null, "Domingo",
                                "1 Unidad De Arepa Asada Con Queso Cocido, Te Sin Azucar",
                                "Cerdo Con Ensalada De Vegetales 2 Unidades De Papa",
                                "Pechuga De Pollo A La Parrilla Con Esparragos"));

                /** PLANES ALIMENTICIOS PARA DIABETICO TIPO 1 CON SOBRE PESO */
                diabetesTipo1SobrePeso.add(new PlanesFoodModel(null, "Lunes",
                                "Cafe Con Leche Descremada, 1 Huevo, 2 Rebanadas De Pan Tostados",
                                "Carne Con Ensalada De Vegetales Y 3/4 De Arroz, Aceite De Oliva",
                                "Atun En Salsa De Tomate Con Aguacate Y Lechuga"));

                diabetesTipo1SobrePeso.add(new PlanesFoodModel(null, "Martes",
                                "1 Taza De Te Verde, 1 Porcion De Ñame Cocido, Porcion De Queso Bajo En Sal Y Grasa",
                                "Pescado Al Vapor Con Ensalada De Brocoli Y 1/2 Platano Verde, Aceite De Oliva",
                                "Pechuga De Pollo Con Vegetales (Zanahorias, Habichuelas, Maiz Tierno)"));

                diabetesTipo1SobrePeso.add(new PlanesFoodModel(null, "Miércoles",
                                "Avena Cocida Con Frutas Frescas (Banana, Papaya, Arandanos) Y 1 Bollo De Maiz Cocido",
                                "Pollo Asado Con Pure De Papa Y Ensalada De Lechuga Crespa, Aceite De Oliva",
                                "Filete De Pescado Con Ensalada De Verduras Y Aguacate"));

                diabetesTipo1SobrePeso.add(new PlanesFoodModel(null, "Jueves",
                                "Cafe Con Leche Descremada, 1 Arepa De Maiz Y 1 Huevo Cocido",
                                "Cerdo Con Crema De Lenteja Y Ensalada De Tomate, 1/2 Platano No Muy Verde",
                                "Filete De Pollo Con Pan Integral Y Arandanos"));

                diabetesTipo1SobrePeso.add(new PlanesFoodModel(null, "Viernes",
                                "Te Verde, 2 Tostadas Y Huevos Revueltos",
                                "Carne Con 3/4 De Arroz Y Ensalada De Vegetales (Pimiento, Aji, Zanahorias, Pepino), Aceite De Oliva",
                                "Pechuga De Pollo Y Champiñones"));

                diabetesTipo1SobrePeso.add(new PlanesFoodModel(null, "Sábado",
                                "Avena Cocida Con Fruta, Porcion De Papa Cocida Y Pechuga Asada",
                                "Pasta Con Carne Molida, Aceite De Oliva Y Ensalada De Aguacate",
                                "Torta De Espinaca Con Huevos"));

                diabetesTipo1SobrePeso.add(new PlanesFoodModel(null, "Domingo",
                                "Leche Descremada, Arepa De Queso Asada Y 1 Porcion De Arandanos",
                                "Atun Con 2 Rodajas De Pan Integral Y Ensalada De Vegetales, Aceite De Oliva",
                                "Burrito De Fajitas De Pollo Con Verduras"));

                /** PLANES ALIMENTICIOS PARA DIABETICO TIPO 1 CON OBESIDAD TIPO1Y2 */
                diabetesTipo1ObesidadTipo1y2.add(new PlanesFoodModel(null, "Lunes",
                                "Avena Con Leche Descremada, Arándanos Y Nueces, Café O Té Sin Azúcar",
                                "Ensalada De Pollo A La Parrilla Con Espinacas, Tomate Y Aguacate, Una Rebanada De Pan Integral",
                                "Salmón A La Parrilla Con Brócoli Al Vapor, Quinoa"));

                diabetesTipo1ObesidadTipo1y2.add(new PlanesFoodModel(null, "Martes",
                                "Tortilla De Huevos Con Espinacas Y Queso Bajo En Grasa, Tostada Integral",
                                "Sándwich De Pavo Con Pan Integral, Lechuga Y Tomate, Pepinillos",
                                "Pollo Al Horno Con Verduras Asadas, Arroz Integral"));

                diabetesTipo1ObesidadTipo1y2.add(new PlanesFoodModel(null, "Miércoles",
                                "Pan Integral Con Aguacate Y Huevo Revueltos, Una Naranja",
                                "Sopa De Lentejas Con Verduras, Ensalada De Lechuga Y Tomate",
                                "Filete De Pescado Blanco Con Espárragos Al Vapor, Patatas Asadas"));

                diabetesTipo1ObesidadTipo1y2.add(new PlanesFoodModel(null, "Jueves",
                                "Smoothie De Espinacas, Plátano Y Leche Descremada, Tostadas Integrales Con Mantequilla De Almendra",
                                "Ensalada De Atún Con Garbanzos Y Verduras, Pan Integral",
                                "Carne De Res Magra A La Parrilla Con Puré De Coliflor, Ensalada Verde"));

                diabetesTipo1ObesidadTipo1y2.add(new PlanesFoodModel(null, "Viernes",
                                "Avena Con Plátano Y Semillas De Chía, Té Verde Sin Azúcar",
                                "Wrap De Pollo Con Verduras Y Salsa De Yogur, Ensalada De Col Rizada",
                                "Pasta Integral Con Salsa De Tomate Y Albóndigas De Pavo, Ensalada Mixta"));

                diabetesTipo1ObesidadTipo1y2.add(new PlanesFoodModel(null, "Sábado",
                                "Tortilla De Claras De Huevo Con Champiñones Y Espinacas, Pan Integral",
                                "Sopa De Verduras Con Pan Integral, Ensalada Verde",
                                "Pollo A La Parrilla Con Arroz Basmati, Ensalada De Tomate Y Albahaca"));

                diabetesTipo1ObesidadTipo1y2.add(new PlanesFoodModel(null, "Domingo",
                                "Avena Con Frutos Rojos Y Nueces, Té O Café Sin Azúcar",
                                "Sándwich De Atún Con Pan Integral Y Aguacate, Ensalada De Espinacas",
                                "Bistec A La Parrilla Con Espárragos, Puré De Batata"));

                /** PLANES ALIMENTICIOS PARA DIABETICO TIPO 1 CON OBESIDAD TIPO3Y4 */
                diabetesTipo1ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Lunes",
                                "Avena Con Leche Descremada Y Frutos Rojos (Como Frambuesas O Arándanos), Café O Té Sin Azúcar",
                                "Ensalada De Pollo A La Parrilla Con Espinacas, Aguacate Y Tomate",
                                "Salmón Al Horno Con Espárragos Y Calabacín, Un Pequeño Trozo De Patata Dulce Al Horno"));

                diabetesTipo1ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Martes",
                                "Tortilla De Claras De Huevo Con Champiñones Y Espinacas, Tostada Integral",
                                "Wrap De Pollo Con Lechuga Y Pimientos, Una Manzana Pequeña",
                                "Pechuga De Pollo Asada Con Brócoli Y Coliflor Al Vapor, Una Pequeña Porción De Arroz Integral"));

                diabetesTipo1ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Miércoles",
                                "Smoothie De Espinacas, Plátano Y Leche Descremada, Tostada Integral Con Mantequilla De Almendra",
                                "Sopa De Lentejas Con Verduras, Ensalada Verde",
                                "Filete De Pescado Blanco Con Espárragos Al Vapor, Un Pequeño Trozo De Batata Al Horno"));

                diabetesTipo1ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Jueves",
                                "Avena Con Leche Descremada Y Frambuesas, Té Verde Sin Azúcar",
                                "Sándwich De Pavo Con Pan Integral, Aguacate Y Espinacas, Ensalada Verde",
                                "Pollo A La Parrilla Con Calabacín Y Pimientos Asados, Un Pequeño Trozo De Quinoa"));

                diabetesTipo1ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Viernes",
                                "Tortilla De Huevo Con Espinacas Y Queso Bajo En Grasa, Pan Integral Con Aguacate",
                                "Sándwich De Pollo Con Pan Integral Y Verduras Frescas, Ensalada Verde",
                                "Carne De Res Magra Con Brócoli Y Espárragos, Un Pequeño Trozo De Arroz Integral"));

                diabetesTipo1ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Sábado",
                                "Smoothie De Espinacas Y Plátano Con Leche Descremada, Tostada Integral",
                                "Sopa De Verduras Con Lentejas Y Espinacas, Pan Integral",
                                "Filete De Pescado Blanco Al Horno Con Brócoli Y Champiñones, Un Pequeño Trozo De Batata Al Horno"));

                diabetesTipo1ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Domingo",
                                "Panqueques De Proteína Con Fresas Y Crema Agria",
                                "Ensalada De Pollo A La Parrilla Con Espinacas Y Aguacate, Sopa De Verduras",
                                "Pollo A La Parrilla Con Pimientos Y Espárragos, Arroz Integral"));

                /** PLANES ALIMENTICIOS PARA DIABETICO TIPO 2 CON BAJO DE PESO */
                diabetesTipo2BajoDePeso.add(new PlanesFoodModel(null, "Lunes",
                                "Huevos Revueltos Con Espinacas, Café Sin Azúcar",
                                "Ajiaco Sin Papas Y Con Pollo Magro",
                                "Pechuga De Pollo Con Salsa De Mostaza"));

                diabetesTipo2BajoDePeso.add(new PlanesFoodModel(null, "Martes",
                                "1 Tortilla De Claras De Huevo, Té Sin Azúcar",
                                "Sancocho De Pescado Con Vegetales Bajos En Carbohidratos",
                                "Ensalada De Atún Y Aguacate"));

                diabetesTipo2BajoDePeso.add(new PlanesFoodModel(null, "Miércoles",
                                "Huevos Cocidos Con Aguacate, Café Tinto Sin Azúcar",
                                "Sándwich De Pavo Y Aguacate Con Pan Integral Bajo En Carbohidratos",
                                "Pechuga De Pollo Con Almendras"));

                diabetesTipo2BajoDePeso.add(new PlanesFoodModel(null, "Jueves",
                                "4 Unidades De Tostadas Con Queso Cocido, Té Sin Azúcar",
                                "Pescado A La Plancha Con Limón Y Hierbas",
                                "Sopa De Lentejas Con Chorizo"));

                diabetesTipo2BajoDePeso.add(new PlanesFoodModel(null, "Viernes",
                                "Panqueques De Avena, Café Sin Azúcar",
                                "Pescado A La Plancha Con Limón Y Hierbas",
                                "Pechuga De Pollo Rellena De Espinacas Y Queso"));

                diabetesTipo2BajoDePeso.add(new PlanesFoodModel(null, "Sábado",
                                "Huevos Revueltos Con Espinacas, Café Sin Azúcar",
                                "Ajiaco Sin Papas Y Con Pollo Magro",
                                "Pechuga De Pollo Con Salsa De Mostaza"));

                diabetesTipo2BajoDePeso.add(new PlanesFoodModel(null, "Domingo",
                                "1 Tortilla De Claras De Huevo, Té Sin Azúcar",
                                "Sancocho De Pescado Con Vegetales Bajos En Carbohidratos",
                                "Ensalada De Atún Y Aguacate"));

                /** PLANES ALIMENTICIOS PARA DIABETICO TIPO 2 CON SOBRE PESO */
                diabetesTipo2SobrePeso.add(new PlanesFoodModel(null, "Lunes",
                                "Pan Integral Con Salmon Ahumado, Cafe Sin Azucar",
                                "Ensalada De Aguacate, Tomate Y Queso Fresco",
                                "Brochetas De Carne Y Vegetales"));

                diabetesTipo2SobrePeso.add(new PlanesFoodModel(null, "Martes",
                                "Pan Integral Con Queso Fresco, Te Sin Azucar",
                                "Sopa De Lentejas Con Vegetales",
                                "Pimientos Rellenos De Carne Molida"));

                diabetesTipo2SobrePeso.add(new PlanesFoodModel(null, "Miércoles",
                                "1 Rebanada De Pan Integral Tostada Con 1/2 Aguacate Y 1 Huevo Pochado, Cafe Tinto Sin Azucar",
                                "Pescado Al Horno Con Ajo Y Hierbas",
                                "Sopa De Pollo Con Papas, Mazorcas De Maíz Y Guascas"));

                diabetesTipo2SobrePeso.add(new PlanesFoodModel(null, "Jueves",
                                "Omelette Con Champiñones, Pimientos Y Queso Bajo En Grasa, Te Sin Azucar",
                                "Ensalada De Pollo Con Nueces Y Espinacas",
                                "Chuletas De Cerdo A La Parrilla"));

                diabetesTipo2SobrePeso.add(new PlanesFoodModel(null, "Viernes",
                                "Ensalada De Aguacate, Tomate Y Queso Feta, Cafe Sin Azucar",
                                "Albondigas De Pollo Con Salsa De Tomate Sin Azucar",
                                "Camarones A La Plancha: Con Ajo Y Perejil"));

                diabetesTipo2SobrePeso.add(new PlanesFoodModel(null, "Sábado",
                                "Omelette Con Champiñones, Pimientos Y Queso Bajo En Grasa, Te Sin Azucar",
                                "Ensalada De Pollo Con Nueces Y Espinacas",
                                "Chuletas De Cerdo A La Parrilla"));

                diabetesTipo2SobrePeso.add(new PlanesFoodModel(null, "Domingo",
                                "Ensalada De Aguacate, Tomate Y Queso Feta, Cafe Sin Azucar",
                                "Albondigas De Pollo Con Salsa De Tomate Sin Azucar",
                                "Camarones A La Plancha: Con Ajo Y Perejil"));

                /** PLANES ALIMENTICIOS PARA DIABETICO TIPO 2 CON OBESIDAD TIPO1Y2 */
                diabetesTipo2ObesidadTipo1y2.add(new PlanesFoodModel(null, "Lunes",
                                "Ensalada De Pollo A La Parrilla Con Aguacate Y Nueces",
                                "Ensalada De Atún Con Aguacate Y Huevo Duro",
                                "Pavo Molido Con Brócoli Al Vapor Y Salsa De Tomate Baja En Carbohidratos"));

                diabetesTipo2ObesidadTipo1y2.add(new PlanesFoodModel(null, "Martes",
                                "Tostadas De Centeno Con Queso Crema Y Salmón",
                                "Chuletas De Cerdo A La Parrilla Con Brócoli Al Vapor",
                                "Lomo De Cerdo Asado Con Brócoli Y Zanahorias"));

                diabetesTipo2ObesidadTipo1y2.add(new PlanesFoodModel(null, "Miércoles",
                                "Huevos Duros Con Zanahorias Baby Y Hummus",
                                "Filete De Salmón Al Horno Con Ensalada De Pepino",
                                "Ensalada De Salmón Con Huevo Duro Y Pepinillos"));

                diabetesTipo2ObesidadTipo1y2.add(new PlanesFoodModel(null, "Jueves",
                                "Tostadas De Huevo Duro Con Aguacate",
                                "Pechuga De Pollo A La Plancha Con Espárragos",
                                "Tazón De Quinua Con Pollo A La Parrilla Y Brócoli"));

                diabetesTipo2ObesidadTipo1y2.add(new PlanesFoodModel(null, "Viernes",
                                "Empanadas De Huevo Con Ensalada De Vegetales",
                                "Ensalada De Atún Con Aceitunas Y Tomates Cherry",
                                "Berenjenas Rellenas De Carne Magra Y Tomate"));

                diabetesTipo2ObesidadTipo1y2.add(new PlanesFoodModel(null, "Sábado",
                                "Tostadas De Centeno Con Queso Crema Y Salmón",
                                "Chuletas De Cerdo A La Parrilla Con Brócoli Al Vapor",
                                "Lomo De Cerdo Asado Con Brócoli Y Zanahorias"));

                diabetesTipo2ObesidadTipo1y2.add(new PlanesFoodModel(null, "Domingo",
                                "Huevos Duros Con Zanahorias Baby Y Hummus",
                                "Filete De Salmón Al Horno Con Ensalada De Pepino",
                                "Ensalada De Salmón Con Huevo Duro Y Pepinillos"));

                /** PLANES ALIMENTICIOS PARA DIABETICO TIPO 2 CON OBESIDAD TIPO3Y4 */
                diabetesTipo2ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Lunes",
                                "Rollitos De Jamon Y Queso",
                                "Caldo De Costilla Con Verduras",
                                "Pavo Molido Con Brocoli Al Vapor Y Salsa De Tomate Baja En Carbohidratos"));

                diabetesTipo2ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Martes",
                                "Sandwich De Aguacate Y Huevo",
                                "Pargo Al Horno Con Hierbas Y Limon",
                                "Lomo De Cerdo Asado Con Brocoli Y Zanahorias"));

                diabetesTipo2ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Miércoles",
                                "Bunuelos De Queso Light",
                                "Cazuela De Frijoles Con Pollo Y Vegetales",
                                "Ensalada De Salmon Con Huevo Duro Y Pepinillos"));

                diabetesTipo2ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Jueves",
                                "Arepa Integral Con Queso Blanco, Cafe Sin Azucar",
                                "Pechuga De Pollo A La Parrilla Con Ensalada De Col Rizada",
                                "Pollo A La Parrilla Con Brocoli Y Zanahorias"));

                diabetesTipo2ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Viernes",
                                "Arepas De Quinoa Con Huevo Pochado",
                                "Tamales Con Pollo Y Verduras (Moderacion En El Consumo Debido A La Masa)",
                                "Salmon Al Horno Con Esparragos Y Limon"));

                diabetesTipo2ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Sábado",
                                "Arepa Integral Con Queso Blanco, Cafe Sin Azucar",
                                "Ensalada De Lentejas Con Huevo Duro Y Espinacas",
                                "Pechuga De Pavo Al Horno Con Hierbas Y Especias"));

                diabetesTipo2ObesiadaTipo3y4.add(new PlanesFoodModel(null, "Domingo",
                                "Panqueques De Proteina Con Fresas Y Crema Agria",
                                "Caldo De Pescado Con Vegetales",
                                "Pulpo A La Gallega, Cocido Con Paprika Y Aceite De Oliva"));

        }
        
}