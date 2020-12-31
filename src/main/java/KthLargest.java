/**
 * @author zhj
 * 54.二叉搜索树的第k大节点
 */
public class KthLargest {
    //给定一棵二叉搜索树，请找出其中第k大的节点。
//
//
//
// 示例 1:
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4
//
//
//
// 限制：
//
// 1 ≤ k ≤ 二叉搜索树元素个数
// Related Topics 树
// 👍 104 👎 0


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
        int tar;
        int res;

        public int kthLargest(TreeNode root, int k) {
            // 递归
            tar = k;
            mid(root);
            return res;
        }

        void mid(TreeNode node) {
            if (node == null) {
                return;
            }
            mid(node.right);
            if (--tar == 0) {
                res = node.val;
                return;
            }
            mid(node.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
