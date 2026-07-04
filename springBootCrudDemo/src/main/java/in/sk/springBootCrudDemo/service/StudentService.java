package in.sk.springBootCrudDemo.service;

import in.sk.springBootCrudDemo.dto.StudentDTO;
import in.sk.springBootCrudDemo.entity.Student;
import in.sk.springBootCrudDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findByEmailAndActiveIsTrue(studentDTO.getEmail());
        if (optionalStudent.isPresent()) {
            return null;
        }
        Student student = new Student(studentDTO.getName(), studentDTO.getEmail(), true);
        Student savedStudent = studentRepository.save(student);
        return new StudentDTO(savedStudent.getId(), savedStudent.getName(), savedStudent.getEmail());
    }

    public StudentDTO getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findByIdAndActiveIsTrue(id);
        if (optionalStudent.isEmpty()) {
            return null;
        }
        Student student = optionalStudent.get();
        return new StudentDTO(student.getId(), student.getName(), student.getEmail());
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream().map(s -> new StudentDTO(s.getId(), s.getName(), s.getEmail()))
                .toList();
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findByIdAndActiveIsTrue(id);
        if (optionalStudent.isEmpty()) {
            return null;
        }
        Student student = optionalStudent.get();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student = studentRepository.save(student);
        return new StudentDTO(student.getId(), student.getName(), student.getEmail());
    }

    public boolean deleteStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findByIdAndActiveIsTrue(id);
        if (optionalStudent.isEmpty()) {
            return false;
        }
        Student student = optionalStudent.get();
        student.setActive(false);
        studentRepository.save(student);
        return true;
    }
}
