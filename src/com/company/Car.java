package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
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

        public Car insertRandomCar()  throws Exception
        { Random ObjectGenerator = new Random();
            String regNo=new String();
            String color=new String();



            int randColor=ObjectGenerator.nextInt(4);
            switch(randColor)
            {
                case 0:
                    color="Black";
                    break;
                case 1:
                    color="White";
                    break;
                case 2:
                    color="Blue";
                    break;
                case 3:
                    color="Red";
                    break;
                default:
            }



            int rand_0 = ObjectGenerator.nextInt(10);

            regNo+="KA";


            // regNo+=ch.toString();
            regNo+='-';
            int rand_digit=ObjectGenerator.nextInt(10);
            regNo+=Integer.toString(rand_digit);
            rand_digit=ObjectGenerator.nextInt(10);
            regNo+=Integer.toString(rand_digit);

            regNo+='-';
            rand_0 =ObjectGenerator.nextInt(25);
            int ch=rand_0+65;
           char d=(char)ch;
            regNo+=Character.toString(d);


            //regNo+=ch.toString();
            int rand_1 = ObjectGenerator.nextInt(25);
            ch=rand_1+65;
            d=(char)ch;
            regNo+=Character.toString(d);


            // regNo+=ch.toString();
            regNo+='-';
            rand_digit=ObjectGenerator.nextInt(10);
            regNo+=Integer.toString(rand_digit);
            rand_digit=ObjectGenerator.nextInt(10);
            regNo+=Integer.toString(rand_digit);
            rand_digit=ObjectGenerator.nextInt(10);
            regNo+=Integer.toString(rand_digit);
            rand_digit=ObjectGenerator.nextInt(10);
            regNo+=Integer.toString(rand_digit);


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