

import java.awt.Color;


public class Node3 {
    private int id; // indice do vertice no grafo
    private String name; // nome do vertice
    private Color color;
    
    private int dfsTime;
    private int dfsEndTime;
    
    private int key;
    private Node3 father;
    
    public Node3() {
    }

    public Node3(String name) {
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
		Node3 other = (Node3) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node3 getFather() {
		return father;
	}

	public void setFather(Node3 father) {
		this.father = father;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getDfsTime() {
		return dfsTime;
	}

	public void setDfsTime(int dfsTime) {
		this.dfsTime = dfsTime;
	}

	public int getDfsEndTime() {
		return dfsEndTime;
	}

	public void setDfsEndTime(int dfsEndTime) {
		this.dfsEndTime = dfsEndTime;
	}
}
