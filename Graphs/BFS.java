import java.util.*;
class BFS
{
	public static void main(String args[])
	{
		Graph g= Graph.createGraph();
		BFS bfs = new BFS();
		bfs.bfsTraversal(g,0);
	}

	private void bfsTraversal(Graph gr, int source)
	{
		boolean visited[] = new boolean[10];
		for(int i=0;i<visited.length;i++)
		{
			visited[i]=false;
		}

		Queue<Integer> vertices = new LinkedList<Integer>(); 
		vertices.add(source); //Initial source vertex of the graph
		visited[source]=true;

		while(vertices.size()!=0)
		{	
			int vertex = vertices.remove();
			System.out.println("On node: "+ vertex);
			LinkedList<Integer> adjList = Graph.getAdjList(gr,vertex); //Retrieving the Adj List for the visiting vertex
			Iterator<Integer> traverse = adjList.iterator();

			while(traverse.hasNext())
			{
				int neighbour = traverse.next();
				if(visited[neighbour]==false)
				{	System.out.println("Visiting neighbour: "+ neighbour);
					vertices.add(neighbour);
					visited[neighbour]=true;
				}
			}
		}
		System.out.println("Breadth First Search Traversal completed");
	}
}