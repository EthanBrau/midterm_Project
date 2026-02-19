
import java.util.*;

public class Professor {
    int professorID;
    String firstName;
    String lastName;
    List<Integer> advisee;
    List<String> courses;
    int ratemyProfScore;
    List<Integer> teachingSchedule;
    boolean onLeave;
    boolean assistant;
    boolean visiting;

    //consructor
    public Professor(int professorID, String firstName, String lastName) {
        this.professorID = professorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<>();

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


    private void addCourse(String course) {
        // will need to fix by having it set to course ID once added
        courses.add(course);
    }

    public List<String> getCourses() {
        return courses;
    }


    private void goOnLeave() {
        onLeave = true;
    }

    public void checkOnleave() {
        if (onLeave)  ;

    }



    public static void main(String[] args) {
    Professor prof1 = new Professor(0001, "John", "Doe");
    System.out.println(prof1.getProfessorID());
    System.out.println(prof1.getProfessorName());
    prof1.addCourse("Java");
    prof1.addCourse("Python");
    System.out.println(prof1.getCourses());
    }
}