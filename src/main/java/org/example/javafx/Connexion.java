package org.example.javafx;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    private static Connection conn;
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_examen_java", "root", "");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }
}