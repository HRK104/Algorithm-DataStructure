//	private final int V;
//	private Bag<Integer>[] adj;
//	
//	public Digraph(int V) {
//		this.V = V;
//		adj = (Bag<Integer>[]) new Bag[V];
//		for(int v=0; v<V; v++)
//			adj[v] = new Bag<Integer>();
//	}
//
//}
/******************************************************************************
 *  Compilation:  javac Digraph.java
 *  Execution:    java Digraph filename.txt
 *  Dependencies: Bag.java In.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/42digraph/tinyDG.txt
 *                https://algs4.cs.princeton.edu/42digraph/mediumDG.txt
 *                https://algs4.cs.princeton.edu/42digraph/largeDG.txt  
 *
 *  A graph, implemented using an array of lists.
 *  Parallel edges and self-loops are permitted.
 *
 *  % java Digraph tinyDG.txt
 *  13 vertices, 22 edges
 *  0: 5 1 
 *  1: 
 *  2: 0 3 
 *  3: 5 2 
 *  4: 3 2 
 *  5: 4 
 *  6: 9 4 8 0 
 *  7: 6 9
 *  8: 6 
 *  9: 11 10 
 *  10: 12 
 *  11: 4 12 
 *  12: 9 
 *  
 ******************************************************************************/

//import java.util.NoSuchElementException;

public class Digraph {

    private final int V;           
    private int E;                
    public Bag<DirectEdge>[] adj;    
    private int[] indegree;        
    
    
    @SuppressWarnings("unchecked")
	public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<DirectEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectEdge>();
        }
    }


    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
    
    public int getAdjLength() {
    	return adj.length;
    }


    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    
    public void addEdge(DirectEdge costGraph) {
    	int v = costGraph.tail;
    	int w = costGraph.head;
        validateVertex(v);
        validateVertex(w);
        adj[v].add(costGraph);
        indegree[w]++;
        E++;
    }


    public Iterable<DirectEdge> edgesAdjacentTo(int v){
    	return adj[v];
    }



}