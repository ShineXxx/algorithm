/**
 * @author zhj
 * 15.二进制中1的个数
 */
public class HammingWeight {
    //请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入
//9，则该函数输出 2。
//
//
//
// 示例 1：
//
//
//输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
//
//
// 示例 2：
//
//
//输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
//
//
// 示例 3：
//
//
//输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
//
//
//
// 提示：
//
//
// 输入必须是长度为 32 的 二进制串 。
//
//
//
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/
// Related Topics 位运算
// 👍 72 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight0(int n) {
            int sum = (1 & n) == 1 ? 1 : 0;
            int res = 1;
            for (int i = 1; i <= 30; i++) {
                res = res << 1;
                if ((res & n) > 0) {
                    sum++;
                }
            }
            if ((0x80000000 & n) == 0x80000000) {
                sum++;
            }
            return sum;
        }

        public int hammingWeight1(int n) {
            int sum = 0;
            while (n != 0) {
                sum += n & 1;
                n >>>= 1;
            }
            return sum;
        }

        public int hammingWeight(int n) {
            int sum = 0;
            while (n != 0) {
                sum++;
                n &= n - 1;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}