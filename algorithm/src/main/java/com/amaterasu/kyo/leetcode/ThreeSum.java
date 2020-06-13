package com.amaterasu.kyo.leetcode;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-31 13:11
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    while (k > j && nums[j + 1] == nums[j]) ++j;
                    while (k > j && nums[k - 1] == nums[k]) --k;
                    j++;
                    k--;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(JSON.toJSONString(threeSum.threeSum(nums)));
    }
}

