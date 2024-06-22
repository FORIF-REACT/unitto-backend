package com.group.unittoapp.lecture.dto.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LectureCreateRequest {
    private Long id;
    private String username;
    private String gender;
    private Long admissionYear;
    private String major;
    private String preferRegion;
    private String lectureName;
    private String meetType;
    private String lectureContent;
    private String preferDay;
    private Long preferTime;
    private Long numberOfClasses;
    private String applyContent;
    private String status;
}
