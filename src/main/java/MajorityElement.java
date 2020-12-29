/**
 * @Author zhj
 * @Description 39.数组中出现次数超过一半的数字
 * @Date 19:04 2020/12/27
 **/

import java.util.HashMap;

public class MajorityElement {
    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
//
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
//
//
// Related Topics 位运算 分治算法
// 👍 97 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int vote = 0;
            int x = 0;
            for (int num : nums) {
                if (vote == 0) {
                    x = num;
                }
                vote += num == x ? 1 : -1;
            }
            return x;
        }

        public int majorityElement0(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                Integer res = map.get(num);
                if (res == null) {
                    res = 0;
                } else {
                    res++;
                }
                map.put(num, res);
                if (res >= nums.length / 2) {
                    return num;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
