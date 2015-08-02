

import java.awt.Color;

public class Node1 {
    private int id; // indice do vertice no grafo
    private String name; // nome do vertice
    private Color color;
    
    private int distance;
    
    public Node1() {
    }

    public Node1(String name) {
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
		Node1 other = (Node1) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
