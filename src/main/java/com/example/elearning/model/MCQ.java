package com.example.elearning.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mcqs")
public class MCQ {

    @Id
    @Column(name = "mcq_id", nullable = false, length = 50)
    private String mcqId;

    @Column(name = "course_id", length = 50)
    private String courseId;

    @Column(name = "difficulty", length = 50)
    private String difficulty;

    @Column(name = "question", columnDefinition = "TEXT")
    private String question;

    @Column(name = "option_a", length = 300)
    private String optionA;

    @Column(name = "option_b", length = 300)
    private String optionB;

    @Column(name = "option_c", length = 300)
    private String optionC;

    @Column(name = "option_d", length = 300)
    private String optionD;

    @Column(name = "correct_option", length = 1)
    private String correctOption;

    public MCQ() {}

    // getters & setters
    public String getMcqId() { return mcqId; }
    public void setMcqId(String mcqId) { this.mcqId = mcqId; }

    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getOptionA() { return optionA; }
    public void setOptionA(String optionA) { this.optionA = optionA; }

    public String getOptionB() { return optionB; }
    public void setOptionB(String optionB) { this.optionB = optionB; }

    public String getOptionC() { return optionC; }
    public void setOptionC(String optionC) { this.optionC = optionC; }

    public String getOptionD() { return optionD; }
    public void setOptionD(String optionD) { this.optionD = optionD; }

    public String getCorrectOption() { return correctOption; }
    public void setCorrectOption(String correctOption) { this.correctOption = correctOption; }
}
