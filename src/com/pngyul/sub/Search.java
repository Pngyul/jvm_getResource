package com.pngyul.sub;

public class Search {

    public static int search(int[] a,int n,int value){

        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = low+(high-low)/2;
            if(a[mid]>value){
                high = mid-1;
            }else if(a[mid]<value){
                low = mid+1;
            }else{
                if((mid == 0) || (a[mid-1] != value))
                    return mid;
                else high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] a = {2,3,5,8,9,9,9,9,9,9,11,15,19,20,25,25,25,26,28,90,100};
        int i = search(a, a.length, 16);
        System.out.println("该位置是："+i);
    }
}
