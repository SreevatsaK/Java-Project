package com.example.elearning.service;

import com.example.elearning.model.Submission;
import com.example.elearning.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository repo;

    public Submission saveSubmission(Submission submission) {
        return repo.save(submission);
    }

    public List<Submission> getSubmissionsByUser(String userId) {
        return repo.findByUserId(userId);
    }
}
