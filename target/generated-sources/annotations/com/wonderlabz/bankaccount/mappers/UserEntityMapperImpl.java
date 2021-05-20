package com.wonderlabz.bankaccount.mappers;

import com.wonderlabz.bankaccount.domain.dto.UserEntityDto;
import com.wonderlabz.bankaccount.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-20T22:45:31+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
public class UserEntityMapperImpl implements UserEntityMapper {

    @Override
    public UserEntityDto convertToUserEntityDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserEntityDto userEntityDto = new UserEntityDto();

        userEntityDto.setIdNumber( userEntity.getIdNumber() );
        userEntityDto.setFirstName( userEntity.getFirstName() );
        userEntityDto.setLastName( userEntity.getLastName() );

        return userEntityDto;
    }

    @Override
    public UserEntity convertToUserEntity(UserEntityDto UserEntityDto) {
        if ( UserEntityDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setIdNumber( UserEntityDto.getIdNumber() );
        userEntity.setFirstName( UserEntityDto.getFirstName() );
        userEntity.setLastName( UserEntityDto.getLastName() );

        return userEntity;
    }

    @Override
    public List<UserEntityDto> convertToUserEntityDtoList(List<UserEntity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<UserEntityDto> list = new ArrayList<UserEntityDto>( userEntityList.size() );
        for ( UserEntity userEntity : userEntityList ) {
            list.add( convertToUserEntityDto( userEntity ) );
        }

        return list;
    }
}
