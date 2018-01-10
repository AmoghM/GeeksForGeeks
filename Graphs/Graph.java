import java.util.*;
class Graph
{
	int numVertices;
	LinkedList<Integer> list[];
	Graph(int numVertices)
	{
		this.numVertices=numVertices;
		list = new LinkedList[numVertices];

		for(int i=0; i<numVertices; i+=1)
			list[i] = new LinkedList<>();
	
	}

	private void addEdge( Graph adj, int source, int dest)
	{
		adj.list[source].add(dest);
		// adding an edge from destination to source to maintain the undirectional nature of the graph
		adj.list[dest].add(source);
	}

	private void printGraph(Graph adj)
	{
		System.out.println("Adjacency List for the Graph is: ");
		for(int itr= 0; itr< adj.numVertices; itr+=1)
		{
			System.out.print(itr);
			for(Integer j: adj.list[itr])
				System.out.print("==> "+j);
			System.out.println();
		}
		System.out.println();
	}

	public static LinkedList<Integer> getAdjList(Graph adj, int vertex)
	{
			return adj.list[vertex];
	}

	public static Graph createGraph()
	{
		Graph g = new Graph(10);
		g.addEdge(g,0,1);
		g.addEdge(g,0,2);
		g.addEdge(g,0,3);
		g.addEdge(g,1,2);
		g.addEdge(g,3,4);
		g.addEdge(g,3,7);
		g.addEdge(g,4,5);
		g.addEdge(g,4,6);
		g.addEdge(g,5,6);
		g.addEdge(g,5,8);
		g.addEdge(g,7,8);
		g.addEdge(g,8,9);

		g.printGraph(g);

		return g;
	}

}