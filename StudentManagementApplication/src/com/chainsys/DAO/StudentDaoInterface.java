package com.chainsys.DAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.chainsys.model.Student;

public interface StudentDaoInterface {


    public boolean insertStudent(Student s);
    public boolean delete(int roll);
    public boolean updateStudent(int ch ,int rollNum, String name, String department, double percentage);

    public void showAllStudent();
    public boolean showStudentById(int rollNum);
    public boolean admindetails(String username , String password,String date_time);
}
