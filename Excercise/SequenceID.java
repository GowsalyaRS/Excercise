/* Given a sequence of length <= 8 consisting of I and D, where I denotes the increasing sequence and D denotes the decreasing sequence, decode the sequence to construct a minimum number without repeated digits.

For example,

sequence        output
 
IIDDIDID  ——>  125437698
IDIDII    ——>  1325467
DDDD      ——>  54321
IIII      ——>  12345 */

import java.util.Stack;
public class SequenceID 
{
   public static void main(String[] args) 
   {
       String str = "IIDDIDID";
       String m ="";
       Stack <Integer> s = new Stack ();
       for(int i=0;i<=str.length();i++)
       {
          s.push(i+1);
          if(i==str.length() || str.charAt(i)=='I')
          {
            while(!s.isEmpty()) 
            {
               m+=s.pop();
            }
          }
       }
       System.out.println(m);
   } 
}
