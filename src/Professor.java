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
    public List<String> classRequests;
    public Map<Integer, Map<Integer, Double>> midTermGrade;
    public Map<Integer, Map<Integer, Double>> finalGrade;
    public boolean hasAppliedDepHead;

    //constructor
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
        this.classRequests = new ArrayList<>();
        this.midTermGrade = new HashMap<>();
        this.finalGrade = new HashMap<>();
        this.hasAppliedDepHead = false;

    }

    public int getProfessorID() {
        // return what a professors ID is
        return professorID;
    }


    public void setProfessorID(int professorID) {
        // set professor ID if needed
        // more for admin class but added for now
        this.professorID = professorID;
    }


    public String getProfessorName() {
        // return professor first and last name.
        return firstName + " " + lastName;
    }


    public void setProfessorFirstName(String firstName) {
        // who knows maybe they switch their first name
        this.firstName = firstName;
    }


    public void setProfessorLastName(String lastName) {
        // set last name, Prof might get married and like that name more
        this.lastName = lastName;
    }


    public void addCourse(Course course) {
        // Check if professor is currently teachning, if they are add
        // this to courses they are teaching and make hashmaaps for final grade.
        if (onLeave) {
            System.out.println("Can't add course because Professor is on leave");
            return;
        }
        courses.add(course);
        midTermGrade.put(course.getId(), new HashMap<>());
        finalGrade.put(course.getId(), new HashMap<>());
    }

    public List<Course> getCourses() {
        // return list of courses
        return courses;
    }

    public void goOnLeave() {
        // if you are a professor, make it so you can go on leave.
        onLeave = true;
    }

    public void returnFromLeave() {
        // if you return from leave make it public
        onLeave = false;
    }

    public String checkOnLeave() {
        // check if Prof is or is not currently on leave.
        if (onLeave) {
            return this.firstName + " " + this.lastName + " is currently on leave";
        } else {
            return this.firstName + " " + this.lastName + " is not on leave";
        }
    }

    public void addGradeMidterm(double grade, int studentID, int id) {
        // check if you teach a class with this id
        if (midTermGrade.containsKey(id)) {
            // if you have a class with this id put grade into unique student spot
            midTermGrade.get(id).put(studentID, grade);
            System.out.println("Added grade " + grade + " to student " + studentID);
        }
        // if you dont teach a class with this id do nothing
        else System.out.println("You dont teach a class with ID" + id);

    }

    public void addGradeFinal(double grade, int studentID, int id) {
        //check if prof on leave
        if (finalGrade.containsKey(id)) {
            // if you have a class with this id put grade into unique student spot
            finalGrade.get(id).put(studentID, grade);
            System.out.println("Added grade " + grade + " to student " + studentID);
        }
        // if you dont teach a class with this id do nothing
        else System.out.println("You dont teach a class with ID" + id);
    }

    public void rateProf(int rating) {
        // if you give a prof a rating not between 0 and 10 dont  store anything
        if (rating < 0 || rating > 10) {
            System.out.println("Rating must be between 0 and 10");
            return;
        }
        // if your rating is between 0 and 10, add rating to rate my prof score
        ratemyProfScore.add(rating);
    }

    public double getProfScore() {
        // first need to chekc if empty, if it is give it a return that would never happen
        if (ratemyProfScore.isEmpty()) {
            System.out.println("No ratings yet for " + getProfessorName());
            return -1;
        }
        // go through rae my prof score list adding to sumscore
        int sumScore = 0;
        for (int score : ratemyProfScore) {
            sumScore += score;
        }
        // take sumscore and the size of rate my prof score to get mean rating
        return (double) sumScore / ratemyProfScore.size();
    }

    public void requestCourse(String courseName, int time) {
        // make it so prof can request to teach a certain course
        String request = getProfessorName() + " has requested to teach "
                + courseName + " at " + time;
        classRequests.add(request);

    }

    public void overrideWaitlist(int id, Student student) {
        // check to see if prof teaches course then if student is already in course
        for (Course course : courses) {
            if (course.getId() == id) {
                if (course.getStudents().contains(student)) {
                    System.out.println("Student " + student.studentID + " is already enrolled.");
                    return;
                }
                // if not in class add student to class.
                course.getStudents().add(student);
                System.out.println("Student " + student.studentID + " has been added to " + course.getName());
                return;
            }
        }
        // prof shouldn't be able to add to class they dont teach.
        System.out.println("You don't teach a course with ID " + id);
    }

    public void applyDepHead() {
        // must be tenure to apply
        if (!tenured) {
            System.out.println("Only tenured professors can apply for department head.");
            return;
        }
        // shouldn't be able to apply more than once
        if (hasAppliedDepHead) {
            System.out.println(getProfessorName() + " has already applied for department head.");
            return;
        }
        //set has applied equal to true and report
        hasAppliedDepHead = true;
        System.out.println(getProfessorName() + " has applied for department head.");
    }
}



