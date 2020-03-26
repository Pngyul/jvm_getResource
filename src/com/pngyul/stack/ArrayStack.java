package com.pngyul.stack;

//// 基于数组实现的顺序栈
public class ArrayStack {
    private String[] items; //数组
    private int count; //栈中元素的个数
    private int n; //栈的大小

    public ArrayStack(int n){
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    //入栈操作
    public boolean push(String item) {
        //数组空间不够了，直接返回false,入栈失败
        if(count == n) return  false;
        //将item放到count的位置，并且count+1
        items[count] = item;
        ++count;
        return true;
    }

    //出栈操作
    public String pop(){
        //栈为空，直接返回null
        if(count == 0) return null;
        //返回栈顶元素，并且count-1
        String tmp = items[count-1];
        --count;
        return  tmp;
    }
}
