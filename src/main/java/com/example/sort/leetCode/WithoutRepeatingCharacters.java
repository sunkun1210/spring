package com.example.sort.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * https://blog.csdn.net/jackgo73/article/details/105310597
 */
public class WithoutRepeatingCharacters {

        public int lengthOfLongestSubstring1(String s) {
            if (s == null) {
                return 0;
            }
            Set<Character> charSet = new HashSet<>();
            int result = 0;
            int len = s.length();

            for (int i = 0; i < len; i++) {
                int curLen = 0;
                for (int j = i; j < len; j++) {
                    if (charSet.contains(s.charAt(j))) {
                        break;
                    }
                    charSet.add(s.charAt(j));
                    curLen++;
                }
                charSet.clear();
                result = Math.max(result, curLen);
            }

            return result;
        }

    public static void main(String[] args) {
       int max= lengthOfLongestSubstring2("abbac");
        System.out.println(max);
    }

        public static int lengthOfLongestSubstring2(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                } else {
                    /**出现重复了 右窗不动，左窗平移*/
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }

    /***
     * 遇到重复值没必要一个一个移动，左窗可以直接跳到str[重复值+1]的位置。
     * i是左窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    public int solution(String str){
        int max=0, from=0;
        Map<Character, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer position = positionMap.get(str.charAt(i));
            if(position == null){
                positionMap.put(str.charAt(i), i);
            }else{
                max = Math.max(max, positionMap.size());
                for(int j = from; j<=position; j++){
                    positionMap.remove(str.charAt(j));
                }
                positionMap.put(str.charAt(i), i);
                from = position + 1;
            }
        }
        return Math.max(max, positionMap.size());
    }
}
