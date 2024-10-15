import java.util.*;
class gfgNumberOfNGE
{
	public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
	 int res[] = new int[queries];
	 Stack<Integer> st = new Stack<>();

     for(int i=0; i<queries; i++)
     {
     	for(int j=indices[i]+1; j<N; j++)
     	{
     		if(arr[j]>arr[indices[i]])
     			st.push(arr[j]);
     	}
     	res[i]=st.size();
     	st.clear();
     }
     return res;
  }
}