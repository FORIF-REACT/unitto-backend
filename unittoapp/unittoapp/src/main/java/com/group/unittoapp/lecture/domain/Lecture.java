package com.group.unittoapp.lecture.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lecture") // 테이블 이름 지정
public class Lecture {
    @Id
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "gender")
    private String gender;

    @Column(name = "admission_year")
    private Long admissionYear;

    @Column(name = "major")
    private String major;

    @Column(name = "prefer_region")
    private String preferRegion;

    @Column(name = "lecture_name")
    private String lectureName;

    @Column(name = "meet_type")
    private String meetType;

    @Column(name = "lecture_content")
    private String lectureContent;

    @Column(name = "prefer_day")
    private String preferDay;

    @Column(name = "prefer_time")
    private Long preferTime;

    @Column(name = "number_of_classes")
    private Long numberOfClasses;

    @Column(name = "apply_content")
    private String applyContent;

    @Column(name = "status")
    private String status;


}