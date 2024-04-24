public class SubArray 
{
   public static void main(String[] args) 
   {
       int arr [] = {2,7,5,-1,-3,2,9,7};
       int sum =0;
       int max = Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++)
       {
           sum+=arr[i];
           if(arr[i]<0)
           {
              sum=0;
           }
           if(sum>max)
           {
             max =sum;
           }
       }
       System.out.println("Largest Sub Array Sum  : " + max);
   } 
}
