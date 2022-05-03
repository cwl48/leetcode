////给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 
//target 的
//// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
////
//// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
////
//// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：candidates = [2,3,6,7], target = 7
////输出：[[2,2,3],[7]]
////解释：
////2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
////7 也是一个候选， 7 = 7 。
////仅有这两种组合。 
////
//// 示例 2： 
////
//// 
////输入: candidates = [2,3,5], target = 8
////输出: [[2,2,2,2],[2,3,3],[3,5]] 
////
//// 示例 3： 
////
//// 
////输入: candidates = [2], target = 1
////输出: []
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= candidates.length <= 30 
//// 1 <= candidates[i] <= 200 
//// candidate 中的每个元素都 互不相同 
//// 1 <= target <= 500 
//// 
//// Related Topics 数组 回溯 👍 1936 👎 0
//


package com.chaoyer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int t = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            List<List<Integer>> rs = new ArrayList<>();
            LinkedList<Integer> output = new LinkedList<>();

            backtrack(candidates, target, 0, output, rs);
            return rs;
        }

        public void backtrack(int[] candidates, int target, int start, LinkedList<Integer> output,
                              List<List<Integer>> rs) {

            if (t == target) {
                rs.add(new ArrayList<>(output));
                return;
            }

            if (t > target) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                output.add(candidates[i]);
                t += candidates[i];
                backtrack(candidates, target, i, output, rs);
                output.removeLast();
                t -= candidates[i];
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}