import java.util.*;
public class lc31 {
    public static void nextPermutation(int[] nums)
    {
        int count = 0;
        int i;
        for(i=nums.length-1; i>0; i--)
        {
            if(nums[i]>nums[i-1])
            {
                count++;
                break;
            }
        }

        outer : if(count>0)
        {
            i--;
            inner : for(int j=nums.length-1; j>i; j--)
            {
                if(nums[j]>nums[i])
                {
                    int t =nums[j];
                    nums[j]=nums[i];
                    nums[i]=t;
                    break inner;
                }
            }

            int arr[] = new int[nums.length-i-1];

            for(int k=0; k<arr.length; k++)
            {
                arr[k]=nums[i+k+1];
            }
            Arrays.sort(arr);
            for(int k=0; k<arr.length; k++)
            {
                nums[i+k+1]=arr[k];
            }
        }
        else{
            Arrays.sort(nums);
        }
        
    }
    public static void main(String[] args) {
        int nums[] = {1,2,4,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
