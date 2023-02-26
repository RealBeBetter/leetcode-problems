package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Real
 * @since 2023/2/26 22:09
 */
public class CyclePrintReentrantLock {

    private static int state = 0;

    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (true) {
                LOCK.lock();
                try {
                    if (state % 3 == 0) {
                        System.out.println("A");
                        state = 1;
                    }
                } finally {
                    LOCK.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                LOCK.lock();
                try {
                    if (state % 3 == 1) {
                        System.out.println("B");
                        state = 2;
                    }
                } finally {
                    LOCK.unlock();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            while (true) {
                LOCK.lock();
                try {
                    if (state % 3 == 2) {
                        System.out.println("C");
                        state = 3;
                    }
                } finally {
                    LOCK.unlock();
                }
            }
        });

        thread2.start();
        thread1.start();
        thread3.start();

    }

}
