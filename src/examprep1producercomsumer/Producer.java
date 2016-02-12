package examprep1producercomsumer;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ChristopherBorum
 */
public class Producer extends Thread {
    
    BlockingQueue<Integer> bq1;
    BlockingQueue<Integer> bq2;

    public Producer(BlockingQueue<Integer> bq1, BlockingQueue<Integer> bq2) {
        this.bq1 = bq1;
        this.bq2 = bq2;
    }
    
    @Override
    public void run() {
        while(!bq1.isEmpty()) {
            int number = bq1.poll();
            int fibcalc = (int) fib(number);
            try {
                bq2.put(fibcalc);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public long fib(long n) {
        if ((n==0) || (n==1)) {
            return n;
        } else {
            return fib(n-1)+fib(n-2);
        }
    }
    
}
