import java.util.*;

public class q6
{
	public static void print(String msg)
	{
		System.out.print(msg);
	}

	public static void printt(int n)
	{
		System.out.print(n + " ");
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		print("Enter the value of N : ");
		int n = Integer.parseInt(sc.nextLine());
		if(n<1)
		{
			print("Invalid number for Hailstone Sequence");
			System.exit(0);
		}
		print("Hailstone Sequence : ");
		while(n!=1)
		{
			printt(n);
			if(n%2 == 0)
				n = n/2;
			else
				n = (n*3)+1;
		}
		printt(n);
	}
}