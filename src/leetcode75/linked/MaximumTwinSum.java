package leetcode75.linked;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2130. 链表最大孪生和
 * <p>
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 *
 * @author wei.song
 * @since 2023/5/18 09:39
 */
public class MaximumTwinSum {

    public int pairSum(ListNode head) {
        List<Integer> numbers = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            numbers.add(cur.val);
            cur = cur.next;
        }

        int size = numbers.size();
        int max = numbers.get(0) + numbers.get(size - 1);

        for (int i = 0, j = size - 1; i < size / 2 && j >= size / 2; i++, j--) {
            max = Math.max(max, numbers.get(i) + numbers.get(j));
        }

        return max;
    }

}
