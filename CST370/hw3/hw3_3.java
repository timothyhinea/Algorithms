/*
 * Title: hw3_3.cpp
 * Abstract: Write a C++ (or Java) program called hw3_3.cpp (or hw3_3.java) 
 that implements the Depth-First Search (DFS) algorithm using a stack 
 and a mark array as you learned in the class. 

 * Author: Timothy Hinea
 * ID: 0001
 * Date: 03/21/2021
 */
import java.util.*;


class hw3_3 {
    public static int counter = 1;
    public static int[][]graph; 
    public static int[] visited;
    
    public static void dfs(int w)
{
    for(int i = 0; i < visited.length; i++){
        // System.out.print(w + "w");
        if(visited[i] == 0 && graph[w][i] != 0 && w != i)
        {
            
            visited[i] = counter++;
           // System.out.println(graph[w][i]);
            //System.out.println(w + "w" + i + "i" + counter + "counter");
            dfs(i);
        }
    }
}
    
    
    public static void main(String[] args) {
    
    
     // create an object of Scanner
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int e = input.nextInt();
         int a, b;
        input.nextLine();
        //Create an array
        graph = new int[v][v];
        visited = new int[v];
        String[] arr1 = new String[e];
        for(int i = 0; i < e; i++)
        {
            arr1[i] = input.nextLine();
        }//gathering user input
        
        // set miltidimensional array to 0
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                graph[i][j] = 0;
            }
        }
        
        //fill up miltiarray with data
        for(int i = 0; i < arr1.length; i++){
            a = arr1[i].charAt(0) - 48;
            b = arr1[i].charAt(2) - 48;
            graph[a][b] = 1;
        }
        
        dfs(0);
        
        for(int i = 0; i < visited.length; i++)
        {
            System.out.println("Mark[" + i + "]:" + (visited[i]+ 1));
        }
        
        
        //print out in correct format
    
    }//Main
}
