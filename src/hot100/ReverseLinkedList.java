package hot100;

import common.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 *
 * @author wei.song
 * @since 2023/1/15 22:20
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList test = new ReverseLinkedList();
        int[] array1 = {1, 2, 3, 4, 5};
        ListNode listNode1 = ListNode.initList(array1);
        ListNode node1 = test.reverseList(listNode1);
        ListNode.printList(node1);

        System.out.println("second solution:");
        int[] array2 = {1, 2, 3, 4, 5};
        ListNode listNode2 = ListNode.initList(array2);
        ListNode node2 = test.reverseListNode(listNode2);
        ListNode.printList(node2);
    }


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        // 原链表中的前一个与后一个
        ListNode pre = null;
        ListNode nex;
        while (head != null) {
            nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        return pre;
    }

    public ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode ans = null;
        while (head != null) {
            if (ans == null) {
                ans = new ListNode(head.val);
            } else {
                ListNode tempHead = new ListNode(head.val);
                tempHead.next = ans;
                ans = tempHead;
            }

            head = head.next;
        }

        return ans;
    }

}
