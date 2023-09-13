package student.enrollment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.enrollment.model.Student;

import java.util.Optional;

/**
 * A JPA Repository to perform operations on the Students table
 */
@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
