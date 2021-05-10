/*
 * Title: hw5_2.java
 * Abstract:Write a C++ (or Java) program named hw5_2.cpp 
 (or hw5_2.java) that displays the performance of three 
 different sorting algorithms (= heap sort, merge sort, 
 and quick sort) on the screen. 
 *Used code from https://www.geeksforgeeks.org/merge-sort/
 * Used code from https://www.geeksforgeeks.org/quick-sort/
 * Author: Timothy Hinea
 * ID: 0001
 * Date: 04/8/2021
 */

import java.util.*;

class hw5_2 {
    
    public static class Heap{
        Scanner input = new Scanner(System.in);
        
        int sizee;
        int heap[];
        
        //The constructor will gather the input at set up the program
        Heap(int size, int[] input){
            sizee = size;
            heap = new int[size];
            
            for(int i =0; i < size; i++){
                heap[i] = input[i];
            }
            buildHeap();
        }// Constructor
        
            public int[] heapSort(){
                int[] arr1 = new int[sizee];
                for(int i = 0; i < sizee; i++)
                {
                    arr1[i] = deleteMax();
                }
                return arr1;
            }
                       
            int deleteMax(){
                int ret = 0;
                if(heap.length > 1){
                    ret = heap[1];
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
                    return ret;
                }
                return ret;
            }
            
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
            
            void display(){
                for(int i = 1; i < heap.length; i++)
                    System.out.print(heap[i] + " ");
                System.out.println();
            } 
            
           
    }// class
    
    /* Java program for Merge Sort */
    public static class MergeSort{
        // Merges two subarrays of arr[].
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]
        void merge(int arr[], int l, int m, int r)
        {
            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;
     
            /* Create temp arrays */
            int L[] = new int[n1];
            int R[] = new int[n2];
     
            /*Copy data to temp arrays*/
            for (int i = 0; i < n1; ++i)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];
     
            /* Merge the temp arrays */
     
            // Initial indexes of first and second subarrays
            int i = 0, j = 0;
     
            // Initial index of merged subarry array
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                }
                else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
     
            /* Copy remaining elements of L[] if any */
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
     
            /* Copy remaining elements of R[] if any */
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
     
        // Main function that sorts arr[l..r] using
        // merge()
        void sort(int arr[], int l, int r)
        {
            if (l < r) {
                // Find the middle point
                int m =l+ (r-l)/2;
     
                // Sort first and second halves
                sort(arr, l, m);
                sort(arr, m + 1, r);
     
                // Merge the sorted halves
                merge(arr, l, m, r);
            }
        }
     
        /* A utility function to print array of size n */
        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    
    }
    /* This code is contributed by Rajat Mishra */
        
        
    public static class QuickSort{
        
            // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {
         
        // pivot
        int pivot = arr[high];
         
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
     
        for(int j = low; j <= high - 1; j++)
        {
             
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {
                 
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
     
    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
             
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
     
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
         
    }
     // This code is contributed by Ayush Choudhary  
    
    
    public static void main(String[] args) {
    
        // create an object of Scanner
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        long start;
        long end; 
        long heapTime, mergeTime= 0, quickTime=0;
        
        //set up arrays
        System.out.print("Enter input size: ");
        int v = input.nextInt();
        int[] arr = new int[v];
        int[] arr1 = new int[v];
        
        for(int i = 0; i < v; i++)
        {
            arr[i] = rand.nextInt(v) & Integer.MAX_VALUE;
            arr1[i] = arr[i];
        }
        
        Heap heap = new Heap(v, arr);
        //heap sort
        start = System.currentTimeMillis();
        heap.heapSort();   // some time passes
        end = System.currentTimeMillis();
        heapTime = end - start;
        
        
        
        //merge sort
        MergeSort ob = new MergeSort();
        start = System.currentTimeMillis();
        ob.sort(arr, 0, arr.length - 1);
        end = System.currentTimeMillis();
        mergeTime = end - start;
        
        QuickSort quick = new QuickSort();
        start = System.currentTimeMillis();
        quick.quickSort(arr1, 0, arr1.length - 1);
        end = System.currentTimeMillis();
        quickTime = end - start;

        
        System.out.println("===================== Execution Time ====================");
        System.out.print("Heap sort:    ");
        System.out.print(heapTime);
        System.out.println("miliseconds");
        System.out.print("Merge sort:   ");
        System.out.print(mergeTime);
        System.out.println("miliseconds");
        System.out.print("Quick sort:   ");
        System.out.print(quickTime);
        System.out.println("miliseconds");
        System.out.println("=========================================================");
       
        
        // for(int i: arr){
        //     System.out.println(i);
        // }
        
    }//Main
}