import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class LabTest {

    private Lab lab;

    @BeforeEach
    void setUp() {
        Professor prof = new Professor(12,"Jaden", "Lee");
        Student taJames = new Student("James", "Jameson", 90);
        Student taSam = new Student("Sam", "Samson", 43);
        List<Student> tas = List.of(taJames, taSam);

        lab = new Lab(
                new ArrayList<Course>(),
                "Chemistry Lab",
                1400,
                new ArrayList<Student>(),
                "CHEM",
                prof,
                "Spring 2026",
                20,
                new ArrayList<Integer>(),
                tas,
                55501,
                3,
                CourseSatisfaction.GLAFC
        );
    }

    @Test
    void testHasLabIsAlwaysTrue() {
        assertTrue(lab.hasLab());
    }

    @Test
    void testGetLinkedClassID() {
        assertEquals(55501, lab.getLinkedClassID());
    }

    @Test
    void testSetLinkedClassID() {
        lab.setLinkedClassID(99999);
        assertEquals(99999, lab.getLinkedClassID());
    }

    @Test
    void testLabIsInstanceOfCourse() {
        assertInstanceOf(Course.class, lab);
    }

    @Test
    void testCreditsInheritedCorrectly() {
        assertEquals(3, lab.getCredits());
    }
}
