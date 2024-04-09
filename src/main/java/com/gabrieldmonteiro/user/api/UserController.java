package com.gabrieldmonteiro.user.api;

import com.gabrieldmonteiro.user.infrastructure.entity.UserEntity;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.gabrieldmonteiro.user.api.request.UserRequestDTO;
import com.gabrieldmonteiro.user.api.response.UserResponseDTO;
import com.gabrieldmonteiro.user.business.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponseDTO> saveUserData(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.recordUsers(userRequestDTO));
    }

    @GetMapping()
    public ResponseEntity<UserResponseDTO> findUserByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(userService.findUserData(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserData(@RequestParam("email") String email){
        userService.deleteUserData(email);
        return ResponseEntity.accepted().build();
    }
}
