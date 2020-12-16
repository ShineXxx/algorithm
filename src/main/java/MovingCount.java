import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhj
 * 13.机器人的运动范围
 */
public class MovingCount {
    //地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//
//
// 示例 1：
//
// 输入：m = 2, n = 3, k = 1
//输出：3
//
//
// 示例 2：
//
// 输入：m = 3, n = 1, k = 0
//输出：1
//
//
// 提示：
//
//
// 1 <= n,m <= 100
// 0 <= k <= 20
//
// 👍 188 👎 0



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//    int k, m, n;
//    int[][] visited;
//
//    //深度优先
//    public int movingCount0(int m, int n, int k) {
//        this.k = k;
//        this.m = m;
//        this.n = n;
//        this.visited = new int[m][n];
//        return dfs(0, 0, 0, 0);
//
//    }


        //广度优先
        public int movingCount(int m, int n, int k) {
            Queue<int[]> queue = new LinkedList<>();
            int sum = 0;
            int[][] visited0 = new int[m][n];
            queue.add(new int[]{0, 0, 0, 0});
            while (queue.size() != 0) {
                int[] arg = queue.poll();
                int sumi = arg[2];
                int sumj = arg[3];
                int i = arg[0];
                int j = arg[1];
                if (sumi + sumj > k || i > m - 1 || j > n - 1 || visited0[i][j] == 1) {
                    continue;
                }
                visited0[i][j] = 1;
                sum++;
                queue.add(new int[]{i, j + 1, sumi, (j + 1) % 10 == 0 ? (sumj - 8) : sumj + 1});
                queue.add(new int[]{i + 1, j, (i + 1) % 10 == 0 ? (sumi - 8) : sumi + 1, sumj});
            }
            return sum;
        }

//    int dfs(int i, int j, int sumi, int sumj) {
//        if (sumi + sumj > k || i > m - 1 || j > n - 1 || visited[i][j] == 1) {
//            return 0;
//        }
//        visited[i][j] = 1;
//        //向上/右走
//        return 1 + dfs(i, j + 1, sumi, (j + 1) % 10 == 0 ? (sumj - 8) : sumj + 1) +
//                dfs(i + 1, j, (i + 1) % 10 == 0 ? (sumi - 8) : sumi + 1, sumj);
//    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
