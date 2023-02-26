package thread;

/**
 * @author Real
 * @since 2023/2/26 22:14
 */
public class CyclePrintSynchronized {


    public static void main(String[] args) throws InterruptedException {
        CyclePrintSynchronized cyclePrintSynchronized = new CyclePrintSynchronized();
        cyclePrintSynchronized.cyclePrint();
    }


    public void cyclePrint() {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (this) {
                    System.out.println("A");
                    this.notify();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (this) {
                    System.out.println("B");
                    this.notify();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 这里要注意顺序
        thread1.start();
        thread2.start();
    }

}
