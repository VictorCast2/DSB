package com.DevSalud.DSB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Model.MenuOfTheDayModel;
import com.DevSalud.DSB.Repository.MenuOfTheDayRepository;

@Service
public class MenuOfTheDayService {

    @Autowired
    private MenuOfTheDayRepository menuOfTheDayRepository;

    // Método para guardar un nuevo menú del día
    public void saveMenuOfTheDay(MenuOfTheDayModel menuOfTheDay) {
        menuOfTheDayRepository.save(menuOfTheDay);
    }

    // Método para obtener todos los menús del día
    public List<MenuOfTheDayModel> getAllMenus() {
        return menuOfTheDayRepository.findAll();
    }

    // Método para obtener un menú del día por ID
    public MenuOfTheDayModel getMenuOfTheDayById(Long id) {
        return menuOfTheDayRepository.findById(id).orElse(null);
    }

    // Método para eliminar un menú del día
    public void deleteMenuOfTheDay(Long id) {
        menuOfTheDayRepository.deleteById(id);
    }
}
