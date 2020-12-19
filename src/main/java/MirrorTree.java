import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * @Author zhj
 * @Description 27 二叉树的镜像
 * @Date 17:27 2020/12/19
 **/
public class MirrorTree {
    //请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入：
//
// 4
// / \
// 2 7
// / \ / \
//1 3 6 9
//镜像输出：
//
// 4
// / \
// 7 2
// / \ / \
//9 6 3 1
//
//
//
// 示例 1：
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
// Related Topics 树
// 👍 86 👎 0


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
        public TreeNode mirrorTree0(TreeNode root) {
            if (root == null) {
                return null;
            }
            //递归
            TreeNode tmp = root.right;
            root.right = mirrorTree(root.left);
            root.left = mirrorTree(tmp);
            return root;
        }

        //BFS
        public TreeNode mirrorTree1(TreeNode root) {
            if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode tmp;
            while (queue.size() != 0) {
                TreeNode node = queue.poll();
                tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            return root;
        }

        //DFS
        public TreeNode mirrorTree(TreeNode root) {
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
