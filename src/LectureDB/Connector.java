/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectureDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Danny
 */
public class Connector {
    public Connection link() {
        String Url ="jdbc:mysql://localhost:3306/axample_mask";
        String Name="root";
        String Password="12345";
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер подключен");
            cn = DriverManager.getConnection(Url, Name, Password);
            System.out.println("Соединение установлено");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return cn;
    }
}
