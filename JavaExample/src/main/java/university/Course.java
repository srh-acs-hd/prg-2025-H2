package university;

public class Course {
    public static int courseCount = 0;

    public Course() {
        courseCount += 1;
    }

    public static int getCourseCount() {
        return courseCount;
    }

    public static void main(String[] args) {
        // runs the program
    }

    String name;
    String description;
    Degree forDegree;



    public Course(String name, String description, Degree forDegree) {
        this();
        this.name = name;
        this.description = description;
        this.forDegree = forDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Degree getForDegree() {
        return forDegree;
    }

    public void setForDegree(Degree forDegree) {
        this.forDegree = forDegree;
    }
}
