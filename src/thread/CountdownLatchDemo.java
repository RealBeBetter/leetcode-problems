package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Real
 * @since 2024/2/6 23:43
 */
public class CountdownLatchDemo {

    private static final int THREAD_COUNT = 10;

    private static final int COUNT_DOWN_LATCH_TIMEOUT = 5;

    public static void main(String[] args) {
        //创建CountDownLatch并设置计数值，该count值可以根据线程数的需要设置
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        //创建线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < THREAD_COUNT; i++) {
            cachedThreadPool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " do something!");
                } catch (Exception e) {
                    System.out.println("Exception: do something exception");
                } finally {
                    //该线程执行完毕-1
                    countDownLatch.countDown();
                }
            });
        }

        System.out.println("main thread do something-1");
        try {
            countDownLatch.await(COUNT_DOWN_LATCH_TIMEOUT, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Exception: await interrupted exception");
        } finally {
            System.out.println("countDownLatch: " + countDownLatch);
        }
        System.out.println("main thread do something-2");
        // 若需要停止线程池可关闭;
        cachedThreadPool.shutdown();
    }

}
