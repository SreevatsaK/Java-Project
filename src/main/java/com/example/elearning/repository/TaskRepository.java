package com.example.elearning.repository;

import com.example.elearning.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {

    List<Task> findByCourseId(String courseId);
}
