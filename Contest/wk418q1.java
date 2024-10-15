import java.util.*;
class wk418q1
{
	public int maxGoodNumber(int[] nums) {
        String binary[] = new String[nums.length];
        for(int i=0; i<nums.length; i++)
        {
        	binary[i] = Integer.toBinaryString(nums[i]);
        }

        Arrays.sort(binary, (a,b)->(b+a).compareTo(a+b));

        StringBuilder res = new StringBuilder();
        for(String bin: binary)
        {
        	res.append(bin);
        }

        String finalRes = res.toString();
        if(finalRes.startsWith("0"))
        	return 0;

        int ans = (int)Integer.parseInt(finalRes,2);
        return ans;
    }
}