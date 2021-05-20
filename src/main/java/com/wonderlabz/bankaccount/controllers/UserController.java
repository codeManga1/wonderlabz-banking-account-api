package com.wonderlabz.bankaccount.controllers;

import com.wonderlabz.bankaccount.domain.dto.UserEntityDto;
import com.wonderlabz.bankaccount.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserEntityDto createNewUser(@RequestBody UserEntityDto user) {
        return this.userService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserEntityDto> getAllUsers() {
        return this.userService.findAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public UserEntityDto getUserById(@PathVariable Long id) {
        return this.userService.getUserByIdNumber(id);
    }
}
