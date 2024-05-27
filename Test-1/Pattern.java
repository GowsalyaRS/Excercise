import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
	  Scanner sacn = new Scanner(System.in);
	   int size =7;
	   for(int i=(size/2) ;i>=0;i--)
	   {
	       int count = (size/2)+1-i;
	       for(int j=0;j<size-i;j++)
	       {
	         if(i<=j)
	         {
	           if(j<(size/2))
	           {
	               System.out.print(count--);
	           }
	           else
	           {
	              System.out.print(count++);
	           }
	         }
	         else
	         {
	             System.out.print(" ");
	         }
	       }
	       System.out.println();
	   }
	   for(int i=1;i<(size/2)+1;i++)
	   {
	       int count = (size/2)+1-i;
	       for(int j=0;j<size-i;j++)
	       {
	        if(i<=j)
	        {
	           if(j<(size/2))
	           {
	               System.out.print(count--);
	           }
	           else
	           {
	              System.out.print(count++);
	           }
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
