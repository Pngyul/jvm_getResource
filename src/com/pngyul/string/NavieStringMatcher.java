package com.pngyul.string;

public class NavieStringMatcher {
    public static void main(String[] args) {
        String T = "大数据决方案大数据应用解决方案提供！";
        String P = "大数据应用解决方案";
        NavieStringMatcher  nsm = new NavieStringMatcher();
        int index = nsm.BFMatcher(T, P);
        System.out.println("有效位移是： "+index);
    }


    //暴力法匹配
    public int BFMatcher(String master, String pattem){
        int n = master.length();
        int m = pattem.length();

        if(n < m) return -1;
        // 从主串开始比较
        for(int i = 0; i < n-m+1; ++i) {

            for(int j = 0; j < m; ++j) {
                if(master.charAt(i+j) != pattem.charAt(j)) {
                    break;
                }else {
                    if(j == m-1) {
                        return i;
                    }
                }
            }
        }
        return -1;  // 匹配不成功，返回-1
    }



    //反转字符串
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    //反转字符串，递归方法
    public void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }
    public void reverseString0(char[] s) {
        helper(s, 0, s.length - 1);
    }


    //字符串转数字
    public int myAtoi(String str) {
        int len = str.length();

        // 去除前导空格
        int index = 0;
        while (index < len) {
            if (str.charAt(index) != ' ') {
                break;
            }
            index++;
        }

        if (index == len) {
            return 0;
        }

        // 第 1 个字符如果是符号，判断合法性，并记录正负
        int sign = 1;
        char firstChar = str.charAt(index);
        if (firstChar == '+') {
            index++;
            sign = 1;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = str.charAt(index);
            // 判断合法性
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }

        return res;
    }
}
