package com.gabrieldmonteiro.user.api.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gabrieldmonteiro.user.api.response.UserResponseDTO;
import com.gabrieldmonteiro.user.infrastructure.entity.AddressEntity;
import com.gabrieldmonteiro.user.infrastructure.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "userEntity.id")
    @Mapping(target = "name", source = "userEntity.name")
    @Mapping(target = "document", source = "userEntity.document")
    @Mapping(target = "address", source = "addressEntity")

    UserResponseDTO forUserResponseDTO(UserEntity userEntity, AddressEntity addressEntity);
}
