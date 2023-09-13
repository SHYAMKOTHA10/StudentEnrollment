package student.enrollment.services;

import org.springframework.stereotype.Service;
import student.enrollment.model.Program;
import student.enrollment.model.Course;
import student.enrollment.model.Student;
import student.enrollment.repositories.StudentsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * A service that applies business logic on the students entity
 */
@Service
public class StudentsService {

    private final StudentsRepository studentsRepository;

    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    /**
     * Finds a student by email address.
     * Returns {@code Optional.empty()} if a student with this email doesn't exist
     */
    public Optional<Student> findStudentByEmail(String email) {

        return studentsRepository.findByEmail(email);
    }

    /**
     * Returns all registered students from the database
     * @return
     */
    public List<Student> getAllRegisteredStudents() {

        return studentsRepository.findAll();
    }

    /**
     * Adds a new student to the database
     */
    public void addStudent(String firstName,
                              String lastName,
                              String email, LocalDate dateOfBirth,
                              Program program) {
        Student student = new Student(firstName, lastName, email, dateOfBirth,program);
        studentsRepository.save(student);
    }

    /**
     * Finds a student by their id.
     * Returns {@code Optional.empty()} if a student with this email doesn't exist
     */
    public Optional<Student> findStudentById(Long id) {

        return studentsRepository.findById(id);
    }

    /**
     * Returns all the courses that a given student is enrolled in
     */
    public Set<Course> getAllStudentCourses(Student student) {
        return student.getEnrolledIn();
    }

    // fix enroll / leave course issue
    public void enrollCourse(Student student,Course course) {
        student.addEnrolledInCourse(course);
        studentsRepository.save(student);
    }

    public void unEnrollCourse(Student student,Course course) {
        if (!student.getEnrolledIn().contains(course)) {
            return;
        }
        student.removeEnrolledInCourse(course);
        studentsRepository.save(student);
    }
}
