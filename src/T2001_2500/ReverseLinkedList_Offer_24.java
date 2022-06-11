package T2001_2500;

/**
 * @ author : Real
 * @ date : 2021/11/5 22:07
 * @ description : 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 限制：
 * 0 <= 节点个数 <= 5000
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReverseLinkedList_Offer_24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 设置两个节点，分别表示当前节点的前一个以及后一个（原链表中的顺序）
        ListNode pre = null;
        // 当前链表指针使用 head 即可
        while (head != null) {
            // 保存当前节点的下一个节点，1->2(nex)->3->4->5->NULL，保存 2 节点
            ListNode nex = head.next;
            // 前面一个节点作为反转之后的下一个节点，1->2->3->4->5->NULL，变成 1->null(pre)
            head.next = pre;
            // 保存下一个要挂在 1 之前的节点，2
            pre = head;
            // 将下一个节点 2 赋给 head ，避免造成无法访问，之后变成 1(pre)->NULL 和 2(head)->3->4->5->NULL
            head = nex;
        }
        return pre;
    }
}


