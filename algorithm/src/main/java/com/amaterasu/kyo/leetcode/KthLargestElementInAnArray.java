package com.amaterasu.kyo.leetcode;

import com.sun.javafx.logging.JFRInputEvent;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-04-02 12:51
 **/
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKthLargest(int[] nums, int i, int j, int k) {
        int p = i;
        for (; p <= j; p++) {
            if (nums[p] > nums[i]) break;
        }
        for (int l = p + 1; l <= j; l++) {
            if (nums[l] < nums[i]) {
                int tmp = nums[l];
                nums[l] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }
        int tmp = nums[p - 1];
        nums[p - 1] = nums[i];
        nums[i] = tmp;
        if (p - 1 == k) return nums[p - 1];
        if (p - 1 < k) return findKthLargest(nums, p, j, k);
        return findKthLargest(nums, i, p - 2, k);
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray test = new KthLargestElementInAnArray();
        int[] nums = new int[]{1};
        System.out.println(test.findKthLargest(nums, 1));
    }
}
