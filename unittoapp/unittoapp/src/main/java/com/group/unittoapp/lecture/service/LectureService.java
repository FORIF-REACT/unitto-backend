package com.group.unittoapp.lecture.service;

import com.group.unittoapp.lecture.domain.Lecture;
import com.group.unittoapp.lecture.dto.request.LectureCreateRequest;
import com.group.unittoapp.lecture.repository.LectureRepository;
import com.group.unittoapp.user.domain.User;
import com.group.unittoapp.user.dto.request.UserUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public Lecture setLecture(LectureCreateRequest lectureCreateRequest) {

        Lecture lecture = new Lecture();

        lecture.setId(lectureCreateRequest.getId());
        lecture.setUsername(lectureCreateRequest.getUsername());
        lecture.setGender(lectureCreateRequest.getGender());
        lecture.setAdmissionYear(lectureCreateRequest.getAdmissionYear());
        lecture.setMajor(lectureCreateRequest.getMajor());
        lecture.setPreferRegion(lectureCreateRequest.getPreferRegion());
        lecture.setLectureName(lectureCreateRequest.getLectureName());
        lecture.setMeetType(lectureCreateRequest.getMeetType());
        lecture.setLectureContent(lectureCreateRequest.getLectureContent());
        lecture.setPreferDay(lectureCreateRequest.getPreferDay());
        lecture.setPreferTime(lectureCreateRequest.getPreferTime());
        lecture.setNumberOfClasses(lectureCreateRequest.getNumberOfClasses());
        lecture.setApplyContent(lectureCreateRequest.getApplyContent());
        lecture.setStatus(lectureCreateRequest.getStatus());

        lectureRepository.save(lecture);

        return lecture;
    }

    public Lecture getLecture(Long id) {
        return lectureRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("강의가 존재하지 않습니다."));
    }

}
