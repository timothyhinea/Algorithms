/*
 * Title: hw4_1.java
 * Abstract:Write a C++ (or Java) program called hw4_1.cpp
 (or hw4_1.java) that reads a number of input values and the 
 values themselves. Then, your program should put all negative 
 numbers in front of all positive numbers.

 * Author: Timothy Hinea
 * ID: 0001
 * Date: 04/3/2021
 */
import java.util.*;

class hw4_1 {
    
    public static int getSmallStrings(String s, int number,int position){
        String [] words = s.split(" ", number);
    
        return Integer.parseInt(words[position]);
    }
    
    
    
    public static void main(String[] args) {
    
    // create an object of Scanner
        Scanner input = new Scanner(System.in);
        String s, outPut;
        int size = 0, j = 0, temp = 0;
        
        boolean check = false;
        
        size  = input.nextInt();
        input.nextLine();
        s = input.nextLine();
        
        int[] arr = new int[size];
        int[] arr0 = new int[size];
        
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = getSmallStrings(s, size, i);
            arr0[i] = arr[i];
        }// Loads user input into array
        
        //Fisrt approach
        j = arr.length -1;
        for(int i = 0; i < arr.length; i++){
            check = true;
            if(arr[i] >= 0 && i < j) {
                
                do {
                    if (check == false)
                        j--;
                    if(arr[j] < 0 && i < j && arr[i] >= 0){
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        temp = 0;
                    }
                    check = false;
                }while(arr[j] > 0 && i < j);
            }
        }
        
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }// Loads user input into array
        
        
        for(int i = 0; i < arr0.length; i++)
        {
            if(arr0[i] >=0)
            {
                for(j = i; j < arr0.length; j++)
                {
                    if(arr0[j] < 0 && arr0[i] >= 0){
                        temp = arr0[i];
                        arr0[i] = arr0[j];
                        arr0[j] = temp;
                        temp = 0;
                    }
                }
                
            }
        }
        System.out.println();
         for(int i = 0; i < arr.length; i++){
            System.out.print(arr0[i] + " ");
        }// Loads user input into array
        
    }//Main
}
