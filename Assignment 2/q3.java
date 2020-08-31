import java.util.*;

public class q3
{
	public static void print(String msg)
	{
		System.out.println(msg);
	}

	public static void sorting(char[] arr)
	{
		for(int i=0 ; i<arr.length ; i++)
		{
			for(int j=0 ; j<arr.length; j++)
			{
				if(arr[i]<arr[j])
				{
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		print("Enter the string :");
		String a = sc.nextLine();
		char[] arr = a.toCharArray();
		sorting(arr);
		a = new String(arr);
		print("String after sorting : ");
		print(a);
	}
}