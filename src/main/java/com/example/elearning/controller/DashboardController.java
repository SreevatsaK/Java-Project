package com.example.elearning.controller;

import com.example.elearning.model.Course;
import com.example.elearning.model.Enrollment;
import com.example.elearning.model.User;
import com.example.elearning.service.CourseService;
import com.example.elearning.service.EnrollmentService;
import com.example.elearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        // FIXED: session attribute should be "loggedUserId"
        String userId = (String) session.getAttribute("loggedUserId");
        if (userId == null) {
            return "redirect:/login.html";
        }

        // Fetch user details
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);

        // Fetch enrolled courses
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsForUser(userId);

        List<String> courseIds = enrollments.stream()
                .map(Enrollment::getCourseId)
                .collect(Collectors.toList());

        List<Course> enrolledCourses = courseService.getCoursesByIds(courseIds);
        model.addAttribute("enrolledCourses", enrolledCourses);

        return "dashboard"; // returns dashboard.html
    }
}
