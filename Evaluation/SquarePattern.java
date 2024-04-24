import java.util.Scanner;
public class SquarePattern 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Number :");
        int n =scan.nextInt();
        int arr [][]= new int [n][n];
        int srow=0,scol=0,erow=n,ecol=n;
        int total = n*n;
        int count = 0;
        boolean flag = true;
        while(count<total)
        {
            for(int i=srow,j=scol;i<ecol;)
            {
                arr[i][j]=(flag)?1:0;
                count++;
                if(j==ecol-1)
                {
                  i++;
                }
                else
                {
                   j++;
                }
            }
            for(int i=erow-1,j=ecol-2;i>srow;)
            {
                arr[i][j]=(flag)?1:0;
                count++;
                if(j==scol)
                {
                    i--;
                }
                else
                {
                    j--;
                }
            }
            srow++;
            scol++;
            erow--;
            ecol--;
            flag =!flag;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    } 
}
