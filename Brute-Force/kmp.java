import java.util.*;
class kmp
{
    int lps[];

    void findLps(String pattern)
    {
        int lp = pattern.length();
        
        lps = new int[lp];
        
        int prev = 0, i=1;
        lps[0]=prev;
        while(i<lp)
        {
            if(pattern.charAt(prev)==pattern.charAt(i))
            {
                lps[i]=prev+1;
                prev++;
                i++;
            }
            else{
                if(prev==0)
                {
                    lps[i]=0;
                    i++;
                }
                else{
                    prev = lps[prev-1];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str = sc.nextLine();
        System.out.println("Enter the pattern : ");
        String pattern = sc.nextLine();
        sc.close();

        kmp obj = new kmp();

        obj.findLps(pattern);

        System.out.println(Arrays.toString(obj.lps));

        int i=0, j=0;
        boolean found = false;
        while(i<str.length())
        {
            if(str.charAt(i)==str.charAt(j))
            {
                i++;
                j++;
            }
            else{
                if(j==0)
                {
                    i++;
                }
                else{
                    j=obj.lps[j-1];
                }
            }
            if(j==pattern.length())
            {
                System.out.println("Pattern found at : "+(i));
                found=true;
            }
        }
        if(!found)
        {
            System.out.println("Pattern not found in the string");
        }
    }

}
