package problems.T2001_2500;

import common.ListNode;

import java.util.Stack;

/**
 * @author : Real
 * @date : 2021/11/28 17:33
 * @description : 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class PrintLinkedListFromEndToHead_Offer_06 {

    /**
     * 使用栈将链表节点添加进去，之后构建数组出栈
     * @param head 头节点
     * @return 目标数组
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        stack.push(temp);
        if (head == null) {
            return new int[0];
        }
        while (temp.next != null) {
            ListNode next = temp.next;
            stack.push(next);
            temp = next;
        }
        int[] array = new int[stack.size()];
        for (int i = 0; i < array.length; i++) {
            int val = stack.pop().val;
            array[i] = val;
        }
        return array;
    }

}
