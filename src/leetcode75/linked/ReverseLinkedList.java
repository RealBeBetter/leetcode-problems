package leetcode75.linked;

import common.ListNode;

/**
 * 206. 反转链表
 *
 * @author wei.song
 * @since 2023/5/17 12:24
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }

        return pre;
    }

}
