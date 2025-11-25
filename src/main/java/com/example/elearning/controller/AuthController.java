package com.example.elearning.controller;

import com.example.elearning.model.User;
import com.example.elearning.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/login")
    public String login(@RequestParam("email") String emailID,
                        @RequestParam("password") String password,
                        HttpSession session) {

        User user = userRepo.findByEmailIDAndPassword(emailID, password);

        if (user != null) {
            // 🔥 SAVE LOGGED USER ID IN SESSION
            session.setAttribute("loggedUserId", user.getUserId());

            // 🔥 redirect to templates/dashboard.html (dynamic)
            return "redirect:/dashboard";
        } else {
            return "redirect:/login.html";  // Login failed
        }
    }
}
