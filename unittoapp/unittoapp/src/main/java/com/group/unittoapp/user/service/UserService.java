package com.group.unittoapp.user.service;

import com.group.unittoapp.user.domain.User;
import com.group.unittoapp.user.dto.request.UserCreateRequest;
import com.group.unittoapp.user.dto.request.UserSignRequest;
import com.group.unittoapp.user.dto.request.UserUpdateRequest;
import com.group.unittoapp.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.jaxb.hbm.spi.EntityInfo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User validateUser(UserSignRequest request){
        return userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("유저가 없습니다."));

    }
    public User saveUser(UserCreateRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setAdmissionYear(request.getAdmissionYear());
        user.setUsername(request.getUsername());
        user.setMajor(request.getMajor());
        user.setPreferRegion(request.getPreferRegion());

        userRepository.save(user);
        return user;
    }

    public User getUser(String email){
        return userRepository.findByEmail(email).
                orElseThrow(() -> new EntityNotFoundException("유저가 없습니다."));
    }

    public User patchUser(UserUpdateRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("유저가 없습니다."));

        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setAdmissionYear(request.getAdmissionYear());
        user.setUsername(request.getUsername());
        user.setMajor(request.getMajor());
        user.setPreferRegion(request.getPreferRegion());

        return user;
    }

    public void deleteUser(String email){
        userRepository.deleteByEmail(email);
    }



}
