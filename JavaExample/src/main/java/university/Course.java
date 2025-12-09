package university;

public class Course {
    String name;
    String description;
    Degree forDegree;

    public Course(String name, String description, Degree forDegree) {
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
