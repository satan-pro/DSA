import java.util.*;
class lc2593
{
	public long findScore(int[] nums) {
        int[][] arr = new int[nums.length][2];

        // Marked array to keep track of marked indexes
        boolean[] marked = new boolean[nums.length];

        // Store the nums inside a 2D array containing : [nums[i], i]
        for(int i=0; i<nums.length; i++)
        {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort the array by the first index, i.e. nums[i]
        Arrays.sort(arr, (a,b)->a[0]-b[0]);

        // Keep track of the no of indexes already marked
        int markedCount=0;
        long score = 0;
        int i=0;

        // Run the loop until all the indexes have been marked
        while(markedCount<nums.length)
        {
            int ind = arr[i][1];

            // Apply the condition given in the question
            if(!marked[ind])
            {
                score+=(long)arr[i][0];
                marked[ind]=true;
                markedCount++;
            
                if(ind>0 && !marked[ind-1])
                {
                    marked[ind-1]=true;
                    markedCount++;
                }
                if(ind<nums.length-1 && !marked[ind+1])
                {
                    marked[ind+1]=true;
                    markedCount++;
                }
            }

            i++;
        }

        return score;
    }
}