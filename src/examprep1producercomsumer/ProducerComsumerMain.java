package examprep1producercomsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author ChristopherBorum
 */
public class ProducerComsumerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> bq1 = new ArrayBlockingQueue<Integer>(11);
        BlockingQueue<Integer> bq2 = new ArrayBlockingQueue<Integer>(11);
        int[] nums = {4,5,8,12,21,22,34,35,36,37,42};
        for (int num : nums) {
            bq1.put(num);
        }
        Producer p1 = new Producer(bq1, bq2);
        Producer p2 = new Producer(bq1, bq2);
        Producer p3 = new Producer(bq1, bq2);
        Producer p4 = new Producer(bq1, bq2);
        Consumer c1 = new Consumer(bq2);
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();
        new Thread(c1).start();
    }
    
}
