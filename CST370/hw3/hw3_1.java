/*
 * Title: hw3_1.java
 * Abstract:Write a C++ (or Java) program named hw3_1.cpp (or hw3_1.java) which checks
 if an input string is a palindrome or not. In the problem, a palindrome means an 
 alphanumeric string which reads the same front to back. For the problem, you should 
 ignore case and remove all non-alphanumeric characters in the input string. For example, 
 "Race car", "I did, did I?", "7...8 Don't nod 87." are all palindromes. But "CSUMB" 
 is not a palindrome.

 * Author: Timothy Hinea
 * ID: 0001
 * Date: 03/21/2021
 */
import java.util.*;

class hw3_1 {
    
    public static String formatString(String s){
        char ch = 'a';
        String ret = "";
        for(int i = 0; i < s.length(); i++){
        ch = s.charAt(i);
         if (ch >= 'A' && ch <= 'Z')  
            ret += ch;
      
        else if (ch >= 'a' && ch <= 'z')  
            ret += ch;   
      
        else if (Character.isDigit(ch))
            ret+= ch;
        }
        return(ret.toUpperCase());
    }
    
    public static boolean isPal(String s, int first, int last){
        //base case for odd strings
        if(first == last)
            return true;
        if(!(s.charAt(first) == s.charAt(last)))
            return false;
        if(first > last) 
            return isPal(s, first + 1, last -1);
        //base case for even strings
        return true;
    }
    
    public static void main(String[] args) {
    
    // create an object of Scanner
        Scanner input = new Scanner(System.in);
        String s, outPut;
        
        s = input.nextLine();
        outPut = formatString(s);
        if(outPut.length() <= 0)
        {
            System.out.println(true);
        }
        else{
        
        if(isPal(outPut, 0, outPut.length() -1))
            System.out.println("TRUE");
         else
            System.out.println("FALSE");
        }
    }//Main
}