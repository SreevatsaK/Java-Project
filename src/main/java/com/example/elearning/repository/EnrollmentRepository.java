package com.example.elearning.repository;

import com.example.elearning.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {

    List<Enrollment> findByUserId(String userId);

    Enrollment findByUserIdAndCourseId(String userId, String courseId);
}
