import java.util.Arrays;
public class AddArray 
{
    public static void main(String[] args) 
    {
        int arr [] ={9,2,8,1,3,5,6,7,3,1,1,6};
        int a [] = {7,8,4,6,2,1,9,9,7};
        int result = (arr.length>a.length)?arr.length:a.length;
        int b [] = new int [result+1];
        int i = arr.length-1;
        int j = a.length-1;
        int balance =0;
        int len = b.length-1;
        while(i>=0 && j>=0)
        {
            int res = arr[i--] + a[j--]+balance;
            balance =isChech(res,b,len);
            len--;
        }
        while(i>=0)
        {
           int res = arr[i--]+ balance;
           balance =isChech(res,b,len);
           len--;
        }
        while(j>=0)
        {
            int res = a[j--]+ balance;
            balance =isChech(res,b,len);
            len--;
        }
        if(balance!=0)
        {
            b[len--] = balance;
        }
        System.out.println(Arrays.toString(b));
    }
    private static int isChech(int res, int[] b, int len) 
    {
            if(res<=9)
            {
              b[len] = res;
            }
            else
            {
               int rem = res%10;
               b[len] = rem;
               return res/10;
            }
        return 0;
    }
}
