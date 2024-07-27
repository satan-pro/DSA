import java.util.*;
class lc88
{
 public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i=m-1, j=0;
    if(n==0)
        return;
    outer : while(i>=0 && j<n)
    {
        if(nums1[i]>nums2[j])
        {
            int temp = nums1[i];
            nums1[i]=nums2[j];
            nums2[j]=temp;
            i--;
            j++;
        }
        else if(nums1[i]<=nums2[j])
        {
            j++;
        }
    }
    for(i=0; i<n; i++)
    {
        nums1[m+i]=nums2[i];
    }
    Arrays.sort(nums1);
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums2[] = new int[n];
    for(int i=0; i<n; i++)
    {
        nums2[i]=sc.nextInt();
    }
    int m = sc.nextInt();
    int nums1[] = new int[m+n];
    for(int i=0; i<m; i++)
    {
        nums1[i]=sc.nextInt();
    }
    sc.close();
    for(int i=m; i<m+n; i++)
    {
        nums1[i]=0;
    }
    lc88 obj = new lc88();
    obj.merge(nums1, m, nums2, n);
}
}