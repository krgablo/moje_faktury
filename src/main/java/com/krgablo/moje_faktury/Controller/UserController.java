package com.krgablo.moje_faktury.Controller;

import com.krgablo.moje_faktury.Entity.User;
import com.krgablo.moje_faktury.Repository.UserReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserReporitory userReporitory;


    @RequestMapping("/example")
    @ResponseBody
    public String userExample() {
        return "Example registrstion";
    }

    @GetMapping("/users")
    List<User> all() {
        return (List<User>) userReporitory.findAll();
    }


    @PostMapping("/registration")
    User newUser(@RequestBody User newUser) {
        return userReporitory.save(newUser);
    }

    @GetMapping("/users/{id}")
    User oneUser(@PathVariable int id) {

        return userReporitory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User is not found"));
    }

    @PutMapping("/users/{id}")
    User editUser(@RequestBody User newUser, @PathVariable int id) {

        return userReporitory.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setPassword(newUser.getPassword());
                    return userReporitory.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userReporitory.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id) {
        userReporitory.deleteById(id);


    }

}
