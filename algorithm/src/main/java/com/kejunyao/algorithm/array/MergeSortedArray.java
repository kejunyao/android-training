package com.kejunyao.algorithm.array;

import com.kejunyao.base.Solution;
import com.kejunyao.base.Utils;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 * @author kejunyao
 * @since 2021年02月11日
 */
public class MergeSortedArray implements Solution {


    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int max1 = nums1.length - 1;
        int index2 = n - 1;
        while (index2 >= 0) {
            if (index1 >= 0 && nums2[index2] < nums1[index1]) {
                nums1[max1--] = nums1[index1--];
            } else {
                nums1[max1--] = nums2[index2--];
            }
        }
        return nums1;
    }


    @Override
    public String getResult() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int[] array = merge(nums1, m, nums2, n);
        return Utils.toString(array);
    }


}
