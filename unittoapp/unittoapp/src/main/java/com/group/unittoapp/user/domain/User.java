package com.group.unittoapp.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user") // 테이블 이름 지정
public class User {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "admissionYear")
    private Long admissionYear;

    @Column(name = "major")
    private String major;

    @Column(name = "gender")
    private String gender;

    @Column(name = "preferRegion")
    private String preferRegion;

    @Column(name = "point")
    private Long point;
}