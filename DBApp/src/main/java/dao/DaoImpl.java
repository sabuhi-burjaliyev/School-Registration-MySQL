/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Student;
import content.Content;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import util.InputUtil;

/**
 *
 * @author Plague
 *
 * DatabaseName -- school TableName -- students
 */
public class DaoImpl extends Connect implements DaoInter {

    private String databaseType;
    private String databaseName;
    private String username;
    private String password;
    private Content content;
    Connection c;

    public DaoImpl(String databaseType, String databaseName, String username, String password) throws Exception {
        this.databaseType = databaseType;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        this.c = connect(databaseType, databaseName, username, password);
        this.content = new Content(databaseType, databaseName, username, password);
        content.initializeStudents();
    }

    @Override
    public boolean regist() throws Exception {

        int id = InputUtil.getNumber("Enter student's id :  ");
        String name = InputUtil.getText("Enter student's name :  ");
        String surname = InputUtil.getText("Enter student's surname :  ");
        String email = InputUtil.getText("Enter student's email :  ");
        String phone = InputUtil.getText("Enter student's phone :  ");

        content.students.add(new Student(id, name, surname, email, phone));
        PreparedStatement stmt = c.prepareStatement("insert into students  values(" + id + ",?,?,?,?)");
        stmt.setString(1, name);
        stmt.setString(2, surname);
        stmt.setString(3, email);
        stmt.setString(4, phone);
        stmt.execute();
        return true;

    }

    @Override
    public boolean update() throws Exception {
        Connection c = connect(databaseType, databaseName, username, password);
        List<Student> students = content.getStudents();
        for (Student s : students) {
            System.out.println(s.getId() + ". " + s.getName() + " " + s.getSurname() + " " + s.getEmail() + " " + s.getPhone());
        }
        int choice = InputUtil.getNumber("Enter id of student you want to update :");
        String updatedParameter = InputUtil.getText("Enter parameter you want to update (id,name,surname,phone,email):");
        if (updatedParameter.equalsIgnoreCase("id")) {
            int newId = InputUtil.getNumber("Enter new id :");
            PreparedStatement stmt = c.prepareStatement("update students set id=" + newId + " where id=" + choice);
            stmt.execute();
            content.getStudent(choice).setId(newId);
        } else if (updatedParameter.equalsIgnoreCase("name")) {
            String newName = InputUtil.getText("Enter new name :");
            PreparedStatement stmt = c.prepareStatement("update students set name=? where id=" + choice);
            stmt.setString(1, newName);
            stmt.execute();
            content.getStudent(choice).setName(newName);
        } else if (updatedParameter.equalsIgnoreCase("surname")) {
            String newSurname = InputUtil.getText("Enter new surname :");
            PreparedStatement stmt = c.prepareStatement("update students set surname=? where id=" + choice);
            stmt.setString(1, newSurname);
            stmt.execute();
            content.getStudent(choice).setSurname(newSurname);
        } else if (updatedParameter.equalsIgnoreCase("email")) {
            String newEmail = InputUtil.getText("Enter new email :");
            PreparedStatement stmt = c.prepareStatement("update students set email=? where id=" + choice);
            stmt.setString(1, newEmail);
            stmt.execute();
            content.getStudent(choice).setEmail(newEmail);
        } else if (updatedParameter.equalsIgnoreCase("phone")) {
            String newPhone = InputUtil.getText("Enter new phone number :");
            PreparedStatement stmt = c.prepareStatement("update students set phone=? where id=" + choice);
            stmt.setString(1, newPhone);
            stmt.execute();
            content.getStudent(choice).setPhone(newPhone);
        } else {
            System.out.println("Please write a valid parameter");
            return false;
        }
        return true;
    }

    @Override
    public boolean remove() throws Exception {
        List<Student> students = content.getStudents();
        for (Student s : students) {
            System.out.println(s.getId() + ". " + s.getName() + " " + s.getSurname() + " " + s.getEmail() + " " + s.getPhone());
        }
        int choice = InputUtil.getNumber("Enter id of student you want to remove :");
        PreparedStatement stmt = c.prepareStatement("delete from students where id=" + choice);
        stmt.execute();
        students.remove(content.getStudent(choice));
        return true;
    }

    @Override
    public void showAllRegisteredStudents() throws SQLException {
        List<Student> students = content.getStudents();
        for (Student s : students) {
            System.out.println(s.getId() + ". " + s.getName() + " " + s.getSurname() + " " + s.getEmail() + " " + s.getPhone());
        }
    }

    @Override
    public void exit() throws SQLException {
        c.close();
        System.exit(0);
    }

}
