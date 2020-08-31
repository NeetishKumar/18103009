import java.util.*;
public class q2
{	
	public static void print(int a)
	{
		System.out.print(a + " ");
	}
	
	public static void printt(String msg)
	{
		System.out.println(msg);
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		printt("Enter n");
		int n=sc.nextInt();
	
		int arr[]=new int[n];
		printt("Enter the nos.");
	
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
	
		int count[]=new int[21];	
		for(int i=0;i<21;i++)
			count[i]=0;
	
		for(int i=0;i<n;i++)
		{
			count[arr[i]]++;
		}

		int i=0,index=0;
		while(i<n && index<21)
		{
			while(index<21 && count[index]<=0)
				index++;
			if(index==21)
				break;
			arr[i++]=index;
			count[index]--;
		}
	
		for(i=0;i<n;i++)
			print(arr[i]);
	}
}
