package Jonathan.EP5;


public class Edge {
    private Node from, to;
    
    private Edge reverseEdge;
    
    private int weight;
	
    public Edge() {
	}
    
    public Edge(Node from, Node to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

    public void invertFromTo(){
    	Node aux = from;
    	from = to;
    	to = aux;
    }
    
	public Node getFrom() {
		return from;
	}
	public void setFrom(Node from) {
		this.from = from;
	}
	public Node getTo() {
		return to;
	}
	public void setTo(Node to) {
		this.to = to;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Edge getReverseEdge() {
		return reverseEdge;
	}

	public void setReverseEdge(Edge reverseEdge) {
		this.reverseEdge = reverseEdge;
	}
    
}
