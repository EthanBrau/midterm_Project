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
    private List<Student> TA;
    private int linkedClassID;
    

    public Lab(List<Course> prerequisites, String name, int time, List<Student> students,
               String department, Professor professor, String semester,
               int maxSize, List<Integer> labSections, List<Student> TA, int linkedClassID, int credits, CourseSatisfaction satisfaction) {
        super(prerequisites,name,time,students,department,professor, semester, maxSize, labSections, credits,satisfaction);
        this.TA = TA;
        this.linkedClassID = linkedClassID;
    }


    public int getLinkedClassID() { return linkedClassID; }
    public void setLinkedClassID(int linkedClassID) { this.linkedClassID = linkedClassID; }
}
