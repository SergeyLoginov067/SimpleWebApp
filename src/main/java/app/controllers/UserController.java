package app.controllers;

import app.dao.UserDAO;
import app.entity.User;
import app.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/{id}")
    public User getUser(@PathVariable(name = "id") Long id) {
        Optional<User> user = userDAO.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userDAO.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        userDAO.deleteById(id);
    }

}
