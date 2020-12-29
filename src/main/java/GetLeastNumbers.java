/**
 * @Author zhj
 * @Description 40.最小的k个数
 * @Date 21:32 2020/12/27
 **/
public class GetLeastNumbers {
    //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
// Related Topics 堆 分治算法
// 👍 172 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] res = new int[k];
            int min = Integer.MAX_VALUE;
            int index = 0;
            while (index < k) {
                min = arr[index];
                int flag = -1;
                for (int i = index + 1; i < arr.length; i++) {
                    int num = arr[i];
                    if (num < min) {
                        min = num;
                        flag = i;
                    }
                }
                res[index] = min;
                if (flag != -1) {
                    swap(arr, index, flag);
                }
                index++;
            }
            return res;
        }

        void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
