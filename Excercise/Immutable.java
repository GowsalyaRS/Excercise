// Write a program in Java to prove that the strings are immutable in Java.
public class Immutable 
{
    public static void main(String[] args) 
    {
        String a = "zoho" ;
        String b = "zoho";
        String c = new String ("zoho");
        System.out.println(a==b); // string constant pool create one memory point all same object refer same object so unmotify String.
        System.out.println(a==c);  
    }
}
