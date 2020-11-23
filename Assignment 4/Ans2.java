class Ans2
{
    public static void main(String[] args)
    {
        int num = -1;
        byte byt = (byte)num;
        char chr = (char)byt;
        int fin = chr;
        
        System.out.println("The initial number is: " + num);
        System.out.println("The number after converting into bytes: " + byt);
        System.out.println("And after being converted to character: " + chr);
        System.out.println("The end result is : " + fin + " after converting back to integer.");
    }
}
