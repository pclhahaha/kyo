package com.amaterasu.kyo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-31 12:55
 **/
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 4; i++) {
            List<List<Integer>> list = fourSum(nums, i, target, 4);
            if (!list.isEmpty()) res.addAll(list);
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int s, int target, int n) {
        if (n == 1) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = s; i < nums.length; i++) {
                if (nums[i] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                }
            }
            return res;
        }
        List<List<Integer>> res = fourSum(nums, s + 1, target - nums[s], n - 1);
        if (res.isEmpty()) return res;
        for (List<Integer> list : res) {
            list.add(nums[s]);
        }
        return res;
    }
}
