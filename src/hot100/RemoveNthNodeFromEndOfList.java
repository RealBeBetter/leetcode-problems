package hot100;

import common.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * @author Real
 * Date: 2022/12/3 20:34
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = ListNode.initList(new int[]{1});
        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
        ListNode listNode = test.removeNthFromEnd(head, 1);
        ListNode.printList(listNode);
    }

    /**
     * 删除倒数第 N 个链表节点
     *
     * @param head 头结点
     * @param n    倒数第 N 个
     * @return 头结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // 链表长度为 length
        // 倒数第 N 个的顺序则为 length - N，需要在 Length - N - 1 处完成链表的删减
        ListNode fast = head;
        ListNode slow = head;
        int temp = n;
        while (temp-- != 0) {
            fast = fast.next;
        }
        if (fast == null) {
            // 删除的是头节点
            return head.next;
        }
        while (fast.next != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode next = slow.next;
        slow.next = next != null ? next.next : null;
        return head;
    }

    public ListNode remove(ListNode head, int n) {
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
