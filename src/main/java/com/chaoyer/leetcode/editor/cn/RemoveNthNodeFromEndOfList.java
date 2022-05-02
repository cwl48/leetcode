//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 2009 👎 0


package com.chaoyer.leetcode.editor.cn;


/**
 * 解题思路:
 * 我们需要找到倒数第 n 个节点，因此我们可以使用两个指针 pre 和 end 同时对链表进行遍历，
 * 并且 end 比 pre 超前 n 个节点。当 end 遍历到链表的末尾时，pre 就恰好处于倒数第 n 个节点。
 *
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode first = new ListNode(0);
            first.next = head;

            ListNode pre = first;
            ListNode end = head;
            while (n>0){
                end = end.next;
                n--;
            }
            while (end!=null){
                pre = pre.next;
                end = end.next;
            }
            pre.next = pre.next.next;
            return first.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}