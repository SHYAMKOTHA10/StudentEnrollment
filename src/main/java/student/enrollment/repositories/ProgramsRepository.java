package student.enrollment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.enrollment.model.Program;

import java.util.Optional;

/**
 * A JPA Repository to perform operations on the Programs table
 */
@Repository
public interface ProgramsRepository extends JpaRepository<Program, Long> {
    Optional<Program> findByFieldOfStudyAndDegree(String fieldOfStudy, Program.Degree degree);
}
