import java.util.ArrayList;
import java.util.List;

/**
 * @author zhj
 * 57 -2.和为s的连续正数序列
 */
public class FindContinuousSequence {
    //输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//
//
// 示例 1：
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
//
//
// 示例 2：
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
//
//
//
//
// 限制：
//
//
// 1 <= target <= 10^5
//
//
//
// 👍 194 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 1; i < target; i++) {
                int sum = 0;
                tmp = new ArrayList<>();
                for (int j = i; j < target; j++) {
                    if (sum < target) {
                        tmp.add(j);
                        sum += j;
                    } else if (sum > target) {
                        break;
                    } else {
                        res.add(tmp);
                        break;
                    }
                }
            }
            int[][] ans = new int[res.size()][0];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = new int[res.get(i).size()];
                for (int j = 0; j < res.get(i).size(); j++) {
                    ans[i][j] = res.get(i).get(j);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
