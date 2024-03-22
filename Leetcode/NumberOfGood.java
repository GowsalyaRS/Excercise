/* Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

 

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0 */
class NumberOfGood
{
    public static int numIdenticalPairs(int[] nums)  
    {
        int i=0,j=1;
        int count =0;
        while(i<nums.length && j<nums.length)
        {
            if(nums[i]==nums[j])
            {
                count++;
            }
            j++;
            if(j==nums.length)
            {
                i=i+1;
                j=i+1;
            }
           
        }
         return count;
    }
    public static void main(String[] args) 
    {
       System.out.println(numIdenticalPairs(new int [] {1,1,1,1})); 
    }
}
