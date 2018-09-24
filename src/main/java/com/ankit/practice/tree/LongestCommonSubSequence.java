package com.ankit.practice.tree;

public class LongestCommonSubSequence {
    private static int[][] nm;
    public static void main(String[] args) {
        String str1 = "ABC";
        String str2 = "AC";
nm = new int[str1.length()][str2.length()];
        int no = LCS(str1, str2, str1.length() -1 , str2.length() -1);
        System.out.println(no);
    }


    private static int LCS(String s1, String s2, int n, int m) {
        int result = 0;
        if(n == -1 || m == -1 ) return 0;
        if(nm[n][m] != 0) return nm[n][m];

        else if(s1.charAt(n ) == s2.charAt(m )){
            result = 1+ LCS(s1, s2, n-1 , m-1 );
        } else {
            int left = LCS(s1,s2,n-1,m);
            int right = LCS(s1,s2, n, m-1);
            result = left > right ? left : right;
        }
        nm[n][m] = result;
        return result;
    }
}
