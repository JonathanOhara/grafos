

import java.awt.Color;


public class Node4 {
    private int id; // indice do vertice no grafo
    private String name; // nome do vertice
    private Color color;
    
    
    private int key;
    
    private Node4 father;
    private int distance;
    
    
    
    public Node4() {
    }

    public Node4(String name) {
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
		Node4 other = (Node4) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Node4 getFather() {
		return father;
	}

	public void setFather(Node4 father) {
		this.father = father;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
}