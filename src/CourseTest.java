/**
 * File: CourseTest.java
 * Description: Course code for Lab subClass UML diagram for group midterm (Gustavus
 *              Registration System)
 *
 * @author  Junior Opoku-Ansah (junioro@gustavus.edu)
 * @version 1.0
 * @since   2026-02-19
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CourseTest {

    private Course course;
    private List<Course> emptyPrereqs;
    private List<Student> emptyStudents;
    private List<Integer> emptyLabSections;

    @BeforeEach
    void setUp() {
        emptyPrereqs = new ArrayList<>();
        emptyStudents = new ArrayList<>();
        emptyLabSections = new ArrayList<>();


        Professor prof = new Professor(1, "Alan", "Smith");

        course = new Course(
                emptyPrereqs,
                "Intro to CS",
                900,
                emptyStudents,
                "CS",
                prof,
                "Fall 2026",
                30,
                emptyLabSections,
                3,
                CourseSatisfaction.QUANT
        );
    }

    @Test
    void testGetCredits() {
        assertEquals(3, course.getCredits());
    }

    @Test
    void testGetSatisfaction() {
        assertEquals(CourseSatisfaction.QUANT, course.getSatisfaction());
    }

    @Test
    void testIdIsWithinRange() {
        // ID should be between MIN (1000) and MAX (1000000000)
        int id = course.getId(); // you'll need to add getId()
        assertTrue(id >= 1000 && id <= 1000000000);
    }

    @Test
    void testTwoCoursesHaveDifferentIds() {
        Professor prof = new Professor(11, "Jane", "Doe");
        Course other = new Course(
                emptyPrereqs, "Data Structures", 1000,
                emptyStudents, "CS", prof, "Fall 2026", 25,
                emptyLabSections, 4, CourseSatisfaction.SIGX
        );
        assertNotEquals(course.getId(), other.getId());
    }
}
