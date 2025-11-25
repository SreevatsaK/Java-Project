package com.example.elearning.repository;

import com.example.elearning.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, String> {
    List<Submission> findByUserId(String userId);
}
