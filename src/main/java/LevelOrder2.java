/**
 * @author zhj
 * 32 - 2.从上到下打印二叉树
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder2 {
    //从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
//  [9,20],
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
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/
// Related Topics 树 广度优先搜索
// 👍 70 👎 0


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
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            List<Integer> levelList;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int sum = 0;
            while (queue.size() != 0) {
                levelList = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        levelList.add(node.val);
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
                if (queue.size() != 0) {
                    list.add(levelList);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
