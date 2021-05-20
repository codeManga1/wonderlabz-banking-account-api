package com.wonderlabz.bankaccount.services.impl;

import com.wonderlabz.bankaccount.domain.dto.UserEntityDto;
import com.wonderlabz.bankaccount.domain.entities.UserEntity;
import com.wonderlabz.bankaccount.exceptions.BadRequestException;
import com.wonderlabz.bankaccount.exceptions.ResourceAlreadyExistsException;
import com.wonderlabz.bankaccount.exceptions.NotFoundException;
import com.wonderlabz.bankaccount.mappers.UserEntityMapper;
import com.wonderlabz.bankaccount.repository.UserRepository;
import com.wonderlabz.bankaccount.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserEntityMapper mapper = Mappers.getMapper(UserEntityMapper.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntityDto saveUser(UserEntityDto userEntityDto) {
        if (!this.validateUserData(userEntityDto)) {
            throw new BadRequestException("Please enter all the required fields");
        }

        if (this.checkIfSchemeExists(userEntityDto.getIdNumber())) {
            throw new ResourceAlreadyExistsException("User of this ID Number: " + userEntityDto.getIdNumber() +
                    " already exists");
        }

        UserEntity userEntity = this.mapper.convertToUserEntity(userEntityDto);
        return this.mapper.convertToUserEntityDto(userRepository.save(userEntity));
    }

    @Override
    public List<UserEntityDto> findAllUsers() {
        return this.mapper.convertToUserEntityDtoList(this.userRepository.findAll());
    }

    @Override
    public UserEntityDto getUserByIdNumber(Long idNumber) {
        UserEntity userEntity = userRepository.findById(idNumber).orElse(null);
        return this.mapper.convertToUserEntityDto(userEntity);
    }

    private boolean validateUserData(UserEntityDto userEntityDto) {
        return !userEntityDto.getLastName().isEmpty() && !userEntityDto.getFirstName().isEmpty();
    }

    private boolean checkIfSchemeExists(long idNumber) {
        return (this.getUserByIdNumber(idNumber) != null);
    }
}
