package com.group.unittoapp.user.controller;

import com.group.unittoapp.jwt.RequireJWT;
import com.group.unittoapp.user.domain.User;
import com.group.unittoapp.user.dto.request.UserCreateRequest;
import com.group.unittoapp.user.dto.request.UserUpdateRequest;
import com.group.unittoapp.user.dto.response.UserCreateResponse;
import com.group.unittoapp.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("연결 성공", HttpStatus.OK);
    }
    @PostMapping("/signin")
    public ResponseEntity<User> signIn(
            @RequestHeader("Authorization") String token
    ) {
        User user = userService.validateUserExist(token);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @RequireJWT
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(
            @RequestHeader("Authorization") String token,
            @RequestBody UserCreateRequest userCreateRequest
    ) {
        userService.validateSignUp(token);
        User user = userService.setUser(userCreateRequest, token);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequireJWT
    @PatchMapping("/user")
    public ResponseEntity<User> patchUser(
            @RequestHeader("Authorization") String token,
            @RequestBody UserUpdateRequest request
    ) {
        User user = userService.validateUserExist(token);

        return new ResponseEntity<>(userService.updateUser(request ,user),HttpStatus.OK);
    }

    @RequireJWT
    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(
            @RequestHeader("Authorization") String token
    ) {
        User user = userService.validateUserExist(token);
        userService.deleteUser(user);

        return new ResponseEntity<>("회원 삭제 성공", HttpStatus.OK);
    }

    @RequireJWT
    @GetMapping("/user")
    public ResponseEntity<UserCreateResponse> getUser(
            @RequestHeader("Authorization") String token
    ){
        User user = userService.validateUserExist(token);
        return ResponseEntity.ok(userService.getUserInfo(user));
    }
}
