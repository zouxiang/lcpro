package medium;

import java.util.HashMap;
import java.util.Map;

/*
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

https://leetcode.com/articles/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s == null || "".equals(s)) return 0;
        char[] charArr = s.toCharArray();
        int startIdx = 0 , endIdx = 0;
        Map<Character, Integer> charMap = new HashMap();
        for(int i=0; i< charArr.length; i++) {
            endIdx = i;
            if(charMap.containsKey(charArr[i]) && charMap.get(charArr[i]) >= startIdx) {
                startIdx = charMap.get(charArr[i])+1;
            } else {
                if(endIdx - startIdx > result) result = endIdx - startIdx;
            }
            charMap.put(charArr[i], i);
        }
        return result+1;
    }
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("f;lajsdlfhkasf"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(""));
    }
}
