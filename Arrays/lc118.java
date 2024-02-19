import java.util.*;
public class lc118 {
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        pascal.add(temp);
        for(int i=1; i<numRows; i++)
        {
            List<Integer> a = pascal.get(i-1);
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            for(int j=0; j<a.size()-1; j++)
            {
                if(a.size()<2)
                {
                    break;
                }
                else{
                    arr.add(a.get(j)+a.get(j+1));
                }
            }
            arr.add(1);
            pascal.add(arr);
        }
        return pascal;
    }
}
