package com.amaterasu.kyo.leetcode;

/**
 * @description:最大子序和 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @author: panchenlei
 * @create: 2020-03-30 19:54
 **/
public class MaximumSubarray {

    /**
     * 动态规划，也可用贪心算法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }

}
