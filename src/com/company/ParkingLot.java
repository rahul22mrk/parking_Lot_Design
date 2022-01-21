package com.company;

import java.util.*;

public class ParkingLot {
    private  int capacity;

    private   HashMap<String ,Car> parkingSpace ;
    private   PriorityQueue<Integer>availableSlot;
    private ArrayList<Car>list=new ArrayList();



    //fetching the car details
    public ArrayList<Car> getAll()
    {

        for(Map.Entry e:parkingSpace.entrySet())
        {
            list.add((Car)e.getValue());
        }
        //showCarList(list);
        return list;

    }

    public ParkingLot()
    {
        parkingSpace=new HashMap<>();
        availableSlot=new PriorityQueue<>();

    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        setAvailableSlot(capacity);
        for(int i=1;i<=capacity;i++)
        {
            availableSlot.offer(i);
        }
    }
    private void setAvailableSlot(int space) {
        this.capacity = space;
    }



    //for external users

    //get the space for parking of car
    public  Car  getParkingSpace(Car car) {
        if(availableSlot.size()!=0)
        {
            int ticket=availableSlot.poll();
            car.setSlot(ticket);
            parkingSpace.put(car.getRegistrationNo(),car);
            return car;
        }
        return null;

    }

    //Remove Car from the parking lot
    public  String  removeCar( String registration ) {
        if(parkingSpace.get(registration)!=null)
        {
            Car c=parkingSpace.remove(registration);
            availableSlot.offer(c.getSlot());
            return "Slot "+c.getSlot()+"is Free "+"\nCar Details is Given Below:\n"+c.toString();
        }
        return "No CAR Found";
    }


    //Show the list of car along with their details
    public void showCarList(ArrayList<Car>list)
    {
        if(list.size()==0)
            System.out.println("Car Not Found");

        else {
            System.out.println("Registration No.\t|\tColor\t|\tSlot No.");
            System.out.println("----------------------------------------------------------------------");

            for (Car e : list) {
                System.out.println(e.getRegistrationNo() + "   \t|\t" + e.getColor() + "\t\t|\t" + e.getSlot());
            }
        }

    }


    //Registration Number of all cars of a Particular Color
    public void getRegistrationNoFromColor(String clr)
    {
        boolean check=false;
        for(Car c:list)
        {
            String tempColor=c.getColor();
            if(tempColor.equals(clr))
            {
                System.out.println(c.getRegistrationNo());
                check=true;

            }
        }
        if(check==false)
        {
            System.out.println(clr+" Color car is not found in our Parking lot");
        }
    }

    //slot number in which a car with given registration Number is parked
    public void getSlotNoFromRegistrationNo(String regNo)
    {

        if(parkingSpace.size()==0)
        {
            System.out.println("Parking Lot Not Created");
        }
        else
        {
            boolean check=false;
            for(Car c:list)
            {
                String tempRegNo=c.getRegistrationNo();
                if(tempRegNo.equals(regNo))
                {
                    System.out.println("Slot Number is: "+c.getSlot());
                    check=true;
                }

            }
            if(check==false)
            {
                System.out.println("Registration Number Not Found");
            }

        }
    }

//Slot Numbers of all slots where a car of a particular colour is parked

    public void getSlotNoFromColor(String color)
    {
        if(parkingSpace.size()==0)
        {
            System.out.println("Parking Lot Not Created");
        }
        else
        {
            boolean check=false;
            for(Car c: list)
            {
                String tempColor=c.getColor();
                if(color.equals(tempColor))
                {
                    System.out.println("Slot Number is : "+c.getSlot());
                    check=true;
                }
                if(check==false)
                {
                    System.out.println(color+" colour of car's slot not found");
                }
            }
        }

    }





}