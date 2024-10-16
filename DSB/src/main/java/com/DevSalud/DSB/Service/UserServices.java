package com.DevSalud.DSB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Exception.GeneralServiceException;
import com.DevSalud.DSB.Exception.NoDataFoundException;
import com.DevSalud.DSB.Exception.ValidateServiceException;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Repository.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    /**
     * Obtiene todos los usuarios.
     * 
     * @return Lista de usuarios.
     * @throws com.DevSalud.DSB.Exception.NoDataFoundException si no se encuentran
     *                                                         usuarios.
     */
    public List<UserModel> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NoDataFoundException("El usuario con ID no puede estar vacia");
        }
        return users;
    }

    /**
     * Guarda un usuario.
     * 
     * @param Users El modelo de usuario a guardar.
     * @return El usuario guardado.
     */
    public void saveOrUpdateUsers(UserModel Users) {
        userRepository.save(Users);
    }

    public UserModel findByUserOrEmail(String UserOrEmail) {
        // Primero, intenta buscar por nombre de usuario
        UserModel user = userRepository.findByUsername(UserOrEmail);

        // Si no se encontró un usuario por nombre de usuario, intenta buscar por
        // dirección de correo electrónico
        if (user == null) {
            user = userRepository.findByEmailAddress(UserOrEmail);
        }
        return user; // Retorna el usuario encontrado o null si no se encontró
    }

    /**
     * Obtiene un usuario por su ID.
     * 
     * @param id El ID del usuario.
     * @return El usuario encontrado.
     * @throws com.DevSalud.DSB.Exception.ValidateServiceException si el ID del
     *                                                             usuario es nulo.
     * @throws NoDataFoundException                                si no se
     *                                                             encuentra un
     *                                                             usuario con el ID
     *                                                             proporcionado.
     */
    public UserModel getUserById(Long id) {
        if (id == null) {
            throw new ValidateServiceException("El usuario con ID no puede estar vacia");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("El usuaio no pudo ser encontrado con la Id: " + id));
    }

    /**
     * Elimina un usuario por su ID.
     * 
     * @param id El ID del usuario.
     * @throws ValidateServiceException                           si el ID del
     *                                                            usuario es nulo.
     * @throws com.DevSalud.DSB.Exception.GeneralServiceException si ocurre un error
     *                                                            al eliminar el
     *                                                            usuario.
     */
    public void deleteUserById(Long id) {
        if (id == null) {
            throw new ValidateServiceException("El usuario con ID no puede estar vacia");
        }
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new GeneralServiceException("Error al eliminar el usuario", e.getCause());
        }
    }

}