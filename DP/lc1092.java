import java.util.*;
class lc1092  // Shortest common supersequence
{
	public String shortestCommonSupersequence(String str1, String str2) {
         int dp[][] = new int[str1.length()+1][str2.length()+1];

         // Making the dp array for finding the longest sommon subsequence
         for(int i=0; i<=str1.length(); i++)
         {
         	for(int j =0; j<=str2.length(); j++)
         	{
         		if(i==0 || j==0)
         			dp[i][j]=0;
         		else 
         		{
         			dp[i][j] = (str1.charAt(i-1)==str2.charAt(j-1))?1+dp[i-1][j-1]:Math.max(dp[i][j-1], dp[i-1][j]);
         		}
         	}
         }
         int maxLen = dp[str1.length()][str2.length()];
         int i=str1.length(), j=str2.length();
         String st="";

         // Finding the Longest common subsequence and storing it in a string
         while(i>0 && j>0)
         {
         	if(str1.charAt(i-1)==str2.charAt(j-1))
         	{
         		st=str1.charAt(i-1)+st;
         		i--;
         		j--;
         	}
         	else 
         	{
         		if(dp[i-1][j]>dp[i][j-1])
         		{
         			st = str1.charAt(i-1)+st;
         			i--;
         		}
         		else 
         		{
         			st = str2.charAt(j-1)+st;
         			j--;
         		}
         	}
         }	

         // Storing the remaining characters in the string
         while(i>0)
         {
         	st = str1.charAt(i-1)+st;
         	i--;
         }
         while(j>0)
         {
         	st = str2.charAt(j-1)+st;
         	j--;
         }

         return st;
    }
}