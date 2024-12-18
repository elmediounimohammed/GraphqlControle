package org.example.student.services;

import org.example.student.dtos.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentService {

    List<StudentDTO>getStudentByDateNaissance(String dateNaissance);
    StudentDTO saveStudent(StudentDTO student);
}
