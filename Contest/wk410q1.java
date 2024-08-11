import java.util.*;
class wk410q1
{
	public int finalPositionOfSnake(int n, List<String> commands) {
        int grid[][] = new int[n][n];
        int i=0, j=0;
        for(String s: commands)
        {
        	if(s.equals("UP"))
        		i--;
        	else if(s.equals("DOWN"))
        		i++;
        	else if(s.equals("RIGHT"))
        		j++;
        	else 
        		j--;
        }
        return (i*n)+j;
    }
}