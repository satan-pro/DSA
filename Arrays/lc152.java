import java.util.*;
public class lc152 {
    public int maxProduct(int[] nums) {
        
        int max=nums[0];

        for(int i=0; i<nums.length; i++)
        {
            int prod=1;
            for(int j=i; j<nums.length; j++)
            {
                prod*=nums[j];
                if(prod>max)
                {
                    max=prod;
                }
            }
        }
        return max;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter array elements : ");
        for(int i=0; i<n; i++)
        {
            nums[i] = sc.nextInt();
        }
        sc.close();
        lc152 obj = new lc152();
        int max = obj.maxProduct(nums);
        System.out.println(max);
    }
}
