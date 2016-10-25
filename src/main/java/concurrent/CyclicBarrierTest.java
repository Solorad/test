package concurrent;

import java.util.concurrent.*;

/**
 * @author emorenkov
 */
public class CyclicBarrierTest {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.submit(new CyclicClass(cyclicBarrier));
        cachedThreadPool.submit(new CyclicClass(cyclicBarrier));
        cyclicBarrier.await();
        System.out.println("Test");
    }


    private static class CyclicClass implements Runnable {
        private final CyclicBarrier cyclicBarrier;

        private CyclicClass(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }


        @Override
        public void run() {
            System.out.println("In run");
            try {
                cyclicBarrier.await();
                System.out.println("Finished.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
