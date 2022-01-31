package com.company;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.sql.*;
public class carService {
    public static Connection con;
    PreparedStatement pstm;
     public carService()
    {
      con=Database.con;

    }
    public int getBill(int sHrs,int eHrs)
    {
        if(sHrs==eHrs)
            return 50;
        else
        {
            int dif=Math.abs(eHrs-sHrs);
            if(dif>=24)
            {
                return 250;

            }
            else
            {
                return 50+20*(dif-1);
            }

        }

    }
    public String insertCar(Car car) throws Exception
    {
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String query="insert into car  values ( ?,?,?,?,?,?)";
        PreparedStatement pstm=con.prepareStatement(query);


      // PreparedStatement pstm=con.prepareStatement();
       // pstm=con.preparedStatement(query);
        pstm.setString(1,car.getRegistrationNo());
        pstm.setString(2,car.getColor());
        pstm.setInt(3,car.getSlot());
        pstm.setString(4,dtf.format(now));
        pstm.setString(5,null);
        pstm.setBoolean(6,true);

        pstm.execute();



      return "true";

    }


    public void showDataBase() throws Exception{



        Statement stmt=con.createStatement();

        ResultSet rs=stmt.executeQuery("select * from car");

        while(rs.next())
        {
            System.out.println(rs.getString("reg_no")+"\t\t"+rs.getString("color")+"\t\t"+rs.getInt("slot")+"\t\t"+rs.getString("in_time")+"\t\t"+rs.getString("out_time")+"\t\t"+rs.getBoolean("is_parked"));
        }


    }
    public String updateDatabase(String registeration)throws Exception{

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String query="update car set out_time = ? ,is_parked = ? where reg_no = ?";
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setString(1,dtf.format(now));
        pstm.setBoolean(2,false);
        pstm.setString(3,registeration);
       return pstm.executeUpdate()+"";

        //return pstm.ex;

    }


    public int getTotalIncome()throws Exception{


   String query = "select * from car where out_time between '2022-01-31 00:00:00' and '2022-01-31 23:59:59'";
    Statement stmt=con.createStatement();

        ResultSet rs=stmt.executeQuery(query);

        int totalIncome=0;
       while(rs.next())
       {
            String enterTime=rs.getString("in_time");
           String ExitTime=rs.getString("out_time");
            int inTime= Integer.parseInt(enterTime.substring(11,13));
             int outTime=Integer.parseInt(enterTime.substring(11,13));

     totalIncome+=getBill(inTime,outTime);

         //System.out.println(rs.getString("reg_no")+"\t"+rs.getString("color")+"\t"+rs.getInt("slot")+"\t"+rs.getString("in_time")+"\t"+rs.getString("out_time")+"\t"+rs.getBoolean("is_parked"));
       }

        return totalIncome;
    }

    public int getTotalCar()throws Exception
    {
        String query = "SELECT COUNT(DISTINCT reg_no) from car where in_time between '2022-01-31 00:00:00' and '2022-01-31 23:59:59';";
        Statement stmt=con.createStatement();

        ResultSet rs=stmt.executeQuery(query);
        rs.next();
        int count = rs.getInt(1);

        int totalCar=count;


         return totalCar;


    }
}
