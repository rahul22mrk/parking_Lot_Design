package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

   public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static int menu()
    {


        int optionn = 0;
          Scanner in=new Scanner(System.in);
        System.out.println("Main Menu:");
        System.out.println("--------------");
        System.out.println("1.Get Slot");
        System.out.println("2.Remove Car");
        System.out.println("3.Show all Slots");
        System.out.println("4.Show Registration Number of all cars of a Particular Colour");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
       optionn = in.nextInt();

        return optionn;

    }
    public static void acutator(int optionn,ParkingLot parkingLot) throws Exception
    {
        switch (optionn) {

            case 1:
                Car c=new Car();
                 c=c.insertCar();
                System.out.println(parkingLot.getParkingSpace(c));
                break;
            case 2:
                System.out.println("Enter Registration No");
                String str=br.readLine().trim();
                System.out.println(parkingLot.removeCar(str));

                break;
            case 3:
                ArrayList<Car> list=new ArrayList();
                list=parkingLot.getAll();
                parkingLot.showCarList(list);
                break;
            case 4:

                System.out.println("Enter the Color: ");
                String clr=br.readLine().trim();
                parkingLot.getRegistrationNoFromColor(clr);
                break;
            case 5:

                System.out.println("Enter the Registration No: ");
                String regNo=br.readLine().trim();
                parkingLot. getSlotNoFromRegistrationNo(regNo);
                break;






            default:
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
