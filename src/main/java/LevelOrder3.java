/**
 * @author zhj
 * 32 - 3.从上到下打印二叉树
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder3 {
    //请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//
//
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
// Related Topics 树 广度优先搜索
// 👍 60 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean flag = true;
            while (queue.size() != 0) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        level.add(node.val);
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
                if (!flag) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int i = level.size() - 1; i >= 0; i--) {
                        tmp.add(level.get(i));
                    }
                    level = tmp;
                }
                flag = !flag;
                if (queue.size() != 0) {
                    res.add(level);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
