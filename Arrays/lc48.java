import java.util.*;
class lc48
{
	int arr[][];
	public void rotate(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int temp[][] = new int[rows][cols];

        for(int i=0; i<rows; i++)
        {
        	for(int j=0; j<cols; j++)
        	{
        		temp[j][cols-i-1]=matrix[i][j];
        	}
        }

        for(int i=0; i<rows; i++)
        {
        	for(int j=0; j<cols; j++)
        	{
        		matrix[i][j]=temp[i][j];
        	}
        }

    }

    public static void main(String[] args) {
    	int arr[][]={{1,2,3},{4,5,6},{7,8,9}};

    	lc48 obj = new lc48();
    	obj.rotate(arr);
    	for(int i=0; i<arr.length; i++)
    	{
    		System.out.print(Arrays.toString(arr[i]));
    	}
    }
}