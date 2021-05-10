/*
 * Title: hw4_3.cpp
 * Abstract: Write a C++ (or Java) program called hw4_3.cpp 
 (or hw4_3.java) that conducts the topological sorting based 
 on the Kahns algorithm covered in the class. 
 * Author: Timothy Hinea
 * ID: 0001
 * Date: 04/3/2021
 */
import java.util.*;

class hw4_3 {
    public static class Graph{
    
        Scanner input = new Scanner(System.in);
        int v, e, a, b;

        //Create an array
        int counter = 1;
        int[][]graph;
        Vector<Integer>order;
        Queue<Integer> que;
        int[]inDegree;
        String[] arr1;
        
        
        public Graph(){
            v = input.nextInt();
            e = input.nextInt();
            input.nextLine();
            
            graph = new int[v][v];
            inDegree = new int[v];
            arr1 = new String[e];
            order = new Vector<Integer>(v);
            que = new LinkedList<Integer>();
            for(int i = 0; i < e; i++)
            {
                arr1[i] = input.nextLine();
            }//gathering user input
            setData();
        }
        
        private void setData(){
                // set miltidimensional array to 0
            for(int i = 0; i < v; i++){
                for(int j = 0; j < v; j++){
                    graph[i][j] = -1;
                }
            }
            
            //fill up miltiarray with data
            for(int i = 0; i < arr1.length; i++){
                a = arr1[i].charAt(0) - 48;
                b = arr1[i].charAt(2) - 48;
                graph[a][b] = 1;
            }
            
            
            //Initialize inDegree with proper elemtns
            for(int i = 0; i < v; i++){
                for(int j = 0; j < v; j++){
                    if(graph[j][i] != -1)
                        inDegree[i]++;
                }
            }
            printInDegree();
            
            //Initialize que with first verts
            for(int i = 0; i < inDegree.length; i++){
                if(inDegree[i] == 0){
                    que.add(i);
                }
            }
        }
        
        public void topologicalSort(){
            
            int cnt = 0;
            while(!que.isEmpty()){
                int u = que.poll();
                order.add(u);
                
                
                
                for(int i = 0; i < v; i++){
                    if(graph[u][i] != -1)
                    {
                        inDegree[i]--;
                        if(inDegree[i] == 0){
                            que.add(i);
                        }
                    }
                }//for loop
                cnt++;
            }// while loop
            if(cnt != v){
                System.out.println("No Order:");
            }
            else
                printOrder();
            
        }// funciton
        
        public void printInDegree(){
            for(int i = 0; i < inDegree.length; i++){
             System.out.println("In-degree[" + i + "]:" + inDegree[i]);
            }
        }
        
        void printQue(){
            System.out.print("QUEUE: ");
            //System.out.println(que.isEmpty());
            for(int o : que){
                System.out.print(o+"->");
            }
             System.out.println();
        }
    
        void printOrder(){
            int stuff = 0;
            System.out.print("Order:"); 
            for(int i: order){
                if(stuff == 0){
                    System.out.print(i);
                    stuff++;
                }
                else
                    System.out.print("->" +i);
            }
        }   
        
        void printGraph(){
            for(int i = 0; i < v; i++){
                for(int j = 0; j < v; j++){
                    System.out.print(graph[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
    
        Graph graph = new Graph();
        graph.topologicalSort();
    }//Main
}
