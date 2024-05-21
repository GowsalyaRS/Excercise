import java.util.Arrays;

public class InsertionSort 
{
    public static void main(String[] args) 
    {
        int arr [] = {8,2,6,1,9,4,7,8,3,5,};
        System.out.println("Original Array           : " + Arrays.toString(arr)); 
        for(int i=0;i<arr.length;i++)
        {
            int key = arr[i];
            int j = i-1;
            while(j>=0 && key<arr[j])
            {
               arr[j+1] =arr[j];
               j--;
            }
            arr[j+1] = key;
        }
        System.out.println("Insertion Sort Algorithm : " + Arrays.toString(arr));
    }
}
