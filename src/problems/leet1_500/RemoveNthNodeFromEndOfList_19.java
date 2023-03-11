package problems.leet1_500;

import common.ListNode;

/**
 * @ author : Real
 * @ date : 2021/11/2 16:20
 * @ description : 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthNodeFromEndOfList_19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 利用一次遍历实现删除目标节点，快慢指针
        // 长度为length，那么倒数第n个应该是length - n + 1，也就是 length - (n - 1)
        // 所以快慢指针的差距应该维持为 n - 1
        // 删除倒数第 n 个节点，那么应该在倒数 第 n - 2 个节点处开始进行删除操作
        // 按照这个逻辑，进行删除的节点应该是在 length - n 开始，所以指针差距应该为 n
        ListNode slow = head, fast = head;
        int slowPoint = 1, fastPoint = 1;
        if (head.next == null) {
            return null;
        }
        while (slow != null) {
            if (fast.next != null) {
                // 后移指针
                fast = fast.next;
                fastPoint++;
            } else {
                // 删除头节点的情况
                if (n == fastPoint) {
                    head = head.next;
                    return head;
                }
            }
            if (fastPoint - slowPoint == n) {
                if (fast.next == null) {
                    // 此时应该删除的节点就是该节点
                    if (slow.next != null) {
                        if (n != 1) {
                            slow.next = slow.next.next;
                        } else {
                            // 删除尾节点的情况
                            slow.next = null;
                        }
                        break;
                    }
                } else {
                    slow = slow.next;
                    slowPoint++;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = removeNthFromEnd(node1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
