package structure.queue;

/**
 * @author wei.song
 * @since 2023/8/19 23:43
 */
public class ArrayQueue {

    private final String[] items;
    private final int capacity;
    private int size;
    private int head;
    private int tail;


    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(String item) {
        if (tail == capacity) {
            return false;
        }

        items[tail++] = item;
        size++;
        return true;
    }

    public String dequeue() {
        if (tail == 0) {
            return null;
        }

        size--;
        tail--;
        String item = items[0];
        // 支持原数组直接复制
        System.arraycopy(items, 1, items, 0, size);
        return item;
    }

    public boolean enqueueCopyLess(String item) {
        if (size == capacity) {
            return false;
        }

        if (head != 0 && tail == capacity) {
            System.arraycopy(items, head, items, 0, size);
            tail = size;
            head = 0;
        }

        items[tail++] = item;
        size++;
        return true;
    }

    public String dequeueCopyLess() {
        if (head == tail) {
            return null;
        }

        size--;
        return items[head++];
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
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
