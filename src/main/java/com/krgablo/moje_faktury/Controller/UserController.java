package com.krgablo.moje_faktury.Controller;

import com.krgablo.moje_faktury.Entity.User;
import com.krgablo.moje_faktury.Repository.UserReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.krgablo.moje_faktury.Entity.Role.ADMIN;
import static com.krgablo.moje_faktury.Entity.Role.USER;

@RestController
public class UserController {

    @Autowired
    UserReporitory userReporitory;

    @GetMapping("/users/{id}")
    List<User> allUsersIfAdmin(@PathVariable int id) {
       User user = userReporitory.findById(id).orElse(null);

        if (user.getRole().equals(ADMIN)) {
            return (List<User>) userReporitory.findAll();
        }
        return null;
    }


    @PostMapping("/registration")
    User newUser(@RequestBody User newUser) {
        if(newUser.getName().equals("ADMIN")){
            newUser.setRole(ADMIN);
        }else{
            newUser.setRole(USER);
        }
        return userReporitory.save(newUser);
    }

    @GetMapping("/user/{id}")
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
                    user.setRole(newUser.getRole());
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
