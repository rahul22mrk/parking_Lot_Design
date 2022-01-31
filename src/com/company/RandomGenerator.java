package com.company;

import java.util.Random;

public class RandomGenerator {
    String generateRandomRegistrationNo()
    {
        Random ObjectGenerator = new Random();
        String regNo=new String();
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

        regNo+='-';
        rand_digit=ObjectGenerator.nextInt(10);
        regNo+=Integer.toString(rand_digit);
        rand_digit=ObjectGenerator.nextInt(10);
        regNo+=Integer.toString(rand_digit);
        rand_digit=ObjectGenerator.nextInt(10);
        regNo+=Integer.toString(rand_digit);
        rand_digit=ObjectGenerator.nextInt(10);
        regNo+=Integer.toString(rand_digit);

        return regNo;

    }

     String generateRandomColor()
    {
        Random ObjectGenerator = new Random();
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


        return color;
    }
}
