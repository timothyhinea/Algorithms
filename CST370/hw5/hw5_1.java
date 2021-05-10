/*
 * Title: hw5_1.java
 * Write a C++ (or Java) program called hw5_1.cpp (or hw5_1.java) to conduct heap operations. 
 * Author: Timothy Hinea
 * ID: 0001
 * Date: 04/8/2021
 */
import java.util.*;

class hw5_1 {
    
    public static class Heap{
        Scanner input = new Scanner(System.in);
         
        int heap[];
        String heapString = "";
        String [] words;
        String [] commands;
        String [] r;
        
        //The constructor will gather the input at set up the program
        Heap(){
            
            //------------gathing input----------
            heap = new int[input.nextInt() + 1];
            input.nextLine();
            
            heapString = input.nextLine();
            
            commands = new String[input.nextInt()];
            input.nextLine();
            for(int i = 0; i < commands.length; i++){
                commands[i] = input.nextLine();
            }
            
            //----------- setting up heap array -------
            words = heapString.split(" ", heap.length -1);
            for(int i = 1; i < heap.length; i++){
                heap[i] = Integer.parseInt(words[i-1]);
            }
            heapOpperations();
        }// Constructor
        
        //Main loop for program
        void heapOpperations(){
            
            if(isMaxHeap(1, heap.length))
                System.out.println("This is a heap.");
            else{
                System.out.println("This is NOT a heap.");
                buildHeap();
            }
            
            for(String command : commands){
               
                r = command.split(" ", 3);
                switch(r[0]){
                    case "displayMax" :
                        displayMax();
                        break;
                    case "insert" :
                        insert(Integer.parseInt(r[1]));
                        break;
                    case "deleteMax" :
                        deleteMax();
                        break;
                    case "delete" :
                        delete(Integer.parseInt(r[1]));
                        break;
                    case "update" :
                        update(Integer.parseInt(r[1]), Integer.parseInt(r[2]));
                        break;
                    case "display" :
                        display();
                        break;
                }
            }
        }//heapOpperations()
            //-----------Heap Opperation functions-----------
            void displayMax(){
                System.out.println(heap[1]);
            }
            
            void insert(int x){
                int[] heap2 = new int[heap.length + 1];
                for(int i = 0; i < heap.length; i++){
                    heap2[i] = heap[i];
                }
                heap = new int[heap2.length];
                for(int i = 0; i < heap.length; i++){
                    heap[i] = heap2[i];
                }
                heap[heap.length - 1] = x;
                
                buildHeap();
            }
           
            void deleteMax(){
                heap[1] = heap[heap.length -1];
                
                
                int[] heap2 = new int[heap.length - 1];
                for(int i = 0; i < heap.length -1; i++){
                    heap2[i] = heap[i];
                }
                heap = new int[heap2.length];
                for(int i = 0; i < heap.length; i++){
                    heap[i] = heap2[i];
                }
                
                buildHeap();
            }
            
            void delete(int x){
                for(int i = 0; i < heap.length; i++){
                    if(heap[i] == x){
                        int temp = heap[i];
                        heap[i] = heap[heap.length -1];
                        heap[heap.length -1] = temp;
                    }
                }
                
                int[] heap2 = new int[heap.length - 1];
                for(int i = 0; i < heap.length - 1; i++){
                    heap2[i] = heap[i];
                }
                heap = new int[heap2.length];
                for(int i = 0; i < heap.length; i++){
                    heap[i] = heap2[i];
                }
                
                buildHeap();
                
            }
            
            void update(int x, int y){
                heap[x] = y;
                buildHeap();
            }
            
            void display(){
                for(int i = 1; i < heap.length; i++)
                    System.out.print(heap[i] + " ");
                System.out.println();
            } 
            
            //------------Heap helper funcitons -----------
            
            void buildHeap(){
                for(int i = (heap.length/2); i >= 1; i--)
                {
                    heapify(heap.length, i);
                    
                }
            }
            
            void heapify(int n,int i){
                int largest = i;
                int left = 2*i;
                int right = (2*i)+1;
                
                if(left < n && heap[left] > heap[largest])
                   largest = left;
                
                if(right < n && heap[right] > heap[largest])
                   largest = right;
                 
                if(largest != i){
                    int temp = heap[i];
                    heap[i] = heap[largest];
                    heap[largest] = temp;
                    
                    heapify(n, largest);
                }
            }
            
            boolean isMaxHeap(int i, int n){
               
               int left = 2*i;
                int right = (2*i)+1;
                // System.out.println("i " + i);
                //  System.out.println("n " + n);
            //     System.out.println("i *Data" + heap[i]);
            //   System.out.println("i *left" + heap[i*2]);
            //   System.out.println("i Right" + heap[i*2+1]);
               if(i >= (n + 1)/2)
               {
                return true;
               }
                
               
               if(right > heap.length){
                    if(
                        heap[i] >= heap[left]
                        && heap[i] >= heap[right]
                        && isMaxHeap(left, n)
                        && isMaxHeap(right, n))
                    {
                        return true;
                    }
                }else{
                    if(
                        heap[i] >= heap[left]
                        && isMaxHeap(left, n)
                        && isMaxHeap(right, n))
                    {
                        return true;
                    }
                }
                return false;
            }
        
            // Prints commands
            void printCommands(){
                System.out.println("Commands: ");
                for(String i : commands)
                    System.out.println("          " + i + " ");
            }//print commands
    }// class
    
    public static void main(String[] args) {
    
    Heap heap = new Heap();
    }//Main
}