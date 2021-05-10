/*
 * Title: hw2_1.java
 * Abstract:program called hw2_1.cpp (or hw2_1.java) 
 that reads two timestamps of two events from a user 
 and displays the difference between the two timestamps. 
 For the program, you can assume that each timestamp 
 is composed of the hour (0 ~ 23), minute (0 ~ 59), 
 and second (0 ~ 59) format. Your program should present 
 the difference from the second event (= second timestamp) 
 to the first event (= first timestamp). 
 * Author: Timothy Hinea
 * ID: 0001
 * Date: 03/13/2021
 */
import java.util.*;

class hw2_1 {
    
     public static int asciiConv(String s, int selector){
        String b = "";
        int number;
        if(selector == 0){
        b = s.substring(0,2);
        }
        else if(selector == 1){
         b = s.substring(3, 5);
        }
        else if(selector == 2){
         b = s.substring(6,8);
        }
        
        //System.out.println(b);
        number = Integer.parseInt(b);
        return number;
    }// ascii Converter
    
    public static int mathHours(int a, int b)
    {
        int sum = 0;
        if(b >= a)
        {
            sum = b - a;
        }
        
        else{
            sum = (24 - a + b);
        }
        return sum;
    }// Math hours
    

    
    
    
    
    
    public static void main(String[] args) {
    
    // create an object of Scanner
        Scanner input = new Scanner(System.in);
        String s1, s2, outPut;
        int[] timeA, timeB, timeC;
        int sum = 0;
        
        timeA = new int[3];
        timeB = new int[3];
        timeC = new int[3];
        
        s1 = input.nextLine();
        s2 = input.nextLine();
        
        
        for(int i = 0; i < 3; i++)
        {
            timeA[i] = asciiConv(s1, i);
            timeB[i] = asciiConv(s2, i);
        }
            
        //Math For the secconds
        if(timeB[2] >= timeA[2])
        {
            timeC[2] = timeB[2] - timeA[2];
        }
        else{
            timeC[2] = (60 - timeA[2] + timeB[2]);
            timeB[1] = timeB[1]-1;
        }
        
        //Math For Minutes
        if(timeB[1] >= timeA[1])
        {
            timeC[1] = timeB[1] - timeA[1];
        }
        else{
            timeC[1] = (60 - timeA[1] + timeB[1]);
            timeB[0] = timeB[0]-1;
        }
        // math for hours
        timeC[0] = mathHours(timeA[0], timeB[0]);
        
        outPut = String.format("%02d", timeC[0]);
        outPut+= ":";
        outPut += String.format("%02d", timeC[1]);
        outPut+= ":";
        outPut += String.format("%02d", timeC[2]);
        System.out.println(outPut);

    }//Main
}