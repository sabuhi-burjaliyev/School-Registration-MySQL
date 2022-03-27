/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package content;

import bean.Student;
import dao.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Plague
 */
public class Content extends Connect {

    private String databaseType;
    private String databaseName;
    private String username;
    private String password;
    Connection c;
    public List<Student> students = new ArrayList<>();

    public void initializeStudents() throws SQLException {
        Statement stmt = c.createStatement();
        stmt.execute("select * from students");
        ResultSet rs = stmt.getResultSet();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            students = new ArrayList<>();
            students.add(new Student(id, name, surname, email, phone));
        }
    }

    public Content(String databaseType, String databaseName, String username, String password) throws Exception {
        this.databaseType = databaseType;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        this.c = connect(databaseType, databaseName, username, password);
    }

    public List<Student> getStudents() throws SQLException {
        return students;
    }

    public Student getStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
