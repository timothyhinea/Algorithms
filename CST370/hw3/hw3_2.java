/*
 * Title: hw3_2.cpp
 * Abstract:Write a C++ (or Java) program called hw3_2.cpp (or hw3_2.java) 
 that reads an input graph data from a user first. Then, it should present a 
 path for the travelling salesman problem (TSP). In the assignment, you can 
 assume that the maximum number of vertices in the input graph is less than 
 or equal to 20.

 * Author: Timothy Hinea
 * ID: 0001
 * Date: 03/21/2021
 */

import java.util.*;

class hw3_2 {
    
    public static int arrAns[];
    
    public static String getSmallStrings(String s, int position){
        String [] words = s.split(" ", 3);
        if(position == 0){
            return words[0];
        
        }
        else if(position == 1){
            return words[1];
        }
        else{
            return words[2];
        }
    }
    
    public static int getIndex(String [] arr, String s){
        int a = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(s)){
                a = i;
                break;
            }
        }
        return a;
    }
    
    public static int Permute(int[] input, int startindex, int[][] graph, int ans) 
    {
       
        int size = input.length;
        int tem = 20000000;
        if (size == startindex + 1) 
        {
            
            tem = calcPerm(input, graph);
            if(tem < ans && tem != -1){
                for(int i = 0; i < size; i++)
                {
                    arrAns[i] = input[i] + 1;
                }
                ans = tem;
            }
            //System.out.println(ans);
            
        //   //System.out.println(calcPerm(input, graph) + "total calc for pern");
        //   for (int i = 0; i < size; i++) 
        //      {
        //          System.out.print(input[i] + "  ");
        //      }
        //      System.out.println();
        } 
        else 
        {
            for (int i = startindex; i < size; i++) 
            {
                int temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;
                
                tem = Permute(input, startindex + 1, graph, ans);
                temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;
                if(tem < ans)
                {
                    ans = tem;
                }
            }
        }
        //System.out.println(ans);
        return ans;
    }
    
    public static int calcPerm(int[] input,int[][] graph)
    {
        int ans = graph[0][input[0] + 1];
       // System.out.println(ans + "First spot");
        for (int i = 0; i < input.length; i++)
        {
            if(i < input.length -1){
                if(graph[input[i]+1][input[i+1]+1] == -1)
                {
                    return -1;
                }
                else{
                ans += graph[input[i]+1][input[i+1]+1];
                }
                //System.out.println(graph[input[i]+ 1][input[i+1]+ 1] + " " + ans + "amser");
            }
            else{
            if(graph[input[i]+1][0] == -1)
                {
                    return -1;
                }
                else{
                ans += graph[input[i]+ 1][0];
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
    
        // create an object of Scanner
        Scanner input = new Scanner(System.in);
        int v = 0, e = 0, ans = 20000000;
        
        //set up arrays
        v = input.nextInt();
        input.nextLine();
        String[] vertString = new String[v];
        int[][] graph = new int[v][v];
        int[] vertInt = new int[v - 1];
        arrAns = new int[v];

        //gather verticies names info
        for(int i =0; i < v; i++){
            vertString[i] = input.nextLine();
            if(i < v -1)
                vertInt[i] = i;
        }//gathering user input
        
         // set miltidimensional array to 0
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                graph[i][j] = -1;
            }
        }
        
        //get number of edges
        e = input.nextInt();
        input.nextLine();
        
        String[] edgesString = new String[e];
        
         //gather input for edges
        for(int i =0; i < e; i++){
            edgesString[i] = input.nextLine();
        }//gathering user input
        
         //fill up miltiarray with data
        for(int i = 0; i < e; i++){
            int a = 0, b = 0;
            a = getIndex(vertString, getSmallStrings(edgesString[i], 0));
            b = getIndex(vertString, getSmallStrings(edgesString[i], 1));
            
            graph[a][b] = Integer.parseInt(getSmallStrings(edgesString[i], 2));
        }
        
       ans = Permute(vertInt, 0, graph, ans);
       if(ans == 20000000 || e < v)
       {
           System.out.println("Path:");
           System.out.println("Cost:" + -1);
       }
       else
       {
            System.out.print("Path:" + vertString[0]);
            for(int i = 0; i < v; i++)
            {
                System.out.print("->");
                System.out.print(vertString[arrAns[i]]);
            }
                System.out.println();
               System.out.println("Cost:" + ans);
       }
        
       //to check if data is stored properly 
        //  for(int i = 0; i < v; i++){
        //     for(int j = 0; j < v; j++){
        //         System.out.print(graph[i][j]);
        //         System.out.print("\t");
        //     }
        //     System.out.println();
        // }
        
        
        
    }//Main
}