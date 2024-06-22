package com.group.unittoapp.user.controller;

import com.group.unittoapp.user.domain.User;
import com.group.unittoapp.user.dto.request.UserCreateRequest;
import com.group.unittoapp.user.dto.request.UserSignRequest;
import com.group.unittoapp.user.dto.request.UserUpdateRequest;
import com.group.unittoapp.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody UserCreateRequest request){
        return new ResponseEntity<>(userService.saveUser(request),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> signIn(@RequestBody UserSignRequest request){
        return new ResponseEntity<>(userService.validateUser(request), HttpStatus.OK);
    }
    @GetMapping("/users/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email){
        return new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
    }

    @PatchMapping("/users/{email}")
    public ResponseEntity<User> patchUser(@RequestBody UserUpdateRequest request) {
        return new ResponseEntity<>(userService.patchUser(request), HttpStatus.OK);
    }


    @DeleteMapping("/users/{email}")
    public void deleteUser(@PathVariable String email){
        userService.deleteUser(email);
    }


}
