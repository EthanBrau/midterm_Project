import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DegreeTest {

    private Course buildCourse(String name) {
        return new Course(
                new ArrayList<>(),
                name,
                900,
                new ArrayList<>(),
                "CSCI",
                new Professor(1, "Test", "Professor"),
                false,
                "Fall 2026",
                30,
                new ArrayList<>(),
                1,
                CourseSatisfaction.QUANT
        );
    }

    @Test
    void constructorAndGettersShouldReturnAssignedValues() {
        Course[] requiredClasses = new Course[]{buildCourse("Algorithms"), buildCourse("Databases")};

        Degree degree = new Degree(true, "Computer Science", 101, true, false, requiredClasses);

        assertTrue(degree.isRequiredToGrad());
        assertEquals("Computer Science", degree.getName());
        assertEquals(101, degree.getDegreeId());
        assertTrue(degree.isMajor());
        assertFalse(degree.isMinor());
        assertSame(requiredClasses, degree.getRequiredClasses());
    }

    @Test
    void settersShouldUpdateAllFields() {
        Degree degree = new Degree(false, "Math", 1, false, true, new Course[0]);
        Course[] updatedClasses = new Course[]{buildCourse("Software Engineering")};

        degree.setRequiredToGrad(true);
        degree.setName("Data Science");
        degree.setDegreeId(202);
        degree.setMajor(true);
        degree.setMinor(false);
        degree.setRequiredClasses(updatedClasses);

        assertTrue(degree.isRequiredToGrad());
        assertEquals("Data Science", degree.getName());
        assertEquals(202, degree.getDegreeId());
        assertTrue(degree.isMajor());
        assertFalse(degree.isMinor());
        assertSame(updatedClasses, degree.getRequiredClasses());
    }

    @Test
    void shouldAllowNullRequiredClasses() {
        Degree degree = new Degree(false, "History", 33, false, false, null);

        assertNull(degree.getRequiredClasses());

        degree.setRequiredClasses(null);

        assertNull(degree.getRequiredClasses());
    }
}
