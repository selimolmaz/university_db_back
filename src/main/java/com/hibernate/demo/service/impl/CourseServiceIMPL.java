package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.CourseDTO;
import com.hibernate.demo.mapper.CourseMapper;
import com.hibernate.demo.model.Course;
import com.hibernate.demo.repository.CourseRepository;
import com.hibernate.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceIMPL implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseServiceIMPL(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = courseMapper.toEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDTO(savedCourse);
    }

    @Override
    public Optional<CourseDTO> getCourseById(String courseId) {
        return courseRepository.findById(courseId)
                .map(courseMapper::toDTO);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .toList();
    }

    @Override
    public List<CourseDTO> getCoursesByDeptName(String deptName) {
        return courseRepository.findByDeptName(deptName)
                .stream()
                .map(courseMapper::toDTO)
                .toList();
    }

    @Override
    public void deleteCourseById(String courseId) {
        courseRepository.getReferenceById(courseId);
    }
}
