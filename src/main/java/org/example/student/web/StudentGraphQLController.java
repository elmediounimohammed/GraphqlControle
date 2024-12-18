package org.example.student.web;


import lombok.AllArgsConstructor;
import org.example.student.dtos.StudentDTO;
import org.example.student.services.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentGraphQLController {

    private StudentService studentService;

    @MutationMapping
    public StudentDTO saveStudent(@Argument  StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }

    @QueryMapping
    public List<StudentDTO> getStudentByDateNaissance(@Argument String dateNaissance ) {
        return studentService.getStudentByDateNaissance(dateNaissance);
    }

}
