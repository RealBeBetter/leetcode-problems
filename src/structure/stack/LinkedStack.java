package structure.stack;

/**
 * @author wei.song
 * @since 2023/8/19 16:21
 */
public class LinkedStack {

    public static class ListNode {
        private ListNode prev;
        private ListNode next;
        private String value;

        public ListNode() {
        }

        public ListNode(ListNode prev, ListNode next, String value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    private final ListNode dummyHead;
    private ListNode tail;
    private int size;

    public LinkedStack() {
        this.size = 0;
        this.tail = null;
        this.dummyHead = new ListNode();
    }

    public void push(String item) {
        size++;
        if (tail == null) {
            tail = new ListNode(dummyHead, null, item);
            dummyHead.next = tail;
            return;
        }

        // 栈不为空时
        ListNode newTail = new ListNode(tail, null, item);
        tail.next = newTail;
        tail = newTail;
    }

    public String pop() {
        if (tail == null) {
            return null;
        }

        size--;
        if (tail.prev == dummyHead) {
            String value = tail.value;
            tail = null;
            return value;
        }

        ListNode prev = tail.prev;
        prev.next = null;
        String value = tail.value;
        tail = prev;
        return value;
    }

    public String peek() {
        if (tail == null) {
            return null;
        }
        return tail.value;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push("3");
        stack.push("1");
        stack.push("2");
        stack.push("4");
        stack.push("5");

        System.out.println(stack.size);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("12345");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.size);
    }

}
