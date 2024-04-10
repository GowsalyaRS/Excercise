/* Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]] */

import java.util.List;
import java.util.ArrayList;
public class Pascal 
{
    public static void main(String[] args) 
    {
        int numRow = 5;
        List <ArrayList<Integer>> ls = new ArrayList();
        for(int i=0;i<numRow;i++)  
        {
            ArrayList s = new ArrayList();
            for(int j=0;j<=i;j++)
            {
                if(j==0 || i==j)
                {
                    s.add(1);
                }
                else
                {
                  ArrayList <Integer> l =  ls.get(i-1);
                  s.add(l.get(j-1)+l.get(j));
                }
            }
            ls.add(s);
        }
       System.out.println(ls);
    } 
}
