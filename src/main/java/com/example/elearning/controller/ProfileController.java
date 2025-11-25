package com.example.elearning.controller;

import com.example.elearning.model.*;
import com.example.elearning.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private CertificationService certificationService;   // FIXED

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {

        String userId = (String) session.getAttribute("loggedUserId");
        if (userId == null) {
            return "redirect:/login.html";
        }

        // USER DETAILS
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);

        // ENROLLED COURSES
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsForUser(userId);

        List<String> courseIds = enrollments.stream()
                .map(Enrollment::getCourseId)
                .collect(Collectors.toList());

        List<Course> enrolledCourses = courseService.getCoursesByIds(courseIds);
        model.addAttribute("enrolledCourses", enrolledCourses);

        // ASSIGNMENT SUBMISSIONS
        List<Submission> submissions = submissionService.getSubmissionsByUser(userId);
        model.addAttribute("submissions", submissions);

        // CERTIFICATES (FIXED TYPE)
        List<Certification> certificates = certificationService.getCertificatesForUser(userId);
        model.addAttribute("certificates", certificates);

        return "profile";
    }
}
