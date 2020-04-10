package com.example.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr={0,1,5,9,10,2,4,6,3,7,8,-3};
        sort(arr);
        print(arr);
    }

    static  void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minPos=i; // 随着i的变化而变化
            for(int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minPos]){//这个时候 minPos要更新
                    minPos=j;
                }
            }
            swap(arr,i,minPos);
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
