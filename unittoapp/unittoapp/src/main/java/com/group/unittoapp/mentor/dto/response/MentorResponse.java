package com.group.unittoapp.mentor.dto.response;

import lombok.Data;

@Data
public class MentorResponse {
    private String username;
    private Long admissionYear;
    private String major;
    private String email;
    private String gender;
    private String preferRegion;
    private Long point;
    //
    private String lectureName;
    private String meetType;
    private String lectureContent;
    private String preferTime;
    private Long numberOfClasses;

}
