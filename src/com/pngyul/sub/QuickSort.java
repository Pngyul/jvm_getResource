package com.pngyul.sub;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] a,int n){
        quickSortInternally(a, 0, n-1);
    }
    public static void quickSortInternally(int[] a,int p,int r){
        if(p >= r) return;

        int q = partition(a,p,r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);

    }

    public static int partition(int[] a,int p,int r){

        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j){
            if(a[j] < pivot){
                if(i == j){
                    ++i;
                }else{
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return  i;

    }


    public static void main(String[] args) {

        int[] a = new int[]{3,6,8,2,5,4};
        quickSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }


}
