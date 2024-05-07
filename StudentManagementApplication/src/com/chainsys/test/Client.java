package com.chainsys.test;
import java.util.Scanner;
import java.util.ArrayList;

import com.chainsys.DAO.StudentDao;
import com.chainsys.DAO.StudentDaoInterface;
import com.chainsys.DAO.StudentManagementValidation;
import com.chainsys.model.Student;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StudentDaoInterface dao = new StudentDao();
		System.out.println("\t\t Welcome to Student Management application\t\t");
		int rollNum;
		String name;
		String department;
		double percentage;
		String collegeName;
		
		System.out.println(
				"-----------------------> LOGIN PAGE <------------------------------------------------");
		int choice1;
		System.out.println("1.ADMIN");
		System.out.println("2.SIGN IN");
		
		
		while(true) {
			
			ArrayList<String> alist = new ArrayList<>();
			alist.add("Sudharsan27");
			alist.add("Rajaguru13");
			alist.add("Vasanth21");
			int i;
			String[] nms = new String[alist.size()];
			for ( i = 0 ; i< alist.size();i++) {
				nms[i]=alist.get(i);
			}
			 for (String k : nms) {
		            
			choice1 = sc.nextInt();
			
			if(choice1==1) {
		
		System.out.println("Enter the Username: ");
		String username= sc.next();
		do {
		if(!username.contains(k) ) {
			System.out.println("Enter the correct Username:");
			username= sc.next();
			}
		
		
		System.out.println("Enter the password");
		String password =sc.next();
		break;
			
		}while(true);
	
			}
			
		else {
			if(choice1==2) {
				
				System.out.println("WELCOME TO SIGN IN PAGE");
				
				
				System.out.println("Enter the New Username: ");
				String username1=sc.next();
				StudentManagementValidation.validusername1(username1);
				
				System.out.println("Enter the password: ");
				String password=sc.next();
				StudentManagementValidation.checkpassword(password);
				
				while (username1.matches(password)) {
					System.out.println("password should not be same as username");
					password=sc.next();
				}
				
				System.out.println("Enter the confirm Password: ");
				String confirmPassword=sc.next();
							
				do {
					
				
						if(password.contains(confirmPassword)) {
							System.out.println("LOGIN SUCCESSFULL");
							break;
						}
						else {
							
							System.out.println("PASSWORD MISMATCH PLEASE RE ENTER: ");
							 confirmPassword=sc.next();
						
						}
						
				}while(true);
						 
			}
					
		}
		

	    
		
		while (true) {
			System.out.println("\n1.Add Student " + "\n2.Show All Students " + "\n3.Get student based on roll number: "
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
				  boolean ans =dao.insertStudent(st);
				  
				  
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
				
				
				
				boolean ff =  dao.delete(rollNum);
				if ( ff ) {
					System.out.println("Record deleted successfully...");
				}
				else  { 
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
					   
					    
					    if (choice == 1) {
					        System.out.println("Enter new name");
					        String newName = sc.next();
					        dao.updateStudent(choice, rollNum, newName, null, 0);
					    } else if(choice == 2) {
					        System.out.println("Enter new department");
					        String newDepartment = sc.next();
					        dao.updateStudent(choice, rollNum, null, newDepartment, 0);
					    } else if(choice == 3) {
					        System.out.println("Enter new percentage");
					        double newPercentage = sc.nextDouble();
					        dao.updateStudent(choice, rollNum, null, null, newPercentage);
					    } else {
					        System.out.println("Invalid choice");
					    }
					    break;
					
				}
				case 6:
				System.out.println("Thank You for using Student management application!!!");
				System.exit(0);
			default:{
				System.out.println("Please enter valid choice..");
			}
			}
		}
	}
}
		
}
		
}
	

