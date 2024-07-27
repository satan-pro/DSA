import java.util.*;
class lc100351
{
	/*public int numberOfAlternatingGroups(int[] colors, int k) {
        int i=0;
        int size=colors.length;
        int count=0;
        while(i<colors.length)
        {
            int j = (i+k-1)%size;
            int m=(i+1)%size;
            boolean flag=true;
            count++;
            inner : while(m<j)
            {
            	System.out.println(colors[m]+" "+colors[m+1]+" "+m+" "+(m+1)+" "+i);
                if(colors[m]==colors[(m+1)%size])
                {
                	
                    count--;
                    break inner;
                }
                m++;
            }
            i++;
        }
        return count;
    }*/

    /*public int numberOfAlternatingGroups(int[] colors, int k) {
    int size = colors.length;
    int count = 0;
    int cap = 
    for (int i = 0; i < size;) {
        boolean isValidGroup = true;
        int j;
        for (j = 1; j < k; j++) {
            int current = colors[(i + j) % size];
            int next = colors[(i + j + 1) % size];

            if (current == next) {
                isValidGroup = false;
                break;
            }
        }

        if (isValidGroup) {
        	i++;
        	count++;
        	continue;
        }
        i=i+j;
    }

    return count;
}*/

public int numberOfAlternatingGroups(int[] colors, int k)
{
	int size = colors.length;
	int count=0;
	int i=0;
	boolean valid=true;
	int cap=(i+k)%size;
	for(; i<size; )
	{
		int j=(i+1)%size;

		if(colors[i]==colors[j] && i!=size-1)
		{
			i=j;
			valid=false;
			continue;
		}
		if(i>=cap)
		{
			if(valid)
				count++;
			cap=(i+k)%size;
			valid=true;
		}
		i++;
	}
	return count;
}

    public static void main(String[] args) {
    	lc100351 obj = new lc100351();
    	int arr[] = {0,1,0,1,0};
    	int res = obj.numberOfAlternatingGroups(arr,3);
    	System.out.println(res);
    }
}