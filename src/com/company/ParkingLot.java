package com.company;

import java.util.*;

public class ParkingLot {
    private  int capacity;
    private int occupiedSpace;
    private int remainingSpace;
    private   HashMap<String ,Car> parkingSpace ;
    private   PriorityQueue<Integer>availableSlot;
    private  ArrayList<Car>list=new ArrayList();



    //fetching the car details
    public void getAll()
    {
         list.clear();
        for(Map.Entry e:parkingSpace.entrySet())
        {
            list.add((Car)e.getValue());
        }


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
    public void setCapacity(int capacity,int occupied)
    {
        this.capacity=capacity;
        this.occupiedSpace=occupied;
        this.remainingSpace=capacity-occupied;
        for(int i=occupied;i<=capacity;i++)
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
        if(remainingSpace>=0)
        {
            int ticket=availableSlot.poll();
            car.setSlot(ticket);
            parkingSpace.put(car.getRegistrationNo(),car);
            this.occupiedSpace=this.occupiedSpace+1;
            this.remainingSpace=this.remainingSpace-1;

            return car;
        }
        else
            System.out.println("Space is Not Available");
        return null;

    }

    //Null PointerException in case of Random Number of Generation
    public Car getRandomParkingSpace(Car car,int occupied) throws Exception
    {
                 int ticket=occupied;

                car.setSlot(ticket);

                       parkingSpace.put(car.getRegistrationNo(),car);



        return car;
    }

    //Remove Car from the parking lot
    public  String  removeCar( String registration ) {
        if(capacity==0)
            return "Parking Pot Not Created";
        else if(occupiedSpace==0)
            return "Slot is Not alloted";

        if(parkingSpace.get(registration)!=null)
        {
            Car c=parkingSpace.remove(registration);
            availableSlot.offer(c.getSlot());
            this.occupiedSpace=this.occupiedSpace-1;
            this.remainingSpace=this.remainingSpace+1;

            return "Slot "+c.getSlot()+"is Free "+"\nCar Details is Given Below:\n"+c.toString();
        }
        return "No CAR Found";
    }

   public String removeCarFromSlot(int slot)
   {

       if(capacity==0)
           return "Parking Pot Not Created";
       else if(occupiedSpace==0)
           return "Slot is Not alloted";
       else {
        int index=-1;
           for (Car c : list) {
               index++;
               if (c.getSlot() == slot) {

                  Car d = parkingSpace.remove(c.getRegistrationNo());
                   availableSlot.offer(d.getSlot());
                   this.occupiedSpace=this.occupiedSpace-1;
                   this.remainingSpace=this.remainingSpace+1;

                   list.remove(index);
                   return "Slot " + d.getSlot() + "is Free " + "\nCar Details is Given Below:\n" + d.toString();


               }
           }


       }
       return "No CAR Found";

   }

    //Show the list of car along with their details
    public void showCarList()
    {

        if(this.capacity==0)
        {
            System.out.println("Parking Lot Not Created");
        }else if(this.occupiedSpace==0)
        {
            System.out.println("Ticket Not Genrated");
        }


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
        if(this.capacity==0)
        {
            System.out.println("Parking Lot Not Created");
        }else if(this.occupiedSpace==0)
        {
            System.out.println("Ticket Not Genrated");
        }
     else {
            boolean check = false;
            for (Car c : list) {
                String tempColor = c.getColor();
                if (tempColor.equals(clr)) {
                    System.out.println(c.getRegistrationNo());
                    check = true;

                }
            }
            if (check == false) {
                System.out.println(clr + " Color car is not found in our Parking lot");
            }
        }
    }

    //slot number in which a car with given registration Number is parked
    public void getSlotNoFromRegistrationNo(String regNo)
    {

        if(this.capacity==0)
        {
            System.out.println("Parking Lot Not Created");
        }else if(this.occupiedSpace==0)
        {
            System.out.println("Ticket Not Genrated");
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
        if(this.capacity==0)
        {
            System.out.println("Parking Lot Not Created");
        }else if(this.occupiedSpace==0)
        {
            System.out.println("Ticket Not Genrated");
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
            }
            if(check==false)
                {
                    System.out.println(color+" colour of car's slot not found");
                }

        }

    }





}