package tech.gregori.springbootecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.gregori.springbootecommerce.db.UserRepository;
import tech.gregori.springbootecommerce.model.User;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }
}