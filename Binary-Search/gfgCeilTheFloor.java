import java.util.*;
class gfgCeilTheFloor
{
	public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++)
        {
        	if(arr[i]<=x)
        		floor = Math.max(floor, arr[i]);
        	if(arr[i]>=x)
        		ceil = Math.min(ceil, arr[i]);
        }

        if(floor==Integer.MIN_VALUE)
        	floor=-1;
        if(ceil==Integer.MAX_VALUE)
        	ceil=-1;

        int res[] = {floor, ceil};
        return res;
    }
}