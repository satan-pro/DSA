import java.util.*;
class gfgFloydWarshall
{
	public void shortestDistance(int[][] mat) {
        // Code here

        // Build the adjacency matrix
        // 0 for same nodes
        // 10^8 for unreachable nodes
        for(int i=0; i<mat.length; i++)
        {
        	for(int j=0; j<mat.length; j++)
        	{
        		if(mat[i][j]==-1)
        			mat[i][j] = (int)(1e8);

        		if(i==j)
        			mat[i][j]=0;	
        	}
        }

        // Floyd-Warshall Algorithm
        for(int k=0; k<mat.length; k++)
        {
        	for(int i=0; i<mat.length; i++)
        	{
        		for(int j=0; j<mat.length; j++)
        		{
        			mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
        		}
        	}
        }

        // unreachable nodes reset to -1
        for(int i=0; i<mat.length; i++)
        {
        	for(int j=0; j<mat.length; j++)
        	{
        		if(mat[i][j]==(int)(1e8))
        			mat[i][j] = -1;
        	}
        }
    }
}