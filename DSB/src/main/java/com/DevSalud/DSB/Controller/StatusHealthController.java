package com.DevSalud.DSB.Controller;

import com.DevSalud.DSB.Model.StatusHealthModel;
import com.DevSalud.DSB.Service.StatusHealthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/Api/StatusHealth")
public class StatusHealthController {

    @Autowired
    private StatusHealthServices statusHealthServices;

    /**
     * Muestra la lista de todas las entradas de StatusHealth.
     *
     * @param modelo El modelo para la vista.
     * @return La vista de lista de StatusHealth.
     */
    @GetMapping("/Lista")
    public String listaStatusHealth(Model modelo) {
        List<StatusHealthModel> statusHealthList = statusHealthServices.getAllStatusHealth();
        modelo.addAttribute("StatusHealth", statusHealthList);
        return "StatusHealth/StatusHealth";
    }

    /**
     * Muestra la página de edición de una entrada de StatusHealth.
     *
     * @param id El ID de la entrada de StatusHealth.
     * @param modelo El modelo para la vista.
     * @return La vista de edición de StatusHealth.
     */
    @GetMapping("/Editar/{id}")
    public String editarStatusHealth(@PathVariable Long id, Model modelo) {
        Optional<StatusHealthModel> statusHealth = statusHealthServices.getStatusHealthById(id);
        if (statusHealth.isPresent()) {
            modelo.addAttribute("StatusHealth", statusHealth.get());
            return "StatusHealth/StatusHealthEditar";
        } else {
            return "redirect:/StatusHealth";
        }
    }

    /**
     * Actualiza una entrada de StatusHealth.
     *
     * @param statusHealthModel El modelo de StatusHealth.
     * @param bindingResult Resultado de la validación.
     * @param redirect Atributos de redirección.
     * @param modelo El modelo para la vista.
     * @return La vista de redirección.
     */
    @PostMapping("/Actualizar")
    public String actualizarStatusHealth(@Validated @ModelAttribute("StatusHealth") StatusHealthModel statusHealthModel, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("StatusHealth", statusHealthModel);
            return "StatusHealth/StatusHealthEditar";
        }
        statusHealthServices.saveOrUpdateStatusHealth(statusHealthModel);
        redirect.addFlashAttribute("msgExito", "La entrada de StatusHealth ha sido actualizada con éxito");
        return "redirect:/StatusHealth";
    }

    /**
     * Elimina una entrada de StatusHealth por su ID.
     *
     * @param id El ID de la entrada de StatusHealth.
     * @param redirect Atributos de redirección.
     * @return La vista de redirección.
     */
    @GetMapping("/Eliminar/{id}")
    public String eliminarStatusHealth(@PathVariable Long id, RedirectAttributes redirect) {
        statusHealthServices.deleteStatusHealth(id);
        redirect.addFlashAttribute("msgExito", "Se ha eliminado con éxito");
        return "redirect:/StatusHealth";
    }

}