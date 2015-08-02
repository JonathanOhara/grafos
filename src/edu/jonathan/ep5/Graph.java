package edu.jonathan.ep5;

/*

// 1 lista de adjacencia para cada vertice2015mar24: 
.read(): faz a leitura de um grafo pela entrada padrão
.print(): imprime listas de adjacencia e matriz de adjacencia

Node 'int id': indice dos vertices.
Assume v.id de 0..N-1, obedecendo a ordem de insercao dos vertices.

*/

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class Graph {
    protected int lastIndex; // temporario para contabilizar indices dos vertices no grafo
    public Map<Integer, Node> vertices; // vetor de vertices indexados por 'id'
    public Map<Node, List<Edge>> edgeByVertices; // lista de adjacencia
    public int vertexTotal, edgeTotal; // total de vertices e arestas no grafo
    
    private int maximumFlow;
    
    public Graph() {
        init(10);
    }
    public Graph(int n) {
    	init(n);
	}
	
    protected void init( int n ) {
        vertices = new LinkedHashMap<Integer, Node>( n );

        lastIndex = 0;
        edgeTotal = 0;
    }
    
    public void addNode( Node v ) {
        v.setId( lastIndex++ );
        vertices.put( v.getId(), v );
    }
    
    public void initAdj( int m ) { //chamar para finalizar insercao de vertices
        vertexTotal = vertices.size();
        
        edgeByVertices = new LinkedHashMap<Node, List<Edge>>( vertexTotal ); // 1 lista de adjacencia para cada vertice
    }
    
    public void insertAdj( int u, int v, int weight ) {
    	Edge edge = insertAdj( vertices.get(u), vertices.get(v), weight );
    	Edge reverseEdge = insertAdj( vertices.get(v), vertices.get(u), 0 );
    	
    	edge.setReverseEdge( reverseEdge );
    	reverseEdge.setReverseEdge( edge );
    }
    
    //insere v na lista de adjacencia de u
    public Edge insertAdj( Node u, Node v, int weight ) {
    	List<Edge> edges = edgeByVertices.get( u );
    	
    	if( edges == null ){
    		edges = new ArrayList<Edge>();
    	}
    	Edge edge = new Edge( u, v, weight );
    	
    	edges.add( edge );
    	
    	edgeByVertices.put(u, edges); 
        edgeTotal++;
        
        return edge;
    }
    
    /*
    //devolve um vetor com os vizinhos de u
    public Node[] getAdj(Node u) {
        int tote = Adj[u.id].size();
        Node[] vAdj = new Node[tote];
        Iterator it = Adj[u.id].iterator();
        int pos = 0;
        while (it.hasNext()) {
            Node v = (Node)it.next();
            vAdj[pos] = v;
            pos++;
        }
    }
    */

    public void print() {
        Graph graph = this;
        int n = graph.vertexTotal;
        int[][] madj = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                madj[i][j] = 0;
            }
        }

        for ( Entry< Node, List<Edge>> entry: edgeByVertices.entrySet() ) {
            System.out.print( entry.getKey().getName() + ": " );
            
            for( Edge edge : entry.getValue() ){
            	System.out.print( edge.getTo().getName() + ", " );
            	madj[ entry.getKey().getId() ][ edge.getTo().getId() ] = 1;
            }
            System.out.println();
        }

        //System.out.println("\nMatriz de Adjacencia:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                System.out.print( madj[ i ][ j ] + " " );
            }
            System.out.println();
        }
        
        System.out.println( "Total de vertices: " + graph.vertexTotal );
        System.out.println( "Total de arcos: " + graph.edgeTotal );
    }

    private Node findNodeByName(String name){
    	for( Node n : vertices.values() ){
    		if( n.getName().equals(name) ){
    			return n;
    		}
    	}
    	return null;
    }
    
    private boolean hasAugmentativePath( Node source, Node target ){
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	for( Node node : vertices.values() ){
    		node.setColor( Color.white );
    		node.setDistance( Integer.MAX_VALUE );
    	}
    	
    	source.setDistance( 0 );
    	source.setColor( Color.gray );
    	
    	queue.add(source);
    	
    	Node node;
    	while( !queue.isEmpty() ){
    		node  = queue.poll();

    		List<Edge> edges = edgeByVertices.get( node );
    		if( edges != null ){
	    		for( Edge edge : edges ){
	    			if( edge.getWeight()> 0 &&
	    			edge.getTo().getColor().equals( Color.white ) ){
	    				
	    				edge.getTo().setDistance( node.getDistance() + 1 );
	    				edge.getTo().setColor(Color.gray);
	    				edge.getTo().setEdgeToFather( edge );
	    				
	    				queue.add(edge.getTo());
	    				
	    			}
	    			node.setColor( Color.black );
	    		}
    		}
    	}

    	return target.getDistance() != Integer.MAX_VALUE;
    }
    
	public void calculateMaximumFlow() {
		Node s, t;
		Edge fatherEdge;
		
		maximumFlow = 0;
		
		s = findNodeByName("s");
		t = findNodeByName("t");
		
		while( hasAugmentativePath(s, t) ){
			int maxFlow = Integer.MAX_VALUE;
			fatherEdge = t.getEdgeToFather();
			while(fatherEdge != null){
				maxFlow = Math.min(maxFlow, fatherEdge.getWeight());
				fatherEdge = fatherEdge.getFrom().getEdgeToFather();
			}

			maximumFlow += maxFlow;
			fatherEdge = t.getEdgeToFather();
			while(fatherEdge != null){
				fatherEdge.setWeight( fatherEdge.getWeight() - maxFlow );
				fatherEdge.getReverseEdge().setWeight( fatherEdge.getReverseEdge().getWeight() + maxFlow );
				fatherEdge = fatherEdge.getFrom().getEdgeToFather();
			}
			
		}
	}
	
	public String getMaximumFlow() {
	   	return String.valueOf( maximumFlow );
	}
}