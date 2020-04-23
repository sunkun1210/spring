package com.example.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr={1,4,100,7,10,2,3,5,8,9};
        sort(arr,0,arr.length-1);
        print(arr);
    }

    static  void sort(int[] arr,int left,int right){
        if (left>=right){
            return;
        }
        //分成两半
        int mid = (left+right)/2;
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);
        merge(arr,left,mid+1,right);
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
     //   print(temp);
        for (int m=0;m<temp.length;m++){
            arr[leftPtr+m]=temp[m];
        }
    }


    static void merge2(int[] arr){
        int mid=arr.length/2;
        int temp[] = new int[arr.length];
        int i=0;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<arr.length){
            if (arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<arr.length){
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
