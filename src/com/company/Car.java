package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Car {
    String registrationNo;
    String color;
    int slot;

    public Car()
    {

    }

    @Override
    public String toString() {
        return  "registrationNo=" + registrationNo + '\'' +
                ", color= " + color + '\'' +
                ", slot= " + slot ;
    }


    public Car insertCar(String color,String regNo) throws Exception
    {
        this.setColor(color);
        this.setRegistrationNo(regNo);

        return this;
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