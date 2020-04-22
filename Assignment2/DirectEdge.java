
public class DirectEdge {
	public int head;
	public int tail;
	public double cost;
	DirectEdge(int head, int tail, double cost){
		this.head = head;
		this.tail = tail;
		this.cost = cost;
	}
	
//	DirectEdge(DirectEdge e){
//		this.head = e.head;
//		this.tail = e.tail;
//		this.cost = e.cost;
//	}
	
	public int from() {
		return tail;
	}

	public int to() {
		return head;
	}

//	public double weight() {
//		return cost;
//	}
	

}
