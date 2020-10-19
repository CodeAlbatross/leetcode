package com.company;

public class Kmp {
    public int[] getnext(char[] str2){
        if(str2.length == 1 ) return new int[]{-1};
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while(i < str2.length){
            if(str2[i-1] == str2[cn]){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
    public int kmp(String haystack, String needle){
        if((haystack != null && haystack.equals(needle)) || (needle != null && needle.length() <1)){
            return 0 ;
        }
        if(haystack == null || needle == null){
            return -1;
        }
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int i1 = 0, i2 = 0;
        int[] next = getnext(chars2);
        while( i1 < chars1.length && i2 < chars2.length  ){
            if(chars1[i1] == chars2[i2]){
                i1++;
                i2++;
            }else{
                if(next[i2] == -1){
                    i1++;
                }else{
                    i2 = next[i2];
                }
            }
        }
        return i2 == chars2.length ? i1 - chars2.length : -1;
    }
}
