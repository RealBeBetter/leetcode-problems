package plan.point;

import common.ListNode;

/**
 * @author wei.song
 * @since 2023/3/6 16:15
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.initList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode middleNode = middleNode(listNode);
        ListNode.printList(middleNode);

        ListNode listNode1 = ListNode.initList(new int[]{1, 2, 3, 4, 5});
        ListNode middleNode1 = middleNode(listNode1);
        ListNode.printList(middleNode1);
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        int step = 2;
        ListNode slowPoint = head;
        ListNode fastPoint = head;

        while (fastPoint != null && fastPoint.next != null) {
            slowPoint = slowPoint.next;
            for (int i = 0; i < step; i++) {
                fastPoint = fastPoint.next;
                if (fastPoint == null) {
                    break;
                }
            }
        }

        return slowPoint;
    }

}
