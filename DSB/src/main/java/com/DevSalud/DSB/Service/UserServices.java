package com.DevSalud.DSB.Service;

import com.DevSalud.DSB.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Repository.UserRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    /**
     * @return Todos los Usuarios encontrados
     */
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * @param Model
     * @return Guardado del Modelo User
     */
    public UserModel saveUsers(UserModel Model) {
        return userRepository.save(Model);
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}