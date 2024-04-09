package com.gabrieldmonteiro.user.api.response;

public record AddressResponseDTO(
        String street,
        Long number,
        String district,
        String complement,
        String city,
        String zipCode) {

}
