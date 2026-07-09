package in.sk.globalExceptionHandling.repository;

import in.sk.globalExceptionHandling.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsStudentsByEmail(String email);

    //List<Student> findByActiveIsTrue();

    Optional<Student> findByIdAndActiveIsTrue(long id);

    List<Student> findAllByActiveIsTrue();
}
