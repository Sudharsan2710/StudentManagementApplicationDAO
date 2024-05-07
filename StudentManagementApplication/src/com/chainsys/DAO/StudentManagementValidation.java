package com.chainsys.DAO;
import java.util.Scanner;
public class StudentManagementValidation {

	static	 Scanner sc = new Scanner(System.in);

		public static String checkusername(String Username) {
			 
			try {
			while (true) {
			
				String userName = Username;

				 if (userName.matches("[a-zA-Z]+")) {
					break;
				} else 
				{
					System.out.println("Please enter a valid name with only characters.");
					
					userName = sc.next();
				}
				
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return Username;
		}
		

		public static String checkname(String Name) {
			try {
			while (true) {
				
				String Name1 = Name;
				if (Name1.matches("[a-zA-Z]+")) {
					break;
				} else {
					System.out.println("Please enter a valid name with only characters.");
					Name = sc.next();
				}
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return Name;
}

		public static String checkpassword(String Password) {
			try { 
			while (true) {
		 
		           if(Password.matches("^[A-Z][a-z]{4,}[0-9]{2,}[!@#$%^&*]")) {
		        	   break;
		           }
		           System.out.println("Please enter a password Starting with one UpperCase characters, OneLowerCase, uppercase, a number, and a special character:");
		           Password = sc.next();
		            
		       }
			 
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
			return Password;
		}
		
		public static int validid(int id) {
			try {
				while(true) {
					
					if(id>3000&&id<=4000) {
						break;
					
					}
					else {
						System.out.print("Enter the correct Roll Number from 3000 to 4000");
						id = sc.nextInt();
						}
				}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return id;
		}
		
		public static double validpercencentage(double percentage) {
			try {
			while(true) {
				if(percentage>0 && percentage<=100) {
					return percentage;
				}
				else {
					System.out.print("Enter the correct Percentage: ");
					percentage=sc.nextDouble();
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return percentage;
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
		public static String validusername1(String username1) {
			 String usernamePattern = "^(?=.*[A-Z])(?=.*[^A-Za-z0-9]).{2,}$";

		        

		        while (!username1.matches(usernamePattern)) {
		            System.out.println("Username should contain at least one uppercase letter and one special character.");
		            System.out.println("Enter the New Username: ");
		            username1 = sc.next();
		           
		        }
		        return username1;
		}
		public static String validpassword(String password) {
			String passwordPattern = "^(?=.*[A-Z])(?=.*[^A-Za-z0-9]).{8,}$";
			 while (!password.matches(passwordPattern)) {
		            System.out.println("Password should contain at least one uppercase letter, one special character, and be at least 8 characters long.");
		            System.out.println("Enter the password: ");
		            password = sc.next();
		        }
			return password;
		}
		
	}

