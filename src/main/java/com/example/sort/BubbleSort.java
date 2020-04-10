package com.example.sort;

public class BubbleSort {


    public static void main(String[] args) {
        int[] arr={0,1,5,9,10,2,4,6,3,7,8,-3};
        sort(arr);
        print(arr);
    }
    static  void sort(int[] arr){
        /**arr.length-1 这里需要减去1  不减会报错数组月结**/
        for(int i=arr.length-1;i>0;i--){
            findMax(arr,i);
        }
    }

    /**n个位置上 找最大那数*/
    static  void findMax(int[] arr, int n){
        for (int i=0;i<n;i++) {
            if (arr[i]>arr[i+1]){
                swap(arr,i,i+1);
            }
        }
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
