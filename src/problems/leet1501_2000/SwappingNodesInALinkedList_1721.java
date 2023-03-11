package problems.leet1501_2000;

import common.ListNode;

/**
 * @ author : Real
 * @ date : 2021/11/1 21:13
 * @ description : 1721. 交换链表中的节点
 * 给你链表的头节点 head 和一个整数 k 。
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，
 * 返回链表的头节点（链表 从 1 开始索引）。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * 提示：
 * 链表中节点的数目是 n
 * 1 <= k <= n <= 10^5
 * 0 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwappingNodesInALinkedList_1721 {
    /**
     * Definition for singly-linked list.
     * public class common.ListNode {
     * int val;
     * common.ListNode next;
     * common.ListNode() {}
     * common.ListNode(int val) { this.val = val; }
     * common.ListNode(int val, common.ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode swapNodes(ListNode head, int k) {
        int length = 1;
        // 算出链表的长度
        ListNode node = head;
        // 顺序数链表节点
        int order = 0;
        while (node != null) {
            if (length == k) {
                order = node.val;
            }
            node = node.next;
            length++;
        }
        length--;
        // 倒序数链表节点
        int point = 1;
        int descOrder = 0;
        node = head;
        while (node != null) {
            if (point == length - k + 1) {
                descOrder = node.val;
            }
            node = node.next;
            point++;
        }
        point = 1;
        node = head;
        while (node != null) {
            // 正顺序的换成倒顺序的
            if (point == k) {
                node.val = descOrder;
            }
            // 倒顺序的换成正顺序的
            if (point == length - k + 1) {
                node.val = order;
            }
            node = node.next;
            point++;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = swapNodes(node1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
