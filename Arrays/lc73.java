import java.util.*;
public class lc73 {
    public void setZeroes(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        ArrayList<ArrayList<Integer>> check = new ArrayList<>();
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(matrix[i][j]==0)
                {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    check.add(a);
                }
            }
        }

        for(int i=0; i<check.size(); i++)
        {
            int row = check.get(i).get(0);
            int col = check.get(i).get(1);
            for(int k=0; k<rows; k++)
            {
                matrix[k][col]=0;
            }
            for(int m=0; m<cols; m++)
            {
                matrix[row][m]=0;
            }
        }
    }
}
