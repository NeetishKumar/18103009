import java.util.*;

public class q5_2 
{
    public static void print(String msg)
    {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        
        Set<Integer> set1=new HashSet<Integer>();
        Set<Integer> set2=new HashSet<Integer>();
        Set<Integer> ref=new HashSet<Integer>();
        ref.addAll(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        Scanner obj= new Scanner(System.in);
        print("No. of elements in first set:");
        int n1=obj.nextInt();
        print("No. of elements in second set:");
        int n2=obj.nextInt();
        print("Elements of first set:");
        for(int i=0; i<n1; i++) {
            int x=obj.nextInt();
            while(x<0 || x>10) {
                print("Not a valid choice. Enter a number between 0 and 10");
                x=obj.nextInt();
            }
            set1.add(x);
        }
        print("Elements of second set:");
        for(int i=0; i<n2; i++) {
            int x=obj.nextInt();
            while(x<0 || x>10) {
                print("Not a valid choice. Enter a number between 0 and 10");
                x=obj.nextInt();
            }
            set2.add(x);
        }
		long start = System.currentTimeMillis();
        Set<Integer> orion=new HashSet<Integer>(set1);
        orion.addAll(set2);
        System.out.println("Union: "+orion);
        Set<Integer> inte= new HashSet<Integer>(set1);
        inte.retainAll(set2);
        System.out.println("Intersection: "+inte);
        Set<Integer> comps1= new HashSet<Integer>(ref);
        comps1.removeAll(set1);
        System.out.println("Complement of set 1: "+comps1);
        Set<Integer> comps2= new HashSet<Integer>(ref);
        comps2.removeAll(set2);
        System.out.println("Complement of set 2: "+comps2);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: "+(end-start)+" milliseconds");
    }
}