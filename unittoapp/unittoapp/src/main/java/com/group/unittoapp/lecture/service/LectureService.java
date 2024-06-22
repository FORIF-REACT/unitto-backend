package com.group.unittoapp.lecture.service;

import com.group.unittoapp.lecture.domain.Lecture;
import com.group.unittoapp.lecture.domain.LectureStatus;
import com.group.unittoapp.lecture.dto.request.LectureApplyRequest;
import com.group.unittoapp.lecture.dto.request.LectureCreateRequest;
import com.group.unittoapp.lecture.dto.request.MyClassRequest;
import com.group.unittoapp.lecture.repository.LectureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        lecture.setLectureStatus(LectureStatus.valueOf(lectureCreateRequest.getStatus()));

        lectureRepository.save(lecture);

        return lecture;
    }

    public Lecture getLecture(Long id) {
        return lectureRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("강의가 존재하지 않습니다."));
    }

    public void applyLecture(LectureApplyRequest request){
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new EntityNotFoundException("강의가 없습니다."));
        lecture.setLectureStatus(LectureStatus.수락대기);
    }

    public List<Lecture> getMyClassMentor(MyClassRequest request){
        return lectureRepository.findAllByLectureStatus(request.getStatus());
    }

    public void acceptLecture(@RequestParam Long id){
        Lecture lecture = lectureRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("NO"));
        lecture.setLectureStatus(LectureStatus.진행중);
    }

    public void declineLecture(@RequestParam Long id) {
        lectureRepository.deleteById(id);
    }

    public void endLecture(@RequestParam Long id) {
        Lecture lecture = lectureRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("NO"));
        lecture.setLectureStatus(LectureStatus.종료됨);
    }

    public List<Lecture> getMyClassMenti(MyClassRequest request){
        return lectureRepository.findAllByLectureStatus(request.getStatus());
    }


}
