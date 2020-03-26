package com.pngyul.string;

import java.util.Arrays;

public class String1 {

    //最长公共前缀，方法1
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)  // 字符串String的indexOf方法使用
                pre = pre.substring(0,pre.length()-1);

            if(pre.equals("")) return pre;
            i++;
        }
        return pre;
    }

    //最长公共前缀,方法2
    public static String longestCommonPrefix1(String[] strs) {
        if(strs == null ||strs.length == 0)
            return "";

        String ans = strs[0];
        for(int i = 1; i < strs.length;i++) {
            int j = 0;
            for( ; j < ans.length() && j < strs[i].length(); j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals("")) return ans;
        }

        return ans;
    }

    //最长公共字串
    public static int longestCommoSubString(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int result = 0;
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength][tLength];
        for (int i = 0; i < sLength; i++) {
            for (int k = 0; k < tLength; k++) {
                if (s.charAt(i) == t.charAt(k)) {
                    if (i == 0 || k == 0) {
                        dp[i][k] = 1;
                    } else {
                        dp[i][k] = dp[i - 1][k - 1] + 1;
                    }
                    result = Math.max(dp[i][k], result);
                } else {
                    dp[i][k] = 0;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {

//        String[] s = {"abaacvxxdgfdddfdfdfd","abaaxcdfdfdfd","abaaafdfdfdfd","abaadsdfdgfhff"};
//        System.out.println(longestCommonPrefix(s));

        System.out.println(longestCommoSubString("asdfghjklv","asdsgh0jk025"));
    }
}
