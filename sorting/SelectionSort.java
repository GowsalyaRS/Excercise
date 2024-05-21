import java.util.Arrays;
public class SelectionSort
{
    public static void main(String[] args) 
    {
        int arr [] = {8,2,6,1,9,4,7,8,3,5,};
        System.out.println("Original Array        : " + Arrays.toString(arr));
        for(int i=0;i<arr.length;i++) 
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]>arr[j])
                {
                    int temp = arr[i];
                    arr[i]   = arr[j];
                    arr[j]   = temp;
                }
            }
        }
        System.out.println("Selection Sort Array  : " + Arrays.toString(arr));
    }
}