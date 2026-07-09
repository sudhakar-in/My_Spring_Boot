package in.sk.globalExceptionHandling.controller;

import in.sk.globalExceptionHandling.dto.ApiResponse;
import in.sk.globalExceptionHandling.dto.StudentDto;
import in.sk.globalExceptionHandling.dto.StudentRequestDto;
import in.sk.globalExceptionHandling.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentDto>> createStudent(@RequestBody @Valid StudentRequestDto studentRequest) {
        StudentDto student = studentService.createNewStudent(studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Student created successfully", student));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentDto>>> getStudents() {
        List<StudentDto> allStudents = studentService.getAllStudents();
        return ResponseEntity
                .ok(ApiResponse.success("All students fetched successfully", allStudents));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDto>> getStudentById(@PathVariable long id) {
        StudentDto studentDto = studentService.getStudent(id);
        return ResponseEntity.ok(ApiResponse.success("Student fetched successfully", studentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDto>> updateStudent(@PathVariable long id, @RequestBody @Valid StudentRequestDto studentRequest) {
        StudentDto studentDto = studentService.updateStudent(id, studentRequest);
        return ResponseEntity.ok(ApiResponse.success("Student updated successfully", studentDto));
    }

    @PatchMapping("/{id}/disable")
    public ResponseEntity<ApiResponse<StudentDto>> disableStudent(@PathVariable long id) {
        studentService.disableStudent(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
