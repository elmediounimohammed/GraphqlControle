package org.example.student.services;


import org.example.student.dao.entities.Student;
import org.example.student.dao.repositories.StudentRepository;
import org.example.student.dtos.StudentDTO;
import org.example.student.mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentManager implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getStudentByDateNaissance(String dateNaissance) {
        List<Student> students = studentRepository.findByDateNaissance(dateNaissance);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            studentDTOS.add(studentMapper.fromStudentToStudentDTO(student));
        }
        return studentDTOS;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = studentMapper.fromStudentDTOToStudent(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.fromStudentToStudentDTO(savedStudent);
    }
}
