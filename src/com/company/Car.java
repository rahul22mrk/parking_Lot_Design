package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Car {
   private String registrationNo;
    private String color;
    private int slot;

    public Car()
    {
    }

    @Override
    public String toString() {
        return  "registrationNo= " + registrationNo + '\'' +
                ", color= " + color + '\'' +
                ", slot= " + slot ;
    }

    //Insert Car Color and Registration Number
    public  Car insertCar(String color,String regNo) throws Exception
    {
        this.setColor(color);
        this.setRegistrationNo(regNo);

        return this;
    }

    //Insert Car Color and Registration Number Randomly
     public Car insertRandomCar()  throws Exception
        {
            RandomGenerator random=new RandomGenerator();
            String regNo=random.generateRandomRegistrationNo();
            String color=random.generateRandomColor();
            this.setColor(color);
            this.setRegistrationNo(regNo);

            return this;
         //  return  insertCar(color,regNo);
        }


    public Car(String registrationNo, String color, int slot) {
        this.registrationNo = registrationNo;
        this.color = color;
        this.slot = slot;
    }





    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}