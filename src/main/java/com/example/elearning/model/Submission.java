package com.example.elearning.model;

import jakarta.persistence.*;

@Entity
@Table(name = "submissions")
public class Submission {

    @Id
    @Column(name = "submission_id", length = 50)
    private String submissionId;

    @Column(name = "task_id", length = 50)
    private String taskId;

    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "pdf_file_path")
    private String pdfFilePath;

    @Column(name = "score")
    private Integer score;

    @Column(name = "feedback", columnDefinition = "TEXT")
    private String feedback;

    public Submission() {}

    // GETTERS & SETTERS
    public String getSubmissionId() { return submissionId; }
    public void setSubmissionId(String submissionId) { this.submissionId = submissionId; }

    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPdfFilePath() { return pdfFilePath; }
    public void setPdfFilePath(String pdfFilePath) { this.pdfFilePath = pdfFilePath; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}
