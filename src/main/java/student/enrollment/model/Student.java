package student.enrollment.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Persistence entity that represents a student, registered at the university
 */
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String firstName;

    @Column(length = 60, nullable = false)
    private String lastName;

    @Column(length = 60, nullable = false, unique = true)
    private String email;

    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id")
    private StudentProfile studentProfile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id")
    private Program program;

    @ManyToMany
    @JoinTable(name = "COURSE_ENROLLMENTS",
            joinColumns = @JoinColumn(name = "enrolled_student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> enrolledIn;

    public Student() {
    }

    public Student(String firstName,
                   String lastName,
                   String email,
                   LocalDate dateOfBirth,Program program) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.studentProfile = new StudentProfile((short) LocalDate.now().getYear());
        this.program = program;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public Program getProgram() {
        return program;
    }

    public Set<Course> getEnrolledIn() {
        return enrolledIn;
    }
    public void addEnrolledInCourse(Course course) {
        enrolledIn.add(course);
    }
    public void removeEnrolledInCourse(Course course) {
        enrolledIn.remove(course);
    }

}
