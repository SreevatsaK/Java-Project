package com.example.elearning.controller;

import com.example.elearning.model.MCQ;
import com.example.elearning.service.MCQService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MCQController {

    @Autowired
    private MCQService mcqService;

    // LOAD MCQ QUIZ
    @GetMapping("/course/{courseId}/mcq")
    public String loadMcqQuiz(@PathVariable String courseId, Model model, HttpSession session) {

        String userId = (String) session.getAttribute("loggedUserId");
        if (userId == null) {
            return "redirect:/login.html";
        }

        List<MCQ> mcqs = mcqService.getByCourse(courseId);

        model.addAttribute("mcqs", mcqs);
        model.addAttribute("courseId", courseId);

        return "mcq-quiz";  // loads mcq-quiz.html
    }

    // SUBMIT & EVALUATE MCQ
    @PostMapping("/course/{courseId}/mcq/submit")
    public String submitMcq(
            @PathVariable String courseId,
            @RequestParam Map<String, String> requestParams,
            Model model,
            HttpSession session) {

        String userId = (String) session.getAttribute("loggedUserId");
        if (userId == null) {
            return "redirect:/login.html";
        }

        // Extract only answers (keys like "q_<id>")
        Map<String, String> answers = new HashMap<>();

        for (String key : requestParams.keySet()) {
            if (key.startsWith("q_")) {
                String mcqId = key.substring(2);
                String selectedOption = requestParams.get(key);
                answers.put(mcqId, selectedOption);
            }
        }

        int correct = mcqService.evaluate(answers);
        int total = answers.size();

        model.addAttribute("correct", correct);
        model.addAttribute("total", total);
        model.addAttribute("courseId", courseId);

        return "mcq-result";
    }
}
