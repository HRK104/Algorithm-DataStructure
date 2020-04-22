
public class DirectEdge {
	public int head;
	public int tail;
	public double cost;
	DirectEdge(int head, int tail, double cost){
		this.head = head;
		this.tail = tail;
		this.cost = cost;
	}
	
	DirectEdge(DirectEdge e){
		this.head = e.head;
		this.tail = e.tail;
		this.cost = e.cost;
	}
	
	public int getHead() {
		return this.head;
	}
	
	public int getTail() {
		return this.tail;
	}
	
	public double getCost() {
		return this.cost;
	}
	

}
