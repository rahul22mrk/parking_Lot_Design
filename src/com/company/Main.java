package com.company;
import java.lang.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        InputUser input=new InputUser();
        ParkingLot parkingLot=new ParkingLot();
        System.out.println("Enter The Capacity of Parking Lot: ");
        Scanner in=new Scanner(System.in);
        int capacity=in.nextInt();
        parkingLot.setCapacity(capacity);
        System.out.println("Enter the Number of Cars Currently in the parking is: ");
        int occupied=in.nextInt();
        if(capacity<occupied)
        {
            System.out.println("Capacity must be Greater than or equal to occupied space");
        }else {

            for(int i=1;i<=occupied;i++)
            {

                System.out.println(parkingLot.getParkingSpace(new Car().insertRandomCar()));
            }
        }
            while (true) {
                int n = input.menu();

                input.acutator(n, parkingLot);
            }


    }
}