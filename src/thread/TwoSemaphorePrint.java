package thread;

import java.util.concurrent.Semaphore;

/**
 * 两个信号量打印abc
 *
 * @author wei.song
 * @date 2023/07/18 00:05
 */
public class TwoSemaphorePrint {

    private static final Semaphore SEMAPHORE_B = new Semaphore(0);
    private static final Semaphore SEMAPHORE_C = new Semaphore(0);

    public static void printA() {
        System.out.println("A");
        SEMAPHORE_B.release();
    }

    public static void printB() throws InterruptedException {
        SEMAPHORE_B.acquire();
        System.out.println("B");
        SEMAPHORE_C.release();
    }

    public static void printC() throws InterruptedException {
        SEMAPHORE_C.acquire();
        System.out.println("C");
    }

    public static void main(String[] args) throws InterruptedException {
        printA();
        printB();
        printC();
    }

}
