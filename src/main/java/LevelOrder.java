import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhj
 * 32 - 1.从上到下打印二叉树
 */
public class LevelOrder {
    //从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
// 返回：
//
// [3,9,20,15,7]
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
// 👍 52 👎 0


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
        public int[] levelOrder(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() != 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            int[] res = new int[list.size()];
            int index = 0;
            for (Integer integer : list) {
                res[index++] = integer;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
