package com.group.unittoapp.mentor.domain;

import com.group.unittoapp.user.domain.User;
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
@Table(name = "mentor")
public class Mentor {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "lectureName")
    private String lectureName;
    @Column(name = "lectureType")
    private String lectureType;
    @Column(name = "meetType")
    private String meetType;
    @Column(name = "lectureContent")
    private String lectureContent;
    @Column(name = "preferDay")
    private String preferDay;
    @Column(name = "preferTime")
    private String preferTime;
    @Column(name = "numberOfClasses")
    private Long numberOfClasses;

    @OneToOne
    @MapsId("email")
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private User user;

}
