package com.wonderlabz.bankaccount.mappers;

import com.wonderlabz.bankaccount.domain.dto.UserEntityDto;
import com.wonderlabz.bankaccount.domain.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserEntityMapper {

    UserEntityDto convertToUserEntityDto(UserEntity userEntity);

    UserEntity convertToUserEntity(UserEntityDto UserEntityDto);

    List<UserEntityDto> convertToUserEntityDtoList(List<UserEntity> userEntityList);
}
