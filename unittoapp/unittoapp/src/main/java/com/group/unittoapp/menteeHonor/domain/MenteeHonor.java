package com.group.unittoapp.menteeHonor.domain;

import com.group.unittoapp.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class MenteeHonor {
    @Id
    private String email;
    private Long menteePunctual;
    private Long menteeDeligence;
    private Long Activeness;

    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    User mentee;
}
