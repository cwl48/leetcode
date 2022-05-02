//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3218 👎 0


package com.chaoyer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("{[]}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};


        public boolean isValid(String s) {

            if (s.length() > 0 && !pairs.containsKey(s.charAt(0))) {
                return false;
            }

            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (pairs.containsKey(c)) {
                    list.addLast(c);
                } else {
                    if (list.size() == 0) {
                        return false;
                    }
                    if (!pairs.get(list.removeLast()).equals(c)) {
                        return false;
                    }
                }
            }
            return list.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}