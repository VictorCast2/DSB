package com.DevSalud.DSB.Service;

import com.DevSalud.DSB.Exception.GeneralServiceException;
import com.DevSalud.DSB.Exception.NoDataFoundException;
import com.DevSalud.DSB.Exception.ValidateServiceException;
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
     * Obtiene todos los usuarios.
     * @return Lista de usuarios.
     * @throws NoDataFoundException si no se encuentran usuarios.
     */
    public List<UserModel> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NoDataFoundException("No users found");
        }
        return users;
    }

    /**
     * Guarda un usuario.
     * @param model El modelo de usuario a guardar.
     * @return El usuario guardado.
     * @throws ValidateServiceException si el nombre del usuario es nulo o vacío.
     * @throws GeneralServiceException si ocurre un error al guardar el usuario.
     */
    public UserModel saveUsers(UserModel model) {
        if (model == null || model.getName().isEmpty()) {
            throw new ValidateServiceException("User name cannot be null or empty");
        }
        try {
            return userRepository.save(model);
        } catch (Exception e) {
            throw new GeneralServiceException("Error saving user", e);
        }
    }

    /**
     * Obtiene un usuario por su ID.
     * @param id El ID del usuario.
     * @return El usuario encontrado.
     * @throws ValidateServiceException si el ID del usuario es nulo.
     * @throws NoDataFoundException si no se encuentra un usuario con el ID proporcionado.
     */
    public UserModel getUserById(Long id) {
        if (id == null) {
            throw new ValidateServiceException("User ID cannot be null");
        }
        return userRepository.findById(id).orElseThrow(() -> new NoDataFoundException("User not found with ID: " + id));
    }

    /**
     * Elimina un usuario por su ID.
     * @param id El ID del usuario.
     * @throws ValidateServiceException si el ID del usuario es nulo.
     * @throws GeneralServiceException si ocurre un error al eliminar el usuario.
     */
    public void deleteUserById(Long id) {
        if (id == null) {
            throw new ValidateServiceException("User ID cannot be null");
        }
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new GeneralServiceException("Error deleting user", e.getCause());
        }
    }

    /**
     * Autentica un usuario.
     *
     * @param loginModel El modelo de inicio de sesión del usuario.
     * @return El usuario autenticado.
     * @throws ValidateServiceException si el nombre de usuario, correo electrónico o contraseña son inválidos.
     */
    /*
    public UserModel loginUser(UserModel loginModel) {
        if ((loginModel.getUsername() == null || loginModel.getUsername().isEmpty()) &&
                (loginModel.getEmailAddress() == null || loginModel.getEmailAddress().isEmpty())) {
            throw new ValidateServiceException("Debe proporcionar un nombre de usuario o un correo electrónico");
        }
        if (loginModel.getPassword() == null || loginModel.getPassword().isEmpty()) {
            throw new ValidateServiceException("La contraseña no puede estar vacía");
        }

        UserModel user = userRepository.findByUsernameOrEmailAddress(loginModel.getUsername(), loginModel.getEmailAddress());
        if (user == null || !user.getPassword().equals(loginModel.getPassword())) {
            throw new ValidateServiceException("Credenciales inválidas");
        }
        return user;
    }
     */
}