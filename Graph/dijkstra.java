import java.util.*;
class Pair
{   
    int node;
    int distance;
    public Pair(int n, int d)
    {
        this.node=n;
        this.distance=d;
    }
}
class dijkstra {

    static int[] shortestPath(int src, int v, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->(x.distance-y.distance));
        pq.offer(new Pair(src,0));

        int dist[] = new int[v];
        for(int i=0; i<v; i++)
            dist[i]=(int)(Integer.MAX_VALUE);

        while(pq.size()>0)
        {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            for(int i=0; i<adj.get(node).size(); i++)
            {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if(dis+edgeWeight<dist[adjNode])
                {
                    dist[adjNode]=dis+edgeWeight;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        return dist;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices");
        int v = sc.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for(int i=0; i<v; i++)
            adj.add(new ArrayList<>());

        boolean check=true;
        System.out.println("Input (src, dest, wt)");
        while(check)
        {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int w = sc.nextInt();
            if(src==-1 && dest==-1 && w==-1)
            {
                check=false;
                break;
            }
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(dest);
            arr.add(w);
            adj.get(src).add(arr);
        }
        sc.close();
        int dist[] = shortestPath(0, v, adj);
        System.out.println("Dijkstra's distance : "+Arrays.toString(dist));
    }
}
