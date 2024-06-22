package com.group.unittoapp.lecture.repository;

import com.group.unittoapp.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository<Lecture,Long> {
    Optional<Lecture> findById(Long id);
}
