//https://www.geeksforgeeks.org/bipartite-graph/
import java.util.*;
class Bipartite
{
	public static void main(String args[])
	{
		Graph g = Graph.createGraph();
		Bipartite bp = new Bipartite();
		int res= bp.twoColorable(g,0);
		if(res==1){
		System.out.println("A bipartite-graph");
		}
		else{
			System.out.println("Not a bipartite-graph");
		}
	}

	private int twoColorable(Graph g, int src)
	{
		boolean visited[] = new boolean[10];
		String color[] = new String[10];
		for(int i=0;i<10;i++){
			visited[i]=false;
		}

		Queue<Integer> vertex = new LinkedList<Integer>();
		vertex.add(src);
		color[src]="red";

		while(vertex.size()!=0)
		{
			int ver = vertex.remove();
			LinkedList<Integer> adjList = Graph.getAdjList(g, ver);
			Iterator<Integer> itr = adjList.iterator();

			while(itr.hasNext())
			{
				int neighbour = itr.next();
				if(visited[neighbour]==false)
				{	
					visited[neighbour]=true;
					vertex.add(neighbour);

					if(color[src]=="red"){
						color[neighbour]="blue";
					}
					else{
						color[neighbour]="red";
					}
				}
				else if(color[src]==color[neighbour])
				{
					return 0;
				}
			}
		}
		return 1;
	}
}