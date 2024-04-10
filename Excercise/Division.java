/* Do the following problems without using multiplication or division operators 
a) Multiply a given integer with 15
b) Multiply a given even integer with 7.5
c) Calculate value of 15 × n/16  */

public class Division 
{
    public static void main(String[] args) 
    {
        int n = 20;
        int a = (n<<3) + (n<<2) + (n<<1) + (n<<0);
        System.out.println("a "+ a);
        int b = a>>1;
        System.out.println("b "+ b);
        int c = a>>4;
        System.out.println("c " + c);
    } 
}
