/**
 * File: Lab.java
 * Description: Course code for Lab subClass UML diagram for group midterm (Gustavus
 *              Registration System)
 *
 * @author  Junior Opoku-Ansah (junioro@gustavus.edu)
 * @version 1.0
 * @since   2026-02-19
 */

import java.util.List;

public class Lab extends Course {
    private List<Integer> ta; // List of TA IDs
    private int linkedClassID;
    

    public Lab(List<Course> prerequisites, String name, int time, List<Student> students,
               String department, Professor professor, String semester,
               int maxSize, List<Integer> labSections, List<Integer> ta, int linkedClassID, CourseSatisfaction satisfaction) {
        super(prerequisites,name,time,students,department,professor, true, semester, maxSize, labSections, maxSize,satisfaction);
        this.ta = ta;
        this.linkedClassID = linkedClassID;
    }


    public int getLinkedClassID() { return linkedClassID; }
    public void setLinkedClassID(int linkedClassID) { this.linkedClassID = linkedClassID; }
}
