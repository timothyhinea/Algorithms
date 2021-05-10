/*
 * Title: hw2_2.cpp
 * Abstract:Java) program called hw2_2.cpp (or hw2_2.java) that collects 
 the maximum number of apples in boxes. For the problem, you should assume 
 that there are n boxes (= from the box number 0 to box n-1) on a table 
 and they contain a few apples. Your program should determine the maximum 
 number of apples you can collect from the boxes. One constraint in this 
 problem is that if you collect the apples in a box, you should skip at 
 least one box next to the box. 
 * Author: Timothy Hinea
 * ID: 0001
 * Date: 03/13/2021
 */

import java.util.*;
import java.lang.Math;




class hw2_2 {
    
    public static void main(String[] args) {
    
        // create an object of Scanner
        Scanner input = new Scanner(System.in);
        int a, b, index =0, sum = 0, totalSum = 0;
        boolean check = false;
        int[] fib = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987, 1597};
        
        //set up arrays
        a = input.nextInt();
        b = (int) Math.round(Math.pow(2,a));
        String[] allPossibleCombos = new String[fib[a+2]];
        String[] binaryPossibilities = new String[b];
        int[] arr0 = new int[a];
        boolean[] boxCheck = new boolean[a];
        boolean[] finalBoxes = new boolean[a];
        
        //gather input
        for(int i =0; i < a; i++){
            arr0[i] = input.nextInt();
        }//gathering user input
        
            for(int i = 0; i < b; i++){
            binaryPossibilities[i] = Integer.toBinaryString(i);
        }// set all possibilities into String array
        
        //This loop creates an array that creates all the possible 
        //combinations of binary numbers without repeting 1s
        for(int i = 0; i < b; i++){
            check = true;
            for(int j = 0; j < binaryPossibilities[i].length(); j++){
                if(j < binaryPossibilities[i].length() - 1){
                    if(binaryPossibilities[i].charAt(j) == '1'){
                        if(binaryPossibilities[i].charAt(j + 1) == '1'){
                            check = false;
                        }
                    }
                    
                }
            }
            if(check == true) {
                allPossibleCombos[index++] = binaryPossibilities[i];
            }
        }
        
        //Loop to add zeros in front of binary strings
        for(int i = 0; i < allPossibleCombos.length; i++)
        {
            if(allPossibleCombos[i].length() < a)
            {
                for(int j = 0; j < allPossibleCombos[fib[a+1]].length(); j++)
                {
                    if(allPossibleCombos[i].length() < a){
                        allPossibleCombos[i] = "0" + allPossibleCombos[i];
                    }
                }
            }
        }
        
        //Check to see all possible combinations to find the best solution
        for(int i = 0; i < allPossibleCombos.length; i++){
            sum = 0;
            for(int j = 0; j < boxCheck.length; j++){
                boxCheck[j] = false;
            }
            
            for(int j = 0; j < allPossibleCombos[i].length(); j++){
                if(allPossibleCombos[i].charAt(j) == '1') {
                    sum += arr0[j];
                    boxCheck[j] = true;
                }
            }
            if(sum >= totalSum){
                totalSum = sum;
                for(int j = 0; j < boxCheck.length; j++){
                    finalBoxes[j] = boxCheck[j];
                }
            }
            //System.out.println(allPossibleCombos[i]);
        }// for loop for all possible combos
        
        //Output the solution
        System.out.print("Boxes:");
        for(int i = 0; i < finalBoxes.length; i++){
            if(finalBoxes[i] == true)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.print("Max Apples:");
        System.out.println(totalSum);
        
    }//Main
}