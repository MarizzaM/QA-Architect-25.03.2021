package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CalculatorDAO {
    static final String DB_URL = "jdbc:sqlite:C:/Marisha/SQLite/lesson2/1.db";
    public static int select(String s) {

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = String.format("SELECT %s FROM CALCDATA", s);

                Statement stmt = conn.createStatement();
                stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
