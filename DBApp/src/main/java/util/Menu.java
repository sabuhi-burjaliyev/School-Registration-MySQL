/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import dao.DaoInter;

/**
 *
 * @author Plague
 */
public class Menu {

    public static int showAndSelectMenu() {
        System.out.println("1)Regist Student\n2)Update Student\n3)Remove Student\n4)Show all students\n5)Exit system");
        while (true) {
            try {
                int choice = InputUtil.getNumber("Enter your choice :");
                return choice;
            } catch (Exception ex) {
                System.out.println("Please enter a number between 1-5");
                continue;
            }
        }

    }

    public static void menu(DaoInter daointer, int choice) throws Exception{
        if (choice == 1) {
            daointer.regist();
        } else if (choice == 2) {
            daointer.update();
        } else if (choice == 3) {
            daointer.remove();
        } else if (choice == 4) {
            daointer.showAllRegisteredStudents();
        } else if (choice == 5) {
            daointer.exit();
        } else {
            System.out.println("Please enter a valid operation !");
        }
    }
}
