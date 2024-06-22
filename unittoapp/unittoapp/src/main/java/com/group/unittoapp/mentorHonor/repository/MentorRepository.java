package com.group.unittoapp.mentorHonor.repository;

import com.group.unittoapp.mentorHonor.domain.MentorHonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<MentorHonor, Long> {
}
