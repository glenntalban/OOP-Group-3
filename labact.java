package com.pracexec;
import java.util.Scanner;
import java.util.Random;

public class EmployeeOrder {

    public static void main(String[] args) {
        System.out.println("Welcome to DNS Corporation!");
        Scanner emp = new Scanner(System.in);
        Random random = new Random();

        int empnum = getEmployeeCount(emp);
        
        String[] name = new String[empnum];
        int[] userID = new int[empnum];
        String[] destination = new String[empnum];
        int[] order_num = new int[empnum];

        for (int num = 1; num <= empnum; ++num) {
            System.out.println("Entering details for employee " + num);
            
            name[num - 1] = getEmployeeName(emp);
            userID[num - 1] = getEmployeeID(emp, userID, num - 1);
            destination[num - 1] = getDestination(emp);
            order_num[num - 1] = generateOrderID(random);

            String passnum = generatePassNumber(num);

            displayEmployeeInfo(name[num - 1], userID[num - 1], passnum);
            displayTravelOrderInfo(destination[num - 1], order_num[num - 1], name[num - 1]);
        }

        System.out.println("Employee Order Successful");
    }

    // ✅ Modular Functions

    public static int getEmployeeCount(Scanner emp) {
        int empnum;
        while (true) {
            System.out.println("Enter the number of employees: ");
            if (emp.hasNextInt() && (empnum = emp.nextInt()) > 0) return empnum;
            else {
                System.out.println("Invalid input. Please enter a valid number.");
                emp.next(); // clear invalid input
            }
        }
    }

    public static String getEmployeeName(Scanner emp) {
        System.out.print("Enter employee name: ");
        return emp.next();
    }

    public static int getEmployeeID(Scanner emp, int[] userID, int count) {
        while (true) {
            System.out.print("Enter employee ID (5-digit number): ");
            if (!emp.hasNextInt()) {
                System.out.println("Invalid input. Must be a number.");
                emp.next(); // clear bad input
                continue;
            }

            int userInf = emp.nextInt();

            if (userInf < 10000 || userInf > 99999) {
                System.out.println("Invalid ID. Must be a 5-digit number.");
                continue;
            }

            // Check for duplicates
            boolean duplicate = false;
            for (int i = 0; i < count; i++) {
                if (userID[i] == userInf) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                System.out.println("ID already used. Please enter a different ID.");
            } else {
                return userInf;
            }
        }
    }

    public static String getDestination(Scanner emp) {
        System.out.println("Enter travel order destination: ");
        return emp.next();
    }

    public static int generateOrderID(Random random) {
        int min = 1000;
        int max = 10000;
        return random.nextInt(max - min) + min;
    }

    public static String generatePassNumber(int empIndex) {
        String newcode = String.format("%05d", empIndex);
        return "EP" + newcode;
    }

    public static void displayEmployeeInfo(String name, int id, String passnum) {
        System.out.println();
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Employment Pass: " + passnum);
    }

    public static void displayTravelOrderInfo(String destination, int orderNum, String empName) {
        System.out.println();
        System.out.println("Travel Order Details:");
        System.out.println("Destination: " + destination);
        System.out.println("Order Number: " + orderNum);
        System.out.println("Employee: " + empName);
        System.out.println();
    }
}
