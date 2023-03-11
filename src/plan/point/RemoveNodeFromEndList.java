package plan.point;

import common.ListNode;

/**
 * @author Real
 * @since 2023/3/11 13:25
 */
public class RemoveNodeFromEndList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 头节点重新开，考虑 [1],1 这种情况
        ListNode node = new ListNode(0, head);
        ListNode first = head;
        ListNode second = node;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return node.next;
    }

}
