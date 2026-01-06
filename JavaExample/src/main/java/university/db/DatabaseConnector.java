package university.db;

import java.sql.*;
import university.Course;
import university.Professor;
import university.Student;

public class DatabaseConnector {

    private final String url;
    private final String user;
    private final String password;

    public DatabaseConnector(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // ---------- Course ----------
    public Course insertCourse(Course course) throws Exception {
        // Tabelle und Spalten gemäß uni-schema.sql (Schema uni, Tabelle course, Spalte forDegree)
        String sql = "INSERT INTO uni.course(name, description, forDegree) VALUES(?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, course.getName());
            ps.setString(2, course.getDescription());
            ps.setString(3, course.getForDegree());
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new Exception("Inserting course failed, no rows affected.");
            }
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int newId = keys.getInt(1);
                    Course inserted = getCourseById(newId);
                    if (inserted == null) throw new Exception("Inserted course not found after insert.");
                    return inserted;
                } else {
                    throw new Exception("Inserting course failed, no ID obtained.");
                }
            }
        }
    }

    public Course updateCourse(Course course) throws Exception {
        String sql = "UPDATE uni.course SET name = ?, description = ?, forDegree = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course.getName());
            ps.setString(2, course.getDescription());
            ps.setString(3, course.getForDegree());
            ps.setInt(4, course.getId());
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new Exception("Updating course failed, no rows affected.");
            }
            Course updated = getCourseById(course.getId());
            if (updated == null) throw new Exception("Updated course not found after update.");
            return updated;
        }
    }

    private Course getCourseById(int id) throws SQLException {
        String sql = "SELECT id, name, description, forDegree FROM uni.course WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("forDegree")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    // ---------- Professor ----------
    public Professor insertProfessor(Professor professor) throws Exception {
        // Tabelle uni.professor, Spalten firstName, lastName, officeNumber
        String sql = "INSERT INTO uni.professor(firstName, lastName, officeNumber) VALUES(?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, professor.getFirstName());
            ps.setString(2, professor.getLastName());
            ps.setString(3, professor.getOfficeNumber());
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new Exception("Inserting professor failed, no rows affected.");
            }
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int newId = keys.getInt(1);
                    Professor inserted = getProfessorById(newId);
                    if (inserted == null) throw new Exception("Inserted professor not found after insert.");
                    return inserted;
                } else {
                    throw new Exception("Inserting professor failed, no ID obtained.");
                }
            }
        }
    }

    public Professor updateProfessor(Professor professor) throws Exception {
        String sql = "UPDATE uni.professor SET firstName = ?, lastName = ?, officeNumber = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, professor.getFirstName());
            ps.setString(2, professor.getLastName());
            ps.setString(3, professor.getOfficeNumber());
            ps.setInt(4, professor.getId());
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new Exception("Updating professor failed, no rows affected.");
            }
            Professor updated = getProfessorById(professor.getId());
            if (updated == null) throw new Exception("Updated professor not found after update.");
            return updated;
        }
    }

    private Professor getProfessorById(int id) throws SQLException {
        String sql = "SELECT id, firstName, lastName, officeNumber FROM uni.professor WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Professor(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("officeNumber")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    // ---------- Student ----------
    public Student insertStudent(Student student) throws Exception {
        // Tabelle uni.student, Spalten firstName, lastName, age
        String sql = "INSERT INTO uni.student(firstName, lastName, age) VALUES(?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setInt(3, student.getAge());
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new Exception("Inserting student failed, no rows affected.");
            }
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int newId = keys.getInt(1);
                    Student inserted = getStudentById(newId);
                    if (inserted == null) throw new Exception("Inserted student not found after insert.");
                    return inserted;
                } else {
                    throw new Exception("Inserting student failed, no ID obtained.");
                }
            }
        }
    }

    public Student updateStudent(Student student) throws Exception {
        String sql = "UPDATE uni.student SET firstName = ?, lastName = ?, age = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setInt(3, student.getAge());
            ps.setInt(4, student.getId());
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new Exception("Updating student failed, no rows affected.");
            }
            Student updated = getStudentById(student.getId());
            if (updated == null) throw new Exception("Updated student not found after update.");
            return updated;
        }
    }

    private Student getStudentById(int id) throws SQLException {
        String sql = "SELECT id, firstName, lastName, age FROM uni.student WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("age")
                    );
                } else {
                    return null;
                }
            }
        }
    }

}
