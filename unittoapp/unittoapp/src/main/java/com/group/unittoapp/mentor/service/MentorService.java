package com.group.unittoapp.mentor.service;

import com.group.unittoapp.mentor.domain.Mentor;
import com.group.unittoapp.mentor.dto.response.MentorResponse;
import com.group.unittoapp.mentor.repository.MentorRepository;
import com.group.unittoapp.user.domain.User;
import com.group.unittoapp.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MentorService {
    private final UserRepository userRepository;
    private final MentorRepository mentorRepository;

    public List<MentorResponse> getMentorList(){
        List<Mentor> mentorList = mentorRepository.findAll();
        if(mentorList.isEmpty()){
            throw new EntityNotFoundException("없음");
        }
        List<User> userList = userRepository.findAll();
        if(userList.isEmpty()){
            throw new EntityNotFoundException("없음");
        }
        List<MentorResponse> mentorResponseList = new ArrayList<>();
        for(User user: userList){
            String userEmail = user.getEmail();
            for (Mentor mentor: mentorList){
                if(mentor.getEmail().equals(userEmail)){
                    MentorResponse mentorResponse = getMentorResponse(user, mentor, userEmail);

                    mentorResponseList.add(mentorResponse);
                }
            }
        }
        return mentorResponseList;
    }

    private static MentorResponse getMentorResponse(User user, Mentor mentor, String userEmail) {
        MentorResponse mentorResponse = new MentorResponse();
        mentorResponse.setUsername(user.getUsername());
        mentorResponse.setAdmissionYear(user.getAdmissionYear());
        mentorResponse.setEmail(userEmail);
        mentorResponse.setMajor(user.getMajor());
        mentorResponse.setPreferRegion(user.getPreferRegion());
        mentorResponse.setPoint(user.getPoint());
        mentorResponse.setLectureName(mentor.getLectureName());
        mentorResponse.setLectureContent(mentor.getLectureContent());
        mentorResponse.setMeetType(mentor.getMeetType());
        mentorResponse.setPreferTime(mentor.getPreferTime());
        mentorResponse.setNumberOfClasses(mentor.getNumberOfClasses());
        return mentorResponse;
    }
}
