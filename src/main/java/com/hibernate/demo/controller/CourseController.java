package com.hibernate.demo.controller;

import com.hibernate.demo.dto.CourseDTO;
import com.hibernate.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uni/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO) {
        CourseDTO savedCourse = courseService.saveCourse(courseDTO);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable String courseId, @RequestBody CourseDTO courseDTO) {
        Optional<CourseDTO> existCourse = courseService.getCourseById(courseId);
        if (existCourse.isPresent()) {
            CourseDTO updatedCourse = courseService.saveCourse(courseDTO);
            return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        List<CourseDTO> courseDTOS = courseService.getAllCourses();
        return new ResponseEntity<>(courseDTOS, HttpStatus.OK);
    }

    @GetMapping("/dept/{deptName}")
    public ResponseEntity<List<CourseDTO>> getCoursesByDeptName(@PathVariable String deptName) {
        List<CourseDTO> courseDTOS = courseService.getCoursesByDeptName(deptName);
        return new ResponseEntity<>(courseDTOS, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDTO> getcourseById(@PathVariable String courseId) {
        return courseService.getCourseById(courseId)
                .map(courseDTO -> new ResponseEntity<>(courseDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable String courseId) {
        courseService.deleteCourseById(courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
