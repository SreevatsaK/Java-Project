package com.example.elearning.service;

import com.example.elearning.model.Course;
import com.example.elearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Fetch all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Fetch a single course by ID
    public Course getCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Fetch multiple courses by list of IDs
    public List<Course> getCoursesByIds(List<String> ids) {
        return courseRepository.findAllById(ids);
    }
}
