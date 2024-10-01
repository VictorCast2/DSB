package com.DevSalud.DSB.Service;

import com.DevSalud.DSB.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Repository.UserRepository;
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
     * Guarda un nuevo usuario o actualiza uno existente en la base de datos.
     *
     * @param model El objeto UserModel que contiene los datos del usuario a guardar o actualizar.
     * @return El objeto UserModel guardado, incluyendo cualquier modificación hecha por la base de datos (como la asignación de un ID).
     */
    public UserModel saveUsers(UserModel model) {
        return userRepository.save(model);
    }


        /**
     * Recupera un usuario por su ID.
     *
     * @param id El ID del usuario a recuperar.
     * @return El objeto UserModel correspondiente al ID proporcionado, o null si no se encuentra ningún usuario con ese ID.
     * @throws IllegalArgumentException Si el ID proporcionado es nulo.
     */
    public UserModel getUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo");
        }
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un usuario de la base de datos por su ID.
     *
     * @param id El ID del usuario a eliminar.
     * @throws IllegalArgumentException Si el ID proporcionado es nulo.
     */
    public void deleteUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo");
        }
        userRepository.deleteById(id);
    }


}