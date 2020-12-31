/**
 * @author zhj
 * 53 -1.在排序数组中查找数字
 */
public class Search {
    //统计一个数字在排序数组中出现的次数。
//
//
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/
// Related Topics 数组 二分查找
// 👍 84 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }
            // 二分法查找
            int sum = 0;
            int start = 0;
            int end = nums.length - 1;
            int mid = (end - start + 1) / 2;
            while (start < end) {
                if (nums[mid] == target) {
                    break;
                }
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                mid = (end - start + 1) / 2 + start;
            }
            if (mid >= 0 && mid < nums.length && nums[mid] == target) {
                sum++;
                start = mid;
                while (--start >= 0) {
                    if (nums[start] == target) {
                        sum++;
                    } else {
                        break;
                    }
                }
                end = mid;
                while (++end < nums.length) {
                    if (nums[end] == target) {
                        sum++;
                    } else {
                        break;
                    }
                }
            } else {
                return 0;
            }
            return sum;
        }
    }
    class Solution1 {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }
            // 二分法查找
            int sum = 0;
            int start = 0;
            int end = nums.length - 1;
            int mid = (end - start + 1) / 2;
            while (start <= end) {
                if (nums[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                mid = (end - start + 1) / 2 + start;
            }
            if (mid >= 0 && mid < nums.length && nums[mid] == target) {
                sum++;
                end = mid;
                while (++end < nums.length) {
                    if (nums[end] == target) {
                        sum++;
                    } else {
                        break;
                    }
                }
            } else {
                return 0;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
