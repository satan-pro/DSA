import java.util.*;
class lc1545
{
	public char findKthBit(int n, int k) {
 		
 		StringBuilder s = new StringBuilder("0");

 		for(int i=2; i<=n; i++)
 		{
 			StringBuilder suffix = new StringBuilder();
 			for(int j=s.length()-1; j>=0; j--)
 			{
 				if(s.charAt(j)=='0')
 					suffix.append("1");
 				else 
 					suffix.append("0");
 			}
 			s.append("1");
 			s.append(suffix);
 		} 

 		return s.charAt(k);      
    }
}