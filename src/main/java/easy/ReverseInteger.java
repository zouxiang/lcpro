package easy;

/*
7. Reverse Integer
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
[−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

import java.util.Stack;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return result;
        Stack<Integer> bitStack = new Stack<Integer>();
        boolean isNegative = x < 0 ? true : false;
        int tmp = Math.abs(x);
        int mod = 10;
        while (tmp > 9) {
            bitStack.push(tmp % mod);
            tmp = tmp / mod;
        }
        bitStack.push(tmp);
        int counter = 0;
        while (!bitStack.isEmpty()) {
            if (counter > 0) {
                result += bitStack.pop() * (int) Math.pow(10, counter);
            } else {
                result += bitStack.pop();
            }
            counter++;
        }
        result = isNegative ? -1 * result : result;
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(33471));
    }
}
