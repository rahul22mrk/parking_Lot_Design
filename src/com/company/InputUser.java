package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUser {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    //Java BifferReader class is used to read the text from a character based input stream.
    //it can be used to read data line by line  by using readLine() method.
    //It makes the performance fast.
    //it inherits reader class
    public static Scanner in=new Scanner(System.in);
    //Java Scanner class breaks the input into tokens using a delimiter which is whitespace by default.

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
        System.out.println("7.Removing Car using slot Number: ");
        System.out.println("8.Total car Parked in a day: ");
        System.out.println("9.Total Income of the day is: ");
        System.out.println("10.Total Car from database: ");
        System.out.println("--------------");
        System.out.println("Enter your valid choice from 1 to 10 :");
        option = in.nextInt();
        return option;

    }
    private static boolean regNoValidation(String regNo)
    {
        //The Java Regex or Regular expression is an api to define a pattern for searching or manipulating strings
        //JAVA Regex API provides 1 interfaces and 3 classes in java.util.regex package
        String regex="^KA-[0-9]{2}-[A-Z]{2}-[0-9]{4}$";
        Pattern p=Pattern.compile(regex);//It is a compiled the given regex and returns the instance of the pattern
        if(regNo==null)
            return false;
        Matcher m=p.matcher(regNo);//Create a mather that matches the given input with the pattern
        return m.matches();//test whether the regular expression matches the pattern

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
        Car c=new Car();
        carService carservice = new carService();
        //ShowParkingDetails show=new ShowParkingDetails();
        switch (option) {//the java switch statement executes one statement from multiple conditions.

            case 1:
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

                break;//when control reaches the break statement, it jumps the control after the switch expression
            //if break condition is not found, it execute the next case
            case 2:
                System.out.println("Enter Car registration Must Be Following Format : KA-01-HH-1234");
                String str=br.readLine();//It is used for reading a line of text.
                checkReg=regNoValidation(str);
                if(checkReg) {

                    System.out.println(parkingLot.removeCar(str));
                }else
                {
                    System.out.println("Invalid Input...");
                }

                break;
            case 3:
                parkingLot.getAll();
                parkingLot.showCarList();
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

            case 7:
                System.out.println("Enter slot number for removing Car: ");
                int slot=in.nextInt();
                System.out.println(parkingLot.removeCarFromSlot(slot));
                break;

            case 8:

                System.out.println(carservice.getTotalCar());
                break;
            case 9:

            System.out.println(carservice.getTotalIncome());
                break;

            case 10:
                carservice.showDataBase();
                break;

            default:
                System.out.println("Invalid Choice:\nExit...");
                System.exit(0);//successful termination
                //the exit() method of system class terminates the current java virtual machine running on system.
                //this method take status code as an argumnet
        }// End of switch statement



    }
}
