import java.util.*;

public class Q4
{
    static boolean checkAnagram(char[] a, char[] b)
    {
        //if(a.length() != b.length())
          //  return false;
        Arrays.sort(a);
        Arrays.sort(b);

        if(Arrays.equals(a,b))
            return true;
        else 
            return false;
        //return true;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 strings:");
        char a[] = sc.next().toCharArray();
        char b[] = sc.next().toCharArray();

        if(checkAnagram(a,b))
            System.out.println("The strings are anagram");
        else
            System.out.println("The strings are not anagram");

    }
}

