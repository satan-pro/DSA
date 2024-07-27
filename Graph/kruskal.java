import java.util.*;
class DisjointSet
{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int n)
    {
        for(int i=0; i<n; i++)
        {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    int findParent(int node)
    {
        if(node==parent.get(node))
            return node;
        int root = findParent(parent.get(node));
        parent.set(node,root);
        return root;
    }

    int unionByRank(int u, int v, int w)
    {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu==pv)
            return 0;
        if(rank.get(pu)<rank.get(pv))
        {
            parent.set(pu,pv);
            return w;
        }
        else if(rank.get(pv)<rank.get(pu))
        {
            parent.set(pv,pu);
            return w;
        }
        else{
            parent.set(pv,pu);
            rank.set(pu,rank.get(pu)+1);
            return w;
        }
    }

    void unionBySize(int u, int v)
    {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu==pv)
            return;
        if(size.get(pu)<size.get(pv))
        {
            parent.set(pu,pv);
            size.set(pv,size.get(pv)+size.get(pu));
        }
        else
        {
            parent.set(pv,pu);
            size.set(pu,size.get(pu)+size.set(pv));
        }
    }
}
class Edge implements Comparable<Edge>
{
    int wt;
    int src;
    int dest;

    public Edge(int w, int s, int d)
    {
        wt=w;
        src=s;
        dest=d;
    }

    public int compareTo(Edge e)
    {
        return this.wt-e.wt;
    }

    public String toString()
    {
        return "Edge{" + "src=" + src + ", dest=" + dest + ", wt=" + wt + "}";
    }
}
public class kruskal {
    
    ArrayList<Edge> graph = new ArrayList<>();

    public void findMST()
    {
        ArrayList<Edge> mst = new ArrayList<>();
        DisjointSet ds = new DisjointSet(graph.size());
        
        Collections.sort(graph);

        for(Edge e : graph)
        {
            int wt = ds.unionByRank(e.dest, e.src, e.wt);
            if(wt>0)
            {
                mst.add(e);
            }
        }
        System.out.println(mst);
    }
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        ArrayList<Edge> graph= new ArrayList<>();
        kruskal k = new kruskal();
        System.out.println("Enter data wt,src,dest <-1 to terminate>:");
        int wt,src,dest=0;
        do{
            wt=sc.nextInt();
            src = sc.nextInt();
            dest = sc.nextInt();

            if(wt==-1 && src==-1 && dest==-1)
                break;

            Edge ed = new Edge(wt,src,dest);

            k.graph.add(ed);
        }while(wt>-1 && src>-1 && dest>-1);
        k.findMST();
    }
}
