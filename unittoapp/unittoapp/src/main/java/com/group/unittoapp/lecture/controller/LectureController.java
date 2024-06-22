package com.group.unittoapp.lecture.controller;

import com.group.unittoapp.lecture.domain.Lecture;
import com.group.unittoapp.lecture.dto.request.LectureApplyRequest;
import com.group.unittoapp.lecture.dto.request.LectureCreateRequest;
import com.group.unittoapp.lecture.dto.request.MyClassRequest;
import com.group.unittoapp.lecture.service.LectureService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @PostMapping("/lectures")
    public ResponseEntity<Lecture> createLecture(
            @RequestBody LectureCreateRequest lectureCreateRequest
    ) {
        Lecture lecture = lectureService.setLecture(lectureCreateRequest);

        return new ResponseEntity<>(lecture, HttpStatus.OK);
    }

    @GetMapping("/lectures")
    public ResponseEntity<Lecture> getLecture(@RequestParam Long id) {
        return ResponseEntity.ok(lectureService.getLecture(id));
    }

    @PostMapping("/apply")
    public void ApplyLecture(@RequestBody LectureApplyRequest request) {
        lectureService.applyLecture(request);
    }

    @PostMapping("/myclassmentor")
    public ResponseEntity<List<Lecture>> getMyClassMentor(@RequestBody MyClassRequest request) {
        return new ResponseEntity<>(lectureService.getMyClassMentor(request), HttpStatus.OK);
    }

    @GetMapping("/myclassmentor/accept")
    public void acceptLecture(@RequestParam Long id){
        lectureService.acceptLecture(id);
    }
    @DeleteMapping("/myclassmentor/decline")
    public void declineLecture(@RequestParam Long id) {
        lectureService.declineLecture(id);
    }
    @GetMapping("/myclassmentor/end")
    public void endLecture(@RequestParam Long id) {
        lectureService.endLecture(id);
    }

    @PostMapping("/myclassmenti")
    public ResponseEntity<List<Lecture>> getMyClassMenti(@RequestBody MyClassRequest request) {
        return new ResponseEntity<>(lectureService.getMyClassMenti(request), HttpStatus.OK);
    }
}
