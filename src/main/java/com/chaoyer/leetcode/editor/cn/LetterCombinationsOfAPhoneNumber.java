//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1871 👎 0


package com.chaoyer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路:
 * 排列组合
 * 根据digits长度，给每个子串的元素进行排列组合
 *
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String letterMap[] = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };

        List<String> rs = new ArrayList<>();

        public List<String> letterCombinations(String digits) {


            if (digits.equals("")) {
                return new ArrayList<>();
            }

            findAll(digits,0,"");
            return rs;
        }

        public void findAll(String digits,int index,String s) {

            if(index==digits.length()){
                rs.add(s);
                return;
            }

            String childStr = letterMap[digits.charAt(index) - '0'];
            for (int i = 0; i < childStr.length(); i++) {
                findAll(digits,index+1,s+childStr.charAt(i));
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}