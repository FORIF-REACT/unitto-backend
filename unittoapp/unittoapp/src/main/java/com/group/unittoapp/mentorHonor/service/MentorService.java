package com.group.unittoapp.mentorHonor.service;

import com.group.unittoapp.mentorHonor.dto.response.MentorRankResponse;
import com.group.unittoapp.mentorHonor.repository.MentorRepository;
import com.group.unittoapp.user.domain.User;
import com.group.unittoapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MentorService {
    private final MentorRepository mentorRepository;
    private final UserRepository userRepository;

    public List<MentorRankResponse> getMentorList() {
        List<User> userList = userRepository.findAll(Sort.by(Sort.Order.desc("point")));
        List<MentorRankResponse> mentorRankResponseList = new ArrayList<>();
        for (User user: userList){
            Long rank = 1L;
            MentorRankResponse mentorRankResponse = new MentorRankResponse();
            mentorRankResponse.setPoint(user.getPoint());
            mentorRankResponse.setUserName(user.getUsername());
            mentorRankResponse.setMentorRank(rank);
            rank++;
            mentorRankResponseList.add(mentorRankResponse);
        }
        return mentorRankResponseList;
    }
}
