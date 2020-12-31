/**
 * 59 -1.滑动窗口的最大值(优化和队列)
 */
public class MaxSlidingWindow {
    //给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
// Related Topics 队列 Sliding Window
// 👍 165 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) {
                return new int[0];
            }
            // 双指针
            int l = 0;
            int r = l + k - 1;
            int max = nums[l];
            int[] res = new int[nums.length - k + 1];
            int index = 0;
            while (r < nums.length) {
                int x = getMax(nums, l, r);
                res[index++] = x;
                r++;
                l++;
            }
            return res;
        }

        int getMax(int[] arr, int l, int r) {
            int max = arr[l];
            for (int i = l; i <= r; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
