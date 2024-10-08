package com.DevSalud.DSB.Service;

import com.DevSalud.DSB.Exception.GeneralServiceException;
import com.DevSalud.DSB.Exception.NoDataFoundException;
import com.DevSalud.DSB.Exception.ValidateServiceException;
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
            throw new NoDataFoundException("El usuario con ID no puede estar vacia");
        }
        return users;
    }

    /**
     * Guarda un usuario.
     * @param user El modelo de usuario a guardar.
     * @return El usuario guardado.
     */
    public void saveOrUpdateUsers(UserModel user) {
        userRepository.save(user);
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
            throw new ValidateServiceException("El usuario con ID no puede estar vacia");
        }
        return userRepository.findById(id).orElseThrow(() -> new NoDataFoundException("El usuaio no pudo ser encontrado con la Id: " + id));
    }

    /**
     * Elimina un usuario por su ID.
     * @param id El ID del usuario.
     * @throws ValidateServiceException si el ID del usuario es nulo.
     * @throws GeneralServiceException si ocurre un error al eliminar el usuario.
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
     * Autentica un usuario.
     *
     * @param loginModel El modelo de inicio de sesión del usuario.
     * @return El usuario autenticado.
     * @throws ValidateServiceException si el nombre de usuario, correo electrónico o contraseña son inválidos.
     */
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

}