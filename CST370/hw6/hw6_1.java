/*
 * Title: hw6_1.java
 * Write a C++ (or Java) program called hw6_1.cpp (or hw6_1.java) to conduct the radix sort. 
 * Author: Timothy Hinea
 * ID: 0001
 * Date: 04/17/2021
 */
import java.util.*;



class hw6_1 {
    public static class Radix{
        int size = 0;
        int maxDigits = 0;
        String s = "";
        String[] radix;
        
        Radix(int size, String s){
            this.size = size;
            this.s = s;
            setUpArray();
            radixSort();

        }
        
        void radixSort(){
            //set up the values array
            int[] values = new int[10];
            
            
            //main loop that runs for each digit
            for(int z = maxDigits -1; z >= 0; z--)
            {
                String[] outPut = new String[size];
            
                int temp = 'a';
                for(int i = 0; i < 10; i++)
                    values[i] = 0;
                
                //adds one to values array[i] for each number
                // whos lsb matches with i
                for(int i = 0; i < size; i++){
                    temp =  Integer.parseInt(String.valueOf(radix[i].charAt(z)));
                    values[temp]++;
                }
                
                //set the values of values to indexes of output array
                for(int i = 1; i < 10; i++){
                    values[i] += values[i-1];
                }
                
                //build the output array
                for(int i = size -1; i >= 0; i--)
                {
                    temp =  Integer.parseInt(String.valueOf(radix[i].charAt(z)));
                    outPut[values[temp] -1] = radix[i];
                    values[temp]--;
                   
                }
                
                //put output array back into radix array
                for(int i = 0; i < size; i++)
                {
                    radix[i] = outPut[i];
                }
                print();

            }
        }
        
        void setUpArray(){
            radix = s.split(" ", size);
            
            for(int i = 0; i < size; i++)
            {
                if(radix[i].length() > maxDigits)
                    maxDigits = radix[i].length();
            }
            for(int i = 0; i < size; i++){
               radix[i] = String.format("%"+ 0 + maxDigits +"d", Integer.parseInt(radix[i]));
            }
            
        }
        
        void print(){
            for(String i: radix){
                System.out.print(Integer.parseInt(i) + " ");
            }
            System.out.println();
        }
        
    }
    
    public static void main(String[] args) {
        
        String s = "";
        int size = 0;
        
        Scanner input = new Scanner(System.in);
        size = input.nextInt();
        input.nextLine();
        s = input.nextLine();
        
        Radix radix = new Radix(size, s);
    
    }//Main
}