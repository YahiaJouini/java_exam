package org.example.javafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String url = "jdbc:postgresql://localhost:5432/db_examen_java";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Load the driver - make sure the driver class is available
                Class.forName("org.postgresql.Driver");
                System.out.println("PostgreSQL JDBC Driver loaded successfully");

                // Establish connection
                conn = DriverManager.getConnection(url, user, password);
                if (conn != null) {
                    System.out.println("Database connection established successfully");
                }
            } catch (ClassNotFoundException e) {
                System.err.println("PostgreSQL JDBC Driver not found");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Connection to database failed");
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}