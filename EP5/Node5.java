

import java.awt.Color;



public class Node5 {
    private int id; // indice do vertice no grafo
    private String name; // nome do vertice
    private Color color;
    
    private int distance;
    private int flow;
    
    private Edge5 edgeToFather;
    
    public Node5() {
    }

    public Node5(String name) {
        this.name = name;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node5 other = (Node5) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Edge5 getEdgeToFather() {
		return edgeToFather;
	}

	public void setEdgeToFather(Edge5 edgeToFather) {
		this.edgeToFather = edgeToFather;
	}


	
}