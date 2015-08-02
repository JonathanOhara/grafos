

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

public class Graph5 {
    protected int lastIndex; // temporario para contabilizar indices dos vertices no grafo
    public Map<Integer, Node5> vertices; // vetor de vertices indexados por 'id'
    public Map<Node5, List<Edge5>> edgeByVertices; // lista de adjacencia
    public int vertexTotal, edgeTotal; // total de vertices e arestas no grafo
    
    private int maximumFlow;
    
    public Graph5() {
        init(10);
    }
    public Graph5(int n) {
    	init(n);
	}
	
    protected void init( int n ) {
        vertices = new LinkedHashMap<Integer, Node5>( n );

        lastIndex = 0;
        edgeTotal = 0;
    }
    
    public void addNode( Node5 v ) {
        v.setId( lastIndex++ );
        vertices.put( v.getId(), v );
    }
    
    public void initAdj( int m ) { //chamar para finalizar insercao de vertices
        vertexTotal = vertices.size();
        
        edgeByVertices = new LinkedHashMap<Node5, List<Edge5>>( vertexTotal ); // 1 lista de adjacencia para cada vertice
    }
    
    public void insertAdj( int u, int v, int weight ) {
    	Edge5 edge = insertAdj( vertices.get(u), vertices.get(v), weight );
    	Edge5 reverseEdge = insertAdj( vertices.get(v), vertices.get(u), 0 );
    	
    	edge.setReverseEdge( reverseEdge );
    	reverseEdge.setReverseEdge( edge );
    }
    
    //insere v na lista de adjacencia de u
    public Edge5 insertAdj( Node5 u, Node5 v, int weight ) {
    	List<Edge5> edges = edgeByVertices.get( u );
    	
    	if( edges == null ){
    		edges = new ArrayList<Edge5>();
    	}
    	Edge5 edge = new Edge5( u, v, weight );
    	
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
        Graph5 graph = this;
        int n = graph.vertexTotal;
        int[][] madj = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                madj[i][j] = 0;
            }
        }

        for ( Entry< Node5, List<Edge5>> entry: edgeByVertices.entrySet() ) {
            System.out.print( entry.getKey().getName() + ": " );
            
            for( Edge5 edge : entry.getValue() ){
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

    private Node5 findNodeByName(String name){
    	for( Node5 n : vertices.values() ){
    		if( n.getName().equals(name) ){
    			return n;
    		}
    	}
    	return null;
    }
    
    private boolean hasAugmentativePath( Node5 source, Node5 target ){
    	Queue<Node5> queue = new LinkedList<Node5>();
    	
    	for( Node5 node : vertices.values() ){
    		node.setColor( Color.white );
    		node.setDistance( Integer.MAX_VALUE );
    	}
    	
    	source.setDistance( 0 );
    	source.setColor( Color.gray );
    	
    	queue.add(source);
    	
    	Node5 node;
    	while( !queue.isEmpty() ){
    		node  = queue.poll();

    		List<Edge5> edges = edgeByVertices.get( node );
    		if( edges != null ){
	    		for( Edge5 edge : edges ){
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
		Node5 s, t;
		Edge5 fatherEdge;
		
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