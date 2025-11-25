package com.example.elearning.controller;

import com.example.elearning.service.EnrollmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public String enrollUser(
            @RequestParam("courseId") String courseId,
            HttpSession session) {

        String userId = (String) session.getAttribute("loggedUserId");

        // Not logged in — redirect to login
        if (userId == null) {
            // 👇 pass courseId so after login we can auto-enroll later if you want
            return "redirect:/login.html";
        }

        // Logged in — enroll
        enrollmentService.enroll(userId, courseId);

        // Redirect to dashboard with success message
        return "redirect:/dashboard?enrolled=success";
    }
}
