package com.hibernate.demo.service;

import com.hibernate.demo.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseDTO saveCourse(CourseDTO courseDTO);
    Optional<CourseDTO> getCourseById(String courseId);
    List<CourseDTO> getAllCourses();
    List<CourseDTO> getCoursesByDeptName(String deptName);
    void deleteCourseById(String courseId);
}
