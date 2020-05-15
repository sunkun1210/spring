package com.example.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr={0,1,5,9,10,2,4,6,3,7,8,-3};
        sort(arr);
        print(arr);
    }

    static  void sort(int[] arr){

    }

    static  void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
