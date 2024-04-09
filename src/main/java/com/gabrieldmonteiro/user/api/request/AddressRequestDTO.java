package com.gabrieldmonteiro.user.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AddressRequestDTO {
    private String street;
    private Long number;
    private String district;
    private String complement;
    private String city;
    private String zipCode;
}
