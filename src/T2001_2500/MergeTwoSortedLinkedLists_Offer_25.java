package T2001_2500;

import java.util.Stack;

/**
 * @ author : Real
 * @ date : 2021/11/6 18:05
 * @ description : 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * 0 <= 链表长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class MergeTwoSortedLinkedLists_Offer_25 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(4);
        s1.next = s2;
        s2.next = s3;

        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(3);
        ListNode t3 = new ListNode(4);
        t1.next = t2;
        t2.next = t3;

        ListNode listNode = mergeTwoLists(s1, t1);
        // 1->1->2->3->4->4
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
