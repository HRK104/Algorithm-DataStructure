


import java.util.Scanner;



public class Digraph {

		private  int V;
		private int E;
		private boolean valid;
		public int[] indegree;
		public Bag<DirectEdge>[] adj;

		@SuppressWarnings("unchecked")
		public Digraph(Scanner in) {

			this.V = in.nextInt(); //1st line
			this.E = in.nextInt(); //2nd line
			this.valid = true;

			int numSteet = E;

			adj = (Bag<DirectEdge>[]) new Bag[V];


			if(this.valid){//3rd line onwards
				this.indegree = new int[V];
				
				for (int v = 0; v < this.V; v++)
					adj[v] = new Bag<DirectEdge>();

				for (int i = 0; i < numSteet; i++) {

					int head = in.nextInt();
					int tail = in.nextInt();
					double cost = in.nextDouble();

					if( head >= 0 && tail >= 0 && cost >= 0.0) addEdge(new DirectEdge(head, tail, cost));
					else this.valid = false;
				}
				
				
				boolean validation = true;
				for(int v=0; v<this.V; v++){
					if(indegree[v] < 1){
						validation = false;
						break;
					}
				}
				this.valid = validation;
			}
			

			
		}



		public boolean getValid() {
			if(this.valid) return true;
			else return false;
		}

		public int V() {
			return V;
		}



		public void addEdge(DirectEdge costEdge) {

			int v = costEdge.from();
			int w = costEdge.to();
			indegree[w]++;
			adj[v].add(costEdge);

			E++;
		}
		
	    
		
		
		public Iterable<DirectEdge> edgesAdjacentTo(int v) {
			return adj[v];
		}


		
		public int getAdjLength() {
			return adj.length;
		}
	}
