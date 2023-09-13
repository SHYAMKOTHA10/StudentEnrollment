package student.enrollment.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Persistence entity that represents a program a student can follow to earn a degree in a
 * particular field of study
 */
@Entity
@Table(name = "Programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;
    @Column(nullable = false)
    private int requiredYearsToGraduation = 4;
    @Column(nullable = false)
    private int requiredCreditsToGraduation = 600;
    @Column(nullable = false, updatable = false)
    private String fieldOfStudy;
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @OneToMany(mappedBy = "program")
    private final List<Student> students = new ArrayList<>();
    public Program() {
    }

    public Program(String fieldOfStudy, Degree degree) {
        this.fieldOfStudy = fieldOfStudy;
        this.degree = degree;
    }

    public Long getProgramId() {
        return programId;
    }

    public int getRequiredYearsToGraduation() {
        return requiredYearsToGraduation;
    }

    public int getRequiredCreditsToGraduation() {
        return requiredCreditsToGraduation;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public Degree getDegree() {
        return degree;
    }


    public List<Student> getStudents() {
        return students;
    }

    public enum Degree {
        ASSOCIATE,
        BACHELOR,
        MASTER,
        PHD,
    }
}
