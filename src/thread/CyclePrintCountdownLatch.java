package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author Real
 * @since 2023/2/26 22:19
 */
public class CyclePrintCountdownLatch {

    CountDownLatch latch1 = new CountDownLatch(1);
    CountDownLatch latch2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        latch1.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        CyclePrintCountdownLatch test = new CyclePrintCountdownLatch();
        Runnable first = () -> System.out.println("A");
        Runnable second = () -> System.out.println("B");
        Runnable third = () -> System.out.println("C");

        test.first(first);
        test.second(second);
        test.third(third);
    }

}
