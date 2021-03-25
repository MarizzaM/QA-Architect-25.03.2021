package com.app;

import java.sql.*;

public class Main {

    static final String DB_URL = "jdbc:sqlite:C:/Marisha/SQLite/lesson2/1.db";

public static void createNewDatabase() {

    try (Connection conn = DriverManager.getConnection(DB_URL)) {
        if (conn != null) {
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("A new database has been created.");
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
    public static void selectAll() {


        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = "SELECT * FROM EMPLOYEES";


                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getDouble("salary"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insert() {


        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = "INSERT INTO EMPLOYEES (NAME,AGE,ADDRESS,SALARY)\n" +
                        "VALUES ( 'Mary', 18, 'Houston', 50000.00 );";
                
                Statement stmt = conn.createStatement();
                stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update() {


        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = "UPDATE EMPLOYEES SET NAME = 'Marisha WHERE ID = 8";

                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete() {

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = "DELETE FROM EMPLOYEES WHERE ID = 9";


                Statement stmt = conn.createStatement();
                stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        insert();
        update();
        delete();
        selectAll();

    }
}
