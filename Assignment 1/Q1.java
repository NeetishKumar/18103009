import java.util.*;

public class Q1
{
	public static String sortString(String sub) 
	{ 
		 char t[] = sub.toCharArray();  
	     Arrays.sort(t); 
	     return new String(t); 
	} 
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string :");
		String str = sc.nextLine();
		System.out.println("Enter substring to check :");
		String sub = sc.nextLine();
		if(sub.length()>str.length())
		{
			System.out.println("Number of times the substring occurs in the String : 0\n");
			return;
		}

		String x = sub;
		x = sortString(x);
		int ans =0;

		for(int i=0 ; i<str.length() ; i++)
		{
			for(int j=i ; j<str.length() ; j++)
			{
				String a = str.substring(i , j+1);
				a = sortString(a);
				if(a.equals(x))
					ans++;
			}
		}
		System.out.println("Number of times substring occurs in the String : " + ans + "\n");

	}
}