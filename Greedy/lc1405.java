import java.util.*;
class lc1405
{
	class Pair
	{
		char ch;
		int freq;
		public Pair(char c, int f) {
			ch=c;
			freq=f;
		}
	}
	public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->(y.freq-x.freq));

        if(a>0)
        	pq.offer(new Pair('a',a));
        if(b>0)
        	pq.offer(new Pair('b',b));
        if(c>0)
        	pq.offer(new Pair('c',c));

        String res="";

        outer: while(!pq.isEmpty())
        {
        	Pair curr = pq.poll();

        	if(res.length()>=2 && res.charAt(res.length()-1)==curr.ch && res.charAt(res.length()-2)==curr.ch)
        	{
        		if(pq.isEmpty())
        			break outer;

        		Pair next = pq.poll();
        		res = res+next.ch+"";
        		next.freq--;

        		if(next.freq>0)
        			pq.offer(next);
        		pq.offer(curr);
        	}
        	else 
        	{
        		res = res+curr.ch+"";
        		curr.freq--;
        		if(curr.freq>0)
        			pq.offer(curr);
        	}
        	
        }

        return res;
    }
}