package com.group.unittoapp.mentor.repository;

import com.group.unittoapp.mentor.domain.Mentor;
import com.group.unittoapp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    void findByEmail(String email);
}
