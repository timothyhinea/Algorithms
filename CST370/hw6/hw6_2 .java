/*
 * Title: hw6_2.java
 * Abstract:Write a C++ (or Java) program called hw6_2.cpp 
 * (or hw6_2.java) to collect maximum number of coins on an 
 * n x m board which was covered in the class. However, the 
 * board has several inaccessible cells in this problem. If 
 * you meet an inaccessible cell on the board, you cannot
 * move to the cell because it is not accessible.
 * Author: Timothy Hinea
 * ID: 0001
 * Date: 04/17/2021
 */

import java.util.*;

class hw6_2 {
    
    public static class Map{
        int rows, cols;
        String[] sRows;
         int[][] map;
         int maxCoins = 0;
         Path path;
         
         class Path{
             int cols = 0;
             int rows = 0;
             int maxCoins  = 0;
             int[][] map;
             
             ArrayList<Integer> path = new ArrayList<Integer> ();
             
             Path(int i, int j, int maxCoins){
                 this.rows = i;
                 this.cols = j;
                 this.maxCoins = maxCoins;
             }
             
             void pushPath(int i, int j){
                 if(i > 0 && j > 0)
                 {
                     path.add(i);
                     path.add(j);
                 }
             }
             
             void print()
             { 
                 System.out.println("Max coins:" + this.maxCoins);
                 System.out.print("Path:");
                 for(int i = path.size() -1; i >= 0; i -=2)
                 {
                     if(i == path.size() -1){
                     System.out.print(
                         "(" + path.get(i)
                         + "," + path.get(i-1)
                         + ")"
                         );
                     }else{
                         System.out.print(
                         "->(" + path.get(i)
                         + "," + path.get(i -1)
                         + ")"
                         );
                     }
                 }
             }
         }
        
        Map(){
            gatherInput();
            setUpMap();
            //print();
            traverse();
            backTrack();
            print();
        }
        
        void gatherInput(){
              // create an object of Scanner
            Scanner input = new Scanner(System.in);
            
            cols = input.nextInt() + 1;
            rows = input.nextInt() + 1;
            input.nextLine();
            sRows = new String[rows];
           
            for(int i = 1; i < rows; i++)
                sRows[i] = input.nextLine();
        }
        
        void setUpMap(){
            map = new int[rows][cols];
            for(int i= 1; i < rows; i++)
            {
                String[] s = sRows[i].split(" ", cols);
                for(int j = 1; j < cols; j++)
                {
                    map[i][j] = Integer.parseInt(s[j-1]);
                }
            }
            
        }
        
        void traverse(){
            for(int i= 1; i < rows; i++)
            {
                for(int j = 1; j < cols; j++)
                {
                    //---Check if square is inaccessible
                    if(i-1 == 0 && map[i][j-1] == -1)
                        map[i][j] = -1;
                        
                    if(map[i-1][j] == -1 && map[i][j-1] == -1)
                        map[i][j] = -1;
                    
                    // -- Find best backwords path
                    if(map[i-1][j] < map[i][j-1]){
                        if(map[i][j] <= map[i][j-1]){
                            if(map[i][j] != -1)
                                map[i][j] += map[i][j-1];
                        }
                    } else {
                        if(map[i][j] <= map[i-1][j]){
                            if(map[i][j] != -1)
                                map[i][j] += map[i-1][j];
                        }
                    }
                }
            }
            maxCoins = map[rows-1][cols-1];
        }
        
        void backTrack(){
            path = new Path(rows, cols, maxCoins);
            int i = rows -1;
            int j = cols -1;
            path.pushPath(i,j);
            while(i > 0 && j > 0)
            {
                if(map[i-1][j] > map[i][j-1]){
                    path.pushPath(i-1,j);
                    i--;
                    
                }
                else{
                    path.pushPath(i, j-1);
                    j--;
                }
            }
            
            if(i == 1)
                j--;
            else
                i--;
            while(i > 0)
            {
                path.pushPath(i,j+1);
                i--;
            }
            
             while(j > 0)
            {
                path.pushPath(i+1,j);
                j--;
            }
        }
    
        
        public void print(){
            // System.out.println();
            //  for(int i= 1; i < rows; i++)
            // {
            //     for(int j = 1; j < cols; j++)
            //     {
            //         System.out.print(map[i][j]+ " ");
            //     }
            //     System.out.println();
            // }
                path.print();
        }
        
    }
    
    
    public static void main(String[] args) {
    
       Map map = new Map();
       
    }//Main
}