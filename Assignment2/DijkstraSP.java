//import java.util.Stack;
//
//public class DijkstraSP {
//	
//	public double []distTo;
//	public DirectEdge[] edgeTo;
//	public IndexMinPQ<Double> pq;
//	
//	DijkstraSP(Digraph graph, int s){
//		distTo = new double[graph.V()];
//		edgeTo = new DirectEdge[graph.E()];
//		
//		for(int i=0; i<graph.V(); i++) {
//			//System.out.println(Double.POSITIVE_INFINITY);
//			distTo[i] =Double.POSITIVE_INFINITY;
//		}
//		distTo[s] =0.0;
//		
//		pq = new IndexMinPQ<Double>(graph.V());
//		pq.insert(s, distTo[s]);
//		
//		while(!pq.isEmpty()) {
//			//System.out.println("within while(!pq.isEmpty())");
//			int v = pq.delMin();
//			for(DirectEdge e: graph.edgesAdjacentTo(v)) {
//				relax(e);
//			}
//		}
//		
//	}
//	double distTo(int v) {
//		return distTo[v];
//	}
//	boolean hasPathTo(int v) {
//		return distTo[v]<Double.POSITIVE_INFINITY;
//	}
//	
//	Iterable<DirectEdge> pathTo(int v){
//		if(!hasPathTo(v)) return null;
//		
//		Stack<DirectEdge> path = new Stack<DirectEdge>();
//		
//		for(DirectEdge e = edgeTo[v]; e != null; e = edgeTo[e.head])
//			path.push(e);
//		return path;
//	}
//	
//	private void relax(DirectEdge e) {
//		System.out.println("relax");
//		int v = e.tail;
//		int w = e.head;
////		System.out.println("distTo[w]: "+distTo[w]);
////		System.out.println("distTo[v] + e.cos: "+(distTo[v] + e.cost));
//		if(distTo[w] > distTo[v] + e.cost) {
//			distTo[w] = distTo[v] + e.cost;
//			System.out.println("distTo[w]: "+distTo[w]);
//			edgeTo[w] = e;
//		}
//	}
//
//}

import java.util.Stack;

public class DijkstraSP {

	public double[] distTo;
	public DirectEdge[] edgeTo;
	public IndexMinPQ<Double> pq;


	public DijkstraSP(Digraph graph, int source) {

		distTo = new double[graph.V()];
		edgeTo = new DirectEdge[graph.V()];

		for (int v = 0; v < graph.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;

		distTo[source] = 0.0;

		pq = new IndexMinPQ<Double>(graph.V());
		pq.insert(source, distTo[source]);

		while (!pq.isEmpty()) {

			int v = pq.delMin();

			for (DirectEdge e : graph.edgesAdjacentTo(v))
				relax(e);
		}

	}

	private void relax(DirectEdge e) {

		int v = e.tail;
		int w = e.head;

		if (distTo[w] > distTo[v] + e.cost) {

			distTo[w] = distTo[v] + e.cost;
			edgeTo[w] = e;

			if(pq.contains(w)) pq.decreaseKey(w, distTo[w]);
			else pq.insert(w, distTo[w]);
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectEdge> pathTo(int v) {

		if (!hasPathTo(v)) return null;

		Stack<DirectEdge> result = new Stack<DirectEdge>();

		for (DirectEdge e = edgeTo[v]; e != null; e = edgeTo[e.head])
			result.push(e);
		return result;
	}
}

