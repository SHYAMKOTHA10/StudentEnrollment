package student.enrollment.model;

import javax.persistence.*;

/**
 * Persistence entity that represents a profile of an active student as well as a row in the
 * StudentProfiles table in the database
 */
@Entity
@Table(name = "StudentProfiles")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private int numberOfCredits;

    private float gpa;
    private boolean isGraduated;
    private short startYear;

    @OneToOne(mappedBy = "studentProfile")
    private Student student;

    public StudentProfile() {
    }

    public StudentProfile(short startYear) {
        this.startYear = startYear;
    }

    public Long getProfileId() {
        return profileId;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public float getGpa() {
        return gpa;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    public short getStartYear() {
        return startYear;
    }

    public Student getStudent() {
        return student;
    }

}
