/**
 * @author zhj
 * 50.第一个只出现一次的字符
 */

import java.util.HashMap;

public class FirstUniqChar {
    //在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例:
//
// s = "abaccdeff"
//返回 "b"
//
//s = ""
//返回 " "
//
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 50000
// Related Topics 哈希表
// 👍 64 👎 0



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                Integer res = map.get(c);
                if (res == null) {
                    map.put(c, i);
                } else {
                    chars[res] = '1';
                    chars[i] = '1';
                }
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != '1') {
                    return chars[i];
                }
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
