package com.app;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    static final String DB_URL = "jdbc:sqlite:C:/Marisha/SQLite/lesson2/1.db";
    public static int select(String s) {

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = String.format("SELECT %s FROM CALCDATA", s);


                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(
                            rs.getString(s));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Test
    public void test_add_small_numbers() {
        // Arrange
        Calculator calculator = new Calculator();
        int a = select("a");
        int b = select("b");
        int c = select("c");

        assertEquals(calculator.add(a, b), c);
    }
}
