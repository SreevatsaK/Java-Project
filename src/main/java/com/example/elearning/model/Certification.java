package com.example.elearning.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certifications")
public class Certification {

    @Id
    @Column(name = "certificate_id", nullable = false, length = 50)
    private String certificateId;

    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "course_id", length = 50)
    private String courseId;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "certificate_code", length = 200)
    private String certificateCode;

    public Certification() {}

    // getters & setters
    public String getCertificateId() { return certificateId; }
    public void setCertificateId(String certificateId) { this.certificateId = certificateId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public String getCertificateCode() { return certificateCode; }
    public void setCertificateCode(String certificateCode) { this.certificateCode = certificateCode; }
}
