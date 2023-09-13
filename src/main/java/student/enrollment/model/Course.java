package student.enrollment.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Persistence Entity that represents a course at the university as well as a row in the Courses
 * table in the database
 */
@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String title;
    private String description;
    private int numberOfCredits;


    @ManyToMany(mappedBy = "enrolledIn",cascade = CascadeType.ALL)
    private Set<Student> enrolledStudents;

    public Course() {
    }

    public Course(String title, String description, int numberOfCredits) {
        this.title = title;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

   /* public void addEnrolledStudent(Student student) {
        enrolledStudents.add(student);
    }*/

   /* public void removeEnrolledStudent(Student student) {
        enrolledStudents.remove(student);
    }*/
}
