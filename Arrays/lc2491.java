import java.util.*;
class lc2491
{
	public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int i=0;
        int j=skill.length-1;
        int sum = skill[i]+skill[j];
        long ans = 0;

        while(i<j)
        {
        	if(sum!=skill[i]+skill[j])
        		return -1;
        	else 
        		ans+=(skill[i]*skill[j]);
        	i++;
        	j--;
        }

        return ans;
    }
}