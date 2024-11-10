package com.DevSalud.DSB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Model.MenuOfTheDayModel;
import com.DevSalud.DSB.Repository.MenuOfTheDayRepository;

@Service
public class MenuOfTheDayService {

    @Autowired
    private MenuOfTheDayRepository menuOfTheDayRepository;

    public void saveMenuOfTheDay(MenuOfTheDayModel menuOfTheDay) {
        menuOfTheDayRepository.save(menuOfTheDay);
    }

    public MenuOfTheDayModel getMenuDelDiaById(Long id) {
        return menuOfTheDayRepository.findById(id).orElse(null); 
    }

}