/**
 * @author zhj
 * 57.和为s的两个数
 */
public class TwoSum {
    //输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//
//
//
// 示例 1：
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
//
//
// 示例 2：
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
//
//
//
//
// 限制：
//
//
// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^6
//
// 👍 62 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 双指针
            int l = 0;
            int r = nums.length - 1;
            int mid = 0;
            while (l <= r) {
                mid = (l + r + 1) / 2;
                if (nums[mid] >= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            l = 0;
            r = nums.length - 1;
            while (l <= r) {
                while (nums[r] + nums[l] < target) {
                    l++;
                }
                if (nums[r] + nums[l] == target) {
                    return new int[]{nums[r], nums[l]};
                } else {
                    r--;
                }
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
