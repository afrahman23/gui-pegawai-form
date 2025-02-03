package org.employment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/employment";
    private static final String USER = "root";
    private static final String PASSWORD = "901n6@Allah";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void addEmployee(Employee employee) throws SQLException {
        String sql;
        if (employee instanceof FullTimeEmployee) {
            sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        } else {
            sql = "INSERT INTO employees (name, department, hourly_rate) VALUES (?, ?, ?)";
        }

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getDepartment());

            if (employee instanceof FullTimeEmployee) {
                pstmt.setDouble(3, ((FullTimeEmployee) employee).getSalary());
            } else {
                pstmt.setDouble(3, ((PartTimeEmployee) employee).getHourlyRate());
            }

            pstmt.executeUpdate();
        }
    }
}