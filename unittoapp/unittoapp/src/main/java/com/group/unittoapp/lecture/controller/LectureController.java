package com.group.unittoapp.lecture.controller;

import com.group.unittoapp.lecture.domain.Lecture;
import com.group.unittoapp.lecture.dto.request.LectureCreateRequest;
import com.group.unittoapp.lecture.service.LectureService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @PostMapping("/lectures")
    public ResponseEntity<Lecture> createLecture(
            @RequestBody LectureCreateRequest lectureCreateRequest
            ){
        Lecture lecture = lectureService.setLecture(lectureCreateRequest);

        return new ResponseEntity<>(lecture, HttpStatus.OK);
    }

    @GetMapping("/lectures")
    public ResponseEntity<Lecture> getLecture(@RequestParam Long id) {
        return ResponseEntity.ok(lectureService.getLecture(id));
    }
}
