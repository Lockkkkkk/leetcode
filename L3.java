//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//示例 1:
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。

import java.util.HashMap;

public class L3 {
    private static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if(hm.containsKey(s.charAt(i))) {
                result = Math.max(hm.get(s.charAt(i)) + 1, result);
            }
            max = Math.max(i- result +1, max);
            hm.put(s.charAt(i),i);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
