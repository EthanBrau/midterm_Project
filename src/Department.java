/**
 * File: Department.java
 * Description: Department model for group midterm (Gustavus Registration System)
 *
 * @author  Isaac Winkelman (isaacwinkelman@gustavus.edu)
 * @version 1.0
 * @since   2026-02-19
 */

import java.util.*;


public class Department {
    private int deptID;
    private List<Integer> staff;
    private List<Integer> students;
    private String name;
    private int departmentHead;
    private List<Integer> degrees;
    private List<Course> classesOffered;
    private List<Course> classArchive;

    //constructor for department class
    public Department(int deptID, String name, int departmentHead) {
        this.deptID = deptID;
        this.name = name;
        this.departmentHead = departmentHead;
        this.staff = new ArrayList<>();
        this.students = new ArrayList<>();
        this.degrees = new ArrayList<>();
        this.classesOffered = new ArrayList<>();
        this.classArchive = new ArrayList<>();
    }

    public void offerClass(Course course, String semester) {
        if (course == null || semester == null || semester.isBlank()) {
            return;
        }

        course.setSemester(semester);
        classesOffered.add(course);
    }

    public void addClassArchive(Course course) {
        if (course == null) {
            return;
        }
        classArchive.add(course);
    }

    public void addStudent(int studentID) {
        // makes it so no duplicates allowed
        if (!students.contains(studentID)) {
            students.add(studentID);
        }
    }

    public void addProf(int profID) {
        // makes it so no duplicates allowed
        if (!staff.contains(profID)) {
            staff.add(profID);
        }
    }
    /* for usage of deptID outside department class */
    public int getDeptID() {
        return deptID;
    }

    public void applyForMajor(int degreeID) {
        // makes it so no duplicates allowed
        if (!degrees.contains(degreeID)) {
            degrees.add(degreeID);
        }
    }
}





