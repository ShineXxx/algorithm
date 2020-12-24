/**
 * @author zhj
 * 35.复杂链表的复制
 */

import java.util.HashMap;

public class CopyRandomList {
    //请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。
//
//
//
// 示例 1：
//
//
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// 示例 2：
//
//
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
//
//
// 示例 3：
//
//
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
//
//
// 示例 4：
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
//
//
//
//
// 提示：
//
//
// -10000 <= Node.val <= 10000
// Node.random 为空（null）或指向链表中的节点。
// 节点数目不超过 1000 。
//
//
//
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/
//
//
// Related Topics 链表
// 👍 127 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        // 拼接 + 拆分
        public Node copyRandomList(Node head) {
            if (head == null) {
                return head;
            }
            Node point = head;
            // 复制一份next间接插入旧链表
            while (point != null) {
                Node newNode = new Node(point.val);
                newNode.next = point.next;
                point.next = newNode;
                point = newNode.next;
            }
            // 修改random
            point = head;
            while (point.next.next != null) {
                if (point.random != null) {
                    point.next.random = point.random.next;
                }
                point = point.next.next;
            }
            point.next.random = point.random == null ? null : point.random.next;
            // 拆分
            point = head;
            Node res = head.next;
            while (point.next.next != null) {
                Node thrid = point.next.next;
                point.next.next = thrid.next;
                point.next = thrid;
                point = thrid;
            }
            point.next = null;
            return res;
        }

        // hashmap
        public Node copyRandomList1(Node head) {
            if (head == null) {
                return head;
            }
            HashMap<Node, Node> map = new HashMap<>();
            Node point = head;
            while (point != null) {
                map.put(point, new Node(point.val));
                point = point.next;
            }
            point = head;
            while (point != null) {
                map.get(point).next = map.get(point.next);
                map.get(point).random = map.get(point.random);
                point = point.next;
            }
            return map.get(head);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
