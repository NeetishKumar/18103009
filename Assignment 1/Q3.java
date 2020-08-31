import java.util.*;

public class Question_3
{
	static class Edge
	{
		int src, dest, cost;
		
		Edge(int s, int d, int c)
		{
			src = s;
			cost = c;
			dest = d;
		}
	}

	public static void print(String msg)
	{
		System.out.println(msg);
	}

	public static String WAP(ArrayList<Edge> edges, int n, int src, int dest)
	{
		int m = edges.size();
		int dist[] = new int[n];
		
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		dist[src] = 0;
		
		for(int i = 1;i<n;i++)
		{
			for(Edge edge:edges)
			{
				int u = edge.src;
				int v = edge.dest;
				int w = edge.cost;

				if((dist[v] > (dist[u] + w)) && (dist[u]!=Integer.MAX_VALUE))
				{
					dist[v] = dist[u]+w;
				}
			}
		}

		for(Edge edge:edges)
		{
			int u = edge.src;
			int v = edge.dest;
			int w = edge.cost;

			if(((dist[u] + w) < dist[v]) && (dist[u] != Integer.MAX_VALUE))
			{
				return "Negative cycles exist";
			}
		}
		if (dist[dest]==Integer.MAX_VALUE)
		{
			return "No path";
		}
		
		return String.valueOf(dist[dest]);
		
			
		
	}


    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	
    	print("Enter the number of vertices : ");
    	int n = sc.nextInt();

    	print("Enter the number of edges : ");
		int m = sc.nextInt();

    	ArrayList<Edge> edges = new ArrayList<Edge>(m);

    	print("Enter the edges in the format : ");
    	print("Source Destination Cost");

    	for(int i = 0; i < m; i++)
    	{
    		edges.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
    	}
    	
   		print("Enter source : ");
    	int src = sc.nextInt();
    	
    	print("Enter destination : ");
    	int dest = sc.nextInt();

    	print(WAP(edges,n,src,dest));
    	
    }   
                             
}