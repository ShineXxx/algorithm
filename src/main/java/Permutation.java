/**
 * @Author zhj
 * @Description 38.字符串的排列
 * @Date 15:25 2020/12/27
 **/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation {
    //输入一个字符串，打印出该字符串中字符的所有排列。
//
//
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//
//
//
// 限制：
//
// 1 <= s 的长度 <= 8
// Related Topics 回溯算法
// 👍 151 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        char[] chars = null;

        public String[] permutation(String s) {
            // 回溯
            chars = s.toCharArray();
            dfs(0);
            return res.toArray(new String[0]);
        }

        void dfs(int x) {
            if (x == chars.length - 1) {
                res.add(new String(chars));
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for (int i = x; i < chars.length; i++) {
                if (set.contains(chars[i])) {
                    continue;
                }
                set.add(chars[i]);
                swap(i, x);
                dfs(x + 1);
                swap(i, x);
            }
        }

        void swap(int i, int j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
