package com.chainsys.model;

import java.util.Date;

public class Student {
    private int rollNum;
    private String name;
    private String collegeName;
    private String department;
    private double percentage;
    private String username;
    private String password;
    private String date_time;

    public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student(){

    }
    public Student( String name, String collegeName, String department, double percentage) {
        
    	
        this.name = name;
        this.collegeName = collegeName;
        this.department = department;
        this.percentage = percentage;
    }
    

    public Student(int rollNum, String name, String collegeName, String department, double percentage) {
        this.rollNum = rollNum;
        this.name = name;
        this.collegeName = collegeName;
        this.department = department;
        this.percentage = percentage;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcollegeName() {
        return collegeName;
    }

    public void setcollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getdepartment() {
        return department;
    }

    public void setdepartment(String department) {
        this.department = department;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    public String getUsername() {
    	return  username;
    }
    
    public void setUsername(String username) {
    		this. username=username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", name='" + name + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", department='" + department + '\'' +
                ", percentage=" + percentage +
                 "username='" + username + '\'' +
                '}';
               
    }
  

	
	}
