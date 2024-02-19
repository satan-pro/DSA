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

class prims {

    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.distance-y.distance);

        int vis[] = new int[v];

        pq.offer(new Pair(0,0));
        int sum=0;
        while(pq.size()>0)
        {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            if(vis[node]==1)
                continue;
            
            vis[node]=1;
            sum+=wt;
            System.out.println(sum);
            
            for(int i=0; i<adj.get(node).size(); i++)
            {
                int edgWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(vis[adjNode]==0)
                {
                    pq.offer(new Pair(adjNode, edgWt));
                }
            }
        
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices");
        int v = sc.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<v; i++)
        {
            for(int j=i+1; j<v; j++)
            {
                System.out.print(i + "connected to "+j+"?:(1/0)");
                int ch = sc.nextInt();
                if(ch==1)
                {
                    System.out.print("Enter the weight of the edge : ");
                    int wt = sc.nextInt();
                    ArrayList<Integer> ob = new ArrayList<>();
                    ob.add(0,j);
                    ob.add(1,wt);
                    adj.get(i).add(ob);
                    System.out.println(ob);
                }
            }
        }
        sc.close();

        int res = spanningTree(v, adj);
        System.out.println("Minimum sum : "+res);
    }
}
