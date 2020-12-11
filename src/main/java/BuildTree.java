import java.util.ArrayList;
import java.util.List;
/**
 * @Author zhj
 * @Description 生成二叉树
 * @Date 14:43 2020/12/11
 **/
public class BuildTree {
    //输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/
// Related Topics 树 递归
// 👍 269 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        int index = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //递归
            List<Integer> in = new ArrayList<>();
            for (int i = 0; i < inorder.length; i++) {
                in.add(inorder[i]);
            }
            return generate(preorder, in);
        }

        TreeNode generate(int[] preorder, List<Integer> inorder) {
            if (inorder.size() == 0) {
                return null;
            }
            int root = preorder[index++];
            TreeNode node = new TreeNode(root);
            int mid = inorder.indexOf(root);
            node.left = generate(preorder, inorder.subList(0, mid));
            node.right = generate(preorder, inorder.subList(mid + 1, inorder.size()));
            return node;
        }
        private int in = 0;
        private int pre = 0;

        //太魔幻了
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return build(preorder, inorder, Integer.MIN_VALUE);
//    }
//
//    private TreeNode build(int[] preorder, int[] inorder, int stop) {
//        if (pre >= preorder.length)
//            return null;
//        if (inorder[in] == stop) {
//            in++;
//            return null;
//        }
//
//        TreeNode node = new TreeNode(preorder[pre++]);
//        node.left = build(preorder, inorder, node.val);
//        node.right = build(preorder, inorder, stop);
//        return node;
//    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
