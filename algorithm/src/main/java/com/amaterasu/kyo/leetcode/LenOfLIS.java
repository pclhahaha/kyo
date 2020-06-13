package com.amaterasu.kyo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: panchenlei
 * @create: 2020-03-14 20:07
 **/
public class LenOfLIS {

    /**
     * 思路是动态规划，应该还有更优解
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] tmpBest = new int[len];
        for (int i = 1; i < len; i++) tmpBest[i] = 0;
        tmpBest[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && tmpBest[i] < tmpBest[j] + 1) {
                    tmpBest[i] = tmpBest[j] + 1;
                } else if (nums[j] >= nums[i] && tmpBest[i] == 0) {
                    tmpBest[i] = 1;
                }
            }
        }
        int max = 0;
        for (int tmpMax : tmpBest) {
            if (max < tmpMax) max = tmpMax;
        }
        return max;
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] tmpBest = new int[nums.length + 1];
        tmpBest[1] = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tmpBest[length]) tmpBest[++length] = nums[i];
            else {
                int start = 1, end = length, pos = 0;
                while (start <= end) {
                    int mid = (start + end) >> 1;
                    if (tmpBest[mid] < nums[i]) {
                        pos = mid;
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                tmpBest[pos + 1] = nums[i];
            }
        }
        return length;
    }

    public static void main(String[] args) {
//        int[] num = {1, 3, 6, 7, 9, 4, 10, 5, 6};
//        int[] num = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] num = {4,10,4,3,8,9};
        int[] num = {0};
        System.out.println(lengthOfLIS2(num));
    }
}
