/**
 * File: Course.java
 * Description: Course code for Course UML diagram for group midterm (Gustavus
 *              Registration System) with a Lab subClass
 *
 * @author  Junior Opoku-Ansah (junioro@gustavus.edu)
 * @version 1.0
 * @since   2026-02-19
 */

import java.util.*;


public class Course {
    private int id;
    List<Integer> prereq;
    String name;
    private int time;
    private List<Integer> students;
    String department;
    Professor professor;
    boolean hasLab;
    String semester;
    int maxSize;
    private List<Integer> labSections;


    static final int MAX = 1000000000;
    static final int MIN = 1000;

    public Course(List<Integer> prereq, String name, int time, List<Integer> students,
                  String department, Professor professor, boolean hasLab,
                  String semester, int maxSize, List<Integer> labSections) {

        Random random = new Random();
        this.id = random.nextInt(MAX - MIN + 1) + MIN;
        this.prereq = prereq;
        this.name = name;
        this.time = time;
        this.students = students;
        this.department = department;
        this.professor = professor;
        this.hasLab = hasLab;
        this.semester = semester;
        this.maxSize = maxSize;
        this.labSections = labSections;
    }
}

