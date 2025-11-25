package com.example.elearning.controller;

import com.example.elearning.model.Course;
import com.example.elearning.model.MCQ;
import com.example.elearning.model.Task;
import com.example.elearning.service.CourseService;
import com.example.elearning.service.EnrollmentService;
import com.example.elearning.service.MCQService;
import com.example.elearning.service.TaskService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private MCQService mcqService;

    // List all courses
    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";   // loads templates/courses.html
    }

    // View a single course
    @GetMapping("/course/{id}")
    public String viewCourse(@PathVariable("id") String id,
                             HttpSession session,
                             Model model) {

        // 1. Load course
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return "redirect:/courses";
        }
        model.addAttribute("course", course);

        // 2. Check if user is logged in
        String userId = (String) session.getAttribute("loggedUserId");
        boolean enrolled = false;

        if (userId != null) {
            // 3. Check if already enrolled
            enrolled = enrollmentService.isUserEnrolled(userId, id);
        }
        model.addAttribute("enrolled", enrolled);

        // 4. Load tasks for the course
        List<Task> tasks = taskService.getTasksForCourse(id);
        model.addAttribute("tasks", tasks);

        // 5. Load MCQs for the course
        List<MCQ> mcqs = mcqService.getByCourse(id);
        model.addAttribute("mcqs", mcqs);

        return "course-details";   // loads templates/course-details.html
    }
}
