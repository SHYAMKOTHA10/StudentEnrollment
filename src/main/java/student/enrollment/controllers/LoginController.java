package student.enrollment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import student.enrollment.model.Student;
import student.enrollment.services.StudentsService;

import java.util.Optional;

/**
 * Controller that handles student login to Student Portal
 */
@Controller
public class LoginController {
    private final StudentsService studentsService;

    public LoginController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    /**
     * Shows the login form to the user
     */
    @GetMapping("/studentlogin")
    public String login() {
        return "login";
    }

    /**
     * Validates the data sent to the server when a user attempts to login.
     * Redirects to the student view if login is successful
     */
    @PostMapping("/studentlogin")
    public String studentLogin(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {
        Optional<Student> student = studentsService.findStudentByEmail(email);
        if (student.isEmpty()) {
            model.addAttribute("error", true);
            model.addAttribute("error_message", "Student with this email wasn't found");
            return "login";
        }

        if (!student.get().getLastName().equalsIgnoreCase(password)) {
            model.addAttribute("error", true);
            model.addAttribute("error_message", "Password doesn't match");
            return "login";
        }

        return "redirect:student?student_id=" + student.get().getId();
    }
}
