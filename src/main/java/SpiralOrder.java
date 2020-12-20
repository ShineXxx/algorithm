/**
 * @Author zhj
 * @Description 29.顺时针打印矩阵
 * @Date 17:30 2020/12/20
 **/
public class SpiralOrder {
    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组
// 👍 163 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new int[0];
            }
            int rowLen = matrix.length;
            int cloLen = matrix[0].length;
            int[] res = new int[rowLen * cloLen];
            res[0] = matrix[0][0];
            int index = 0;
            int i = 0, j = 0;
            int up = 0, down = rowLen, left = 0, right = cloLen;
            while (true) {
                while (j + 1 < right) res[++index] = matrix[i][++j];
                if (++up >= down) break;
                while (i + 1 < down) res[++index] = matrix[++i][j];
                if (--right <= left) break;
                while (j - 1 >= left) res[++index] = matrix[i][--j];
                if (--down <= up) break;
                while (i - 1 >= up) res[++index] = matrix[--i][j];
                if (++left >= right) break;
                if (index == res.length - 1) break;
            }
            return res;
        }

//    public int[] spiralOrder(int[][] matrix) {
//        if (matrix.length == 0) {
//            return new int[0];
//        }
//        int chang = matrix[0].length;
//        int kuan = matrix.length;
//        visited = new int[kuan][chang];
//        int[] res = new int[chang * kuan];
//        recur(matrix, 0, 0, res);
//        return res;
//    }

//    void recur(int[][] matrix, int i, int j) {
//        if (j + 1 < matrix[0].length && visited[i][j + 1] == 0) {
//            recur(matrix, i, j + 1);
//        }
//        recur(matrix, i + 1, j);
//        recur(matrix, i, j - 1);
//        recur(matrix, i - 1, j);
//    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
