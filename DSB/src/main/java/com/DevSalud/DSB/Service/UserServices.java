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
     * @throws NoDataFoundException si no se encuentran usuarios.
     */
    public List<UserModel> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NoDataFoundException("No se encontraron usuarios.");
        }
        return users;
    }

    /**
     * Guarda un usuario.
     *
     * @param user El modelo de usuario a guardar.
     * @return El usuario guardado.
     */
    public UserModel saveOrUpdateUser(UserModel user) {
        return userRepository.save(user);
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
     * @throws ValidateServiceException si el ID del usuario es nulo.
     * @throws NoDataFoundException si no se encuentra un usuario con el ID
     * proporcionado.
     */
    public UserModel getUserById(Long id) {
        if (id == null) {
            throw new ValidateServiceException("El ID del usuario no puede estar vacío.");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("El usuario no pudo ser encontrado con la ID: " + id));
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id El ID del usuario.
     * @throws ValidateServiceException si el ID del usuario es nulo.
     * @throws GeneralServiceException si ocurre un error al eliminar el
     * usuario.
     */
    public void deleteUserById(Long id) {
        if (id == null) {
            throw new ValidateServiceException("El ID del usuario no puede estar vacío.");
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
     * @param id El ID del usuario.
     * @param newPassword La nueva contraseña.
     * @throws ValidateServiceException si el ID del usuario es nulo.
     * @throws GeneralServiceException si ocurre un error al restablecer la
     * contraseña.
     */
    public void resetPassword(Long id, String newPassword) {
        if (id == null) {
            throw new ValidateServiceException("El ID del usuario no puede estar vacío.");
        }
        try {
            UserModel user = getUserById(id);
            user.setPassword(newPassword); // Establece la nueva contraseña sin cifrar
            userRepository.save(user);
        } catch (Exception e) {
            throw new GeneralServiceException("Error al restablecer la contraseña del usuario", e.getCause());
        }
    }

    /**
     * Obtiene un usuario por su nombre de usuario o correo electrónico.
     *
     * @param userOrEmail El nombre de usuario o correo electrónico a buscar.
     * @return El UserModel correspondiente, o null si no se encuentra.
     */
    public UserModel getUserByUsernameOrEmail(String userOrEmail) {
        return findByUserOrEmail(userOrEmail);
    }

    /**
     * Calcula la edad en base a la fecha de nacimiento.
     *
     * @param DateBirthday La fecha de nacimiento.
     * @return La edad calculada.
     */
    public Integer calculateAge(LocalDate DateBirthday) {
        if (DateBirthday == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        LocalDate Today = LocalDate.now();
        return Period.between(DateBirthday, Today).getYears();
    }

}
