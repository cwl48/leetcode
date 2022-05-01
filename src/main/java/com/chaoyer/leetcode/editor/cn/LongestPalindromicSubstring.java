//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5150 👎 0


package com.chaoyer.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 从每一个位置出发，向两边扩散即可。遇到不是回文的时候结束。
 *
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.printf(solution.longestPalindrome("babad") + "\n");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            if (s.length() < 2) {
                return s;
            }

            int start = 0;
            int maxLen = 1;
            int len = s.length();
            boolean dp[][] = new boolean[len][len];

            for (int r = 1; r < len; r++) {
                for (int l = 0; l < r; l++) {
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            start = l;
                            maxLen = r - l + 1;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}