package com.example.elearning.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();   // remove all session data

        return "redirect:/index.html";  // redirect to home page with Sign In / Sign Up
    }
}
