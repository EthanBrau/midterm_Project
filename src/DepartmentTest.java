import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {

    private Department department;
    private Course course;

    @BeforeEach
    void setUp() {
        department = new Department(10, "Computer Science", 99);
        course = new Course(
                new ArrayList<>(),
                "Intro to CS",
                900,
                new ArrayList<>(),
                "CS",
                new Professor(1, "Alan", "Smith"),
                "Fall 2026",
                30,
                new ArrayList<>(),
                3,
                CourseSatisfaction.QUANT
        );
    }

    @Test
    void testGetDeptIDReturnsConstructorValue() {
        assertEquals(10, department.getDeptID());
    }

    @Test
    void testConstructorInitializesEmptyCollections() throws Exception {
        assertTrue(getIntListField("staff").isEmpty());
        assertTrue(getIntListField("students").isEmpty());
        assertTrue(getIntListField("degrees").isEmpty());
        assertTrue(getCourseListField("classesOffered").isEmpty());
        assertTrue(getCourseListField("classArchive").isEmpty());
    }

    @Test
    void testOfferClassSetsSemesterAndAddsCourse() throws Exception {
        department.offerClass(course, "Spring 2027");

        assertEquals("Spring 2027", course.getSemester());
        List<Course> offered = getCourseListField("classesOffered");
        assertEquals(1, offered.size());
        assertSame(course, offered.get(0));
    }

    @Test
    void testOfferClassIgnoresNullOrBlank() throws Exception {
        department.offerClass(null, "Fall 2027");
        assertTrue(getCourseListField("classesOffered").isEmpty());

        department.offerClass(course, "   ");
        assertEquals("Fall 2026", course.getSemester());
        assertTrue(getCourseListField("classesOffered").isEmpty());
    }

    @Test
    void testAddStudentNoDuplicates() throws Exception {
        department.addStudent(123);
        department.addStudent(123);

        List<Integer> students = getIntListField("students");
        assertEquals(1, students.size());
        assertEquals(123, students.get(0));
    }

    @Test
    void testAddProfNoDuplicates() throws Exception {
        department.addProf(7);
        department.addProf(7);

        List<Integer> staff = getIntListField("staff");
        assertEquals(1, staff.size());
        assertEquals(7, staff.get(0));
    }

    @Test
    void testApplyForMajorAddsDegree() throws Exception {
        department.applyForMajor(42);

        List<Integer> degrees = getIntListField("degrees");
        assertEquals(1, degrees.size());
        assertEquals(42, degrees.get(0));
    }

    @Test
    void testAddClassArchiveAddsCourseAndIgnoresNull() throws Exception {
        department.addClassArchive(null);
        assertTrue(getCourseListField("classArchive").isEmpty());

        department.addClassArchive(course);
        List<Course> archive = getCourseListField("classArchive");
        assertEquals(1, archive.size());
        assertSame(course, archive.get(0));
    }

    @SuppressWarnings("unchecked")
    private List<Integer> getIntListField(String fieldName) throws Exception {
        Field field = Department.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (List<Integer>) field.get(department);
    }

    @SuppressWarnings("unchecked")
    private List<Course> getCourseListField(String fieldName) throws Exception {
        Field field = Department.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (List<Course>) field.get(department);
    }
}
