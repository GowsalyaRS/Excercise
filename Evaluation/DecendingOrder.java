import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
public class DecendingOrder 
{
    public static void main(String[] args) 
    {
        int len = 8;
        int arr [] = {4,1,2,3,1,2,5,2};   // 4's and 5's and 3's =1 then  1's =2  then 2's= 3
        int a [] = new int [len];
        for(int i=0;i<len;i++)
        {
            if(arr[i]==1)
            {
                a[i] = 2;
            }
            else if(arr[i]==2)
            {
                a[i] = 3;
            }
            else
            {
                a[i] =1;
            }
        }
        System.out.println( "Arrangning the conversion : "+ Arrays.toString(a));
        TreeMap<Integer,ArrayList<Integer> > ls = new TreeMap<>();
        for(int i=0;i<a.length;i++)
        {
            if(!ls.containsKey(a[i]))
            {
                ArrayList <Integer> al = new ArrayList<>();
                al.add(arr[i]);
                ls.put(a[i],al);
            }
            else
            {
                ArrayList <Integer> l = ls.get(a[i]);
                l.add(arr[i]);
                ls.put(a[i],l);
            }
        }
        int k=0;
        for(int i=ls.size();i>=1;i--)
        {
            for(int n :ls.get(i))
            {
               a[k++] = n;
            }
        }
        System.out.println( "Revered Array : "+ Arrays.toString(a));
    }
}
