package leetcode75.linked;

import common.ListNode;

/**
 * 328. 奇偶链表
 * <p>
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 * @author wei.song
 * @since 2023/5/17 12:00
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode head = ListNode.initList(new int[]{1, 2, 3, 4, 5});
        ListNode res = new OddEvenLinkedList().oddEvenList(head);
        ListNode.printList(res);
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode oddList = new ListNode(0);
        ListNode evenList = new ListNode(0);
        ListNode evenHead = evenList;

        ListNode ans = oddList;
        ListNode cur = head;

        int index = 1;
        while (cur != null) {
            if (index % 2 == 0) {
                evenList.next = new ListNode(cur.val);
                evenList = evenList.next;
            } else {
                oddList.next = new ListNode(cur.val);
                oddList = oddList.next;
            }

            index++;
            cur = cur.next;
        }

        oddList.next = evenHead.next;

        return ans.next;
    }

    public ListNode oddEvenListAnswer(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
