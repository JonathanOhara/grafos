


public class Edge1 {
    private Node1 from, to;
    private int weight;
	
    public Edge1() {
	}
    
    public Edge1(Node1 from, Node1 to) {
		super();
		this.from = from;
		this.to = to;
	}
    
    public Edge1(Node1 from, Node1 to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public Node1 getFrom() {
		return from;
	}
	public void setFrom(Node1 from) {
		this.from = from;
	}
	public Node1 getTo() {
		return to;
	}
	public void setTo(Node1 to) {
		this.to = to;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

    
}
