/**
 * @author zhj
 * 37.序列化二叉树
 */

import java.util.LinkedList;
import java.util.Queue;

public class CodecSerialize {
    //请实现两个函数，分别用来序列化和反序列化二叉树。
//
// 示例:
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]"
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/
// Related Topics 树 设计
// 👍 94 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            StringBuilder builder = new StringBuilder();
            //广度优先搜索
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() != 0) {
                int size = queue.size();
                boolean num = false;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    builder.append(node == null ? "null," : (node.val + ","));
                    if (node != null) {
                        num = true;
                        if (node.left != null) {
                            queue.add(node.left);
                        } else {
                            queue.add(null);
                        }
                        if (node.right != null) {
                            queue.add(node.right);
                        } else {
                            queue.add(null);
                        }
                    } else {
                        queue.add(null);
                        queue.add(null);
                    }
                }
                if (num == false) {
                    String s = builder.substring(0, builder.length() - size * 5 - 1);
                    builder = new StringBuilder(s);
                    break;
                }
                num = false;
            }
            System.out.println(builder);
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arrs = data.split(",");
            return null;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
