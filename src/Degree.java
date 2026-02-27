public class Degree {
    private boolean requiredToGrad;
    private String name;
    private int degreeId;
    private boolean isMajor;
    private boolean isMinor;
    private Course[] requiredClasses;

    public Degree(boolean requiredToGrad, String name, int degreeId, boolean isMajor, boolean isMinor, Course[] requiredClasses) {
        this.requiredToGrad = requiredToGrad;
        this.name = name;
        this.degreeId = degreeId;
        this.isMajor = isMajor;
        this.isMinor = isMinor;
        this.requiredClasses = requiredClasses;
    }

    public boolean isRequiredToGrad() {
        return requiredToGrad;
    }

    public void setRequiredToGrad(boolean requiredToGrad) {
        this.requiredToGrad = requiredToGrad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public boolean isMajor() {
        return isMajor;
    }

    public void setMajor(boolean major) {
        isMajor = major;
    }

    public boolean isMinor() {
        return isMinor;
    }

    public void setMinor(boolean minor) {
        isMinor = minor;
    }

    public Course[] getRequiredClasses() {
        return requiredClasses;
    }

    public void setRequiredClasses(Course[] requiredClasses) {
        this.requiredClasses = requiredClasses;
    }
}