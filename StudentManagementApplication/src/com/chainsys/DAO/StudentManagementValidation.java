package com.chainsys.DAO;
import java.util.Scanner;
public class StudentManagementValidation {

	static	 Scanner sc = new Scanner(System.in);

		public static String checkusername(String Username) {

			while (true) {
				String userName = Username;

				if (userName.matches("[a-zA-Z]+")) {
					break;
				} else {
				
					System.out.println("Please enter a valid name with only characters.");
					
					userName = sc.next();
				}

			}
			return Username;
		}

		public static String checkname(String Name) {

			while (true) {

				String Name1 = Name;
				if (Name1.matches("[a-zA-Z]+")) {
					break;
				} else {
					System.out.println("Please enter a valid name with only characters.");
					Name = sc.next();
				}
			}
			return Name;
		}

		public static String checkpassword(String Password) {
			 while (true) {
		 
		           if(Password.matches("^[A-Z][a-z]{4,}[0-9]{2,}[!@#$%^&*]")) {
		        	   return Password;
		           }
		           System.out.println("Please enter a password Starting with one UpperCase characters, OneLowerCase, uppercase, a number, and a special character:");
		           Password = sc.next();
		            
		       }
			 
		   }
		
		public static int validid(int id) {
				while(true) {
					
					if(id>3000&&id<=4000) {
						return id;
					
					}
					else {
						System.out.print("Enter the correct Roll Number from 3000 to 4000");
						id = sc.nextInt();
						}
				}
		}
		
		public static double validpercencentage(double percentage) {
			while(true) {
				if(percentage>0 && percentage<=100) {
					return percentage;
				}
				else {
					System.out.print("Enter the correct Percentage: ");
					percentage=sc.nextDouble();
				}
			}
			
		}
		public static String validdepartment(String department) {
				
			while(true) {
				if(department.equalsIgnoreCase("ECE")||department.equalsIgnoreCase("MECH")||department.equalsIgnoreCase("CIVIL")||department.equalsIgnoreCase("CSE")||department.equalsIgnoreCase("EEE")||department.equalsIgnoreCase("AI")) {
				return department;
			}	
				
				else
				
					System.out.println("Enter the correct department with the uppercaseWord: ");
					department=sc.next();
					
				
			}
			
			
		}
		
	}

