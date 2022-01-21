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
    public static void acutator(int option,ParkingLot parkingLot) throws Exception
    {
        switch (option) {

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

            case 6:

                System.out.println("Enter the Colour: ");
                String color=br.readLine().trim();
                parkingLot.getSlotNoFromColor(color);
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
