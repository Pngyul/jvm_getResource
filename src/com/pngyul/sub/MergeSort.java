package com.pngyul.sub;

import java.util.Arrays;

public class MergeSort {
    public static void MergeSort(int[] a,int n){
        mergeSortInternally(a,0,n-1);
    }

    private static void mergeSortInternally(int[] a,int p,int r){
        //递归终止条件
        if(p >= r) return;

        //去p...r的中间位置
        int q = p + (r - p)/2;

        //分治递归
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a,p,q,r);
    }

    private static void merge(int[] a,int p,int q,int r){

        int i = p;
        int j = q + 1;
        int k = 0;  //初始化变量i，j,k

        //申请一个大小跟a[p...r]一样的临时数组
        int[] tmp = new int[r-p+1];

        while(i<=q && j<=r){
            if(a[i] < a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        //判断哪个子数组中有数据剩余
        int start = i;
        int end = q;
        if(j <= r){
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end){
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for(i = 0; i <= r-p; ++i){
            a[p+i] = tmp[i];
        }


    }

    public static void main(String[] args) {

        int[] a = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        MergeSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
