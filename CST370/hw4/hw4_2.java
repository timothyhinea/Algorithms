/*
 * Title: hw4_2.cpp
 * Abstract:Write a C++ (or Java) program named hw4_2.cpp 
 (or hw4_2.java) which displays the biggest number in an 
 array with n integer numbers using a divide-and-conquer 
 technique. For example, if your algorithm has an input 
 array such as 1, 3, 11, 7, 5, 6, 4, 9, your algorithm 
 should display 11.


 * Author: Timothy Hinea
 * ID: 0001
 * Date: 04/3/2021
 */

import java.util.*;

class hw4_2 {

public static int dAndC(int [] arr, int first, int last)
{


    if (first == last) 
    {
        return arr[first];
    }
    else 
    {
        int a = dAndC (arr, first, (first+last)/2);
        int b = dAndC (arr, (first+last)/2+1, last);
        return Math.max(a,b);
    }

}
    
    public static void main(String[] args) {
    
        // create an object of Scanner
        Scanner input = new Scanner(System.in);
        
        //set up arrays
        int v = input.nextInt();
        input.nextLine();
        String s = input.nextLine();
        int[] arr = new int[v];
        String [] words = s.split(" ", v);

        //fill array from string
        for(int i =0; i < v; i++){
            arr[i] = Integer.parseInt(words[i]);
         
        }//gathering user input
        
        System.out.println(dAndC(arr, 0, v - 1));
    }//Main
}