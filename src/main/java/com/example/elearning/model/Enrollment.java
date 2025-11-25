package com.example.elearning.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @Column(name = "enrollment_id", nullable = false, length = 50)
    private String enrollmentId;

    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "course_id", length = 50)
    private String courseId;

    @Column(name = "progress", precision = 5, scale = 2)
    private BigDecimal progress;

    public Enrollment() {}

    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public BigDecimal getProgress() { return progress; }
    public void setProgress(BigDecimal progress) { this.progress = progress; }
}
