package com.gabrieldmonteiro.user.api.converter;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.gabrieldmonteiro.user.api.request.AddressRequestDTO;
import com.gabrieldmonteiro.user.api.request.UserRequestDTO;
import com.gabrieldmonteiro.user.infrastructure.entity.AddressEntity;
import com.gabrieldmonteiro.user.infrastructure.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserConverter {

    public UserEntity forUserEntity(UserRequestDTO userDTO) {
        return UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(userDTO.getName())
                .document(userDTO.getDocument())
                .email(userDTO.getEmail())
                .signDate(LocalDateTime.now())
                .build();
    }

    public AddressEntity forAddressEntity(AddressRequestDTO addressDTO, String userID) {
        return AddressEntity.builder()
                .street(addressDTO.getStreet())
                .district(addressDTO.getDistrict())
                .userId(userID)
                .zipCode(addressDTO.getZipCode())
                .city(addressDTO.getCity())
                .number(addressDTO.getNumber())
                .complement(addressDTO.getComplement())
                .build();
    }

}
