/**
 * @author zhj
 * 24. 反转链表
 */
public class ReverseList {
    //定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
// Related Topics 链表
// 👍 145 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList0(ListNode head) {
            // 1-2-3
            if (head == null) {
                return null;
            }
            ListNode point = null;
            ListNode third = null;
            while (head.next != null) {
                // 保存下一个节点
                third = head.next;
                // 上一个节点
                head.next = point;
                // 当前节点
                point = head;
                head = third;
            }
            head.next = point;
            return head;
        }

        ListNode ans = null;

        public ListNode reverseList(ListNode head) {
            // 1-2-3
            if (head == null) {
                return null;
            }
            ListNode res = dfs(head);
            return ans;
        }

        ListNode dfs(ListNode node) {
            if (node.next == null) {
                ans = node;
                return node;
            }
            ListNode res = dfs(node.next);
            res.next = node;
            node.next = null;
            return node;
        }

        public ListNode reverseList1(ListNode head) {
            // 1-2-3
            if (head == null || head.next == null) {
                ans = head;
                return head;
            }
            ListNode res = reverseList(head.next);
//        res.next = head;
            head.next.next = head;
            head.next = null;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
