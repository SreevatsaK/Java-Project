package com.example.elearning.service;

import com.example.elearning.model.MCQ;
import com.example.elearning.repository.MCQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MCQService {

    @Autowired
    private MCQRepository mcqRepository;

    public List<MCQ> getByCourse(String courseId) {
        return mcqRepository.findByCourseId(courseId);
    }

    // answers: map of mcqId -> selectedOption (e.g., "A")
    public int evaluate(Map<String, String> answers) {
        int correct = 0;
        for (Map.Entry<String, String> e : answers.entrySet()) {
            MCQ mcq = mcqRepository.findById(e.getKey()).orElse(null);
            if (mcq != null && mcq.getCorrectOption() != null && mcq.getCorrectOption().equalsIgnoreCase(e.getValue())) {
                correct++;
            }
        }
        return correct;
    }
}
