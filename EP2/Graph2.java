

/*

edgeByVertices = new LinkedHashMap<Node, List<Node>>( vertexTotal ); // 1 lista de adjacencia para cada vertice2015mar24: 
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

public class Graph2 {
    protected int lastIndex; // temporario para contabilizar indices dos vertices no grafo
    public Map<Integer, Node2> vertices; // vetor de vertices indexados por 'id'
    public Map<Node2, List<Edge2>> edgeByVertices; // lista de adjacencia
    public int vertexTotal, edgeTotal; // total de vertices e arestas no grafo
    
    public Graph2() {
        init(10);
    }
    public Graph2(int n) {
    	init(n);
	}
	
    protected void init( int n ) {
        vertices = new LinkedHashMap<Integer, Node2>( n );
        
        lastIndex = 0;
        edgeTotal = 0;
    }
    
    public void addNode( Node2 v ) {
        v.setId( lastIndex++ );
        vertices.put( v.getId(), v );
    }
    
    public void initAdj( int m ) { //chamar para finalizar insercao de vertices
        vertexTotal = vertices.size();
        
        edgeByVertices = new LinkedHashMap<Node2, List<Edge2>>( vertexTotal ); // 1 lista de adjacencia para cada vertice
    }
    
    public void insertAdj( int u, int v, int weight ) {
    	insertAdj( vertices.get(u), vertices.get(v), weight );
    }
    
    //insere v na lista de adjacencia de u
    public void insertAdj( Node2 u, Node2 v, int weight ) {
    	List<Edge2> edges = edgeByVertices.get( u );
    	
    	if( edges == null ){
    		edges = new ArrayList<Edge2>();
    	}
    	
    	edges.add( new Edge2( u, v, weight ) );
    	
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
        Graph2 graph = this;
        int n = graph.vertexTotal;
        int[][] madj = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                madj[i][j] = 0;
            }
        }

        for ( Entry< Node2, List<Edge2>> entry: edgeByVertices.entrySet() ) {
            System.out.print( entry.getKey().getName() + ": " );
            
            for( Edge2 edge : entry.getValue() ){
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
	
    
    public void calculateMstPrim( Node2 source ){

    	PriorityQueue<Node2> priorityQueue = new PriorityQueue<Node2>(vertexTotal, new Comparator<Node2>() {
			@Override
			public int compare(Node2 o1, Node2 o2) {
				int comp = Integer.compare( o1.getKey(), o2.getKey() );
				return comp;
			}
    	});
    	
    	for( Node2 node : vertices.values() ){
    		node.setKey( Integer.MAX_VALUE );
    		node.setFather( null );
    	}
    	
    	source.setKey( 0 );
    	
    	priorityQueue.addAll( vertices.values() );
    	
    	Node2 node, other;
    	while( !priorityQueue.isEmpty() ){
    		node = priorityQueue.poll();
    		
    		for( Edge2 edge : edgeByVertices.get( node ) ){
    			other = edge.getTo();
    			if( priorityQueue.contains( other ) && edge.getWeight() < other.getKey() ){
    				priorityQueue.remove( other );
    				
    				other.setKey( edge.getWeight() );
    				other.setFather( node );
    				
    				priorityQueue.add( other );
    			}
    		}
    	}
    }

    public int getGraphWeight(){
    	int total = 0;
    	for( Node2 node : vertices.values() ){
    		total += node.getKey();
    	}
    	
    	return total;
    }
}






