/**
 * @author zhj
 * 34.二叉树中和为某一值的路径
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum {
    //输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
//
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 10000
//
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
// Related Topics 树 深度优先搜索
// 👍 112 👎 0


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

        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> path = new Stack<Integer>();

        public List<List<Integer>> pathSum0(TreeNode root, int sum) {
            if (root == null) {
                return res;
            }
            dfs(root, sum, 0);
            return res;
        }

        // 递归 深度优先遍历
        void dfs(TreeNode node, int sum, int count) {
            if (node == null) {
                return;
            }
            count += node.val;
            path.add(node.val);
            if (count == sum) {
                if (node.left == null && node.right == null) {
                    res.add(new ArrayList<>(path));
                }
            }
            dfs(node.left, sum, count);
            dfs(node.right, sum, count);
            path.pop();
        }

        // 栈 深度优先遍历
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            Stack<Integer> sumList = new Stack<>();
            stack.push(root);
            int count = 0;
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
