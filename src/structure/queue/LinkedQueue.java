package structure.queue;

/**
 * @author wei.song
 * @since 2023/8/20 0:21
 */
public class LinkedQueue {
    public static class ListNode {
        private ListNode next;
        private final String value;

        public ListNode(ListNode next, String value) {
            this.next = next;
            this.value = value;
        }
    }

    private final ListNode dummyHead;
    private ListNode tail;
    private int size;

    public LinkedQueue() {
        this.size = 0;
        this.dummyHead = new ListNode(null, null);
    }

    public boolean enqueue(String item) {
        if (size == Integer.MAX_VALUE) {
            return false;
        }

        ListNode nextTail = new ListNode(null, item);
        if (size == 0) {
            size++;
            this.tail = nextTail;
            dummyHead.next = tail;
            return true;
        }

        size++;
        this.tail.next = nextTail;
        this.tail = nextTail;
        return true;
    }

    public String dequeue() {
        if (size == 0) {
            return null;
        }

        size--;
        ListNode head = dummyHead.next;
        dummyHead.next = head.next;
        head.next = null;
        return head.value;
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");

        System.out.println("size : " + queue.size);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("6");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
