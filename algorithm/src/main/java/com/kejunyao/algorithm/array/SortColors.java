package com.kejunyao.algorithm.array;

import com.kejunyao.algorithm.Solution;
import com.kejunyao.algorithm.Utils;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 *
 * @author kejunyao
 * @since 2021年02月11日
 */
public class SortColors implements Solution {

    public int[] sortColors(int[] nums) {
        return nums;
    }

    @Override
    public String getResult() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        return Utils.toString(sortColors(nums));
    }
}
