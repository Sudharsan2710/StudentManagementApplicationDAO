package com.chainsys.test;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TimeZone;

import com.chainsys.DAO.StudentDao;
import com.chainsys.DAO.StudentDaoInterface;
import com.chainsys.DAO.StudentManagementValidation;
import com.chainsys.model.Student;

public class Client {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		StudentDaoInterface dao = new StudentDao();
		System.out.println("\t\t Welcome to Student Management application\t\t");
		int rollNum;
		String name;
		String department;
		double percentage;
		String collegeName;
		
		Date thisDate = new Date();
	SimpleDateFormat dateForm= new SimpleDateFormat("yyyy-MM-dd-HH-mm");
	String	localdate = dateForm.format(thisDate);
		

		System.out.println("-----------------------> LOGIN PAGE <------------------------------------------------");

		System.out.print("--> 1. Existing Admin ");
		System.out.print("\t \t--> 2. New Admin ");
		System.out.print("\t \t--> Enter the choice: ");

		boolean isAdminLoggedIn = false;
		HashMap<String, String> adminCredentials = new HashMap<>();
		adminCredentials.put("Sudharsan27", "Sudharsan27102001@");
		adminCredentials.put("Rajaguru13", "Rajaguru27102001@");
		adminCredentials.put("Vasanth21", "Vasanth27102001@");

		String username;
		String password;
		String confirmPassword;

		while (!isAdminLoggedIn) {
			int choice1 = sc.nextInt();
			sc.nextLine();
			switch (choice1) {
			case 1:
				boolean isUsernameCorrect = false;
				while (!isUsernameCorrect) {
					System.out.println("Enter the Username: ");
					username = sc.next();
					if (!adminCredentials.containsKey(username)) {
						System.out.println("Invalid Username. Please enter the correct username.");
					} else {
					
						isUsernameCorrect = true;

						while (!isAdminLoggedIn) {
							System.out.println("Enter the password");
							password = sc.next();
							if (!adminCredentials.get(username).equals(password)) {
								System.out.println("Invalid password. Please enter the correct password.");
							} else {
								System.out.println(dao.admindetails(username,password,localdate));
								isAdminLoggedIn = true;
								System.out.println("Login successful.");
							}
						}
					}
				}

				break;
			case 2:
				boolean isUsernameCorrect1 = false;
				 System.out.println("WELCOME TO SIGN IN PAGE");
				 
				while (!isUsernameCorrect1) {
					System.out.println("Enter the New UserName:");
					username = sc.next();

					if (adminCredentials.containsKey(username)) {
						System.out.println("Already you have an Account");
						System.out.println("Please try to login in Your Existing account");
						
						
						} else {
							
							isUsernameCorrect1 = true;
							
						while (!isAdminLoggedIn) {
								System.out.println("Enter the New password");
								password = sc.next();
								if (username.equals(password)) {
									System.out.println("password must not be same of username,please Re-enter the correct password.");
								}

								else {
									System.out.println("Enter the confirm Password");
									confirmPassword = sc.next();

									if (!password.equals(confirmPassword)) {
										System.out.println("password Mis match enter properly:");
									}

							else {
								dao.admindetails(username,password,localdate);
								adminCredentials.put(username,password);
								isAdminLoggedIn = true;
								System.out.println("Created Succesfully");
								
							}
						}
					}
				}
			} 
				 
			break;	 
			case 3:{
				System.out.println("Enter to Exit: ");
				System.exit(0);
			}
			default:{
				System.out.println("User Entered wrong Choice:");
			}
				
		}
			
			
		

			while (true) {

				System.out.println(
						"\n1.Add Student " + "\n2.Show All Students " + "\n3.Get student based on roll number: "
								+ "\n4.Delete Student " + "\n5.Update Student " + "\n6.Exit ");
				System.out.println("Enter choice");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter student name");
					name = sc.next();
					StudentManagementValidation.checkname(name);
					System.out.println("Enter student clg name");
					collegeName = sc.next();
					StudentManagementValidation.checkname(collegeName);
					System.out.println("Enter department");
					department = sc.next();
					StudentManagementValidation.checkname(department);
					System.out.println("Enter Percentage");
					percentage = sc.nextDouble();
					StudentManagementValidation.validpercencentage(percentage);
					Student st = new Student(name, collegeName, department, percentage);
					boolean ans = dao.insertStudent(st);

					if (ans)
						System.out.println("Record inserted Successfully!!!");
					else
						System.out.println("something went wrong, please try again");

					break;
				case 2:
					System.out.println("Show all students ");
					dao.showAllStudent();

					break;
				case 3:
					System.out.println("Get student based on rollnumber");
					System.out.println("enter roll number");
					int roll = sc.nextInt();

					boolean f = dao.showStudentById(roll);
					if (!f)
						System.out.println("Student with this id is not available in our system");

					break;
				case 4:
					dao.showAllStudent();

					System.out.println("enter the correct Roll Number to Delete");
					rollNum = sc.nextInt();

					boolean ff = dao.delete(rollNum);
					if (ff) {
						System.out.println("Record deleted successfully...");
					} else {
						System.out.println("Enter the Correct rollnumber");
						rollNum = sc.nextInt();
					}

					break;
				case 5:
					System.out.println("Update the student");
					System.out.println("\n1.Update name\n2.Update department \n3.Update percentage");
					System.out.println("enter your choice");

					int choice = sc.nextInt();

					if (choice == 1) {
						System.out.println("enter roll number");
						rollNum = sc.nextInt();

						System.out.println("Enter new name");
						String newName = sc.next();
						dao.updateStudent(choice, rollNum, newName, null, 0);
					}

					else if (choice == 2) {
						System.out.println("enter roll number");
						rollNum = sc.nextInt();
						System.out.println("Enter new department");
						String newDepartment = sc.next();
						dao.updateStudent(choice, rollNum, null, newDepartment, 0);
					}

					else if (choice == 3) {
						System.out.println("enter roll number");
						rollNum = sc.nextInt();

						System.out.println("Enter new percentage");
						double newPercentage = sc.nextDouble();
						dao.updateStudent(choice, rollNum, null, null, newPercentage);
					} else {
						System.out.println("Invalid choice");
					}
					break;

				case 6:
					System.out.println("Thank You for using Student management application!!!");
					System.exit(0);
				default: {
					System.out.println("Please enter valid choice..");
				}
				}
			}

		}
			
			
			
			
		}
}


