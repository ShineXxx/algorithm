/**
 * @author zhj
 * 17 打印从1到最大的n位数
 */
public class PrintNumbers {
    //输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1:
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
//
//
//
//
// 说明：
//
//
// 用返回一个整数列表来代替打印
// n 为正整数
//
// Related Topics 数学
// 👍 68 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int sum = 1;
            while (n-- > 0) {
                sum *= 10;
            }
            sum--;
            int[] res = new int[sum];
            for (int i = 0; i < sum; i++) {
                res[i] = i + 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
