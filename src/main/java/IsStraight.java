/**
 * @author zhj
 * 61.扑克牌中的顺子
 */
public class IsStraight {
    //从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。
//
//
//
// 示例 1:
//
// 输入: [1,2,3,4,5]
//输出: True
//
//
//
// 示例 2:
//
// 输入: [0,0,1,2,5]
//输出: True
//
//
//
// 限制：
//
// 数组长度为 5
//
// 数组的数取值为 [0, 13] .
// 👍 86 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            if (nums.length == 0) {
                return false;
            }
            int[] save = new int[19];
            for (int i = 0; i < nums.length; i++) {
                save[nums[i]] += 1;
            }
            int index = -1;
            for (int i = 1; i < save.length; i++) {
                if (save[i] > 0) {
                    index = i;
                    break;
                }
            }
            int flag = 0;
            int len = 5;
            while (len-- > 0) {
                if (save[index] > 0) {
                    flag++;
                } else if (save[0]-- == 0) {
                    return false;
                } else {
                    flag++;
                }
                if (flag == 5) {
                    return true;
                }
                index++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
