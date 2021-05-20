package com.wonderlabz.bankaccount.controllers;

import com.wonderlabz.bankaccount.domain.dto.UserEntityDto;
import com.wonderlabz.bankaccount.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
