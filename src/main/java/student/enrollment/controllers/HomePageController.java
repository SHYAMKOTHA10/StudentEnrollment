package student.enrollment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import student.enrollment.model.Course;
import student.enrollment.model.StudentProfile;
import student.enrollment.model.Program;
import student.enrollment.model.Student;
import student.enrollment.services.CoursesService;
import student.enrollment.services.StudentProfileService;
import student.enrollment.services.ProgramService;
import student.enrollment.services.StudentsService;

import java.util.List;

/**
 * Controller that handles requests from the homepage
 */
@Controller
public class HomePageController {
    private final StudentProfileService studentProfileService;
    private final StudentsService studentsService;
    private final ProgramService programService;
    private final CoursesService coursesService;

    public HomePageController(StudentProfileService studentProfileService,
                              StudentsService studentsService,
                              ProgramService programService,
                              CoursesService coursesService) {

        this.studentProfileService = studentProfileService;
        this.studentsService = studentsService;
        this.programService = programService;
        this.coursesService = coursesService;
    }
    /**
     * Shows a list of all the students, registered to the university
     */
    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> allRegisteredStudents = studentsService.getAllRegisteredStudents();
        model.addAttribute("students", allRegisteredStudents);

        model.addAttribute("show_students", true);
        model.addAttribute("show_courses", false);
        model.addAttribute("show_programs", false);
        model.addAttribute("show_scores", false);
        return "programs";
    }

    /**
     * Shows the active students data, sorted by GPA
     */
    @GetMapping("/scores")
    public String getActiveStudentsSortedByGpa(Model model) {
        List<StudentProfile> activeStudentsProfiles =
                studentProfileService.getActiveStudentProfilesOrderedByGpa();
        model.addAttribute("students_profiles", activeStudentsProfiles);

        model.addAttribute("show_students", false);
        model.addAttribute("show_courses", false);
        model.addAttribute("show_programs", false);
        model.addAttribute("show_scores", true);
        return "programs";
    }

    /**
     * Shows all the programs that students are currently enrolled in
     */
    @GetMapping("/programs")
    public String getProgramsWithStudents(Model model) {
        List<Program> programs = programService.getAllProgramsWithStudents();
        model.addAttribute("programs", programs);

        model.addAttribute("show_students", false);
        model.addAttribute("show_courses", false);
        model.addAttribute("show_programs", true);
        model.addAttribute("show_scores", false);
        return "programs";
    }

    /**
     * Shows all the courses on the homepage
     */
    @GetMapping("/courses")
    public String getNumberOfStudentPerCourse(Model model) {
        List<Course> courses =
                coursesService.getAllCourses();
        model.addAttribute("courses", courses);

        model.addAttribute("show_students", false);
        model.addAttribute("show_courses", true);
        model.addAttribute("show_programs", false);
        model.addAttribute("show_scores", false);
        return "programs";
    }
}
