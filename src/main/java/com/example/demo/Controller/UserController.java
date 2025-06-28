package com.example.demo.Controller;

import com.example.demo.repository.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> HelloWorld(){
        return userService.FindAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable(name = "id") Long id){
        userService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String name)
    {
        userService.update(id, email, name);
    }
}
