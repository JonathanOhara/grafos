


public class Node2 {
    private int id; // indice do vertice no grafo
    private String name; // nome do vertice
    
    private int key;
    private Node2 father;
    
    public Node2() {
    }

    public Node2(String name) {
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
		Node2 other = (Node2) obj;
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

	public Node2 getFather() {
		return father;
	}

	public void setFather(Node2 father) {
		this.father = father;
	}
}
