// 2. Program to use multiple threads to find the integer in the range 1 to 10000 that has maximum number of divisors.

import java.util.*;

public class Q2 extends Thread
{
    static int maxDiv = 0, num = 0;
    int start;
    
    public Q2(int start)
    {
        this.start = start;
    }
    
    public void run()
    {
        int div;

        for(int i=start; i<this.start+10000; i++)
        {
            div = 0;

            for(int j=1; j<=i; j++)
                if(i%j == 0)
                    div += 1;
               
            
            if(div>maxDiv)
                synchronized(this)
                {
                    maxDiv = div;
                    num = i;
                }
            
        }
    }

    public static void main(String[] args)
    {
        Q2 t1 = new Q2(1);
        Q2 t2 = new Q2(10001);
        Q2 t3 = new Q2(20001);
        Q2 t4 = new Q2(30001);
        Q2 t5 = new Q2(40001);
        Q2 t6 = new Q2(50001);
        Q2 t7 = new Q2(60001);
        Q2 t8 = new Q2(70001);
        Q2 t9 = new Q2(80001);
        Q2 t10 = new Q2(90001);

        long startTime = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        
        try
        {        
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
        }

        catch(Exception e)
        {
            ;
        }

        long endTime = System.currentTimeMillis();

        System.out.println("\nResultant number : " + num);
        System.out.println("\nNumber of divisors : " + maxDiv);
        
        System.out.println("\nTime elapsed: " + (endTime-startTime) + " ms");
    }
    
}