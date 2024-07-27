import java.util.*;
class lc1550
{
	public boolean threeConsecutiveOdds(int[] arr) {
        int count=0;
        int i=0;
        int j=0;
        while(j<arr.length)
        {
        	if(arr[j]%2==0)
        	{
        		i=j+1;
        		j=i;
                count=0;
        	}
        	else{
        		j++;
        		count++;
        	}
        	if(count==3)
        		return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	int arr[] = {2,6,4,1};
    	lc1550 obj = new lc1550();
    	System.out.println(obj.threeConsecutiveOdds(arr));
    }
}