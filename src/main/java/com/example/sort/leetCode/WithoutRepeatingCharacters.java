package com.example.sort.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WithoutRepeatingCharacters {


    public static void main(String[] args) {
        String strs="asad";
        char[]  c = strs.toCharArray();
        Map<Object,Integer> map = new HashMap<>();
        int max=0;
        for(int i=0;i<c.length;i++){
            int length=0;
            char str=c[i];
            for(int j=i;j<c.length;j++){
                if (!map.containsKey(c[j])||(map.containsKey(c[j])&&map.get(c[j])<length)){
                    length++;
                }else {
                    break;
                }
                if (length>max){
                    max=length;
                }
                map.put(str,length);
            }
        }
        System.out.println("  "+max);
    }
}
