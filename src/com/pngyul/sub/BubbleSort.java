package com.pngyul.sub;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] a,int n){

        if(n<=1) return;

        for (int i=0;i<n;i++){
            //提前退出冒泡循环的标志位
            boolean flag=false;
            for (int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){ //交换
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                    flag=true;//表示有数据交换
                }

            }
            if(!flag) break; //没有数据交换，提前退出循环
        }
    }

    public static void main(String[] args) {

        int[] a={5,19,58,12,6,6,32,36,15,1,1,9,6};
        bubbleSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }


}
