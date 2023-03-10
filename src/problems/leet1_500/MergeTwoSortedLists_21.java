package problems.leet1_500;

import common.ListNode;

/**
 * @ author : Real
 * @ date : 2021/11/6 18:43
 * @ description : 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
        ListNode first = new ListNode(0), ans = first;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                ans.next = temp1;
                temp1 = temp1.next;
            } else {
                ans.next = temp2;
                temp2 = temp2.next;
            }
            ans = ans.next;
        }
        ans.next = temp1 != null ? temp1 : temp2;
        return first.next;
    }
}
