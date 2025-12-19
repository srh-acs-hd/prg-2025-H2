package university;

import university.utils.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapSearch {
    public static final String DATA_PATH = "C:\\srh\\github\\prg-2025-H2\\JavaExample\\src\\main\\java\\university\\data\\";

    public static void main(String[] args) throws IOException {
        System.out.println("HashMap Search Example");
        //ArrayList<Student> studentsAsList = CSVReader.readStudents(DATA_PATH + "students.csv");
        ArrayList<Student> studentsAsList = generateStudents(10000000);

        HashMap<Integer, Student>  studentsAsMap = convertListToHashMap(studentsAsList);
        System.out.println("List loaded: " + studentsAsList.size());
        System.out.println("Map  loaded: " + studentsAsMap.size());
        long lStart = System.currentTimeMillis();
        Student l0 = findStudentById(0, studentsAsList);
        Student l200 = findStudentById(10000000, studentsAsList);
        long lEnd = System.currentTimeMillis();
        long listTime = lEnd - lStart;
        System.out.println("List search time: " + listTime + " ms");
        long mStart = System.currentTimeMillis();


        Student m0 = studentsAsMap.get(0);
        Student m200 = studentsAsMap.get(10000000);
        long mEnd = System.currentTimeMillis();
        long mapTime = mEnd - mStart;
        System.out.println("Map search time: " + mapTime + " ms");
    }

    public static ArrayList<Student> generateStudents(int count) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            students.add(new Student(i, "Firstname" +i , "Lastname" +i, 18));
        }
        return students;
    }

    public static HashMap<Integer, Student> convertListToHashMap(ArrayList<Student> students) {
        HashMap<Integer, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student.id, student);
        }
        return studentMap;
    }

    public static Student findStudentById(int id, List<Student> students) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
