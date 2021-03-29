package com.company;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDAO {

    static Scanner scanner = new Scanner(System.in);
    static final String DB_URL = "jdbc:sqlite:C:/SQLite/Employees.db";

    public void selectAll() {

        System.out.println("======== show all records =========");
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = "SELECT * FROM EMPLOYEES";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getInt("age") + "\t" +
                            rs.getString("address") + "\t" +
                            rs.getDouble("salary")
                    );
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String selectLastRow(String s) {

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = String.format("SELECT %s FROM EMPLOYEES WHERE   ID = (SELECT MAX(ID)  FROM EMPLOYEES)", s);

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                return rs.getString(s);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insertTest(String name, int age, String address, double salary) {

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {

                String sql = String.format("INSERT INTO EMPLOYEES (NAME,AGE,ADDRESS,SALARY)\n" +
                        "VALUES ( '%s', %d, '%s', %f )", name, age, address, salary);
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(sql);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert() {

        System.out.println("======== insert record =========");

        System.out.print("Please enter name: ");
        String name = scanner.next();

        System.out.print("Please enter age: ");
        int age = scanner.nextInt();

        System.out.print("Please enter address:  ");
        String address = scanner.next();

        System.out.print("Please enter salary: ");
        double salary = scanner.nextDouble();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {

                String sql = String.format("INSERT INTO EMPLOYEES (NAME,AGE,ADDRESS,SALARY)\n" +
                        "VALUES ( '%s', %d, '%s', %f )", name, age, address, salary);
                Statement stmt = conn.createStatement();

                int result = stmt.executeUpdate(sql); // not expect result
                System.out.println(result + " record inserted successfully");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update() {

        System.out.println("======== update record =========");

        System.out.print("Please enter id of the record: ");
        int id = scanner.nextInt();

        System.out.print("Please enter new name: ");
        String name = scanner.next();

        System.out.print("Please enter new age: ");
        int age = scanner.nextInt();

        System.out.print("Please enter new address:  ");
        String address = scanner.next();

        System.out.print("Please enter new salary: ");
        double salary = scanner.nextDouble();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {

            if (conn != null) {

                String sql = String.format("UPDATE EMPLOYEES SET NAME = '%S', AGE = %d, ADDRESS = '%s', SALARY = %f " +
                        "WHERE ID = %d", name, age, address, salary, id);

                Statement stmt = conn.createStatement();

                int result = stmt.executeUpdate(sql); // not expect result
                System.out.println(String.format("%d record #%d updated successfully", result, id));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove() {

        System.out.println("======== remove record =========");

        System.out.print("Please enter id of the remove: ");
        int id = scanner.nextInt();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {

            if (conn != null) {

                String sql = String.format("DELETE FROM EMPLOYEES WHERE ID = %d", id);
                Statement stmt = conn.createStatement();

                int result = stmt.executeUpdate(sql); // not expect result
                System.out.println(String.format("%d record #%d removed successfully", result, id));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
