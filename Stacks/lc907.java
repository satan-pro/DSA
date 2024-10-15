import java.util.*;
class lc907  // Sum of Subarray Minimums
{
    // Intuition : Find the next smaller element and previous smaller element of each element in the array
    // Our goal is to find the total no of subarrays that can be formed with the small elements multiplied by the element itself 
    // Note : while calculating the pse/nse, take one which is less than or equal to arr[i] and one that is strictly less than arr[i] to avoid less calculations for a given subarray
	public int sumSubarrayMins(int[] arr) {
		int mod = (int)(1e9+7);
        Stack<Integer> st = new Stack<>();
        int pse[] = new int[arr.length];

        for(int i=0; i<arr.length; i++)
        {
        	while(!st.isEmpty() && arr[st.peek()]>=arr[i])
        		st.pop();
        	pse[i] = st.isEmpty()?-1:st.peek();
        	st.push(i);
        }

        st.clear();
        int nse[] = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--)
        {
        	while(!st.isEmpty() && arr[st.peek()]>arr[i])
        		st.pop();
        	nse[i] = st.isEmpty()?arr.length:st.peek();
        	st.push(i);
        }

        long res=0;
        for(int i=0; i<arr.length; i++)
        {
        	res+=(long)(i-pse[i])*(nse[i]-i)%mod*arr[i]%mod;
            res%=mod;
        }
        return (int)res;
    }
}