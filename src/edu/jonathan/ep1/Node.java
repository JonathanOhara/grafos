package edu.jonathan.ep1;

import java.awt.Color;

public class Node {
    private int id; // indice do vertice no grafo
    private String name; // nome do vertice
    private Color color;
    
    private int distance;
    
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
}
