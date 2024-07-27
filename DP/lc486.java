import java.util.*;
class lc486
{
	public boolean predictTheWinner(int[] nums) {
        int p1=0;
        int p2=0;
        int left=0;
        int right=nums.length-1;
        int count=1;
        int opt1,opt2;
        while(left<=right)
        {
        	if(left==right)
        	{
        		opt1=nums[left];
        		opt2=nums[right];
        	}
        	else{
        	opt1 = nums[left]+nums[right-1];
        	opt2 = nums[left+1]+nums[right];
        }
        System.out.println("option 1 : "+opt1+"\noption 2 : "+opt2);
        	
        	if(opt1>opt2)
        	{
        		if(count%2==0)
        		{
        			p2+=nums[left];
        			System.out.println("Player 2 chooses : "+nums[left]);
        			left++;
        		}
        		else
        		{
        			p1+=nums[left];
        			System.out.println("Player 1 chooses : "+nums[left]);
        			left++;
        		}
        	}
        	else{
        		if(count%2==0)
        		{
        			p2+=nums[right];
        			System.out.println("Player 2 chooses : "+nums[right]);
        			right--;
        		}
        		else 
        		{
        			p1+=nums[right];
        			System.out.println("Player 1 chooses : "+nums[right]);
        			right--;
        		}
        	}
        	count++;
        }

        if(p1<p2)
        	return false;
        else
        	return true;
    }
    public static void main(String[] args) {
    	int arr[] = {1,5,233,7};
    	lc486 obj = new lc486();
    	System.out.println(obj.predictTheWinner(arr));
    }
}