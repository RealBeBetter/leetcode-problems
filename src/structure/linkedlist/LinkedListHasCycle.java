package structure.linkedlist;

import common.ListNode;

/**
 * 141. 环形链表
 *
 * @author Real
 * @since 2023/4/5 21:46
 */
public class LinkedListHasCycle {

    /**
     * 判断链表是否有环
     *
     * @param head 头结点
     * @return boolean
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
