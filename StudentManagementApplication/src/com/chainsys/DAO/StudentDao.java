package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.chainsys.Util.DBConnection;
import com.chainsys.model.Student;

public class StudentDao implements StudentDaoInterface {
	Connection con;

	@Override

	public boolean insertStudent(Student s) {
		boolean flag = false;
		try {
			Connection con = DBConnection.createConnection();
			String query = "insert into student (name,collegeName,department,percentage) values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, s.getName());
			pst.setString(2, s.getcollegeName());
			pst.setString(3, s.getdepartment());
			pst.setDouble(4, s.getPercentage());
			pst.executeUpdate();
			flag = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;

	}

	@Override
	public boolean delete(int roll) {

		boolean flag = false;
		try {

			Connection con = DBConnection.createConnection();
			String query = "delete from student where rollnum=" + roll;
			PreparedStatement pst = con.prepareStatement(query);

			pst.executeUpdate();
			flag = true;
		} catch (Exception e) {
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
				String query = "update student set name=? where rollnum=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, name);
				ps.setInt(2, rollNum);
				ps.executeUpdate();
				flag = true;
				System.out.println("Updated Name Succesfully");
			} else if (choice == 2) {
				String query = "update student set department=? where rollnum=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, department);
				ps.setInt(2, rollNum);
				ps.executeUpdate();
				flag = true;
				System.out.println("Updated Department Succesfully");
			} else if (choice == 3) {
				String query = "update student set percentage=? where rollnum=?";
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
				con.close();
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
			String query = "select * from student";
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
			String query = "select * from student where rollnum=" + roll;
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

	@Override
	public boolean admindetails(String username, String password, String date_time) {

		Connection con = null;
		boolean isAdminLoggedIn = false;
		
		try {
			
			con = DBConnection.createConnection();

			String query = "INSERT INTO admin (username,password,date_time) VALUES (?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, date_time);
			

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {

				isAdminLoggedIn = true;
				System.out.println("Inserted Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return isAdminLoggedIn;
	}

}
