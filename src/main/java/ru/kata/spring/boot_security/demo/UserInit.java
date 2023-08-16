package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserInit {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void createTestUsers() {

        Role admin = new Role("ADMIN");
        Role user = new Role("USER");
        roleService.save(admin);
        roleService.save(user);
        List<Role> roleAdmin = new ArrayList<>();
        List<Role> roleUser = new ArrayList<>();
        Collections.addAll(roleAdmin, admin, user);
        Collections.addAll(roleUser, user);
        User userOne = new User("admin", "admin", "admin", "admin", roleAdmin);
        User userTwo = new User("user", "user", "user", "user", roleUser);
        userService.save(userOne);
        userService.save(userTwo);
    }
}