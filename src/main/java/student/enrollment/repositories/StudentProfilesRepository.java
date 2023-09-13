package student.enrollment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.enrollment.model.StudentProfile;

import java.util.List;

/**
 * A JPA Repository to perform operations on the LearnerProfiles table
 */
@Repository
public interface StudentProfilesRepository extends JpaRepository<StudentProfile, Long> {
    List<StudentProfile> findAllByIsGraduatedIsFalseOrderByGpaDesc();
}
