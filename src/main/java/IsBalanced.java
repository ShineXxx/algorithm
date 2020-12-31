import java.util.HashMap;

/**
 * @author zhj
 * 55 -2.平衡二叉树(自底向上,没有重复计算)
 */
public class IsBalanced {
    //输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
//
// 限制：
//
//
// 1 <= 树的结点个数 <= 10000
//
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
//
//
// Related Topics 树 深度优先搜索
// 👍 98 👎 0


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
        boolean ans = true;
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

        public boolean isBalanced(TreeNode root) {
            return recur(root) != -1;
        }

        private int recur(TreeNode root) {
            if (root == null) return 0;
            int left = recur(root.left);
            if (left == -1) return -1;
            int right = recur(root.right);
            if (right == -1) return -1;
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }


        public boolean isBalanced0(TreeNode root) {
            if (root == null) {
                return ans;
            }
            if (!ans) {
                return ans;
            }
            isBalanced(root.left);
            int res = maxDepth(root.left) - maxDepth(root.right);
            if (res > 1 || res < -1) {
                ans = false;
            }
            isBalanced(root.right);
            return ans;
        }

        int maxDepth(TreeNode node) {
            Integer dp = map.get(node);
            int res = 0;
            if (dp == null) {
                res = node == null ? 0 : Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
                map.put(node, res);
            } else {
                return dp;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
