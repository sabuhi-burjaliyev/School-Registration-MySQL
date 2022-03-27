/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import dao.DaoFactory;
import dao.DaoInter;
import util.Menu;

/**
 *
 * @author Plague
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String databaseType = util.InputUtil.getText("Enter database server type :");
        String databaseName = util.InputUtil.getText("Enter database name :");
        String username = util.InputUtil.getText("Enter username :");
        String password = util.InputUtil.getText("Enter password :");
        DaoInter daointer = DaoFactory.generate(databaseType, databaseName, username, password);
        while (true) {
            int choice = Menu.showAndSelectMenu();
            Menu.menu(daointer, choice);
        }

    }
}
