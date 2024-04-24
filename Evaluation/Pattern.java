import java.util.Scanner;
public class Pattern
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the letter (upper or lower case)");
        char ch = scan.next().toUpperCase().charAt(0);
        int n = (int)ch-64;
        for(int i=1;i<=n;i++)
        {
           for(int j=n;j>=1;j-- )
           {
                if(j==1 || i==j)
                {
                 
                  System.out.print( (char)(i+64) + " " );
                }
                else
                {
                 System.out.print(" ");
                }
           }
           System.out.println();
        }
        for(int i=n-1;i>=1;i--)
        {
            for(int j=n;j>=1;j--)
           {
              if(i==j || j==1)
              {
                System.out.print( (char)(i+64) +" " );
              }
              else
              {
                System.out.print(" ");
              }
           }
           System.out.println();
        }
    }
}