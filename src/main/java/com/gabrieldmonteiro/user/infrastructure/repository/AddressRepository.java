package com.gabrieldmonteiro.user.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gabrieldmonteiro.user.infrastructure.entity.AddressEntity;

public interface AddressRepository extends MongoRepository <AddressEntity, String> {

        AddressEntity findByUserId(String userId);

        @Transactional
        void deleteByUserId(String userId);
}
