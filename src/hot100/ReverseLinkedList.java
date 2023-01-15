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
        int[] array = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.initList(array);
        ListNode node = test.reverseList(listNode);
        ListNode.printList(node);
    }


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 1 2 3 4 5
        // 原链表中的前一个与后一个
        ListNode pre = null;
        ListNode nex = null;
        while (head != null) {
            nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        return pre;
    }

}
