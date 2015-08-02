package edu.jonathan.ep5;

import java.awt.Color;



public class Node {
    private int id; // indice do vertice no grafo
    private String name; // nome do vertice
    private Color color;
    
    private int distance;
    private int flow;
    
    private Edge edgeToFather;
    
    public Node() {
    }

    public Node(String name) {
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
		Node other = (Node) obj;
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

	public Edge getEdgeToFather() {
		return edgeToFather;
	}

	public void setEdgeToFather(Edge edgeToFather) {
		this.edgeToFather = edgeToFather;
	}


	
}