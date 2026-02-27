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
    List<Course> prerequisites;
    String name;
    private int time;
    private List<Student> students;
    String department;
    Professor professor;
    boolean hasLab;
    String semester;
    int maxSize;
    int credits;
    private List<Integer> labSections;
    private CourseSatisfaction satisfaction;


    static final int MAX = 1000000000;
    static final int MIN = 1000;

    public Course(List<Course> prereq, String name, int time, List<Student> students,
                  String department, Professor professor, boolean hasLab,
                  String semester, int maxSize, List<Integer> labSections, int credits, CourseSatisfaction satisfaction) {

        Random random = new Random();
        this.id = random.nextInt(MAX - MIN + 1) + MIN;
        this.prerequisites = prereq;
        this.name = name;
        this.time = time;
        this.students = students;
        this.department = department;
        this.professor = professor;
        this.hasLab = hasLab;
        this.semester = semester;
        this.maxSize = maxSize;
        this.labSections = labSections;
        this.satisfaction = satisfaction;
    }

    public int getCredits() {
        return this.credits;
    }
    public  CourseSatisfaction getSatisfaction() {return this.satisfaction;}
}

