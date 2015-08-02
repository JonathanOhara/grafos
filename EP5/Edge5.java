


public class Edge5 {
    private Node5 from, to;
    
    private Edge5 reverseEdge;
    
    private int weight;
	
    public Edge5() {
	}
    
    public Edge5(Node5 from, Node5 to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

    public void invertFromTo(){
    	Node5 aux = from;
    	from = to;
    	to = aux;
    }
    
	public Node5 getFrom() {
		return from;
	}
	public void setFrom(Node5 from) {
		this.from = from;
	}
	public Node5 getTo() {
		return to;
	}
	public void setTo(Node5 to) {
		this.to = to;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Edge5 getReverseEdge() {
		return reverseEdge;
	}

	public void setReverseEdge(Edge5 reverseEdge) {
		this.reverseEdge = reverseEdge;
	}
    
}
