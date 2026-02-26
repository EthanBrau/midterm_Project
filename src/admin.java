public class Admin {
    // Attributes
    private int adminId;
    private String firstName;
    private String lastName;



    //Constructor
    public Admin(int adminId, String firstName, String lastName) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // Methods
    public void addStudent(int id, String course) {
        // add a student using their "id" to a "course" list or database
        System.out.println("Adding this student " + id + "to course " + course);
    }

    public void removeStudent(int id, String course) {
        // remove a student using their "id" from a "course" list or database 
        System.out.println("Removing this student " = id = "from course " + course);
    }

    public void addClass(int id, String time, String desc) {
        // be able to create a new class entry into the class list or database
        System.out.println("Add class: " + desc + " at " + time);
    }

    public void removeClass(int id, String time) {
        // be able to delete a class from the class database
        System.out.println("Remove class ID: " + id)
    }

    public void changeRequirement(int id, String value) {
        // update major or graduation requirements
        System.out.println("Changing requirement for ID " + id + " to " + value)
    }

    public void reviewProfessor(int id) {
        // be able to pull up Professor details and evaluations 
        System.out.println("Reviewing Professor with ID: " + id);
    }

    // getters and setters
    public int getAdminId() {return AdminId; }
    public String getFullName() {return firstName + " " + lastName; }
}