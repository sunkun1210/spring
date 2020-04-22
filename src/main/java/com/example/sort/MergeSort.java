package com.example.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr={1,4,7,8,3,6,9};
        sort(arr);

    }

    static  void sort(int[] arr){
        merge(arr,1,4,5);
    }

    /***
     * 两个半截数组已经排好序的情况下
     * 把他们合并到一起
     * 指定整个数组不够灵活，增加参数
     * @param arr
     */
    static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound){
        int mid=rightPtr-1;
        int temp[] = new int[rightBound-leftPtr+1];
        int i=leftPtr;
        int j=rightPtr;
        int k=0;
        while (i<=mid&&j<=rightBound){
            if (arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=rightBound){
            temp[k++] =arr[j++];
        }
        print(temp);
    }
    static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
