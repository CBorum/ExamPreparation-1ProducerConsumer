package examprep1producercomsumer;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ChristopherBorum
 */
public class Consumer extends Thread{
    
    BlockingQueue<Integer> bq2;

    public Consumer(BlockingQueue<Integer> bq2) {
        this.bq2 = bq2;
    }
    
    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 11; i++) {
            try {
                int numb = bq2.take();
                System.out.println("Consumer got number: " + numb);
                sum += numb;
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Sum of numbers consumer got: " + sum);
    }
    
}
