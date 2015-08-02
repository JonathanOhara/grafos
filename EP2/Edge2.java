


public class Edge2 {
    private Node2 from, to;
    private int weight;
	
    public Edge2() {
	}
    
    public Edge2(Node2 from, Node2 to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public Node2 getFrom() {
		return from;
	}
	public void setFrom(Node2 from) {
		this.from = from;
	}
	public Node2 getTo() {
		return to;
	}
	public void setTo(Node2 to) {
		this.to = to;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

    
}
