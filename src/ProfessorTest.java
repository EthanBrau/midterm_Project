//Ethan Brau unit testing
// All methods made public in Professor.Java to do unit testing in professor test
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class ProfessorTest {

    private Professor prof;
    private Course javaCourse;
    private Course pythonCourse;

    @BeforeEach
    void setUp() {
        prof = new Professor(001, "John", "Doe");

        javaCourse = new Course(
                new ArrayList<>(), "Intro to Java", 900,
                new ArrayList<>(), "Computer Science", prof,
                "Fall 2026", 30, new ArrayList<>(), 3, CourseSatisfaction.QUANT
        );

        pythonCourse = new Course(
                new ArrayList<>(), "Intro to Python", 1100,
                new ArrayList<>(), "Computer Science", prof,
                "Fall 2026", 25, new ArrayList<>(), 3, CourseSatisfaction.QUANT
        );
    }


    @Test
    void testGetProfessorID() {
        assertEquals(1, prof.getProfessorID());
    }

    @Test
    void testGetProfessorName() {
        assertEquals("John Doe", prof.getProfessorName());
    }

    @Test
    void testAddCourseNormal() {
        prof.addCourse(javaCourse);
        prof.addCourse(pythonCourse);
        assertEquals(2, prof.getCourses().size());
    }

    @Test
    void testAddCourseWhileOnLeave() {
        prof.goOnLeave();
        prof.addCourse(javaCourse);
        assertEquals(0, prof.getCourses().size()); // course should not be added
        prof.returnFromLeave();
    }

    @Test
    void testCheckOnLeaveWhenNotOnLeave() {
        assertEquals("John Doe is not on leave", prof.checkOnLeave());
    }

    @Test
    void testCheckOnLeaveWhenOnLeave() {
        prof.goOnLeave();
        assertEquals("John Doe is currently on leave", prof.checkOnLeave());
        prof.returnFromLeave();
    }

    @Test
    void testAddGradeMidtermValidCourse() {
        prof.addCourse(javaCourse);
        prof.addGradeMidterm(88.5, 1001, javaCourse.getId());
        assertEquals(88.5, prof.midTermGrade.get(javaCourse.getId()).get(1001));
    }

    @Test
    void testAddGradeMidtermInvalidCourse() {
        prof.addCourse(javaCourse);
        prof.addGradeMidterm(88.5, 1001, 9999);
        assertNull(prof.midTermGrade.get(9999)); // no entry should exist for invalid ID
    }

    @Test
    void testAddGradeMidtermTwoStudentsSameCourse() {
        // check to make sure can add multiple grades multiple students
        prof.addCourse(javaCourse);
        prof.addGradeMidterm(88.5, 1001, javaCourse.getId());
        prof.addGradeMidterm(76.0, 1002, javaCourse.getId());
        assertEquals(88.5, prof.midTermGrade.get(javaCourse.getId()).get(1001));
        assertEquals(76.0, prof.midTermGrade.get(javaCourse.getId()).get(1002));
    }


    @Test
    void testAddGradeFinalValidCourse() {
        prof.addCourse(javaCourse);
        prof.addGradeFinal(91.0, 1001, javaCourse.getId());
        assertEquals(91.0, prof.finalGrade.get(javaCourse.getId()).get(1001));
    }

    @Test
    void testAddGradeFinalInvalidCourse() {
        prof.addCourse(javaCourse);
        prof.addGradeFinal(91.0, 1001, 9999);
        assertNull(prof.finalGrade.get(9999));
    }


    @Test
    void testGetProfScoreNoRatings() {
        assertEquals(-1, prof.getProfScore());
    }

    @Test
    void testGetProfScoreSingleRating() {
        prof.rateProf(4);
        assertEquals(4.0, prof.getProfScore());
    }

    @Test
    void testGetProfScoreTwoRatings() {
        prof.rateProf(4);
        prof.rateProf(5);
        assertEquals(4.5, prof.getProfScore());
    }


    @Test
    void testRequestCourseAddsToList() {
        prof.requestCourse("Data Structures", 1300);
        assertEquals(1, prof.classRequests.size());
    }

    @Test
    void testRequestCourseCorrectMessage() {
        prof.requestCourse("Data Structures", 1300);
        assertEquals("John Doe has requested to teach Data Structures at 1300",
                prof.classRequests.get(0));
    }


    @Test
    void testOverrideWaitlistValidAdd() {
        prof.addCourse(javaCourse);
        Student stu1 = new Student("Jane", "Smith", 1001);
        prof.overrideWaitlist(javaCourse.getId(), stu1);
        assertTrue(javaCourse.getStudents().contains(stu1));
    }

    @Test
    void testOverrideWaitlistAlreadyEnrolled() {
        prof.addCourse(javaCourse);
        Student stu1 = new Student("Jane", "Smith", 1001);
        prof.overrideWaitlist(javaCourse.getId(), stu1);
        prof.overrideWaitlist(javaCourse.getId(), stu1); // second add should be blocked
        assertEquals(1, javaCourse.getStudents().size()); // still only 1
    }

    @Test
    void testOverrideWaitlistInvalidCourse() {
        prof.addCourse(javaCourse);
        Student stu1 = new Student("Jane", "Smith", 1001);
        prof.overrideWaitlist(9999, stu1);
        assertFalse(javaCourse.getStudents().contains(stu1)); // should not be added
    }


    @Test
    void testApplyDepHeadNotTenured() {
        prof.applyDepHead();
        assertFalse(prof.hasAppliedDepHead); // should not be set if not tenured
    }

    @Test
    void testApplyDepHeadTenured() {
        prof.tenured = true;
        prof.applyDepHead();
        assertTrue(prof.hasAppliedDepHead);
    }

    @Test
    void testApplyDepHeadAlreadyApplied() {
        prof.tenured = true;
        prof.applyDepHead();
        prof.applyDepHead(); // second apply should be blocked
        assertTrue(prof.hasAppliedDepHead); // still true, not doubled
    }
}
