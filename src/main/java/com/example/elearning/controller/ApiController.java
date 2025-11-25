package com.example.elearning.controller;

import com.example.elearning.model.Course;
import com.example.elearning.model.Enrollment;
import com.example.elearning.repository.CourseRepository;
import com.example.elearning.service.CertificationService;
import com.example.elearning.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private CertificationService certificationService;

    // GET all courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    // GET all enrollments for a user
    @GetMapping("/enrollments/{userId}")
    public List<Enrollment> getUserEnrollments(@PathVariable String userId) {
        return enrollmentService.getEnrollmentsForUser(userId);
    }

    // ISSUE certificate using your existing service method
    @PostMapping("/certify")
    public String issueCertificate(@RequestParam String userId,
                                   @RequestParam String courseId) {

        certificationService.issueCertificate(userId, courseId);
        return "issued";
    }
}
