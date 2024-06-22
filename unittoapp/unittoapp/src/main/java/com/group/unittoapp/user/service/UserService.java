package com.group.unittoapp.user.service;

import com.group.unittoapp.jwt.JWTValidator;
import com.group.unittoapp.user.domain.User;
import com.group.unittoapp.user.dto.request.UserCreateRequest;
import com.group.unittoapp.user.dto.request.UserUpdateRequest;
import com.group.unittoapp.user.dto.response.UserCreateResponse;
import com.group.unittoapp.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JWTValidator jwtValidator;


    public User setUser(UserCreateRequest userCreateRequest, String token) {

        // 요청으로부터 받은 이름
        String email = userCreateRequest.getEmail();
        String userName = userCreateRequest.getUsername();
        Long admissionYear = userCreateRequest.getAdmissionYear();
        String major = userCreateRequest.getMajor();
        String preferRegion = userCreateRequest.getPreferRegion();
        String gender= userCreateRequest.getGender();

        // JWT 토큰 검증을 통해 ID 획득
        String[] inf = jwtValidator.validateToken(token);


        // 사용자 정보 설정
        User user = new User();

        user.setEmail(inf[0]);
        user.setUsername(userName);
        user.setAdmissionYear(admissionYear);
        user.setMajor(major);
        user.setPreferRegion(preferRegion);
        user.setGender(gender);

        // 사용자 정보 저장
        userRepository.save(user);

        return user;
    }

    public User patchUser(UserUpdateRequest request, User user) {
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setAdmissionYear(request.getAdmissionYear());
        user.setMajor(request.getMajor());
        user.setPreferRegion(request.getPreferRegion());
        user.setGender(request.getGender());
        user.setPoint(request.getPoint());

        // 사용자 정보 저장
        userRepository.save(user);

        return user;
    }

    public void deleteUser(User user) {
        String email = user.getEmail();

        userRepository.deleteByEmail(email);
    }


    public void validateSignUp(String token) {

        //요청으로 부터 email 추출
        String[] inf = jwtValidator.validateToken(token);

        // 이메일로 사용자 조회
        Optional<User> optionalStudent = userRepository.findByEmail(inf[0]);
        // email이 등록되어 있으면 예외 처리
        if (optionalStudent.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 가입된 사용자입니다.");
        }
    }

    public User validateUserExist(String token) {

        // JWT 토큰 검증을 통해 ID 획득
        String[] inf = jwtValidator.validateToken(token);

        return userRepository.findByEmail(inf[0])
                .orElseThrow(() -> new EntityNotFoundException("유저가 없습니다."));
    }

}
