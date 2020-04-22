
public class FloydWarshallSP {
	
	Digraph graph;
	double [][] table;
	int startValue;
	
	
	public FloydWarshallSP(Digraph graph, int i) {
		// TODO Auto-generated constructor stub
		this.graph = graph;
		table = new double[this.graph.V()][this.graph.V()];
		startValue = i;
		for(int j=0; j<table.length;j++) {
			for(int k=0;k<table[j].length;k++) {
				table[j][k] = Double.POSITIVE_INFINITY;
			}
		}
		
		for(int j=0;j<table.length;j++) {
			table[j][j] = 0.0;
		}
		//System.out.println("start FloydWarshallSP");
		
		for(int j=0; j<graph.getAdjLength();j++) {
			
			for (DirectEdge e : graph.edgesAdjacentTo(j)) {
				int head = e.head;//((DirectEdge) graph.edgesAdjacentTo(j)).getHead();
				int tail = e.tail;
				double cost = e.cost;
				
				table[head][tail] = cost;
			}
		}
		//System.out.println("before calculate");

		
		calculate();
	}
	
	public void calculate() {
		boolean hasBlank = true;
		
		while(hasBlank) {
			//System.out.println("start while: "+times);
			hasBlank = false;
			for(int k=0; k<table.length;k++) {
				for(int i=0; i<table.length;i++) {
					for(int j=0; j<table.length;j++) {
						if(table[i][j]>table[i][k]+table[k][j]) {
							table[i][j] = table[i][k]+table[k][j];
						}
						if(table[i][j] == Double.POSITIVE_INFINITY) hasBlank = true;
					}
				}
			}
		}
	}
}
