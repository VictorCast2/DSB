package com.DevSalud.DSB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Model.PlanesFoodModel;
import com.DevSalud.DSB.Repository.PlanesFoodRepository;

@Service
public class PlanesFoodService {

    @Autowired
    private PlanesFoodRepository planesFoodRepository;

    public List<PlanesFoodModel> listaPlanesAlimenticios(){
        return  planesFoodRepository.findAll();
    }

    public void guardarPlanAlimenticio(List<PlanesFoodModel> planes) {
        planesFoodRepository.saveAll(planes);  // Guarda todos los planes alimenticios a la vez
    }
}
