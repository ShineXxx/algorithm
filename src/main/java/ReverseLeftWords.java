/**
 * @author zhj
 * 58 -2.左旋转字符串
 */
public class ReverseLeftWords {
    //字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。
//
//
//
// 示例 1：
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
//
//
// 示例 2：
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
//
//
//
//
// 限制：
//
//
// 1 <= k < s.length <= 10000
//
// Related Topics 字符串
// 👍 70 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            char[] chars = s.toCharArray();
            char[] save = new char[n];
            for (int i = 0; i < n; i++) {
                save[i] = chars[i];
            }
            for (int i = n; i < chars.length; i++) {
                chars[i - n] = chars[i];
            }
            int index = 0;
            for (int i = chars.length - n; i < chars.length; i++) {
                chars[i] = save[index++];
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
