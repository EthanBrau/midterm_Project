//Ethan Brau implementations
import java.util.*;


public class Professor {
    public int professorID;
    public String firstName;
    public String lastName;
    public List<Integer> advisee;
    public List<Course> courses;
    public List<Integer> ratemyProfScore;
    public List<Integer> teachingSchedule;
    public boolean onLeave;
    public boolean associate;
    public boolean visiting;
    public boolean tenured;

    //consructor
    public Professor(int professorID, String firstName, String lastName) {
        this.professorID = professorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<>();
        this.advisee = new ArrayList<>();
        this.ratemyProfScore = new ArrayList<>();
        this.teachingSchedule = new ArrayList<>();
        this.onLeave = false;
        this.associate = false;
        this.visiting = false;
        this.tenured = false;

    }

    public int getProfessorID() {
        // return what a professors ID is
        return professorID;
    }


    private void setProfessorID(int professorID) {
        // set professor ID if needed
        // more for admin class but added for now
        this.professorID = professorID;
    }


    public String getProfessorName() {
        return firstName + " " + lastName;
    }


    private void setProfessorFirstName(String firstName) {
        // who knows maybe they switch their first name
        this.firstName = firstName;
    }


    private void setProfessorLastName(String lastName) {
        // set last name, Prof might get married and like that name more
        this.lastName = lastName;
    }


    private void addCourse(Course course) {
        // will need to fix by having it set to course ID once added
        if (onLeave) {
            System.out.println("Can't add course because Professor is on leave");
            return;
        }
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    private void goOnLeave() {
        onLeave = true;
    }
    private void returnFromLeave() {
        onLeave = false;
    }

    public String checkOnleave() {
        if (onLeave) {
            return this.firstName + " " + this.lastName +" is currently on leave";
        }
        else {
            return this.firstName + " " + this.lastName +" is not on leave";
        }
    }

    private void addGradeMidterm(double grade, Student studentID,Course id ) {

    }

    public void rateProf(int rating) {

            if (rating < 0 || rating > 10) {
                System.out.println("Rating must be between 0 and 10");
                return;
        }
        ratemyProfScore.add(rating);
    }

    public double getProfScore() {
        int sumScore = 0;
        for (int score : ratemyProfScore) {
            sumScore += score;
        }
        return (double) sumScore / ratemyProfScore.size();
    }


    public static void main(String[] args) {
        Professor prof1 = new Professor(0001, "John", "Doe");
        System.out.println(prof1.getProfessorID());
        System.out.println(prof1.getProfessorName());
        System.out.println(prof1.getCourses());

        // --- rateProf / getProfScore tests ---

        // Test 1: no ratings yet should return -1.0
        System.out.println("\n-- Test 1: No ratings yet --");
        System.out.println(prof1.getProfScore()); // expected: -1.0

        // Test 2: single rating, average should equal that rating
        System.out.println("\n-- Test 2: Single rating of 4 --");
        prof1.rateProf(4);
        System.out.println(prof1.getProfScore()); // expected: 4.0

        // Test 3: two ratings, checks the sum/size math
        System.out.println("\n-- Test 3: Add rating of 5, average of [4,5] --");
        prof1.rateProf(5);
        System.out.println(prof1.getProfScore()); // expected: 4.5

        // Test 4: invalid rating too low, should not change the average
        System.out.println("\n-- Test 4: Invalid rating of -1 (should be rejected) --");
        prof1.rateProf(-1);
        System.out.println(prof1.getProfScore()); // expected: still 4.5

        // Test 5: invalid rating too high, should not change the average
        System.out.println("\n-- Test 5: Invalid rating of 11 (should be rejected) --");
        prof1.rateProf(11);
        System.out.println(prof1.getProfScore()); // expected: still 4.5

        // Test 6: boundary values, 0 and 10 should both be accepted
        System.out.println("\n-- Test 6: Boundary ratings 0 and 10 --");
        prof1.rateProf(0);
        prof1.rateProf(10);
        System.out.println(prof1.getProfScore()); // expected: (4+5+0+10)/4 = 4.75
    }

}

