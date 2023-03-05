package weekly_competition.date2022.date202211.week321;

import common.ListNode;

import java.util.LinkedList;

/**
 * 给你一个链表的头节点 head 。
 * 对于列表中的每个节点 node ，如果其右侧存在一个具有 严格更大 值的节点，则移除 node 。
 * 返回修改后链表的头节点 head 。
 * <p>
 * 示例 1：
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * 示例 2：
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 * <p>
 * 提示：
 * 给定列表中的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 *
 * @author Real
 * Date: 2022/11/27 11:15
 */
public class RemoveNodesFromLinkedList {

    public static void main(String[] args) {
        RemoveNodesFromLinkedList test = new RemoveNodesFromLinkedList();
        int[] array = {5, 2, 13, 3, 8};
        ListNode head = ListNode.initList(array);
        ListNode listNode = test.removeNodes(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 找出链表次序中递减的序列
     *
     * @param head 头节点
     * @return 新链表的头节点
     */
    public ListNode removeNodes(ListNode head) {
        LinkedList<ListNode> ans = new LinkedList<>();
        while (head != null) {
            while (ans.size() > 0 && ans.getLast().val < head.val) {
                ans.removeLast();
            }
            if (ans.size() == 0 || ans.getLast().val >= head.val) {
                ans.add(head);
            }
            head = head.next;
        }
        ListNode newHead = new ListNode();
        ListNode p = newHead;
        for (ListNode node : ans) {
            p.next = node;
            p = p.next;
        }
        p.next = null;
        return newHead.next;
    }
}
