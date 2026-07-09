package in.sk.globalExceptionHandling.service;

import in.sk.globalExceptionHandling.dto.StudentDto;
import in.sk.globalExceptionHandling.dto.StudentRequestDto;
import in.sk.globalExceptionHandling.entity.Student;
import in.sk.globalExceptionHandling.exception.DuplicateResourceException;
import in.sk.globalExceptionHandling.exception.ResourceNotFoundException;
import in.sk.globalExceptionHandling.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDto createNewStudent(StudentRequestDto studentRequest) {
        if (studentEmailExists(studentRequest.getEmail())) {
            throw new DuplicateResourceException("Student with email already exists");
        }
        Student student = mapStudentRequestDtoToStudentEntity(studentRequest);
        student = studentRepository.save(student);
        return mapStudentEntityToStudentDto(student);
    }

    public StudentDto getStudent(long id) {
        Student student = getStudentById(id);
        return mapStudentEntityToStudentDto(student);
    }

    public List<StudentDto> getAllStudents() {
        List<Student> allStudents = studentRepository.findAllByActiveIsTrue();
        return allStudents.stream().map(this::mapStudentEntityToStudentDto).toList();
    }

    public StudentDto updateStudent(long id, @Valid StudentRequestDto studentRequest) {
        Student student = getStudentById(id);
        student.setName(studentRequest.getName());
        student.setRollNo(studentRequest.getRollNo());
        student.setGender(studentRequest.getGender());
        student.setEmail(studentRequest.getEmail());
        student = studentRepository.save(student);
        return mapStudentEntityToStudentDto(student);
    }

    public void disableStudent(long id) {
        Student student = getStudentById(id);
        student.setActive(Boolean.FALSE);
        studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }


    private StudentDto mapStudentEntityToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setRollNo(student.getRollNo());
        studentDto.setGender(student.getGender());
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }

    private Student mapStudentRequestDtoToStudentEntity(StudentRequestDto studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setRollNo(studentRequest.getRollNo());
        student.setGender(studentRequest.getGender());
        student.setEmail(studentRequest.getEmail());
        student.setActive(Boolean.TRUE);
        return student;
    }

    private boolean studentEmailExists(String email) {
        return studentRepository.existsStudentsByEmail(email);
    }

    private Student getStudentById(long id) {
        return studentRepository.findByIdAndActiveIsTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }
}
