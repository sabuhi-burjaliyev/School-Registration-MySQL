/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Student;

/**
 *
 * @author Plague
 */
public interface DaoInter {
    public boolean regist() throws Exception;
    public boolean update() throws Exception;
    public boolean remove()throws Exception;
    public void showAllRegisteredStudents() throws Exception; 
    public void exit() throws Exception;
}
