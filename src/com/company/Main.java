package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;

public class Main {

    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static int menu()
    {


        int option = 0;
        Scanner in=new Scanner(System.in);
        System.out.println("\nMain Menu:");
        System.out.println("--------------");
        System.out.println("1.Get Slot");
        System.out.println("2.Remove Car");
        System.out.println("3.Show all Slots");
        System.out.println("4.Show Registration Number of all cars of a Particular Colour");
        System.out.println("5.Slot number in which a car with a given registration number is parked");
        System.out.println("6.Slot number of all slots where a car of a particular colur is parked");
        System.out.println("--------------");
        System.out.println("Enter your valid choice from 1 to 6 :");
        option = in.nextInt();

        return option;

    }
    private static boolean regNoValidation(String regNo)
    {
        String regex="^KA-[0-9]{2}-[A-Z]{2}-[0-9]{4}$";
        Pattern p=Pattern.compile(regex);
        if(regNo==null)
            return false;
        Matcher m=p.matcher(regNo);
        return m.matches();

    }
    private static boolean colorValidation(String color)
    {
        if(color.equals("White")||color.equals("Black")||color.equals("Blue")||color.equals("Red"))
            return true;
        return false;
    }
    public static void acutator(int option,ParkingLot parkingLot) throws Exception
    {
        boolean checkColor=false;
        boolean checkReg=false;

        switch (option) {

            case 1:
                Car c=new Car();

                Scanner sc=new Scanner(System.in);
                System.out.println("Enter Car registration Must Be Following Format : KA-01-HH-1234");
                String regNo=sc.nextLine();
                checkReg=regNoValidation(regNo);
                 if(checkReg)
                 {
                System.out.println("Enter Car Color only [White or Black or Blue or Red] :");
                String color=sc.nextLine();
                checkColor=colorValidation(color);
                        if( checkColor)
                        {
                            c=c.insertCar(color,regNo);
                            System.out.println(parkingLot.getParkingSpace(c));
                        }
                        else{
                            System.out.println("Invalid Input...");
                        }
              }else{
                     System.out.println("Invalid Input...");

                 }

                break;
            case 2:
                System.out.println("Enter Car registration Must Be Following Format : KA-01-HH-1234");
                String str=br.readLine();
                checkReg=regNoValidation(str);
                if(checkReg) {

                    System.out.println(parkingLot.removeCar(str));
                }else
                {
                    System.out.println("Invalid Input...");
                }

                break;
            case 3:
                ArrayList<Car> list=new ArrayList();
                list=parkingLot.getAll();
                parkingLot.showCarList(list);
                break;
            case 4:

                System.out.println("Enter Car Color only [White or Black or Blue or Red] :");
                String clr=br.readLine();
                checkColor=colorValidation(clr);
                if( checkColor){
                    parkingLot.getRegistrationNoFromColor(clr);
                }else
                {
                    System.out.println("Invalid Input...");
                }

                break;
            case 5:

                System.out.println("Enter Car registration Must Be Following Format : KA-01-HH-1234");
                regNo=br.readLine();
                checkReg=regNoValidation(regNo);
                if(checkReg) {

                    parkingLot.getSlotNoFromRegistrationNo(regNo);
                }
                else
                {
                    System.out.println("Invalid Input...");
                }
                break;

            case 6:
                System.out.println("Enter Car Color only [White or Black or Blue or Red] :");
                String  colr=br.readLine();
                checkColor=colorValidation(colr);
                if( checkColor){
                    parkingLot.getSlotNoFromColor(colr);
                }else
                {
                    System.out.println("Invalid Input...");
                }

                break;

            default:
                System.out.println("Invalid Choice:\nExit...");
                System.exit(0);
        }// End of switch statement



    }

    public static void main(String[] args) throws Exception{

        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setCapacity(10);
        while(true) {
            int n = menu();
            acutator(n,parkingLot);
        }

    }
}