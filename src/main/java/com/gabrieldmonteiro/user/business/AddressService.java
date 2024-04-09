package com.gabrieldmonteiro.user.business;

import org.springframework.stereotype.Service;

import com.gabrieldmonteiro.user.infrastructure.entity.AddressEntity;
import com.gabrieldmonteiro.user.infrastructure.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressEntity saveAddress(AddressEntity addressEntity) {
        return addressRepository.save(addressEntity);
    }

    public AddressEntity findByUserId(String userId){
        return addressRepository.findByUserId(userId);
    }

    public void deleteByUserId(String userID){
        addressRepository.deleteByUserId(userID);
    }
}
