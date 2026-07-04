package in.sk.springBootCrudDemo.controller;

import in.sk.springBootCrudDemo.dto.ResponseDTO;
import in.sk.springBootCrudDemo.dto.StudentDTO;
import in.sk.springBootCrudDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<StudentDTO>> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO student = studentService.addStudent(studentDTO);
        if (Objects.nonNull(student)) {
            ResponseDTO<StudentDTO> response = new ResponseDTO<>(true, "Student added successfully", student);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ResponseDTO<>(false, "Invalid input data", List.of("Student with email exists")), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<StudentDTO>> geStudent(@PathVariable Long id) {
       StudentDTO student = studentService.getStudentById(id);
        if (Objects.nonNull(student)) {
            ResponseDTO<StudentDTO> response = new ResponseDTO<>(true, "Student found", student);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ResponseDTO<StudentDTO> response = new ResponseDTO<>(false, "Student not found", List.of("Student with given ID not exits"));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<StudentDTO>>> getAllStudents() {
        List<StudentDTO> allStudents = studentService.getAllStudents();
        ResponseDTO<List<StudentDTO>> response = new ResponseDTO<>(true, "Fetched all students", allStudents);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<StudentDTO>> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        StudentDTO student = studentService.updateStudent(id, studentDTO);
        if (Objects.nonNull(student)) {
            ResponseDTO<StudentDTO> response = new ResponseDTO<>(true, "Student details updated", student);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ResponseDTO<StudentDTO> response = new ResponseDTO<>(false, "Student not found", List.of("Student with given ID not exits"));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDTO<String>> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudentById(id);
        if (deleted) {
            ResponseDTO<String> response = new ResponseDTO<>(true, "Student deleted successfully", "Deleted");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ResponseDTO<String> response = new ResponseDTO<>(false, "Student not found", List.of("Student with given ID not exits"));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
