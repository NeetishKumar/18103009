import java.util.Scanner;

public class q5_1 
{

    public static void print(String msg)
    {
        System.out.println(msg);
    }

    public static void intersection(int []a1, int[] a2) {
        int n1=a1.length;
        int n2=a2.length;
        int emptyflag=1;
        int[] ours=new int[Math.min(n1, n2)];
        int i1=0, i2=0, index=0;
        while(i1<n1 && i2<n2) {
            if (a1[i1] == a2[i2]) {
                ours[index] = a1[i1];
                index++;
                i1++;
                i2++;
                emptyflag = 0;
            }
            else if (a1[i1] < a2[i2]) {
                i1++;
            }
            else i2++;
        }
        print("Intersection is:");
        if(emptyflag==1)
            System.out.print("NULL");
        else
            for(int i=0; i<index; i++)
                System.out.print(" " + ours[i]);
    }

    public static void union(int []a1, int[] a2) {
        int n1=a1.length;
        int n2=a2.length;
        int[] ours=new int[n1+n2];
        int i1=0, i2=0, index=0;
        while(i1<n1 && i2<n2) {
            if(a1[i1]==a2[i2]) {
                ours[index++]=a1[i1++];
                i2++;
            }
            else if(a1[i1]<a2[i2]) {
                ours[index++]=a1[i1++];
            }
            else {
                ours[index++]=a2[i2++];
            }
        }
        while(i2<n2) {
            ours[index++] = a2[i2++];
        }
        while(i1<n1) {
            ours[index++]=a1[i1++];
        }
        print("Union is:");
        for(int i=0; i<index; i++)
            System.out.print(" " + ours[i]);
    }

    public static void complement(int []a1, int []ref) {
        int n1=a1.length, index=0;
        int []ours=new int[11];
        int i=0, j=0, emptyflag=1;
        while(index<11 && i<n1) {
            if(a1[i]==ref[index]) {
                i++;
                index++;
            }
            else {
                ours[j++]=ref[index++];
                emptyflag=0;
            }
        }
        while(index<11) {
            ours[j++] = ref[index++];
            emptyflag = 0;
        }
        print("Complement is:");
        if(emptyflag==1)
            System.out.print("NULL");
        else
        for(i=0; i<j; i++)
            System.out.print(" " + ours[i]);
    }

    public static int[] finetune(int[] a1) {
        int n=a1.length;
        int ref[]= new int [11];
        for(int i=0; i<11; i++)
            ref[i]=0;
        for(int i=0; i<n; i++) {
            ref[a1[i]]++;
        }
        int index=0;
        for(int i=0; i<11; i++) {
            if(ref[i]!=0) {
                a1[index]=i;
                index++;
            }
        }
        int []ours= new int [index];
//      System.arraycopy(ours, 0, a1, 0, index);
        for(int i=0; i<index; i++)
            ours[i]=a1[i];
        return ours;
    }

    public static void main(String[] args) {
		
        Scanner obj = new Scanner (System.in);
        print("No. of elements in first set:");
        int n1=obj.nextInt();
        print("No. of elements in second set:");
        int n2=obj.nextInt(), count=0;
        int ref[]={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int []arr1= new int[n1];
        int []arr2= new int[n2];
        print("Elements of first set:");
        for(int i=0; i<n1; i++) {
            arr1[i] = obj.nextInt();
            while(arr1[i]<0 || arr1[i]>10) {
                print("Not a valid choice. Enter a number between 0 and 10");
                arr1[i]=obj.nextInt();
            }
        }
        print("Elements of second set:");
        for(int i=0; i<n2; i++) {
            arr2[i] = obj.nextInt();
            while(arr2[i]<0 || arr2[i]>10) {
                print("Not a valid choice. Enter a number between 0 and 10");
                arr2[i]=obj.nextInt();
            }
        }
		long start = System.currentTimeMillis();
        arr1=finetune(arr1); //sort and handle repetitions
        arr2=finetune(arr2);
        union(arr1, arr2);
        intersection(arr1, arr2);
        complement(arr1, ref);
        complement(arr2, ref);
		long end = System.currentTimeMillis();
        System.out.println("Time taken: "+(end-start)+" milliseconds");
    }
}