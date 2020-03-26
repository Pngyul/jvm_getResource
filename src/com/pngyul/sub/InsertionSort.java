package com.pngyul.sub;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] a,int n){

        if(n <= 1) return;

        for(int i = 1; i < n; ++i){
            int value = a[i];
            int j = i - 1;
            //查找插入位置
            for(; j >= 0; --j){
                if(a[j] > value) {
                    a[j+1] = a[j];//数据移动
                }else {
                    break;
                }
            }
            a[j+1] = value;//插入数据
        }

    }

    public static void main(String[] args) {

        int[] a = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        insertionSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
