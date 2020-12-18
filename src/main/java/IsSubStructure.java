import java.util.LinkedList;
import java.util.Queue;
/**
 * @Author zhj
 * @Description 26.树的子结构
 * @Date 23:04 2020/12/18
 **/
public class IsSubStructure {

    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            //广度优先搜索
            if (B == null) {
                return false;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(A);
            while (queue.size() != 0) {
                TreeNode node = queue.poll();
                if (isSame(node, B)) {
                    return true;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            return false;
        }

        boolean isSame(TreeNode a, TreeNode b) {
            if (b == null) {
                return true;
            }
            if (a == null || a.val != b.val) {
                return false;
            }
            return isSame(a.left, b.left) &&
                    isSame(a.right, b.right);
        }
    }

}
