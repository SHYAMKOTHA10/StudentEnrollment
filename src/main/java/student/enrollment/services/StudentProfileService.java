package student.enrollment.services;

import org.springframework.stereotype.Service;
import student.enrollment.model.StudentProfile;
import student.enrollment.repositories.StudentProfilesRepository;

import java.util.List;

/**
 * A service that applies business logic to learner profiles
 */
@Service
public class StudentProfileService {

    private final StudentProfilesRepository studentProfilesRepository;

    public StudentProfileService(StudentProfilesRepository studentProfilesRepository) {
        this.studentProfilesRepository = studentProfilesRepository;
    }

    /**
     * Returns all the active students' learner profiles in the database,
     * sorted by their GPA in descending order
     */
    public List<StudentProfile> getActiveStudentProfilesOrderedByGpa() {
        return studentProfilesRepository.findAllByIsGraduatedIsFalseOrderByGpaDesc();

    }
}
