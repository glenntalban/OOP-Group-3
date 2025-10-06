package com.pracexec;
import java.util.Scanner;
import java.util.Random;

public class EmployeeOrder {

	public static void main(String[] args) {
		System.out.println("Welcome to DNS Corporation!");
		Scanner emp = new Scanner(System.in);
	    Random random = new Random();
		
		
		int empnum;
		while (true) {
			System.out.println("Enter the number of employees: ");
			if (emp.hasNextInt() && (empnum = emp.nextInt()) > 0) break;
			else {
				System.out.println("Invalid input. Please enter a valid number.");
				emp.next();s
			}
		}
		
		// this part saves the data
		String[] name = new String[empnum];
		int[] userID = new int[empnum];
		String[] destination = new String[empnum];
		int[] order_num = new int[empnum];
		
		for(int num = 1; num <= empnum; ++num) { // loop for entering details
			// Employee details
			System.out.println("Entering details for employee " + num);
			
			System.out.print("Enter employee name: ");
			name[num-1] = emp.next();
			
			int id = checkID(emp, userID, num -1);
			userID[num -1] = id;
			
			System.out.println("Enter travel order destination: ");
			destination[num-1] = emp.next();
			
			// TRAVEL ORDER
			order_num[num-1] = orderID(random);
			
			//TRAVEL DATE
			System.out.println("Enter travel date (MM/DD/YYYY): ");
			String travelDate = emp.next();
			
			//RETURN DATE
			System.out.println("Enter return date (MM/DD/YYYY): ");
			String returnDate = emp.next();
			
			
			//EMPLOYEE PASS
			String newcode = String.format("%05d", num);
			String passnum = "EP" + newcode;
			
			// EMPLOYEE PASS OUTPUT
			System.out.println();
			System.out.println("Employee Details: ");
			System.out.println("Name: " + name[num-1]);
			System.out.println("ID: " + userID[num-1]);			
			System.out.println("Employment Pass: " + passnum);
			
			//EMPLOYEE ORDER OUTPUT
			System.out.println("");	
			System.out.println("Travel Order Details: ");
			System.out.println("Travel Date: " + travelDate + " Return Date: " + returnDate);
			System.out.println("Destination: " + destination[num-1]);
			System.out.println("Order Number: " + order_num[num-1]);
			System.out.println("Employee: " + name[num-1]);
			System.out.println();
		}
		System.out.println("Employee Order Successful");
		}
	//METHOD FOR CHECKING ID DUPLICATE PO HAHAHA
	    private static int checkID(Scanner emp, int[] userID, int count) {
	        while (true) {
	            System.out.print("Enter employee ID: ");
           	 			int userInf = emp.nextInt();
           	 			if (userInf > 9999 && userInf < 99999) {
		                boolean duplicate = false;
		                for (int i = 0; i < count; i++) {
		                    if (userID[i] == userInf) {
		                        duplicate = true;
		                        break;
		                    }
		                }
		                if (!duplicate) {
		                    return userInf; // valid, return it
		                } else {
		                    System.out.println("ID already used or invalid. Try another.");
		                }
		            } else {
		                System.out.println("Invalid. Input valid ID.");
		                emp.next(); // clear invalid input
		                 
		   	        }    
	            }
	        }
      private static int orderID(Random random) {
          int min = 1000;
          int max = 10000; 
          int randomNumber = random.nextInt(max - min) + min;
		  return randomNumber; 
    		  	}
      }
        	
