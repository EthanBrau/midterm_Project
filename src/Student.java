import java.util.*;




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
    ArrayList<Course> schedule;
    ArrayList<Integer> allCompletedClasses;
    ArrayList<String> graduationRequirements;
    int graduationCreditRequirements;
    Boolean canGraduate;
    Boolean isGraduated;
    Boolean enrollmentStatus;// will be true if fulltime student, false if parttime
    Boolean onCampus;
    int advisor;

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
        advisor = 0;

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

    Integer getGradYear(){
        return this.gradYear;
    }

    Integer getCurrentCredits(){
        return this.currentCredits;
    }

    List<Course> getSchedule(){
        return this.schedule;
    }

    List<String> getGraduationRequirements(){
        return this.graduationRequirements;
    }

    List<Integer> getCompletedClasses(){
        return this.allCompletedClasses;
    }

    Boolean getEnrollmentStatus(){
        return this.enrollmentStatus;
    }

    Integer getMyAdvisor(){
        return this.advisor;
    }

    Boolean getOncampusStatus(){
        return this.onCampus;
    }

    String getFirstName(){
        return this.firstName;
    }

    void setFirstName(String FirstName){
        this.firstName = FirstName;
    }

    String getLastName(){
        return this.lastName;
    }

    String setLastName(String LastName){
        return this.lastName = LastName;
    }

    Integer getStudentIDNumber(){
        return this.studentID;
    }

    List<Integer> getMyMajor(){
        return this.major;
    }

    List<Integer> getMyMinor(){
        return this.minor;
    }

    int getGraduationCreditsRemaining(){
        return graduationCreditRequirements;
    }

    Boolean getIsGraduatedStatus(){
        return this.isGraduated;
    }

    /*
    Updates the rate my professor score in the professor class. this is based off of the inputted
    professor object and the rating you want to give them
     */
    void rateProfessor(int rating, Professor professor){
        professor.rateProf(rating);
    }

    /*
    this will add an advisor to your advisor list.
     */
    void addAdvisor(int ProfessorID){
        this.advisor = ProfessorID;
        //needs to send to professor to add you as an advisee?
    }

    /*
    adds a course (based off the course id to find the course object) to your
    arrayList schedule. it also updates the current credits you have for the semester.
     */
    void addCourseToSchedule(Course course){
        schedule.addLast(course);
        currentCredits = currentCredits + course.getCredits();
    }

    /*
    removes the course if you have it from your schedule based off the courseID inputted.
    it also updates the current Credits, and it will print out a string to tell you if you
    do not have the course in your schedule.
     */
    void removeCourseFromSchedule(Course course){
        if (schedule.contains(course)){
            schedule.remove(course);
            currentCredits = currentCredits - course.getCredits();
        } else{
            System.out.println("The course you are trying to remove is not in your schedule");
        }
    }

    /*
    sends a request to the department through the departmentID and the MajorID
    to add the major to your major ArrayList

    Request spots for these functions requestMajor and requestMinor
    never got added to department so i can really use these functions,
    but i think they would be useful ones to have in the registration system

     */
//    private void requestMajor(int DepartmentID, Degree degree, int MajorID){
//        Collection<?> req = List.of(degree.getRequiredClasses());
//        if (allCompletedClasses.containsAll(req)){
//            Department.DepartmentID.applyForMajor(MajorID);
//            System.out.println("You have sucessfully requested a major");
//        } else{
//            System.out.println("You have not completed the required classes for this major");
//        }
//    }
    /*
    sends a request to the department through the departmentID and minorID to add the minor
    to your minor ArrayList
     */
//    private void requestMinor(int DepartmentID,Degree degree, int MinorID){
//        Collection<Course> req = List.of(degree.getRequiredClasses());
//        if (allCompletedClasses.containsAll(req)){
//            System.out.println("You have sucessfully requested a minor");
//            Department.DepartmentID.applyForMajor(MinorID);
//        } else{
//            System.out.println("You have not completed the required classes for this minor");
//        }
//    }

    
    /*
    this is  function a student can call to check and see if they can graduate.
    it will first check and see if the canGraduate variable is true, otherwise it looks
    at the graduation requirements, credits and if you have a major. if you have all these
    things it will update the variable canGraduate and gives you a nice string.
    if you aren't eligible to graduate it will give you a string saying you cannot graduate
     */
    void canIGraduate(){
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
    void graduate(){
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
    void changeEnrollmentStatus(){
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
    void changeOnCampusStatus(){
        if (onCampus = true){
            onCampus = false;
        }else{
            onCampus = true;
        }
    }


    public static void main(String[] args){
    }

}
