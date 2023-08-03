package thread;

import java.util.concurrent.Semaphore;

/**
 * @author wei.song
 * @date 2023/07/18 11:25
 */
public class PrintCountLoopSemaphore {

    private static final int PRINT_COUNT = 3;

    private static final Semaphore SEMAPHORE1 = new Semaphore(PRINT_COUNT);
    private static final Semaphore SEMAPHORE2 = new Semaphore(0);
    private static final Semaphore SEMAPHORE3 = new Semaphore(0);

    private volatile static int currentCount = 0;

    public static void main(String[] args) {
        printNumberByThread(100, PRINT_COUNT);
    }

    public static void printNumberByThread(int count, int printCount) {
        new Thread(() -> {
            while (currentCount < count) {
                for (int i = 0; i < printCount; i++) {
                    try {
                        SEMAPHORE1.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " currentCount:" + currentCount);
                    if (++currentCount == 100) {
                        return;
                    }
                }
                SEMAPHORE2.release(PRINT_COUNT);
            }
        }, "ThreadA").start();

        new Thread(() -> {
            while (currentCount < count) {
                for (int i = 0; i < printCount; i++) {
                    try {
                        SEMAPHORE2.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " currentCount:" + currentCount);
                    if (++currentCount == 100) {
                        return;
                    }
                }
                SEMAPHORE3.release(PRINT_COUNT);
            }
        }, "ThreadB").start();

        new Thread(() -> {
            while (currentCount < count) {
                for (int i = 0; i < printCount; i++) {
                    try {
                        SEMAPHORE3.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " currentCount:" + currentCount);
                    if (++currentCount == 100) {
                        return;
                    }
                }
                SEMAPHORE1.release(PRINT_COUNT);
            }
        }, "ThreadC").start();
    }

}
