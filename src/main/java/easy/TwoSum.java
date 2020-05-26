package easy;


/*
1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

思路
最容易想到的就是暴力枚举，我们可以利用两层 for 循环来遍历每个元素，并查找满足条件的目标元素。不过这样时间复杂度为 O(N^2)，空间复杂度为 O(1)，时间复杂度较高，我们要想办法进行优化。我们可以增加一个 Map 记录已经遍历过的数字及其对应的索引值。这样当遍历一个新数字的时候去 Map 里查询，target 与该数的差值是否已经在前面的数字中出现过。如果出现过，那么已经得出答案，就不必再往下执行了。

关键点
求和转换为求差
借助 Map 结构将数组中每个元素及其索引相互对应
以空间换时间，将查找时间从 O(N) 降低到 O(1)

https://leetcode.com/articles/two-sum/

 */


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> counterpartMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int answer = target - nums[i];
            if(counterpartMap.containsKey(answer)) {
                result[0] = counterpartMap.get(answer);
                result[1] = i;
                return result;
            } else {
                counterpartMap.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(new int[] {2,7,11,15}, 9);
        System.out.println(result[0] +", " + result[1]);
    }
}
