import java.sql.Array;
import java.util.*;
//import Professor;
//import Course;



 //****** Made By Alex Hoff ******



public class Student {
    int currentYear;
    int studentID;
    String firstName;
    String lastName;
    int gradYear;
    ArrayList<Integer> major; // major id, the default value that shouldn't be assigned to a major is 0
    ArrayList<Integer> minor; // minor id the default value that shouldn't be assigned to a minor is 0
    int currentCredits;
    ArrayList<Integer> schedule;
    ArrayList<Integer> allCompletedClasses;
    ArrayList<String> graduationRequirements;
    int graduationCreditRequirements;
    Boolean canGraduate;
    Boolean isGraduated;
    Boolean enrollmentStatus;// will be true if fulltime student, false if parttime
    Boolean onCampus;
    ArrayList<Integer> advisor;

    /*
    Constructor for student class
    this only has on way of making a student because you need a name for them and a student id
     */
    public Student(String firstName, String lastName, int StudentID){
        studentID = StudentID;
        this.firstName = firstName;
        this.lastName = lastName;
        gradYear = currentYear + 4;
        currentCredits = 0;
        schedule = new ArrayList<>();
        minor = new ArrayList<>();
        major = new ArrayList<>();
        graduationRequirements = new ArrayList<>();
        graduationRequirements.addLast("QUANT");
        graduationRequirements.addLast("USIDG");
        graduationRequirements.addLast("GLAFC");
        graduationRequirements.addLast("LANG-101");
        graduationRequirements.addLast("LANG-102");
        graduationRequirements.addLast("CHALS");
        graduationRequirements.addLast("FTS");
        graduationRequirements.addLast("SIGX");
        graduationCreditRequirements = 128;
        allCompletedClasses = new ArrayList<>();
        canGraduate = false;
        isGraduated = false;
        enrollmentStatus = true;
        onCampus = true;
        advisor = new ArrayList<>();

    }

    /*
    toString function to make it so when you print out a student it shows the relevant
    information (relevant and public)
     */
    @Override
    public String toString() {
        return "Student name: " + firstName + " " + lastName + " Student ID: " + studentID +
                "Graduation Year: " + gradYear + " Total Completed Credits: " + (128 - graduationCreditRequirements);
    }


    /*
    Updates the rate my professor score in the professor class. this is based off of the inputted
    professor object and the rating you want to give them
     */
    private void rateProfessor(int rating, Professor professor){
        professor.rateProfessor(rating);
    }

    /*
    this will add an advisor to your advisor list.
     */
    private void addAdvisor(int AdvisorID){
        advisor.add(AdvisorID);
    }

    /*
    adds a course (based off the course id to find the course object) to your
    arrayList schedule. it also updates the current credits you have for the semester.
     */
    private void addCourseToSchedule(int courseID){
        schedule.addLast(courseID);
        currentCredits = currentCredits + Course.getCredits(courseID);
    }

    /*
    removes the course if you have it from your schedule based off the courseID inputted.
    it also updates the current Credits, and it will print out a string to tell you if you
    do not have the course in your schedule.
     */
    private void removeCourseFromSchedule(int courseID){
        if (schedule.contains(courseID)){
            schedule.remove(schedule.get(courseID));
            currentCredits = currentCredits - Course.getCredits(courseID);
        } else{
            System.out.println("The course you are trying to remove is not in your schedule");
        }
    }

    /*

     */
    private void requestMajor(int MajorID){
        req = department.getMajorRequirements(MajorID);
        if (allCompletedClasses.containsAll(req)){
            System.out.println("You have sucessfully requested a major");
            department.applyForMajor(MajorID);
        } else{
            System.out.println("You have not completed the required classes for this major");
        }
    }

    /*

     */
    private void requestMinor(int MinorID){
        req = department.getMinorRequirements(MinorID);
        if (allCompletedClasses.containsAll(req)){
            System.out.println("You have sucessfully requested a minor");
            department.applyForMajor(MinorID);
        } else{
            System.out.println("You have not completed the required classes for this minor");
        }
    }

    /*
    this is  function a student can call to check and see if they can graduate.
    it will first check and see if the canGraduate variable is true, otherwise it looks
    at the graduation requirements, credits and if you have a major. if you have all these
    things it will update the variable canGraduate and gives you a nice string.
    if you aren't eligible to graduate it will give you a string saying you cannot graduate
     */
    private void canIGraduate(){
        if (canGraduate){
            System.out.println("Yes you can graduate!");
        } else if (graduationRequirements.isEmpty() && graduationCreditRequirements <= 0 && !major.isEmpty()){
            canGraduate = true;
            System.out.println("Yes you can graduate!");
        }
        else{
            System.out.println("You are not eligible to graduate right now.");
        }
    }

    /*
    this function should be used once you have graduated to mark this student object that
    it is no longer in use, and can be deleted safely.
     */
    private void graduate(){
        if (canGraduate){
            isGraduated = true;
            System.out.println("Congratulations");
        }else{
            System.out.println("You cannot graduate yet");
        }
    }


    /*
    this will change if you are a fulltime/parttime student. it will change to what it isn't
    currently
     */
    private void changeEnrollmentStatus(){
        if (enrollmentStatus = true){
            enrollmentStatus = false;
        }else{
            enrollmentStatus = true;
        }
    }

    /*
    this will change if you are a onCampus status of the student. it will change to what it isn't
    currently. this should represent if they are living on campus or off campus.
     */
    private void changeOnCampusStatus(){
        if (onCampus = true){
            onCampus = false;
        }else{
            onCampus = true;
        }
    }


    /*
    this will finalize the current courses that you have, update the variables like
    if you can graduate, finished classes, credits/requirements to graduate.
    ******need to have all classes (i think) to finish this one******
     */
    private void register(){

    }





    public static void main(String[] args){
        Student stu = new Student("Stu", "Pid", 001);

    }

}
