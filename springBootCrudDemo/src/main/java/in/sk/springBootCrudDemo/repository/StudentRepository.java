package in.sk.springBootCrudDemo.repository;

import in.sk.springBootCrudDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmailAndActiveIsTrue(String email);

    Optional<Student> findByIdAndActiveIsTrue(Long id);
}
