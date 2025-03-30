import java.util.*;
class lc2244
{
	public int minimumRounds(int[] tasks) {
        // Hashmap to count values of all the unique numbers
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: tasks){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int ans = 0;

        // There are only 4 cases to this problem:
        // If count == 1 ; return -1
        // If count == 3k ; we get k batches
        // If count == 3k+1 ; we can divide it into 3(k-1)+2+2 batches
        // If count == 3k+2 ; we can divide it into 3k + 2 batches

        // So in either of the last 2 cases, if we divide by 3, we need to create one extra batch of 2
        // This we can do by checking if the count is completely divisible by 3 or not
        for(int k: map.values())
        {
            if(k==1)
                return -1;
            // divide by 3 and add to answer for all cases
            ans+=k/3;

            // If there is some remaining after dividing by 3, then increase the batch count by 1
            if(k%3!=0)
                ans++;
        }

        return ans;
    }
}