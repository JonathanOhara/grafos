package edu.jonathan.ep4;

/*

// 1 lista de adjacencia para cada vertice2015mar24: 
.read(): faz a leitura de um grafo pela entrada padrão
.print(): imprime listas de adjacencia e matriz de adjacencia

Node 'int id': indice dos vertices.
Assume v.id de 0..N-1, obedecendo a ordem de insercao dos vertices.

*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Graph {
    protected int lastIndex; // temporario para contabilizar indices dos vertices no grafo
    public Map<Integer, Node> vertices; // vetor de vertices indexados por 'id'
    public Map<Node, List<Edge>> edgeByVertices; // lista de adjacencia
    public int vertexTotal, edgeTotal; // total de vertices e arestas no grafo
    
    private int[][] distanceMatrix;
    
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
    	insertAdj( vertices.get(u), vertices.get(v), weight );
    }
    
    //insere v na lista de adjacencia de u
    public void insertAdj( Node u, Node v, int weight ) {
    	List<Edge> edges = edgeByVertices.get( u );
    	
    	if( edges == null ){
    		edges = new ArrayList<Edge>();
    	}
    	
    	edges.add( new Edge( u, v, weight ) );
    	
    	edgeByVertices.put(u, edges); 
        edgeTotal++;
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

	public void calculateDistanceMatrixByDikstra() {
		
		distanceMatrix = new int[vertexTotal][vertexTotal];
		
		for( int i = 0; i < vertexTotal; i++ ){
			for( int j = 0; j < vertexTotal; j++ ){
				distanceMatrix[i][j] = 0;
			}
		}
		
		for( Node from : vertices.values() ){
			dijkstra(from);
		}
		
	}
	
	private void dijkstra(Node from) {
		Node u;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.getDistance(), o2.getDistance());
			}
		
		});
		
		for( Node vertex : vertices.values() ){
			vertex.setDistance( Integer.MAX_VALUE );
			vertex.setFather( null );
		}
		
		from.setDistance(0);
		
		//Linha Riscada 1
		
		queue.addAll( vertices.values() );

		while( !queue.isEmpty() ){
			u = queue.remove();
			//Linha Riscada 2
			

			List<Edge> edges = edgeByVertices.get(u);
			if( edges != null ){
				for( Edge edge : edges ){
					relax( edge );
	
					if( queue.contains(edge.getTo()) ){
						queue.remove( edge.getTo() );
						queue.add( edge.getTo() );
					}
				}
			}
				
			distanceMatrix[ from.getId() ][ u.getId() ] = u.getDistance();
		}
		
	}
	
	private void relax(Edge edge) {
		int distancePlusWeight = edge.getFrom().getDistance() == Integer.MAX_VALUE ? Integer.MAX_VALUE : edge.getFrom().getDistance() + edge.getWeight();
   		if( distancePlusWeight < edge.getTo().getDistance() ){
   			edge.getTo().setDistance( distancePlusWeight );
   			edge.getTo().setFather( edge.getFrom() );
   		}
		
	}
	public String getDistanceMatrix() {
		StringBuilder print = new StringBuilder();
		
		int i, j;
	   	
	   	for( i = 0; i < vertexTotal; i++ ){
	   		for( j = 0; j < vertexTotal; j++ ){
	   			print.append( distanceMatrix[i][j] == Integer.MAX_VALUE ? "." : distanceMatrix[i][j] ).append( " " );
	   		}
	   		print.append("\n");
	   	}
	   	
	   	return print.toString();
	}
}