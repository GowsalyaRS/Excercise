import java.util.Arrays;

public class QuickSort 
{
    public static void main(String[] args) 
    {
        int arr [] = {8,2,6,1,9,4,7,8,3,5,};
        System.out.println("Original Array           : " + Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("Quick Sort Algorithm     : " + Arrays.toString(arr));   
    }

    private static void quickSort(int[] arr,int low,int high) 
    {
       if(low>high)
       {
          return;
       }
       int start = low;
       int end = high;
       int mid = (low+high)/2;
       int pivot = arr[mid];
       while(start<=end)
       {
          if(arr[start]<pivot)
          {
             start++;
          }
          else if(arr[end]>pivot)
          {
            end--;
          }
          else
          {
             int temp = arr[start];
             arr[start] = arr[end];
             arr[end] = temp;
             start++;
             end--;
          }
       }
       quickSort(arr, low, end);
       quickSort(arr, start, high);
    }  
}
