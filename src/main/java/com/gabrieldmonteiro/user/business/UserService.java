package com.gabrieldmonteiro.user.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrieldmonteiro.user.api.converter.UserConverter;
import com.gabrieldmonteiro.user.api.converter.UserMapper;
import com.gabrieldmonteiro.user.api.request.UserRequestDTO;
import com.gabrieldmonteiro.user.api.response.UserResponseDTO;
import com.gabrieldmonteiro.user.infrastructure.entity.AddressEntity;
import com.gabrieldmonteiro.user.infrastructure.entity.UserEntity;
import com.gabrieldmonteiro.user.infrastructure.exceptions.BusinessException;
import com.gabrieldmonteiro.user.infrastructure.repository.UserRepository;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final UserMapper userMapper;
    private final AddressService addressService;

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserResponseDTO recordUsers(UserRequestDTO userRequestDTO) {
        try {
            notNull(userRequestDTO, "User infos are required");
            UserEntity userEntity = saveUser(userConverter.forUserEntity(userRequestDTO));
            AddressEntity addressEntity = addressService
                    .saveAddress(userConverter.forAddressEntity(userRequestDTO.getAddress(), userEntity.getId()));
            return userMapper.forUserResponseDTO(userEntity, addressEntity);
        } catch (Exception e) {
            throw new BusinessException("Error when trying to save data", e);
        }
    }

    public UserResponseDTO findUserData(String email) {
        try {
            UserEntity entity = userRepository.findByEmail(email);
            notNull(entity, "User not found");
            AddressEntity addressEntity = addressService.findByUserId(entity.getId());

            return userMapper.forUserResponseDTO(entity, addressEntity);
        } catch (Exception e) {
            throw new BusinessException("Error when trying to find user data", e);
        }
    }

    @Transactional
    public void deleteUserData(String email) {
        UserEntity entity = userRepository.findByEmail(email);
        userRepository.deleteByEmail(email);
        addressService.deleteByUserId(entity.getId());
    }
}
