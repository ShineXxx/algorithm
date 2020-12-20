import java.util.LinkedList;
import java.util.Queue;
/**
 * @Author zhj
 * @Description 28.对称的二叉树
 * @Date 10:12 2020/12/20
 **/
public class IsSymmetric {
    //请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
// 1
// / \
// 2 2
// / \ / \
//3 4 4 3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
// 1
// / \
// 2 2
// \ \
// 3 3
//
//
//
// 示例 1：
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
// Related Topics 树
// 👍 111 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric0(TreeNode root) {
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            queue1.add(root);
            queue2.add(root);
            while (queue1.size() != 0) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null) {
                    return false;
                }
                if (node1.val != node2.val) {
                    return false;
                }
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.right);
                queue2.add(node2.left);
            }
            return true;
        }

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return recur(root.left, root.right);
        }

        boolean recur(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return recur(left.left, right.right) && recur(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
