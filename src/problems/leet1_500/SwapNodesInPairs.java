package problems.leet1_500;

import common.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * @author Real
 * @since 2023/4/18 21:52
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null && temp.next.next != null) {
            ListNode middle = temp.next;
            ListNode behind = temp.next.next;
            // 开始接续链表指针
            temp.next = behind;
            middle.next = behind.next;
            behind.next = middle;
            temp = temp.next.next;
        }

        return dummyHead.next;
    }

}
