package org.example.student;

import org.example.student.dtos.StudentDTO;
import org.example.student.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudentApplication.class, args);
    }

    @Bean
    CommandLineRunner start(StudentService studentService) {
        return args -> {
            List<StudentDTO> studentDTOS = List.of(
                StudentDTO.builder().name("mediouni").email("@gmail").dateNaissance("14").build(),
                StudentDTO.builder().name("el aoui").email("").dateNaissance("13").build(),
                StudentDTO.builder().name("othman").email("").dateNaissance("11").build(),
                StudentDTO.builder().name("gaadi").email("").dateNaissance("12").build()
            );
            for (StudentDTO studentDTO : studentDTOS) {
                    studentService.saveStudent(studentDTO);
            }
        };
    }

}
