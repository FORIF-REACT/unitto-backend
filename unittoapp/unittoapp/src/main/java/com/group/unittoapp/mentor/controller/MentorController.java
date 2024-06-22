package com.group.unittoapp.mentor.controller;

import com.group.unittoapp.mentor.domain.Mentor;
import com.group.unittoapp.mentor.dto.response.MentorResponse;
import com.group.unittoapp.mentor.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MentorController {

    private final MentorService mentorService;

    @GetMapping("/mentor")
    public ResponseEntity<MentorResponse> getMentor() {
        return ResponseEntity.ok(mentorService.getUser());
    }

}
