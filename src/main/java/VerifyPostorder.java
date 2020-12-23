/**
 * @Author zhj
 * @Description 33.二叉搜索树的后序遍历序列
 * @Date 23:03 2020/12/23
 **/
public class VerifyPostorder {
    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//
//
// 参考以下这颗二叉搜索树：
//
//      5
//    / \
//   2   6
//  / \
// 1   3
//
// 示例 1：
//
// 输入: [1,6,3,2,5]
//输出: false
//
// 示例 2：
//
// 输入: [1,3,2,6,5]
//输出: true
//
//
//
// 提示：
//
//
// 数组长度 <= 1000
//
// 👍 157 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return dfs(postorder, 0, postorder.length - 1);
        }

        boolean dfs(int[] arr, int l, int r) {
            if (l >= r) {
                return true;
            }
            int p = l;
            while (p < r && arr[p] < arr[r]) {
                p++;
            }
            int m = p;
            while (p < r && arr[p] > arr[r]) {
                p++;
            }
            return p == r && dfs(arr, l, m - 1) && dfs(arr, m, r - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
