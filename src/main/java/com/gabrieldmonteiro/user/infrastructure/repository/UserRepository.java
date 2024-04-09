package com.gabrieldmonteiro.user.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gabrieldmonteiro.user.infrastructure.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
