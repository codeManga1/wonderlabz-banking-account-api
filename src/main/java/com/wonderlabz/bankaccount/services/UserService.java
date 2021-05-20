package com.wonderlabz.bankaccount.services;

import com.wonderlabz.bankaccount.domain.dto.UserEntityDto;

import java.util.List;

public interface UserService {

    UserEntityDto saveUser(UserEntityDto user);

    List<UserEntityDto> findAllUsers();

    UserEntityDto getUserByIdNumber(Long idNumber);
}
