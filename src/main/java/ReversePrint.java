/**
 * @Author zhj
 * @Description 从未到头遍历链表
 * @Date 15:01 2020/12/10
 **/
public class ReversePrint {
    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 链表
// 👍 77 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class Solution {
        public int[] reversePrint(ListNode head) {
            int len = 0;
            ListNode point = head;
            while (point != null) {
                point = point.next;
                len++;
            }
            int[] res = new int[len];
            point = head;
            int index = res.length;
            while (point != null) {
                res[--index] = point.val;
                point = point.next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
