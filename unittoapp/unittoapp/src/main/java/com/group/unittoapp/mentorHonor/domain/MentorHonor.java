package com.group.unittoapp.mentorHonor.domain;

import com.group.unittoapp.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MentorHonor {
    @Id
    private String email;
    private Long professional;
    private Long goodTeaching;
    private Long mentorPreparation;
    private Long gradeGuarantee;
    private Long mentorPunctual;

    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    User mentor;
}
