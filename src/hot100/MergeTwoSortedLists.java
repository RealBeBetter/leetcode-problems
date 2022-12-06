package hot100;

import common.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * @author wei.song
 * @since 2022/12/6 18:53
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists test = new MergeTwoSortedLists();
        int[] array = {1, 2, 3, 4, 5};
        ListNode listNode1 = ListNode.initList(array);
        ListNode listNode2 = ListNode.initList(array);
        ListNode listNode = test.mergeTwoLists(listNode1, listNode2);
        ListNode.printList(listNode);
    }

    /**
     * 合并两个有序链表，头指针法
     *
     * @param list1 第一个链表
     * @param list2 第二个链表
     * @return 新的有序链表的Head节点
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode temp1 = list1, temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 == null ? temp2 : temp1;
        return head.next;
    }

}
