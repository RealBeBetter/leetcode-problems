package structure.linkedlist;

import common.ListNode;

/**
 * 206. 反转链表
 *
 * @author Real
 * @since 2023/4/5 20:31
 */
public class ReverseLinkedList {

    /**
     * 反转链表，新建头结点完成
     *
     * @param head 头结点
     * @return {@link ListNode}
     */
    public ListNode reverseListCreateNewNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ans = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode tempHead = new ListNode(head.val);
            tempHead.next = ans;
            ans = tempHead;
            head = head.next;
        }

        return ans;
    }


    /**
     * 翻转链表递归实现，参考：
     * https://leetcode.cn/problems/reverse-linked-list/solutions/99711/fan-zhuan-lian-biao-shuang-zhi-zhen-di-gui-yao-mo-/
     *
     * @param head 头结点
     * @return {@link ListNode}
     */
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, nex = head;
        while (nex != null) {
            ListNode next = nex.next;
            nex.next = pre;
            pre = nex;
            nex = next;
        }

        return pre;
    }
}
