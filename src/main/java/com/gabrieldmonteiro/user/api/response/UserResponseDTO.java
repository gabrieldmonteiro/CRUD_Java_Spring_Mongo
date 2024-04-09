package com.gabrieldmonteiro.user.api.response;

public record UserResponseDTO(
        String id,
        String name,
        String document,
        AddressResponseDTO address) {

}
