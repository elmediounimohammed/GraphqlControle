package org.example.student.mappers;


import org.example.student.dao.entities.Student;
import org.example.student.dtos.StudentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

 private final ModelMapper modelMapper = new ModelMapper();

    public StudentDTO fromStudentToStudentDTO(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }
    public Student fromStudentDTOToStudent(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }
}
