


public class Edge3 {
    private Node3 from, to;
	
    public Edge3() {
	}
    
    public Edge3(Node3 from, Node3 to) {
		super();
		this.from = from;
		this.to = to;
	}

    public void invertFromTo(){
    	Node3 aux = from;
    	from = to;
    	to = aux;
    }
    
	public Node3 getFrom() {
		return from;
	}
	public void setFrom(Node3 from) {
		this.from = from;
	}
	public Node3 getTo() {
		return to;
	}
	public void setTo(Node3 to) {
		this.to = to;
	}
    
}
