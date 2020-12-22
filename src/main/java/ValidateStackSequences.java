/**
 * @Author zhj
 * @Description 31.栈的压入、弹出序列(臃肿)
 * @Date 23:23 2020/12/21
 **/

public class ValidateStackSequences {
    //输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
//
//
//
// 示例 1：
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//
//
// 示例 2：
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
//
//
//
//
// 提示：
//
//
// 0 <= pushed.length == popped.length <= 1000
// 0 <= pushed[i], popped[i] < 1000
// pushed 是 popped 的排列。
//
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
// 👍 103 👎 0
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean validateStackSequences0(int[] pushed, int[] popped) {
            if (pushed.length == 0) {
                return true;
            }
            int[] stack = new int[pushed.length];
            int stackIndex = -1;
            int left = 0;
            int right = 0;
//            pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
            while (left < pushed.length) {
                int chu = popped[right];
                if (stackIndex != -1) {
                    // pop符合时 出栈 继续匹配下一个pop
                    if (chu == stack[stackIndex]) {
                        stackIndex--;
                        if (++right == popped.length) {
                            break;
                        }
                    }
                }
                // pop不符合时 压入栈
                while (left < pushed.length) {
                    int jin = pushed[left++];
                    stack[++stackIndex] = jin;
                    if (jin == chu) {
                        break;
                    }
                }
            }
            return stackIndex == -1;
        }

        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed.length == 0) {
                return true;
            }
            int[] stack = new int[pushed.length];
            int stackIndex = -1;
            int left = 0;
            int right = 0;
//            pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
            while (left < pushed.length) {
                stack[++stackIndex] = pushed[left++];
                while (stackIndex != -1 && popped[right] == stack[stackIndex]) {
                    stackIndex--;
                    right++;
                }
            }
            return stackIndex == -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
