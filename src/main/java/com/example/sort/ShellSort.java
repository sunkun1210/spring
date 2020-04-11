package com.example.sort;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr={0,111,5,9,10,2333,4,6,3,7,8,-3,9999};
        sort(arr);
        print(arr);
    }
    static  void sort(int[] arr){
        for (int gap=4;gap>0;gap/=2){
            /**希尔排序的间隔**/
            for (int i=gap;i<arr.length;i+=gap){
                insertN(arr,i,gap);
            }
        }
    }

    /**把前i个排成有序*/
    static  void insertN(int[] arr, int i,int gap){
        for(int j=i;j>gap-1;j=j-gap){
            if (arr[j]<arr[j-gap]){
                swap(arr,j,j-gap);
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
