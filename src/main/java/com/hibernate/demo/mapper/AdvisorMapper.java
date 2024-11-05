package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.AdvisorDTO;
import com.hibernate.demo.model.Advisor;
import com.hibernate.demo.model.Student;
import com.hibernate.demo.model.Instructor;
import com.hibernate.demo.service.InstructorService;
import com.hibernate.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvisorMapper {

    private final StudentService studentService;
    private final InstructorService instructorService;
    private final StudentMapper studentMapper;
    private final InstructorMapper instructorMapper;

    @Autowired
    public AdvisorMapper(StudentService studentService, InstructorService instructorService, StudentMapper studentMapper, InstructorMapper instructorMapper) {
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.studentMapper = studentMapper;
        this.instructorMapper = instructorMapper;
    }

    public AdvisorDTO toDto(Advisor advisor) {
        if (advisor == null) {
            return null;
        }

        AdvisorDTO advisorDTO = new AdvisorDTO();
        advisorDTO.setiId(advisor.getSId());
        advisorDTO.setsId(advisor.getIId());

        return advisorDTO;
    }

    public Advisor toEntity(AdvisorDTO advisorDTO) {
        if (advisorDTO == null) {
            return null;
        }

        Advisor advisor = new Advisor();
        advisor.setSId(advisorDTO.getsId());
        advisor.setIId(advisorDTO.getiId());
//
//        if (advisorDTO.getsId() != null) {
//            Student student = studentMapper.studentDTOToStudent(studentService.getStudentById(advisorDTO.getsId()));
//            advisor.setStudent(student);
//        }
//
//        if (advisorDTO.getiId() != null) {
//            Instructor instructor = instructorMapper.toEntity(instructorService.getInstructorById(advisorDTO.getiId()).get());
//        }

        return advisor;
    }
}
