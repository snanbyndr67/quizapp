package com.quizapp.multiplechoice.controller;


import com.quizapp.multiplechoice.model.Role;
import com.quizapp.multiplechoice.model.User;
import com.quizapp.multiplechoice.model.UserRole;
import com.quizapp.multiplechoice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    //Kullanıcı oluşturma
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles=new HashSet<>();

        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("STUDENT");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user, roles);

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //Kullanıcıyı kimliğe göre silme
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }


    //Api'yi güncelleme
}
