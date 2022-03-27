/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Plague
 */
public abstract class Connect {

    public Connection connect(String databaseType, String databaseName, String username, String password) throws Exception {
        String url = "jdbc:" + databaseType + "://localhost:3306/" + databaseName;
        Connection c = (Connection) DriverManager.getConnection(url, username, password);
        return c;
    }
}
