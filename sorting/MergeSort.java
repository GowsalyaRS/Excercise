import java.util.Arrays;

public class MergeSort 
{
    public static void main(String[] args) 
    {
        int arr [] = {8,2,6,1,9,4,7,8,3,5,};
        System.out.println("Original Array           : " + Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println("Merge Sort Algorithm     : " + Arrays.toString(arr));  
    }
    private static void mergeSort(int[] arr, int low, int high) 
    {
        if(low<high)  
        {
            int mid = (low+high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            mergeSort(arr, low,mid, high);
        }
    }
    private static void mergeSort(int[] arr, int low, int mid, int high) 
    {
       int arr1[] = new int [mid-low+1];
       int arr2[] = new int [high-mid];  
       for(int i=0;i<arr1.length;i++)
       {
          arr1 [i]= arr[low+i];
       }
       for(int i=0;i<arr2.length;i++)
       {
          arr2[i] = arr[mid+i+1];
       }
       int i=0,j=0,k=low;
       while(i<arr1.length && j<arr2.length)
       {
           if(arr1[i]<arr2[j])
           {
             arr[k++] = arr1[i++];
           }
           else
           {
             arr[k++] = arr2[j++];
           }
       }
       while(i<arr1.length)
       {
         arr[k++] = arr1[i++];
       }
       while(j<arr2.length)
       {
         arr[k++] = arr2[j++];
       }
    }
}
