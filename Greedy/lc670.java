import java.util.*;
class lc670
{
	public int maximumSwap(int num) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            else 
                return b[0]-a[0];
        });

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        String data[] = Integer.toString(num).split("");
        int arr[] = new int[data.length];

        for(int i=arr.length-1; i>=0; i--)
        {
            arr[i] = Integer.parseInt(data[i]);
            pq.offer(new int[]{arr[i], i});
            ArrayList<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }

        int i=0;
        boolean flag = false;

        while(!pq.isEmpty() && !flag)
        {
            int[] curr = pq.poll();

            if(curr[0]!=arr[i])
            {
                if(map.get(curr[0]).size()>1)
                {
                    curr[1] = map.get(curr[0]).get(0);
                }
                int temp = curr[0];
                arr[curr[1]] = arr[i];
                arr[i] = temp;

                flag=true;
            }
            else 
            {
                i++;
            }
        }

        String res = "";
        for(int n: arr)
        {
            res = res + Integer.toString(n)+"";
        }

        return Integer.parseInt(res);
    }
    public static void main(String[] args) {
        lc670 obj = new lc670();
        System.out.println(obj.maximumSwap(99088));
    }
}