package com.DevSalud.DSB.Controller;

import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping(path="/Api/Users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // POST: Añadir un nuevo usuario
    @PostMapping("/add")
    public @ResponseBody ResponseEntity<String> addNewUser(@RequestParam String FirstName,
                                                           @RequestParam String LastName,
                                                           @RequestParam String Sex,
                                                           @RequestParam String User,
                                                           @RequestParam String Password,
                                                           @RequestParam Double Weight,
                                                           @RequestParam Double Height,
                                                           @RequestParam String Disease) {
        UserModel newUser = UserModel.builder()
                .FirstName(FirstName)
                .LastName(LastName)
                .Sex(Sex)
                .User(User)
                .Password(Password)
                .Weight(Weight)
                .Height(Height)
                .Disease(Disease)
                .build();
        userRepository.save(newUser);
        return ResponseEntity.ok("User added successfully!");
    }

    // GET: Obtener todos los usuarios
    @GetMapping("/all")
    public @ResponseBody Iterable<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    // GET: Obtener un usuario por ID
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT: Actualizar un usuario existente por ID
    @PutMapping("/update/{id}")
    public @ResponseBody ResponseEntity<String> updateUser(@PathVariable Long id,
                                                           @RequestParam String FirstName,
                                                           @RequestParam String LastName,
                                                           @RequestParam String Sex,
                                                           @RequestParam String User,
                                                           @RequestParam String Password,
                                                           @RequestParam Double Weight,
                                                           @RequestParam Double Height,
                                                           @RequestParam String Disease) {

        Optional<UserModel> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            UserModel existingUser = optionalUser.get();
            existingUser.setFirstName(FirstName);
            existingUser.setLastName(LastName);
            existingUser.setSex(Sex);
            existingUser.setUser(User);
            existingUser.setPassword(Password);
            existingUser.setWeight(Weight);
            existingUser.setHeight(Height);
            existingUser.setDisease(Disease);
            userRepository.save(existingUser);
            return ResponseEntity.ok("User updated successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    // DELETE: Eliminar un usuario por ID
    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable Long id) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET: Página de índex
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // GET: Página de Login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // GET: Página de Registro
    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

}