package com.company;

import java.sql.*;
import java.util.*;
public class Database {
    public static Connection con;

 static {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/xoxday", "root", "Rk97@nrp");
         } catch (Exception e) {
             System.out.println(e);
         }
     }

//    public static void main(String[] args) throws Exception{
//
//        Connection con=Database.con;
//        System.out.println(con);
//        Statement stmt=con.createStatement();
//
//
//        ResultSet rs=stmt.executeQuery("select * from car");
//       // System.out.println(rs.getString("reg_no"));
//        while(rs.next())
//        {
//            System.out.println(rs.getString("reg_no"));
//        }
//
//
//    }
}
