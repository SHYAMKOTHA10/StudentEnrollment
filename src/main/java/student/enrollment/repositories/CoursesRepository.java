package student.enrollment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.enrollment.model.Course;

/**
 * A Spring Data JPA Repository to perform operations on the Courses table.
 */
@Repository
public interface CoursesRepository extends JpaRepository<Course, Long> {
}
