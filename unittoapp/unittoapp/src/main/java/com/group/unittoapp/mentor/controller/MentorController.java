package com.group.unittoapp.mentor.controller;

import com.group.unittoapp.mentor.dto.response.MentorResponse;
import com.group.unittoapp.mentor.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/mentor")
public class MentorController {
    private final MentorService mentorService;

    @GetMapping
    public ResponseEntity<List<MentorResponse>> getMentor() {
        return ResponseEntity.ok(mentorService.getMentorList());
    }

}
