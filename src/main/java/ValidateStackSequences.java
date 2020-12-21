/**
 *
 */

import java.util.HashMap;
import java.util.Stack;

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
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int index = 0;
//        pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
            for (int i = 0; i < popped.length; i++) {
                int pop = popped[i];
                int push = 0;
                System.out.println("pop = " + pop);
                while (index < pushed.length) {
                    push = pushed[index++];
                    System.out.println("push = " + push);
                    System.out.println("index = " + index);
                    //先入栈
                    stack.push(push);
                    map.put(push, push);
                    if (push == pop) {
                        stack.pop();
                        break;
                    } else {
                        if (map.get(pop) == null) {
                            //pop没找到的时候,一直入栈
                        } else {
                            //pop找到后,出栈和push做比较
                            if (stack.pop() != pop) {
                                return false;
                            } else {
                                map.remove(pop);
                                break;
                            }
                        }
                    }
                }
                System.out.println("=======pop = " + pop);
                if (index == pushed.length) {
                    if (pop != stack.pop()) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
