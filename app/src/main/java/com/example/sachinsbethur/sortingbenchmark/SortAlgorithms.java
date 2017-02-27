package com.example.sachinsbethur.sortingbenchmark;

/**
 * Created by Sachin S Bethur on 5/17/2016.
 */

public class SortAlgorithms {
    // Method For Bubble Sort
    public static int[] BubbleSort(int[] array){
        int j;
        int temp;
        boolean flag=false;
        while ( flag )
        {
            flag= false;
            for( j=0;j<array.length-1;j++ )
            {
                if ( array[j] < array[j+1] )
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
        }
        return array;
    }
    //Method for Merge Sort
    public static int[] MergeSort(int array[]){
        if(array.length > 1){
            int elementsInA1 = array.length/2;
            int elementsInA2 = elementsInA1;
            if((array.length % 2) == 1)
                elementsInA2 += 1;
            int arr1[] = new int[elementsInA1];
            int arr2[] = new int[elementsInA2];
            for(int i = 0; i < elementsInA1; i++)
                arr1[i] = array[i];
            for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
                arr2[i - elementsInA1] = array[i];
            arr1 = MergeSort(arr1);
            arr2 = MergeSort(arr2);
            int i = 0, j = 0, k = 0;
            while(arr1.length != j && arr2.length != k)
            {
                if(arr1[j] < arr2[k])
                {
                    array[i] = arr1[j];
                    i++;
                    j++;
                }
                else
                {
                    array[i] = arr2[k];
                    i++;
                    k++;
                }
            }
            while(arr1.length != j)
            {
                array[i] = arr1[j];
                i++;
                j++;
            }
            while(arr2.length != k)
            {
                array[i] = arr2[k];
                i++;
                k++;
            }
        }
        return array;
    }
    //Method for Selection Sort
    public static int[] SelectionSort(int array[]){
        int j;
        for(int i = 0;i<array.length-1;i++) {
            int minPos = i;
            for (j = i + 1; j < array.length-1; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
    //Method for Quick Sort
    public static int[] quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return arr;
        if (low >= high)
            return arr;
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);

        return arr;
    }

    //Method for Heap Sort Algorithm
    private static int N;
    public static int[] heapSort(int arr[]){
        heapify(arr);
        for (int i = N; i > 0; i--){
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
        return arr;
    }
    public static void heapify(int arr[]){
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);
    }
    //Function to swap largest element in heap
    public static void maxheap(int arr[], int i){
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;
        if (max != i){
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }
    //Function to swap two numbers in an array
    public static void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    // Binary Search
    public static int binarySearch(int[] inputArr, int key) {

        int start = 0;
        int end = inputArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(key == inputArr[mid]){
                return mid;
            }
            if(key < inputArr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public static int[] InsertionSort(int array[]){
        int n = array.length;
        for (int j=1;j<n;j++){
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
        return array;
    }

}
