package com.group.unittoapp.mentorHonor.controller;

import com.group.unittoapp.mentorHonor.domain.MentorHonor;
import com.group.unittoapp.mentorHonor.dto.response.MentorRankResponse;
import com.group.unittoapp.mentorHonor.repository.MentorRepository;
import com.group.unittoapp.mentorHonor.service.MentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MentorController {
    private final MentorRepository mentorRepository;
    private final MentorService mentorService;

    public MentorController(MentorRepository mentorRepository, MentorService mentorService) {
        this.mentorRepository = mentorRepository;
        this.mentorService = mentorService;
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<MentorRankResponse>> getMentorList(){
        return new ResponseEntity<>(mentorService.getMentorList(), HttpStatus.OK);
    }
}
