import java.util.Arrays;

public class BubbleSort 
{
    public static void main(String[] args)
    {
        int arr [] = {8,2,6,1,9,4,7,8,3,5,};
        System.out.println("Original Array        : " + Arrays.toString(arr));
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j]   = arr[j+1];
                    arr[j+1]   = temp;
                }
            }
        }
        System.out.println("Bubble Sorting Array  : " +  Arrays.toString(arr));
    }
} 
