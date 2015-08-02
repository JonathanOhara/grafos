


public class Edge4 {
    private Node4 from, to;
    
    private int weight;
	
    public Edge4() {
	}
    
    public Edge4(Node4 from, Node4 to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

    public void invertFromTo(){
    	Node4 aux = from;
    	from = to;
    	to = aux;
    }
    
	public Node4 getFrom() {
		return from;
	}
	public void setFrom(Node4 from) {
		this.from = from;
	}
	public Node4 getTo() {
		return to;
	}
	public void setTo(Node4 to) {
		this.to = to;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
    
}
