/**
 * @Author zhj
 * @Description 11.旋转数组的最小数字
 * @Date 15:33 2020/12/14
 **/
public class MinArray {
    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
// 示例 1：
//
// 输入：[3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
// 输入：[2,2,2,0,1]
//输出：0
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/
// Related Topics 二分查找
// 👍 188 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //[1,1,3,1]
        //[10,10,10,1,10]
//    public int minArray0(int[] numbers) {
//        if (numbers.length == 1) {
//            return numbers[0];
//        }
//        int last = numbers[numbers.length - 1];
//        int d = numbers.length / 2;
//        int index = d;
//        int mid = 0;
//        while (d != 0) {
//            mid = numbers[index];
//            d /= 2;
//            if (mid > last) {
//                // 最小值在右半边
//                index += d;
//                continue;
//            }
//            if (mid == last) {
//                index = numbers.length - 1;
//            }
//            //逐次向前查找
//            while (true) {
//                if (index == 0) {
//                    return numbers[0];
//                }
//                if (numbers[index] >= numbers[index - 1]) {
//                    index--;
//                } else {
//                    return numbers[index];
//                }
//            }
//        }
//        return last;
//    }
        // 三种情况：
        //  1.全递增 123456
        //  2.全相等 111111
        //  3.两个递增 456123
        public int minArray0(int[] numbers) {
            if (numbers.length == 1) {
                return numbers[0];
            }
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    return numbers[i + 1];
                }
            }
            return numbers[0];
        }

        public int minArray(int[] numbers) {
            // 二分法
            // mid=中间指针
            // left 和 right 作为左右边界
            int left = 0;
            int right = numbers.length - 1;
            int mid;
            while (left < right) {
                mid = left + (right - left) / 2;
                // 中间大于右，最小值在右半边
                if (numbers[mid] > numbers[right]) {
                    left = mid + 1;
                } else if (numbers[mid] < numbers[right]) {
                    // 中间小于右，最小值在左半边
                    right = mid;
                } else {
                    right--;
                }

            }
            return numbers[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
