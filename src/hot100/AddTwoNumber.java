package hot100;

import common.ListNode;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author Real
 * Date: 2022/11/30 0:32
 */
public class AddTwoNumber {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        AddTwoNumber test = new AddTwoNumber();
        ListNode head1 = ListNode.initList(array1);
        ListNode head2 = ListNode.initList(array2);
        ListNode listNode = test.addTwoNumbers(head1, head2);
        ListNode.printList(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        // 进位
        int carry = 0;
        ListNode ans = new ListNode();
        ListNode tempNode = ans;
        while (head1 != null || head2 != null) {
            int number1 = head1 == null ? 0 : head1.val;
            int number2 = head2 == null ? 0 : head2.val;
            // 两数相加
            int tempSum = number2 + number1 + carry;
            carry = tempSum >= 10 ? 1 : 0;
            tempNode.next = new ListNode(tempSum % 10);
            tempNode = tempNode.next;

            head1 = head1 != null ? head1.next : head1;
            head2 = head2 != null ? head2.next : head2;
        }
        if (carry == 1) {
            tempNode.next = new ListNode(carry);
        }
        return ans.next;
    }

}
