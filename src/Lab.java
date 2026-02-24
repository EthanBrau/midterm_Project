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
    

    public Lab(List<Integer> prereq, String name, int time, List<Integer> students,
               String department, Professor professor, String semester,
               int maxSize, List<Integer> labSections, List<Integer> ta, int linkedClassID) {
        super(prereq, name, time, students, department, professor,
                true, semester, maxSize, labSections);
        this.ta = ta;
        this.linkedClassID = linkedClassID;
    }


    public int getLinkedClassID() { return linkedClassID; }
    public void setLinkedClassID(int linkedClassID) { this.linkedClassID = linkedClassID; }
}
