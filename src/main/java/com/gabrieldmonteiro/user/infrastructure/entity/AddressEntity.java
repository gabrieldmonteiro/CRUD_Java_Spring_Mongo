package com.gabrieldmonteiro.user.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "address_entity")
public class AddressEntity {
    @Id
    private String id;
    private String userId;
    private String street;
    private Long number;
    private String complement;
    private String district;
    private String city;
    private String zipCode;   
}
