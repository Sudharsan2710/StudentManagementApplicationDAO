package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.Util.DBConnection;
import com.chainsys.model.Student;

public   class StudentDao implements StudentDaoInterface {
	Connection con;
	

	@Override

	public boolean insertStudent(Student s) {
		boolean flag = false;
		try {
			Connection con = DBConnection.createConnection();
			String query = "insert into Student_details (name,collegeName,department,percentage) values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, s.getName());
			pst.setString(2, s.getcollegeName());
			pst.setString(3, s.getdepartment());
			pst.setDouble(4, s.getPercentage());
			pst.executeUpdate();
			flag=true;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
		

	}

	@Override
	public boolean  delete(int roll) {
		
		boolean flag=false;
		try {
		
			
			Connection con = DBConnection.createConnection();
			String query = "delete from Student_details where rollnum=" + roll;
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.executeUpdate();
			flag = true;
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
			return flag;
	}
	
	
	@Override
	public boolean updateStudent(int ch, int rollNum, String name, String department, double percentage) {
	    int choice = ch;
	    boolean flag = false;
	    try {
	   
	        con = DBConnection.createConnection();
	        if (choice == 1) {
	            String query = "update Student_details set name=? where rollnum=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, name);
	            ps.setInt(2, rollNum);
	            ps.executeUpdate();
	            flag = true;
	            System.out.println("Updated Name Succesfully");
	        } else if (choice == 2) {
	            String query = "update Student_details set department=? where rollnum=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, department);
	            ps.setInt(2, rollNum);
	            ps.executeUpdate();
	            flag = true;
	            System.out.println("Updated Department Succesfully");
	        } else if (choice == 3) {
	            String query = "update Student_details set percentage=? where rollnum=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setDouble(1, percentage);
	            ps.setInt(2, rollNum);
	            ps.executeUpdate();
	            flag = true;
	            System.out.println("Updated Percentage Succesfully");
	        }
	    } catch (Exception ex) {	
	        ex.printStackTrace();
	    } finally {
	        try {
	            con.close(); // Close the connection
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return flag;
	}

	@Override
	public void showAllStudent() {
		try {
			Connection con = DBConnection.createConnection();
			String query = "select * from Student_details";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("RollNumber: " + rs.getInt(1) + "\n" + "Name: " + rs.getString(2) + "\n"
						+ "Clg name: " + rs.getString(3) + "\n" + "City: " + rs.getString(4) + "\n" + "Percentage: "
						+ rs.getDouble(5));
				System.out.println("----------------------------------");

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public boolean showStudentById(int roll) {
		boolean flag = false;
		try {

			Connection con = DBConnection.createConnection();
			String query = "select * from Student_details where rollnum=" + roll;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("RollNumber: " + rs.getInt(1) + "\n" + "Name: " + rs.getString(2) + "\n"
						+ "Clg name: " + rs.getString(3) + "\n" + "City: " + rs.getString(4) + "\n" + "Percentage+"
						+ rs.getDouble(5));
				// System.out.println("----------------------------------");
				flag = true;

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return flag;
	}

	public boolean  adminDetails() {
		boolean flag=false;
		
			Scanner sc = new Scanner(System.in);
		
		     Connection con = DBConnection.createConnection();

		     
		     while(true) {
		    	 
		    	 try {
		         ArrayList<String> alist = new ArrayList<>();
		         alist.add("Sudharsan27");
		         alist.add("Rajaguru13");
		         alist.add("Vasanth21");

		         String[] nms = new String[alist.size()];
		         for (int i = 0; i < alist.size(); i++) {
		             nms[i] = alist.get(i);
		         
		         System.out.println("1. Existing Admin");
	             System.out.println("2. New Admin");
		         for (String k: nms) {
		            
		             int choice1 = sc.nextInt();

		             if (choice1 == 1) {
		                 System.out.println("Enter the Username: ");
		                 String username = sc.next();
		                 while(true) {
		                     if (!username.contains(k)) {
		                         System.out.println("Enter the correct Username:");
		                         username = sc.next();
		                    
		                     } 
		                 System.out.println("Enter the password");
		                 String password1 = sc.next();

		                 
		                 String query = "insert into admindetails(username,password ) values(?,?)";
		                 PreparedStatement pst = con.prepareStatement(query);
		                 pst.setString(1, username);
		                 pst.setString(2, password1);
		                 int row = pst.executeUpdate();
		                 System.out.println("Rows affected: " + row);
		             } 
		             }else if (choice1 == 2) {
		                 System.out.println("WELCOME TO SIGN IN PAGE");

		                 System.out.println("Enter the New Username: ");
		                 String username1 = sc.next();

		                 System.out.println("Enter the password: ");
		                 String password1 = sc.next();

		                 while (password1.matches(username1)) {
		                     System.out.println("Password should not be same as username");
		                     password1 = sc.next();
		                 }

		                 System.out.println("Enter the confirm Password: ");
		                 String confirmPassword = sc.next();

		                 do {
		                     if (password1.equals(confirmPassword)) {
		                         System.out.println("LOGIN SUCCESSFULL");
		                         
		                         String query = "insert into admindetails(username,password ) values(?,?)";
		                         PreparedStatement pst = con.prepareStatement(query);
		                         pst.setString(1, username1);
		                         pst.setString(2, password1);
		                         int row = pst.executeUpdate();
		                         System.out.println("Rows affected: " + row);
		                         break;
		                     } else {
		                         System.out.println("PASSWORD MISMATCH PLEASE RE ENTER: ");
		                         confirmPassword = sc.next();
		                     }
		                 } while (true);
		             }
		         }
		         	con.close();
					return false;
		        
		        
		     
		     } 
		    	 }catch(Exception e){
		    	 e.printStackTrace();
		    	 
		     }
		    	  
	}
		     
		     }     
	}
				



