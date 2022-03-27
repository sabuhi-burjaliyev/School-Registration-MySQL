/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Plague
 */
public class DaoFactory {

    public static DaoImpl generate(String databaseType, String databaseName, String username, String password) throws Exception {
        return new DaoImpl(databaseType, databaseName, username, password);
    }
}
