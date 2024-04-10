// Array elements are stored in Sequential/Random location ?
public class Arrayss 
{
   public static void main(String[] args) 
   {
      int arr [] = new int [5]; // sequential location. so before use array, created memory allocate.
      for(int i=0;i<arr.length;i++)
      {
        arr[i] = i+1;
        System.out.println(arr[i]);
      }
   }  
}
