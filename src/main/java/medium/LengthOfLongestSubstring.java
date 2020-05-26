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
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] charArr = s.toCharArray();
        int startIdx = 0 , endIdx = 0;
        Map<Character, Integer> charMap = new HashMap();
        for(int i=0; i< charArr.length; i++) {
            if(charMap.containsKey(charArr[i])) {
                startIdx++;
                charMap.put(charArr[i], i);
            } else {
                charMap.put(charArr[i], i);
                endIdx = i;
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
