/*
 * Title: hw2_3.cpp
 * Abstract: Write a program called hw2_3.cpp (or hw2_3.java) 
 that converts a directed graph data from a user into a 
 corresponding adjacency list format. Your program should 
 read an input graph data from a user. Then, your program 
 should convert it to the adjacency list format. In the 
 assignment, you can assume that the maximum number of 
 vertices in the input graph is less than or equal to 50.
 * Author: Timothy Hinea
 * ID: 0001
 * Date: 03/09/2021
 */
import java.util.*;

class hw2_3 {
    public static void main(String[] args) {
    
    
    // create an object of Scanner
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int e = input.nextInt();
        int a, b;
        input.nextLine();
        //Create an array
        int[][] arr0 = new int[v][v];
        String[] arr1 = new String[e];
        for(int i = 0; i < e; i++)
        {
            arr1[i] = input.nextLine();
        }//gathering user input
        
        // set miltidimensional array to 0
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                arr0[i][j] = 0;
            }
        }
        
        //fill up miltiarray with data
        for(int i = 0; i < arr1.length; i++){
            a = arr1[i].charAt(0) - 48;
            b = arr1[i].charAt(2) - 48;
            arr0[a][b] = 1;
        }
        
        for(int i = 0; i < v; i++){
            System.out.print(i);
            for(int j = 0; j < v; j++){
                if(arr0[i][j] == 1)
                {
                    System.out.print("->" + j);
                }
            }
            System.out.println();
        }
        
    }//Main
}