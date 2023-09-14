DELETE FROM COURSES;
INSERT INTO COURSES (title, description, number_of_credits) VALUES ('Spring framework', 'Introduction to the Spring framework 5', 100);
INSERT INTO COURSES (title, description, number_of_credits) VALUES ('Kubernetes', 'Introduction to container orchestration', 200);
INSERT INTO COURSES (title, description, number_of_credits) VALUES ('Mongo DB', 'Introduction to Mongo DB Replicasets , sharding', 200);
INSERT INTO COURSES (title, description, number_of_credits) VALUES ('Docker', 'Introduction to Containerization', 100);
INSERT INTO COURSES (title, description, number_of_credits) VALUES ('Hibernate', 'Introduction to object–relational mapping tool', 200);
INSERT INTO COURSES (title, description, number_of_credits) VALUES ('Virtualization', 'Technology to create virtual Machines', 300);

DELETE FROM STUDENTS;
DELETE FROM STUDENT_PROFILES;

INSERT INTO STUDENT_PROFILES (number_of_credits, gpa, is_graduated, start_year) VALUES (500, 83.34, FALSE, 2022);
INSERT INTO STUDENTS (first_name, last_name, email, date_of_birth, profile_id) VALUES ('Shyamsunder', 'Kotha', 'kshyamhcl@gmail.com', '1978-05-10', 1);

INSERT INTO STUDENT_PROFILES (number_of_credits, gpa, is_graduated, start_year) VALUES (450, 75, FALSE, 2021);
INSERT INTO STUDENTS (first_name, last_name, email, date_of_birth, profile_id) VALUES ('Ajantha', 'Kotha', 'aj@gmail.com', '1985-07-27', 2);

INSERT INTO STUDENT_PROFILES (number_of_credits, gpa, is_graduated, start_year) VALUES (700, 87.5, FALSE, 2021);
INSERT INTO STUDENTS (first_name, last_name, email, date_of_birth, profile_id) VALUES ('Srineeth', 'Kotha', 'kothasrineeth@gmail.com', '2012-02-03', 3);

INSERT INTO STUDENT_PROFILES (number_of_credits, gpa, is_graduated, start_year) VALUES (1000, 100, TRUE, 2019);
INSERT INTO STUDENTS (first_name, last_name, email, date_of_birth, profile_id) VALUES ('Aanvi', 'Kotha', 'ak@gmail.com', '2017-10-13', 4);

DELETE FROM PROGRAMS;
INSERT INTO PROGRAMS (required_years_to_graduation, required_credits_to_graduation, field_of_study, degree) VALUES (4, 600, 'Computer Science', 'BACHELOR');
INSERT INTO PROGRAMS (required_years_to_graduation, required_credits_to_graduation, field_of_study, degree) VALUES (2, 800, 'Computer Science', 'MASTER');
INSERT INTO PROGRAMS (required_years_to_graduation, required_credits_to_graduation, field_of_study, degree) VALUES (2, 1000, 'Computer Science', 'PHD');
INSERT INTO PROGRAMS (required_years_to_graduation, required_credits_to_graduation, field_of_study, degree) VALUES (4, 600, 'Electrical Engineering', 'BACHELOR');

UPDATE STUDENTS SET program_id = 1 WHERE first_name = 'Shyamsunder';
UPDATE STUDENTS SET program_id = 1 WHERE first_name = 'Ajantha';
UPDATE STUDENTS SET program_id = 2 WHERE first_name = 'Srineeth';
UPDATE STUDENTS SET program_id = 3 WHERE first_name = 'Aanvi';

DELETE FROM COURSE_ENROLLMENTS;

INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (1, 1);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (1, 2);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (1, 3);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (1, 4);

INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (2, 1);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (2, 2);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (2, 3);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (2, 4);

INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (3, 1);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (3, 2);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (3, 3);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (3, 4);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (3, 5);

INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (4, 1);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (4, 2);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (4, 3);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (4, 4);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (4, 5);
INSERT INTO COURSE_ENROLLMENTS (enrolled_student_id, course_id) VALUES (4, 6);
