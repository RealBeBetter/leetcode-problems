package T1_500;

import common.ListNode;

/**
 * @ author : Real
 * @ date : 2021/11/5 22:21
 * @ description : 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 设置两个节点，分别表示当前节点的前一个以及后一个（原链表中的顺序）
        ListNode pre = null;
        ListNode nex = null;
        // 当前链表指针使用 head 即可
        while (head != null) {
            // 保存当前节点的下一个节点，1->2(nex)->3->4->5->NULL，保存 2 节点
            nex = head.next;
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
