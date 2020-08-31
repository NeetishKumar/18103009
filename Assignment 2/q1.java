import java.util.*;

public class q1
{
	public static void print(String msg)
	{
		System.out.println(msg);
	}
	
	public static int compare(String a, String b)
	{
		for(int i=0 ; i<a.length() && i<b.length() ; i++)
		{
			if(a.charAt(i) != b.charAt(i))
			{
				return a.charAt(i)-b.charAt(i);
			}
		}
		return a.length()-b.length();
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		print("Enter two strings : ");
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		int ans = compare(str1,str2);

		if(ans==0)
		{
			print("Both strings are same");
		} 
		else if(ans>0)
		{
			System.out.println(str1 + " is bigger than " + str2);
		}
		else
		{
			System.out.println(str1 + " is smaller than " + str2);
		}
	}
}