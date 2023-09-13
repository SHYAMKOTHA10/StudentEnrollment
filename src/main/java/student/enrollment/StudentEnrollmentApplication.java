package student.enrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Entry point to the Spring boot application
 */
@SpringBootApplication
public class StudentEnrollmentApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "true");
        System.setProperty("spring.devtools.restart.additional-paths", "src/*");
        SpringApplication.run(StudentEnrollmentApplication.class, args);
    }
}
