package structure.heap;

/**
 * @author Real
 * @since 2023/4/16 17:13
 */
public class Heap {

    /**
     * 数据。这里用数组存储堆的数据
     */
    private final int[] data;

    /**
     * 最大容量，允许存储的最大容量值
     */
    private final int maxCapacity;

    /**
     * 已经存储的数据大小，这里的大小并不等于 data.length
     */
    private int size;

    public Heap() {
        maxCapacity = 10;
        data = new int[maxCapacity + 1];
        size = 0;
    }

    public Heap(int[] data, int maxCapacity, int size) {
        this.data = data;
        this.maxCapacity = maxCapacity;
        this.size = size;
    }


    /**
     * 插入数据。假定使用数组保存
     *
     * @param val 插入的值
     */
    public void insertData(int val) {
        if (size == maxCapacity) {
            // 已经超出容量，不允许添加
            return;
        }

        // 没有数据的时候插入堆顶
        if (size == 0) {
            data[1] = val;
            return;
        }

        data[++size] = val;
        int index = size;
        // 只需要与父节点进行比较即可
        while (index / 2 > 0 && data[index] > data[index / 2]) {
            int parentNode = data[index / 2];
            data[index / 2] = data[index];
            data[index] = parentNode;
            index /= 2;
        }
    }

    /**
     * 删除堆顶
     */
    public void deleteTop() {
        if (size == 0) {
            return;
        }

        // 将堆顶替换成堆的最后一个元素
        data[1] = data[size];
        data[size] = 0;

        int index = 1;
        // 自顶向上的堆化，这里只需要使用左子树即可
        while (true) {
            if (data[index] >= data[index * 2] && data[index] >= data[index * 2 + 1]) {
                return;
            }

            if (index * 2 < maxCapacity && data[index] < data[index * 2]) {
                // 替换
                int parentNode = data[index * 2];
                data[index * 2] = data[index];
                data[index] = parentNode;
                index *= 2;
            }

            if (index * 2 + 1 < maxCapacity && data[index] < data[index * 2 + 1]) {
                // 替换
                int parentNode = data[index * 2];
                data[index * 2] = data[index];
                data[index] = parentNode;
                index = index * 2 + 1;
            }
        }
    }


    private void buildHeap() {
        for (int i = size / 2; i >= 1; --i) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= size && data[i] < data[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= size && data[maxPos] < data[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }

            int temp = data[maxPos];
            data[maxPos] = data[i];
            data[i] = temp;

            i = maxPos;
        }
    }


    public void sort(int[] a) {
        buildHeap();
        int restSize = size;
        while (restSize > 1) {
            int temp = data[restSize];
            data[restSize] = data[1];
            data[1] = temp;

            restSize--;
            heapify(1);
        }
    }
}
