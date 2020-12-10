/**
 * @Author zhj
 * @Description 替换空格
 * @Date 15:00 2020/12/10
 **/
public class ReplaceSpace {
    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
// 👍 53 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            //1.把字符串转化为字符数组
            char[] chars = s.toCharArray();
            //2.计算空格出现的数量
            int count = 0;
            for (char c : chars) {
                if (c == ' ') {
                    count++;
                }
            }
            //3.计算空格字符替换后数组大小，新建新的数组
            char[] newChar = new char[chars.length + count * 2];
            //4.根据记录的空格字符位置，写入新建的字符数组
            int index = 0;
            for (char c : chars) {
                if (c == ' ') {
                    newChar[index++] = '%';
                    newChar[index++] = '2';
                    newChar[index++] = '0';
                } else {
                    newChar[index++] = c;
                }
            }
            return new String(newChar);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
