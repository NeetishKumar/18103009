import java.util.*;
public class q4
{
	public static void print(String msg)
	{
		System.out.println(msg);
	}
	public static void printt(int a)
	{
		System.out.print(a);
	}

	public static void main(String args[])
	{
		int i=1;
		int sum=0;
		int ans=0;
		for(; i<Integer.MAX_VALUE ; i++)
		{
			sum = sum+i;
			if(sum == i*i)
				ans=i;
		}
		System.out.println("Smallest answer for the question : " + ans);
		System.out.println("The program ended at : " + i);
	}
}