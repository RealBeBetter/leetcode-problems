package structure.queue;

/**
 * @author wei.song
 * @since 2023/08/22 22:26
 */
public class CircularQueue {

    private final String[] items;
    private final int capacity;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(String item) {
        // 队列满
        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % capacity;
        return ret;
    }

}
