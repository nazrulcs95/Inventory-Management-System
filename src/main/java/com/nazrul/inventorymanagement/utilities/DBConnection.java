/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nazrul.inventorymanagement.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rokon Nazrul
 */
public class DBConnection {

    private static final String DATABASE_URL = "jdbc:sqlite:/C:\\Users\\Rokon Nazrul\\Documents\\NetBeansProjects\\LibraryManagement\\src\\database\\library_management.sqlite3";

    public static Connection connectDB() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}
