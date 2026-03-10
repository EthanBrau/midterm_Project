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
    private List<Course> prerequisites;
    private String name;
    private int time;
    private List<Student> students;
    private String department;
    private Professor professor;
    private String semester;
    private int maxSize;
    private int credits;
    private List<Integer> labSections;
    private  CourseSatisfaction satisfaction;


    static final int MAX = 1000000000;
    static final int MIN = 1000;

    public Course(List<Course> prereq, String name, int time, List<Student> students,
                  String department, Professor professor,
                  String semester, int maxSize, List<Integer> labSections, int credits, CourseSatisfaction satisfaction) {

        Random random = new Random();
        this.id = random.nextInt(MAX - MIN + 1) + MIN;
        this.prerequisites = prereq;
        this.name = name;
        this.time = time;
        this.students = students;
        this.department = department;
        this.professor = professor;
        this.semester = semester;
        this.maxSize = maxSize;
        this.labSections = labSections;
        this.credits = credits;
        this.satisfaction = satisfaction;
    }

    public int getCredits() {
        return this.credits;
    }
    public  CourseSatisfaction getSatisfaction() {return this.satisfaction;}

    public int getId() {
        return this.id;
    }

    public boolean hasLab() {
        return this instanceof Lab;
    }

    public String getName() {
        return this.name;
    }

    public List<Student> getStudents() {
        return this.students;
    }
}

