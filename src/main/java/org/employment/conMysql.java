package org.employment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conMysql {
    // Konfigurasi koneksi
    private static final String DB_URL = "jdbc:mysql://localhost:3306/perusahaan";
    private static final String USER = "root";
    private static final String PASS = "901n6@Allah";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Mencoba membuat koneksi
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn != null) {
                System.out.println("Koneksi berhasil!");
            }
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        } finally {
            // Menutup koneksi
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}


