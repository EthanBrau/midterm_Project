
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

//****** Made by Alex Hoff ******

public class StudentTest {
    private Student BuildDaStudent(String Firstname, String Lastname, int ID){
        return new Student(Firstname, Lastname, ID);

    }

    @Test
    void TestingStudentStartingAttributes(){

        Student stu = new Student("stu", "pid", 001);
        Student mike = new Student("mike", "oxlong", 002);


        assertEquals("stu", stu.getFirstName());
        assertEquals("pid", stu.getLastName());
        assertEquals(001, stu.getStudentIDNumber());
        assertEquals(2030, stu.getGradYear());
        assertNotEquals(null, stu.getGraduationRequirements());
        assertEquals(128, stu.getGraduationCreditsRemaining());
        assertEquals(0,stu.getMyAdvisor());
        assertNull(stu.getCompletedClasses());
        assertNull(stu.getSchedule());
        assertEquals(0,stu.getCurrentCredits());
        assertEquals(true,stu.getOncampusStatus());
        assertEquals(true, stu.getEnrollmentStatus());
        assertNull(stu.getMyMajor());
        assertNull(stu.getMyMinor());
        assertEquals(false, stu.canGraduate);
        assertEquals(false,stu.getIsGraduatedStatus());
    }

    @Test
    void StudentSettersAndManipulators(){
        Student stu = new Student("stu", "pid", 001);
        Student mike = new Student("mike", "oxlong", 002);
        List<Student> students = List.of();
        Professor louis = new Professor(001, "louis", "yu");
        Course chem = new Course(null, "chemistry", 9, students, "MCS", louis, "fall", 30, null, 4,CourseSatisfaction.QUANT);
        Degree compSci = new Degree(true,"computer science", 001, true, false, null);

        stu.setFirstName("Stu");
        assertEquals("Stu", stu.getFirstName());
        stu.setLastName("Pid");
        assertEquals("Pid", stu.getLastName());

        stu.addAdvisor(001);
        assertEquals(001, stu.getMyAdvisor());

        stu.addCourseToSchedule(chem);
        assertNotNull(stu.getSchedule());
        stu.removeCourseFromSchedule(chem);
        assertNull(stu.getSchedule());

        stu.changeOnCampusStatus();
        assertEquals(false, stu.getOncampusStatus());
        stu.changeOnCampusStatus();
        assertEquals(true, stu.getOncampusStatus());

        stu.changeEnrollmentStatus();
        assertEquals(false, stu.getEnrollmentStatus());
        stu.changeEnrollmentStatus();
        assertEquals(true, stu.getEnrollmentStatus());

        stu.canIGraduate();
        assertNotEquals(true, stu.canGraduate);

        stu.graduate();
        assertNotEquals(true,stu.getIsGraduatedStatus());

        stu.rateProfessor(5, louis);
        assertEquals(5, louis.getProfScore());
    }






}
