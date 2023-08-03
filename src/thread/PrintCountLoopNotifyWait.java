package thread;

/**
 * @author wei.song
 * @date 2023/07/18 00:44
 */
public class PrintCountLoopNotifyWait {

    private static final int PRINT_COUNT = 3;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();

    private volatile static int currentCount = 0;

    public static void main(String[] args) {
        PrintCountLoopNotifyWait test03 = new PrintCountLoopNotifyWait();
        test03.printNumberByThread(100, PRINT_COUNT);
    }

    public void printNumberByThread(int count, int printCount) {
        new Thread(() -> {
            while (currentCount < count) {
                for (int i = 0; i < printCount; i++) {
                    System.out.println(Thread.currentThread().getName() + " currentCount:" + currentCount);
                    if (++currentCount == 100) {
                        return;
                    }
                }
                try {
                    synchronized (lock2) {
                        lock2.notify();
                    }
                    synchronized (lock1) {
                        lock1.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "ThreadA").start();

        new Thread(() -> {
            while (currentCount < count) {
                try {
                    synchronized (lock2) {
                        lock2.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < printCount; i++) {
                    System.out.println(Thread.currentThread().getName() + " currentCount:" + currentCount);
                    if (++currentCount == 100) {
                        return;
                    }
                }
                synchronized (lock3) {
                    lock3.notify();
                }
            }
        }, "ThreadB").start();

        new Thread(() -> {
            while (currentCount < count) {
                try {
                    synchronized (lock3) {
                        lock3.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < printCount; i++) {
                    System.out.println(Thread.currentThread().getName() + " currentCount:" + currentCount);
                    if (++currentCount == 100) {
                        return;
                    }
                }
                synchronized (lock1) {
                    lock1.notify();
                }

            }
        }, "ThreadC").start();
    }
}
