package university;

import java.util.ArrayList;

public class UniversityApplication {


    public static void main(String[] args) {
        Student student = new Student("John", "Doe", 20);
        student.enrollCourse(new Course("Mathematics", "Basic Math Course", new Degree("Master")));
        student.enrollCourse(new Course("Computer Science", "Advance Computer Science", new Degree("Master")));
        student.printInformation();
    }

    public static void createPersons() {
        Person john = new Person();
        john.setFirstName("John");
        john.setLastName("Doe");
        Person jane = new Person("Jane", "Smith");
        System.out.println(john.getLastName());
        System.out.println(jane.getLastName());
    }

    public static ArrayList<Degree> getDegrees() {
        ArrayList<Degree> degrees = new ArrayList<>();
        degrees.add(new Degree("Bachelor"));
        degrees.add(new Degree("Master"));
        degrees.add(new Degree("PhD"));
        return degrees;
    }

    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Mathematics", "Basic Math Course", new Degree("Bachelor")));
        courses.add(new Course("Computer Science", "Intro to Computer Science", new Degree("Bachelor")));
        courses.add(new Course("Physics", "Fundamentals of Physics", new Degree("Bachelor")));
        courses.add(new Course("Chemistry", "General Chemistry", new Degree("Bachelor")));
        courses.add(new Course("Data Structures", "In-depth study of data structures", new Degree("Master")));
        courses.add(new Course("Algorithms", "Algorithm design and analysis", new Degree("Master")));
        courses.add(new Course("Philosophy", "Introduction to Philosophy", new Degree("Bachelor")));
        return courses;
    }

    public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Smith", 22));

        students.add(new Student("Bob", "Johnson", 24));
        return students;
    }
}
