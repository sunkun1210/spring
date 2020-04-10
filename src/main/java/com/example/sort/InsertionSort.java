package com.example.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr={0,1,5,9,10,2,4,6,3,7,8,-3};
        sort(arr);
        print(arr);
    }

    static  void sort(int[] arr){
        //把第i个牌插到i前面的位置上
        int temp = 0;
        int j;
        for (int i=0;i<arr.length;i++){
            for(j = i;j > 0;j--){
                if(arr[j]<arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    /**把第n个牌 插到前面的位置上*/
    static  void findMin(int[] arr, int n){
        for(int i=n;i>0;i--){
            if (arr[i]<arr[i-1]){
                swap(arr,i,i-1);
            }
        }
    }
    /**把第n个牌 插到前面的位置上*/
    static  void findMin2(int[] arr, int n){

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
