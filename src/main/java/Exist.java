/**
 * 12.矩阵中的路径
 * @author zhaoyao
 */
public class Exist {
    //请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
//
// [["a","b","c","e"],
//["s","f","c","s"],
//["a","d","e","e"]]
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
//
//
//
// 示例 1：
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "A
//BCCED"
//输出：true
//
//
// 示例 2：
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
//
// 提示：
//
//
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
//
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
// Related Topics 深度优先搜索
// 👍 209 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            //深度优先搜索
            // 递归
            char[] array = word.toCharArray();
            if (array.length == 0) {
                return false;
            }
            // 字符串索引指针
            int p = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (deep(board, array, p, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean deep(char[][] board, char[] array, int p, int x, int y) {
            if (board.length <= x || x < 0 || board[0].length <= y || y < 0) {
                return false;
            }
            if (board[x][y] != array[p]) {
                return false;
            }
            if (p == array.length - 1) {
                return true;
            }
            board[x][y] = '\0';
            boolean res = deep(board, array, p + 1, x + 1, y) ||
                    deep(board, array, p + 1, x - 1, y) ||
                    deep(board, array, p + 1, x, y + 1) ||
                    deep(board, array, p + 1, x, y - 1);
            board[x][y] = array[p];
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
