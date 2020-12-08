/**
 * @Author zhj
 * @Description 找数组中重复的数字
 * @Date 10:03 2020/12/8
 **/
public class FindRepeatNumber {
//找出数组中重复的数字。
//
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表
// 👍 227 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            //HashMap or HashSet
            /**
             HashMap<Integer, Integer> map = new HashMap<>();
             for (int i = 0; i < nums.length; i++) {
             Integer res = map.get(nums[i]);
             if (res == null) {
             map.put(nums[i], nums[i]);
             } else {
             return res;
             }
             }
             return -1;
             **/
            //原地置换
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i) {
                    if (nums[i] == nums[nums[i]]) {
                        return nums[i];
                    } else {
                        swap(nums, nums[i], i);
                    }
                }

            }
            return -1;
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
