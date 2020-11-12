// 1. To count nos. from 1 to 100 using thread with 1 sec pause.

import java.util.*;

public class Q1 extends Thread
{

	public void run()
	{
		for(int i=0; i<100; i++)
		{
			System.out.println(i+1);

			if((i+1) % 10 == 0)
				System.out.println("###### 10 Numbers Printed ######");

			try
			{
				Thread.sleep(1000);
			}

			catch(Exception e)
			{
				;
			}

		}
	}


	public static void main(String[] args)
	{
		Q1 newThread = new Q1();
		newThread.start();
	}

}