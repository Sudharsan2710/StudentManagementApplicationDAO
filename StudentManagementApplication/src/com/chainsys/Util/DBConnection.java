package com.chainsys.Util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con; 

    public static Connection createConnection(){
    	

        try{
        	//load driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
            String user="root";
            String pass="Sudha@27102001";
            String url ="jdbc:mysql://localhost:3306/Student?useSSL=false";
        
            con= DriverManager.getConnection(url,user,pass);

            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return con;
    }
    }

