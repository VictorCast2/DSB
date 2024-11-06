package com.DevSalud.DSB.Service;

import java.time.LocalDate;
import java.time.Period;
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

    public UserModel findByUserOrEmail(String userOrEmail) {
        // First, try to find by username
        UserModel user = userRepository.findByuser(userOrEmail);
        // If not found by username, try to find by email address
        if (user == null) {
            user = userRepository.findByemailAddress(userOrEmail);
        }
        return user; // Return the found user or null if not found
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

    /**
     * Restablece la contraseña de un usuario por su ID.
     *
     * @param id          El ID del usuario.
     * @param NewPassword La nueva contraseña.
     * @throws ValidateServiceException                           si el ID del
     *                                                            usuario es nulo.
     * @throws com.DevSalud.DSB.Exception.GeneralServiceException si ocurre un error
     *                                                            al restablecer la
     *                                                            contraseña.
     */
    public void olvidarContrasenna(Long id, String NewPassword) {
        if (id == null) {
            throw new ValidateServiceException("El ID del usuario no puede estar vacío");
        }
        try {
            UserModel user = getUserById(id);
            user.setPassword(NewPassword); // Establece la nueva contraseña sin cifrar
            userRepository.save(user);
        } catch (Exception e) {
            throw new GeneralServiceException("Error al restablecer la contraseña del usuario ...", e.getCause());
        }
    }

    /**
     * Obtiene un usuario por su nombre de usuario.
     *
     * @param userOrEmail El nombre de usuario a buscar.
     * @return El UserModel correspondiente al nombre de usuario, o null si no se
     *         encuentra.
     */
    public UserModel getUserByUsername(String userOrEmail) {
        return findByUserOrEmail(userOrEmail);
    }

    /**
     * Calcula la edad en base a la fecha de nacimiento.
     *
     * @param DateBirthday La fecha de nacimiento.
     * @return La edad calculada.
     */
    public Integer calculateYourAge(LocalDate DateBirthday) {
        if (DateBirthday == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        LocalDate today = LocalDate.now();
        return Period.between(DateBirthday, today).getYears();
    }
}