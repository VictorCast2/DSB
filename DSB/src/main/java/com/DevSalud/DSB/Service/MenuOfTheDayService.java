package com.DevSalud.DSB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Model.MenuOfTheDayModel;
import com.DevSalud.DSB.Repository.MenuOfTheDayRepository;

@Service
public class MenuOfTheDayService {

    @Autowired
    private MenuOfTheDayRepository menuOfTheDayRepository;

    /**
     * Guarda un nuevo menú del día.
     * @param menuOfTheDay El menú a guardar.
     * @return El menú guardado con su ID generado.
     */
    public MenuOfTheDayModel saveMenuOfTheDay(MenuOfTheDayModel menuOfTheDay) {
        try {
            return menuOfTheDayRepository.save(menuOfTheDay);
        } catch (Exception e) {
            // Manejo de errores, puedes personalizar el manejo
            throw new RuntimeException("Error al guardar el menú del día: " + e.getMessage());
        }
    }

    public MenuOfTheDayModel getMenuDelDiaById(Long id) {
        return menuOfTheDayRepository.findById(id).orElse(null); 
    }

}