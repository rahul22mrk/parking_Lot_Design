package com.company;

import java.util.*;

public class ParkingLot {
    private  int capacity;
   HashMap<String ,Car> parkingSpace ;
    private   PriorityQueue<Integer>availableSlot;



    //fetching the car details
    public ArrayList<Car> getAll()
    {
        ArrayList<Car>list=new ArrayList();
        for(Map.Entry e:parkingSpace.entrySet())
        {
            list.add((Car)e.getValue());
        }
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
        if(availableSlot.size()>0)
        {
            int ticket=availableSlot.poll();
            car.setSlot(ticket);
            parkingSpace.put(car.getRegistrationNo(),car);
            return car;
        }
        else
            System.out.println("Space is Not Available");
        return null;

    }


    //Remove Car from the parking lot
    public  String  removeCar( String registration ) {
        if(this.capacity==0)
            return "Space Not Available";

        if(parkingSpace.get(registration)!=null)
        {
            Car c=parkingSpace.remove(registration);
            availableSlot.offer(c.getSlot());

            return "Slot "+c.getSlot()+"is Free "+"\nCar Details is Given Below:\n"+c.toString();
        }
        return "No CAR Found";
    }

   public String removeCarFromSlot(int slot)
   {

       if(this.capacity==0)
           return "Parking Pot Not Created";
       else {
           boolean occupied=false;

           ArrayList<Car>list=getAll();
        for(Car c:list)
        {
            if(c.getSlot()==slot)
            {
                occupied=true;
                parkingSpace.remove(c.getRegistrationNo());
                availableSlot.offer(c.getSlot());
                return "Slot " + c.getSlot() + "is Free " + "\nCar Details is Given Below:\n" + c.toString();

            }
        }


               return "No CAR is Parked ";


       }
   }

    //Show the list of car along with their details
    public void showCarList()
    {

        if(this.capacity==0)
        {
            System.out.println("Parking Lot Not Created");
        }
        else {

            System.out.println("Registration No.\t|\tColor\t|\tSlot No.");
            System.out.println("----------------------------------------------------------------------");

            for(Map.Entry e:parkingSpace.entrySet())
            {
               Car car= (Car)e.getValue();
                System.out.println(car.getRegistrationNo() + "   \t|\t" + car.getColor() + "\t\t|\t" + car.getSlot());
            }

        }

    }


    //Registration Number of all cars of a Particular Color
    public void getRegistrationNoFromColor(String color)
    {
        if(this.capacity==0)
        {
            System.out.println("Parking Lot Not Created");
        }
     else {
            boolean check = false;
            ArrayList<Car>list=getAll();
            for(Car c:list)
            {
                String tempColor=c.getColor();
                if(tempColor.equals(color))
                {
                    check =true;
                    System.out.println(c.getRegistrationNo());


                }
            }

            if (check == false) {
                System.out.println(color + " Color car is not found in our Parking lot");
            }
        }
    }

    //slot number in which a car with given registration Number is parked
    public void getSlotNoFromRegistrationNo(String registrationNo)
    {
                if(parkingSpace.get(registrationNo)!=null)
                {
                    System.out.println("Slot Number is: "+parkingSpace.get(registrationNo).getSlot());
                }
               else
               {
                System.out.println("No Car parked with this Registration Number");
               }


    }

//Slot Numbers of all slots where a car of a particular colour is parked

    public void getSlotNoFromColor(String color)
    {
        if(this.capacity==0)
        {
            System.out.println("Parking Lot Not Created");
        }
        else
        {
            ArrayList<Car>list=getAll();
            boolean check=false;
            for(Car c:list)
            {
                String tempColor=c.getColor();
                if(tempColor.equals(color))
                {
                    check =true;
                    System.out.println(c.getSlot());


                }
            }


            if(check==false)
                {
                    System.out.println(color+" colour of car's slot not found");
                }

        }

    }





}