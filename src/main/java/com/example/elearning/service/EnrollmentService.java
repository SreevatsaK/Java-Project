package com.example.elearning.service;

import com.example.elearning.model.Enrollment;
import com.example.elearning.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // Enroll user into course
    public Enrollment enroll(String userId, String courseId) {
        Enrollment existing = enrollmentRepository.findByUserIdAndCourseId(userId, courseId);
        if (existing != null) return existing;

        Enrollment e = new Enrollment();
        String id = "E" + UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
        e.setEnrollmentId(id);
        e.setUserId(userId);
        e.setCourseId(courseId);
        e.setProgress(BigDecimal.ZERO);

        return enrollmentRepository.save(e);
    }

    // Fetch user's enrollments
    public List<Enrollment> getEnrollmentsForUser(String userId) {
        return enrollmentRepository.findByUserId(userId);
    }

    // ✅ NEW METHOD (place below, NOT inside another method)
    public boolean isUserEnrolled(String userId, String courseId) {
        Enrollment e = enrollmentRepository.findByUserIdAndCourseId(userId, courseId);
        return e != null;
    }
}
