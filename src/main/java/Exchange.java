/**
 * @author zhj
 * 21.调整数组顺序使奇书位于偶数前
 */
public class Exchange {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//
//
//
// 示例：
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10000
//
// 👍 64 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int pre = 0;
            int nex = nums.length - 1;
            while (nex > pre) {
                //pre指向偶数
                while (nex > pre && (nums[pre] & 1) == 1) pre++;
                //nex指向奇数
                while (nex > pre && (nums[nex] & 1) == 0) nex--;
                swap(nums, pre, nex);
                pre++;
                nex--;
            }
            return nums;
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
