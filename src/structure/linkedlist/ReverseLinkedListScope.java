package structure.linkedlist;

import common.ListNode;

/**
 * 92. 反转链表 II
 *
 * @author Real
 * @since 2023/4/5 20:43
 */
public class ReverseLinkedListScope {

    public static void main(String[] args) {
        ReverseLinkedListScope test = new ReverseLinkedListScope();
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = ListNode.initList(array);
        ListNode.printList(test.reverseBetween(head, 1, 5));
    }

    /**
     * 翻转范围内的链表
     *
     * @param head  头结点
     * @param left  左
     * @param right 右
     * @return {@link ListNode}
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }


    public ListNode reverseBetweenSecond(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 头插法，将后面的节点不断移动到pre的下一个节点完成翻转
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }

}
