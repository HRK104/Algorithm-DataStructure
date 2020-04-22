


public class DijkstraSP {

	public double[] distTo;
	public DirectEdge[] edgeTo;
	public IndexMinPQ<Double> pq;


	public DijkstraSP(Digraph graph, int s) {

		distTo = new double[graph.V()];
		edgeTo = new DirectEdge[graph.V()];

		for(int i=0; i<graph.V(); i++) {
			distTo[i] =Double.POSITIVE_INFINITY;
		}

		distTo[s] = 0.0;
		
		pq = new IndexMinPQ<Double>(graph.V());
		pq.insert(s, distTo[s]);
		
		while(!pq.isEmpty()) {
			//System.out.println("within while(!pq.isEmpty())");
			int v = pq.delMin();
			for(DirectEdge e: graph.edgesAdjacentTo(v)) {
				relax(e);
			}
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


}

