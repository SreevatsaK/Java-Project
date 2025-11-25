package com.example.elearning.service;

import com.example.elearning.model.Task;
import com.example.elearning.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Fetch all tasks for a course
    public List<Task> getTasksForCourse(String courseId) {
        return taskRepository.findByCourseId(courseId);
    }
}
