package demo;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RateService
{
    private BigDecimal rate = BigDecimal.ZERO;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public BigDecimal getRate()
    {
        readWriteLock.readLock().lock();
        BigDecimal newRate = rate;
        readWriteLock.readLock().unlock();
        return newRate;
    }

    public void setRate(BigDecimal rate)
    {
        readWriteLock.writeLock().lock();
        this.rate = rate;
        readWriteLock.writeLock().unlock();
    }

    private static class Read implements Runnable
    {
        private RateService rateService;

        public Read(RateService rateService)
        {
            this.rateService = rateService;
        }

        public void run()
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(rateService.getRate());
        }
    }

    private static class Write implements Runnable
    {
        private RateService rateService;

        public Write(RateService rateService)
        {
            this.rateService = rateService;
        }

        public void run()
        {
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            BigDecimal updatedRate = new BigDecimal(new Random().nextInt(100));
            String threadName = Thread.currentThread().getName();
            synchronized (this)
            {
                System.out.println(System.nanoTime() + " - " + threadName + " WRITE: " + updatedRate);
                rateService.setRate(updatedRate);
            }
        }
    }

    public static void main(String[] args)
    {
        RateService rateService = new RateService();
        Write write = new Write(rateService);
        for(int i = 0; i < 10; i++)
        {
            Thread thread = new Thread(write);
            thread.setName("W" + i);
            thread.start();
        }

        Read read = new Read(rateService);
        for(int i = 0; i < 10; i++)
        {
            Thread thread = new Thread(read);
            thread.start();
        }
    }
}
