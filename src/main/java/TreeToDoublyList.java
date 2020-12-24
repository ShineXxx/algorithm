/**
 * @author zhj
 * 36.二叉搜索树与双向链表
 */
public class TreeToDoublyList {
    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
//
//
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例：
//
//
//
//
//
//
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
//
//
//
//
//
//
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
//
//
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/
//
// 注意：此题对比原题有改动。
// Related Topics 分治算法
// 👍 149 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    class Solution {
        // 左右根
        public Node treeToDoublyList0(Node root) {
            if (root == null) {
                return null;
            }
            Node node = dfs(root, true);
            while (node.left != null) {
                node = node.left;
            }
            Node left = node;
            while (node.right != null) {
                node = node.right;
            }
            Node right = node;
            left.left = right;
            right.right = left;
            return left;
        }

        Node pre, head;

        // 左根右
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            mid(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        void mid(Node node) {
            if (node == null) {
                return;
            }
            mid(node.left);
            if (pre != null) {
                pre.right = node;
            }
            if (pre == null) {
                head = node;
            }
            node.left = pre;
            pre = node;
            mid(node.right);
        }

        Node dfs(Node node, boolean isLeft) {
            if (node == null) {
                return node;
            }
            // left=左子树中最大的
            node.left = dfs(node.left, true);
            // right=右子树中最小的
            node.right = dfs(node.right, false);
            if (node.left != null) {
                node.left.right = node;
            }
            if (node.right != null) {
                node.right.left = node;
            }
            Node point = node;
            if (isLeft) {
                while (point.right != null) {
                    point = point.right;
                }
            } else {
                while (point.left != null) {
                    point = point.left;
                }
            }
            return point;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
