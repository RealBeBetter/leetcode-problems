package structure.stack;

/**
 * @author wei.song
 * @since 2023/8/18 0:27
 */
public class ArrayStack {

    /**
     * 保存栈中的元素数据
     */
    private final String[] items;

    /**
     * 容量
     */
    private final int capacity;

    /**
     * 栈当前的大小
     */
    private int size;

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }

        this.capacity = capacity;
        this.items = new String[capacity];
        this.size = 0;
    }

    public void push(String item) {
        if (size == capacity) {
            return;
        }

        items[size++] = item;
    }


    public String pop() {
        if (size == 0) {
            return null;
        }

        String pop = items[--size];
        items[size] = null;
        return pop;
    }

    public String peek() {
        if (size == 0) {
            return null;
        }

        return items[size - 1];
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        System.out.println(stack.isFull());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
