package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
	// write your code here
        System.out.println("Please select item of the SQL menu:" +
                "\n(1) show all records " +
                "\n(2) insert record" +
                "\n(3) update record" +
                "\n(4) remove record" +
                "\n(5) free-style query" +
                "\n(6) exit");

        int x = scanner.nextInt();
        EmployeeDAO empDAO = new EmployeeDAO( );

        switch(x) {
            case 1:
                empDAO.selectAll();
                break;
            case 2:
                empDAO.insert();
                break;
            case 3:
                empDAO.update();
                break;
            case 4:
                empDAO.remove();
                break;
            case 5:
                int fsq = random.nextInt(4);
                switch(fsq) {
                    case 0:
                        empDAO.selectAll();
                        break;
                    case 1:
                        empDAO.insert();
                        break;
                    case 2:
                        empDAO.update();
                        break;
                    case 3:
                        empDAO.remove();
                        break;
                }
                break;
            case 6:
                System.out.print("Coming soon");
                break;
            default:
                System.out.println("Error");
        }

    }
}
