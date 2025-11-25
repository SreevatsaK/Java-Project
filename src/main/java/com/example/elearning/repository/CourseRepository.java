package com.example.elearning.repository;

import com.example.elearning.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
    // you can add custom queries here later
}
